package com.mis.education.Education.MIS.modules.customer_address;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.checkout.CheckoutForm;
import com.mis.education.Education.MIS.modules.checkout.CheckoutcompleteForm;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import com.mis.education.Education.MIS.modules.products.form.ProductForm;
import com.mis.education.Education.MIS.modules.states.StatesMaster;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.cart.CartRepository;
import com.mis.education.Education.MIS.repositories.customer_address.CustomerAddressRepository;
import com.mis.education.Education.MIS.repositories.orders.OrdersRepository;
import com.mis.education.Education.MIS.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerAddressController {


    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrdersRepository ordersRepository;


    @RequestMapping(value = "/customer-address", method = RequestMethod.GET)
    public String viewBarrier(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

            if (user == null) {
                return "login";
            } else {

                //GEt All UserAddress
                List<CustomerAddressEntity> address = customerAddressRepository.getAddressByUSerId(Math.toIntExact(user.getUserId()));
                System.out.println(address);

                Integer completedStatus = ordersRepository.getCompletedOrdersViaUserID(Math.toIntExact(user.getUserId()));
                Integer createdStatus = ordersRepository.getCreatedOrdersViaUserID(Math.toIntExact(user.getUserId()));
                model.addAttribute("customerProfile", user);
                model.addAttribute("completed", completedStatus);
                model.addAttribute("created", createdStatus);

                model.addAttribute("address", address);

                model.addAttribute("addressForm", new AddressForm());
                model.addAttribute("checkoutcompleteForm", new CheckoutcompleteForm());




                return "customer-address";
            }
        }
    }

    @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
    @Transactional
    public String saveDetails(@ModelAttribute("addressForm") AddressForm addressForm, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {


       // productsValidator.validate(transferForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer-address";
        }
        try {
            UserEntity userSession = (UserEntity) request.getSession().getAttribute("UserData");

            CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();
            CustomerAddressEntity savedCustomerAddress = null;

            UserEntity user = new UserEntity();
            user.setUserId(userSession.getUserId());
            customerAddressEntity.setUserId(user);
            customerAddressEntity.setCountryId(Integer.parseInt(addressForm.getCountry()));

            StatesMaster state = new StatesMaster();
            state.setStateID(Integer.parseInt(addressForm.getState()));
            customerAddressEntity.setStateId(state);


            customerAddressEntity.setCity(addressForm.getCity().trim());
            if(addressForm.getDefaultAddress().equalsIgnoreCase("No")){
                customerAddressEntity.setDefaultAddress(false);
            }else{
                customerAddressEntity.setDefaultAddress(true);
            }
            customerAddressEntity.setAddress(addressForm.getAddress().trim());

            customerAddressEntity.setPincode(Integer.valueOf(addressForm.getPincode().trim()));

            customerAddressEntity.setActive(true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            customerAddressEntity.setCreatedDate(date);
            savedCustomerAddress = customerAddressRepository.save(customerAddressEntity);

            //GEt All UserAddress
            List<CustomerAddressEntity> address = customerAddressRepository.getAddressByUSerId(Math.toIntExact(userSession.getUserId()));
            System.out.println(address);

            model.addAttribute("address", address);
            addressForm.setAddress("");
            addressForm.setPincode("");
            addressForm.setCity("");
            request.getSession().setAttribute("successMessage", "Address saved Successfully.");
            return "redirect:/customer-address";

        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "redirect:/customer-address";
        }

    }



    @RequestMapping(value = "/saveAddressCart", method = RequestMethod.POST)
    @Transactional
    public String saveAddressCart(@ModelAttribute("addressForm") AddressForm addressForm, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {


        // productsValidator.validate(transferForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "checkout";
        }
        try {
            UserEntity userSession = (UserEntity) request.getSession().getAttribute("UserData");

            CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();
            CustomerAddressEntity savedCustomerAddress = null;

            UserEntity user = new UserEntity();
            user.setUserId(userSession.getUserId());
            customerAddressEntity.setUserId(user);
            customerAddressEntity.setCountryId(Integer.parseInt(addressForm.getCountry()));

            StatesMaster state = new StatesMaster();
            state.setStateID(Integer.parseInt(addressForm.getState()));
            customerAddressEntity.setStateId(state);


            customerAddressEntity.setCity(addressForm.getCity().trim());
            if(addressForm.getDefaultAddress().equalsIgnoreCase("No")){
                customerAddressEntity.setDefaultAddress(false);
            }else{
                customerAddressEntity.setDefaultAddress(true);
            }
            customerAddressEntity.setAddress(addressForm.getAddress().trim());

            customerAddressEntity.setPincode(Integer.valueOf(addressForm.getPincode().trim()));

            customerAddressEntity.setActive(true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            customerAddressEntity.setCreatedDate(date);
            savedCustomerAddress = customerAddressRepository.save(customerAddressEntity);

            //GEt All UserAddress
            List<CustomerAddressEntity> address = customerAddressRepository.getAddressByUSerId(Math.toIntExact(userSession.getUserId()));
            System.out.println(address);

            // Fetch updated cart data
            CartEntity cartData = cartRepository.getCartItemViaId(user.getUserId(), Constants.CART_ACTIVE).get(0);

            model.addAttribute("cart", cartData.getCartId());
            model.addAttribute("address", address);
            model.addAttribute("addressForm", new AddressForm());
            model.addAttribute("checkoutForm", new CheckoutForm());
            model.addAttribute("checkoutcompleteForm", new CheckoutcompleteForm());

            addressForm.setAddress("");
            addressForm.setPincode("");
            addressForm.setCity("");
            request.getSession().setAttribute("successMessage", "Address saved Successfully.");
            return "checkout";

        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "checkout";
        }

    }
}
