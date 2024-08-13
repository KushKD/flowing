package com.mis.education.Education.MIS.modules.checkout;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.cart.Summary;
import com.mis.education.Education.MIS.modules.checkout.validator.CheckoutValidator;
import com.mis.education.Education.MIS.modules.customer_address.AddressForm;
import com.mis.education.Education.MIS.modules.customer_address.CustomerAddressEntity;
import com.mis.education.Education.MIS.modules.order.OrdersEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import com.mis.education.Education.MIS.modules.products.form.ProductForm;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.cart.CartRepository;
import com.mis.education.Education.MIS.repositories.customer_address.CustomerAddressRepository;
import com.mis.education.Education.MIS.repositories.orders.OrdersRepository;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import com.mis.education.Education.MIS.utilities.Constants;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CheckoutController {

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CheckoutValidator checkoutValidator;

    @Autowired
    ProductsDatatableRepository productsDatatableRepository;


    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String viewBarrier(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

            if (user == null) {
                return "login";
            } else {

                /**
                 * Get CartId
                 */
                // Fetch updated cart data
                CartEntity cartData = cartRepository.getCartItemViaId(user.getUserId(), Constants.CART_ACTIVE).get(0);
              //  Summary summary = generateSummary(cartData);
                List<CustomerAddressEntity> address = customerAddressRepository.getAddressByUSerId(Math.toIntExact(user.getUserId()));
                model.addAttribute("cart", cartData.getCartId());
                //model.addAttribute("summary", summary);
                model.addAttribute("address", address);
                model.addAttribute("addressForm", new AddressForm());
                model.addAttribute("checkoutForm", new CheckoutForm());
                model.addAttribute("checkoutcompleteForm", new CheckoutcompleteForm());
                return "checkout";
            }
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


    //checkout-complete
    @RequestMapping(value = "/checkout-complete", method = RequestMethod.POST)
    @Transactional
    public String checkout_omplete(@ModelAttribute("checkoutForm") CheckoutForm checkoutForm, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {


        checkoutValidator.validate(checkoutForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/checkout";
        }
        try {
            UserEntity userSession = (UserEntity) request.getSession().getAttribute("UserData");


            OrdersEntity ordersSaved =null;
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            java.sql.Date date = new java.sql.Date(timestamp.getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = dateFormat.format(date);

            RazorpayClient client = new RazorpayClient("rzp_live_BAOw4280u3OH3l","VVp4CWE7Rzj95uH6HEkmL3Ux");
            JSONObject options = new JSONObject();
            options.put("amount",checkoutForm.getTotal()*100);
            options.put("currency","INR");
            options.put("receipt","#F-Chakra:"+userSession.getUserId()+formattedDate+checkoutForm.getCartId());
            Order order = client.Orders.create(options);

            OrdersEntity orders = new OrdersEntity();
            orders.setAmount(checkoutForm.getTotal());
            orders.setCurrency("INR");
            orders.setReceipt(order.get("receipt").toString());
            orders.setOrderId(order.get("id").toString());
            UserEntity user = new UserEntity();
            user.setUserId(userSession.getUserId());
            orders.setUserId(user);
            CartEntity cart = new CartEntity();
            cart.setCartId(checkoutForm.getCartId());
            orders.setCartId(cart);
            orders.setGatewayEntity(order.get("entity").toString());
            orders.setStatus(order.get("status").toString());
            orders.setAttempts(order.get("attempts"));
            orders.setActive(true);
            orders.setCreatedDate(date);

            orders.setPhone(checkoutForm.getPhone());
            orders.setAlternatePhone(checkoutForm.getAlternatePhone());
            orders.setAdditionalInfo("");
            orders.setShippingaddressId(checkoutForm.getShippingAddressId());
            orders.setBillingaddressId(checkoutForm.getShippingAddressId());
            orders.setPaymentMethord("RAZORPAY");

            ordersSaved = ordersRepository.save(orders);
            List<CustomerAddressEntity> address = customerAddressRepository.getAddressByUSerId(Math.toIntExact(userSession.getUserId()));



            model.addAttribute("order", order.get("id").toString());
            model.addAttribute("address", address);
            model.addAttribute("checkoutForm", checkoutForm);

            model.addAttribute("checkoutcompleteForm", new CheckoutcompleteForm());
            model.addAttribute("addressForm", new AddressForm());
            model.addAttribute("checkoutForm", new CheckoutForm());
            System.out.println(checkoutForm);


            model.addAttribute("key", "rzp_live_BAOw4280u3OH3l");
            model.addAttribute("name", userSession.getFirstName()+" "+ userSession.getLastName());
            model.addAttribute("email", userSession.getEmail());




            return "checkout";  //checkout-complete

        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "checkout";
        }

    }



    @Transactional
    @RequestMapping(value = "/save-payment-details", method = RequestMethod.POST)
    @ResponseBody
    public String savePaymentDetails( @RequestParam(value="razorpay_payment_id") String razorpay_payment_id,
                                      @RequestParam(value="razorpay_signature") String razorpay_signature,
                                      @RequestParam(value="razorpay_order_id") String razorpay_order_id,HttpServletRequest request, HttpSession session) {

        try{
            OrdersEntity order = ordersRepository.findOrderByOrderId(razorpay_order_id);
            System.out.println(order);
            order.setStatus("completed");
            Integer attempts = order.getAttempts();
            order.setAttempts(attempts+1);
            ordersRepository.save(order);

            UserEntity userSession = (UserEntity) request.getSession().getAttribute("UserData");
            CartEntity cart = cartRepository.getCartViaId(userSession.getUserId());
            cart.setStatus("IN-ACTIVE");
            Integer items = cart.getCartItemId().size();
            cart.setQuantityId(items);
            cartRepository.save(cart);

            return "Payment Saved Successfully";
        }catch(Exception ex){
            return "Payment attempt unsuccessful. Please try again.";
        }


    }
}
