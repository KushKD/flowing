package com.mis.education.Education.MIS.modules.cart;

import com.mis.education.Education.MIS.modules.cart_items.CartItemsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.cart.CartRepository;
import com.mis.education.Education.MIS.repositories.cart_items.CartItemRepository;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import com.mis.education.Education.MIS.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CartRestContoller {


    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cardCartItemRepository;

    @Autowired
    ProductsDatatableRepository productsDatatableRepository;

    @Autowired
    private EntityManager entityManager;


    @Transactional
    @RequestMapping(value = "/api/add-to-cart", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addToCart(@RequestBody ProductCart productCart, HttpServletRequest request) {
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", "Please Login to Add Products to Wishlist.");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            } else {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date(timestamp.getTime());

                int quantity = productCart.getQuantity();
                int variationId = productCart.getProduct_variation_id();
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(user.getUserId());

                // Get or create cart
                CartEntity savedCart = getOrCreateCart(userEntity, date, quantity);

                // Save or update cart item
                CartItemsEntity savedCartItem = saveOrUpdateCartItem(userEntity, savedCart, date, variationId, quantity);


                // Commit the transaction to persist changes to the database
                entityManager.flush();
                entityManager.clear(); // Clear the entity manager cache to ensure we fetch fresh data


                // Fetch updated cart data
                CartEntity cartData = cartRepository.getCartItemViaId(user.getUserId(), Constants.CART_ACTIVE).get(0);

                // Prepare response
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", (cartData.getQuantityId() > 1) ? "Quantity has been increased." : "Quantity has been added.");
                response.put("carts", generateCartsResponse(cartData));
                response.put("navCarts", generateNavCarts(cartData));
                response.put("cartCount", cartData.getCartItemId().size());
                response.put("subTotal", calculateSubTotal(cartData));
                response.put("couponDiscount", "0");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    private CartEntity getOrCreateCart(UserEntity userEntity, Date date, int quantity) {
        List<CartEntity> existingCarts = cartRepository.getCartItemViaId(userEntity.getUserId(), Constants.CART_ACTIVE);
        if (!existingCarts.isEmpty()) {
            return existingCarts.get(0);
        } else {
            CartEntity cart = new CartEntity();
            cart.setUserId(userEntity);
            cart.setStatus(Constants.CART_ACTIVE);
            cart.setActive(true);
            cart.setCreatedDate(date);
            cart.setQuantityId(quantity);
            return cartRepository.save(cart);
        }
    }

    @Transactional
    private CartItemsEntity saveOrUpdateCartItem(UserEntity userEntity, CartEntity savedCart, Date date, int variationId, int quantity) {
        List<CartItemsEntity> existingCartItems = cardCartItemRepository.getCartItemViaId(userEntity.getUserId(), savedCart.getCartId(), Long.valueOf(variationId));
        CartItemsEntity cartItemsEntity;
        if (!existingCartItems.isEmpty()) {
            cartItemsEntity = existingCartItems.get(0);
            Integer quantity_ = cartItemsEntity.getProductQuantity();
            cartItemsEntity.setProductQuantity(quantity_ + quantity);
        } else {
            cartItemsEntity = new CartItemsEntity();
            cartItemsEntity.setProductQuantity(quantity);
            cartItemsEntity.setUserId(Math.toIntExact(userEntity.getUserId()));
            cartItemsEntity.setCartId(savedCart.getCartId());
            cartItemsEntity.setActive(true);
            ProductsEntity product = new ProductsEntity();
            product.setProductId(Long.valueOf(variationId));
            cartItemsEntity.setProductsEntity(product);
            cartItemsEntity.setCreatedDate(date);
        }
        return cardCartItemRepository.save(cartItemsEntity);
    }




    @RequestMapping(value = "/api/update-cart", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updateCart(@RequestBody UpdateCartModal updateCartModal, HttpServletRequest request) {
        try {


            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", " Please Login to Add Products to Wishlist.");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            } else {
                String action = updateCartModal.getAction();
                int id = updateCartModal.getId();
                boolean isItemDeleted = cardCartItemRepository.deleteItemById(id);
                CartEntity cartData = cartRepository.getCartItemViaId(user.getUserId(), Constants.CART_ACTIVE).get(0);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                if(isItemDeleted) {
                    response.put("message", "Item removed from cart.");
                }else{
                    response.put("message", "Unable to remove Item form cart. Please try again later.");
                }
                response.put("carts", generateCartsResponse(cartData));
                response.put("navCarts",generateNavCarts(cartData));
                response.put("cartCount", cartData.getCartItemId().size());
                response.put("subTotal", calculateSubTotal(cartData));
                response.put("couponDiscount", "0");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateNavCarts(CartEntity cartData) {


        StringBuilder htmlBuilder = new StringBuilder();
        for(int i=0; i<cartData.getCartItemId().size() ; i++) {
            ProductsEntity product = productsDatatableRepository.getProductViaId(Math.toIntExact(cartData.getCartItemId().get(i).getProductsEntity().getProductId()));
            htmlBuilder.append("<li class=\"d-flex align-items-center pb-3 \">\n");
            htmlBuilder.append("  <div class=\"thumb-wrapper\">\n");
            htmlBuilder.append("    <a href=\"#\">\n");
            htmlBuilder.append("      <img src=\"/downloadFile/" + product.getProductImage() + "\" alt=\""+product.getProductName()+"\" class=\"img-fluid rounded-circle\">\n");
            htmlBuilder.append("    </a>\n");
            htmlBuilder.append("  </div>\n");
            htmlBuilder.append("  <div class=\"items-content ms-3\">\n");
            htmlBuilder.append("    <a href=\"#\">\n");
            htmlBuilder.append("      <h6 class=\"mb-0\">" + product.getProductName() );
            htmlBuilder.append("</h6>\n");
            htmlBuilder.append("    </a>\n");
            htmlBuilder.append("    <div class=\"products_meta mt-1 d-flex align-items-center\">\n");
            htmlBuilder.append("      <div>\n");
            htmlBuilder.append("        <span class=\"price text-primary fw-semibold\"> &#8377; "+ calculateTotalPriceSingle(Double.parseDouble(product.getProductPrice()), Double.parseDouble(product.getProductTax()), cartData.getCartItemId().get(i).getProductQuantity()) +"</span> <span class=\"count fs-semibold\">x"+ cartData.getCartItemId().get(i).getProductQuantity()+"</span>");
            htmlBuilder.append("      </div>\n");
            htmlBuilder.append("      <button class=\"remove_cart_btn ms-2\" onclick=\"handleCartItem('delete', "+ product.getProductId()+")\">\n");
            htmlBuilder.append("        <i class=\"fa-solid fa-trash\"></i>\n");
            htmlBuilder.append("      </button>\n");
            htmlBuilder.append("    </div>\n");
            htmlBuilder.append("  </div>\n");
            htmlBuilder.append("</li>\n");

        }

        return htmlBuilder.toString();

    }

    private Double calculateSubTotal(CartEntity cartData) {

        double SubTotal = 0.0;

        for (int i=0; i<cartData.getCartItemId().size() ;i++){

            //Get Product Id
            ProductsEntity product = productsDatatableRepository.getProductViaId(Math.toIntExact(cartData.getCartItemId().get(i).getProductsEntity().getProductId()));
            double taxAmount = Double.parseDouble(product.getProductPrice()) * (Double.parseDouble(product.getProductTax()) / 100);
            double total = Double.parseDouble(product.getProductPrice())*cartData.getCartItemId().get(i).getProductQuantity(); // + taxAmount;
            SubTotal = (SubTotal + total);
        }

        return SubTotal;
    }

    private String generateCartsResponse(CartEntity cartData) {
        StringBuilder SB = new StringBuilder();

        for(int i=0; i<cartData.getCartItemId().size() ; i++){

            //Get Product Id
            ProductsEntity product = productsDatatableRepository.getProductViaId(Math.toIntExact(cartData.getCartItemId().get(i).getProductsEntity().getProductId()));
            SB.append("<tr>");
            SB.append("<td class=\"h-100px\"> <img src=\"${pageContext.request.contextPath}/downloadFile/"+product.getProductImage()+"\" alt=\""+product.getProductName()+"\" class=\"img-fluid\" width=\"100\"></td>\n");
            SB.append("<td class=\"text-start product-title\">");
            SB.append("<h6 class=\"mb-0\">");
            SB.append(product.getProductName() +"  </h6> </td>");
            SB.append("<td> <span class=\"text-dark fw-bold me-2 d-lg-none\">Unit Price:</span> <span class=\"text-dark fw-bold\">"+ calculateTotalPrice(Double.parseDouble(product.getProductPrice()), Double.parseDouble(product.getProductTax()), cartData.getCartItemId().get(i).getProductQuantity()) +" </span></td>");
            SB.append("<td> <div class=\"product-qty d-inline-flex align-items-center\">");
            SB.append("<button class=\"decrese\" onclick=\"handleCartItem('decrease',"+product.getProductId()+"\")>-</button> <input type=\"text\" readonly value=\"1\"> <button class=\"increase\" onclick=\"handleCartItem('increase',"+product.getProductId()+"\")>+</button> </div></td>");
            SB.append("<td> <span class=\"text-dark fw-bold me-2 d-lg-none\">Total Price:</span> <span class=\"text-dark fw-bold\"> "+ calculateTotalPrice(Double.parseDouble(product.getProductPrice()), Double.parseDouble(product.getProductTax()), cartData.getCartItemId().get(i).getProductQuantity() ) +"\" </span></td>");
            SB.append("<td> <span class=\"text-dark fw-bold me-2 d-lg-none\">Delete:</span> <span class=\"text-dark fw-bold\"><button type=\"button\" class=\"close-btn ms-3\" onclick=\"handleCartItem('delete', "+ product.getProductId() + "\")><i  class=\"fas fa-close\"></i></button></span></td></tr>\n");
        }

        return SB.toString();

    }


    public static String calculateTotalPrice(double originalPrice, double taxRate, Integer quantityId) {
       // double taxAmount = originalPrice * (taxRate / 100);
        //double total = originalPrice + taxAmount;
        return String.valueOf(originalPrice);
    }


    public static String calculateTotalPriceSingle(double originalPrice, double taxRate, Integer quantityId) {
      //  double taxAmount = originalPrice * (taxRate / 100);
        //double total = originalPrice + taxAmount;
        return String.valueOf(originalPrice);
    }


    //get-checkout-summary
    @RequestMapping(value = "/api/get-checkout-summary", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> get_checkout_summary( HttpServletRequest request) {
        try {


            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", " Please Login to Check Out.");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            } else {
                CartEntity cartData = cartRepository.getCartItemViaId(user.getUserId(), Constants.CART_ACTIVE).get(0);
                Map<String, Object> response = new HashMap<>();
               // response.put("logistics", generateLogisticts());
                Summary summary = generateSummary(cartData);
                response.put("summary", summary.getSummaryHtml());
                response.put("total", summary.getTotal());
                response.put("items", summary.getItems());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //add-to-cart-check
    @RequestMapping(value = "/api/add-to-cart-check", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> add_to_cart_check( HttpServletRequest request) {
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", " Please Login to Check Out.");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            } else {
                CartEntity cartData = cartRepository.getCartItemViaId(user.getUserId(), Constants.CART_ACTIVE).get(0);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Cart is Almost Full.");
                response.put("carts", generateCartsResponse(cartData));
                response.put("navCarts",generateNavCarts(cartData));
                response.put("cartCount", cartData.getCartItemId().size());
                response.put("subTotal", calculateSubTotal(cartData));
                response.put("couponDiscount", "0");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Summary generateSummary(CartEntity cartData) {
        Summary summary = new Summary();
        StringBuilder sb = new StringBuilder();
        Double price = 0.0;
        Double tax = 0.0;
        for(int i=0; i<cartData.getCartItemId().size(); i++){
            ProductsEntity product = productsDatatableRepository.getProductViaId(Math.toIntExact(cartData.getCartItemId().get(i).getProductsEntity().getProductId()));
            price = price + cartData.getCartItemId().get(i).getProductQuantity()*(Double.parseDouble(product.getProductPrice()));
            tax = (price * 0.12);
        }

        sb.append("<div class=\"sidebar-widget py-6 px-4 bg-white rounded-2\">");
        sb.append("<div class=\"widget-title d-flex\">");
        sb.append("<h5 class=\"mb-0 flex-shrink-0\">Order Summary</h5>");
        sb.append("<span class=\"hr-line w-100 position-relative d-block align-self-end ms-1\"></span>");
        sb.append("</div>");
        sb.append("<table class=\"sidebar-table w-100 mt-5\">");
        sb.append("<tr>");
        sb.append("<td>(+) Items("+cartData.getCartItemId().size()+"):</td>");
        sb.append("<td class=\"text-end\">₹"+ price +"</td>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td>(+) Tax:</td>");
        sb.append("<td class=\"text-end\">₹"+tax+"</td>");
        sb.append("</tr>");
        sb.append("</table>");
        sb.append("<span class=\"sidebar-spacer d-block my-4 opacity-50\"></span>");
        sb.append("<div class=\"d-flex align-items-center justify-content-between\">");
        sb.append("<h6 class=\"mb-0 fs-md\">Total</h6>");
        sb.append("<h6  class=\"mb-0 fs-md\"> &#8377; "+ (price+tax) +"</h6>");
        sb.append("</div>");
        sb.append("<button type=\"submit\" class=\"btn btn-primary btn-md rounded mt-6 w-100\">Place Order</button>");
        sb.append("</div>");


        summary.setTotal(price+tax);
        summary.setPrice(price);
        summary.setTax(tax);
        summary.setSummaryHtml(sb.toString());
        summary.setItems(cartData.getCartItemId().size());
        return summary;
    }
}
