package com.mis.education.Education.MIS.modules.customer;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.customer_address.CustomerAddressEntity;
import com.mis.education.Education.MIS.modules.order.OrdersEntity;
import com.mis.education.Education.MIS.modules.products.form.ProductForm;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.cart.CartRepository;
import com.mis.education.Education.MIS.repositories.customer_address.CustomerAddressRepository;
import com.mis.education.Education.MIS.repositories.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {



    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    //customer-dashboard
    @RequestMapping(value = "/customer-dashboard", method = RequestMethod.GET)
    public String createTransfer(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            Integer completedStatus = ordersRepository.getCompletedOrdersViaUserID(Math.toIntExact(user.getUserId()));
            Integer createdStatus = ordersRepository.getCreatedOrdersViaUserID(Math.toIntExact(user.getUserId()));
            if (user == null) {
                return "login";
            } else {
                model.addAttribute("customerProfile", user);
                model.addAttribute("completed", completedStatus);
                model.addAttribute("created", createdStatus);
                return "customer-dashboard";
            }

        }
    }


    @RequestMapping(value = "/customer-invoice/{id}", method = RequestMethod.GET)
    public String customerInvoice(@PathVariable("id")Integer id, Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            OrdersEntity orderDetails = ordersRepository.findOrderById(id);
            CustomerAddressEntity shippingAddress = customerAddressRepository.getAddressByAddressId(orderDetails.getShippingaddressId());
            CustomerAddressEntity billingAddress = customerAddressRepository.getAddressByAddressId(orderDetails.getBillingaddressId());
            if (user == null) {
                return "login";
            } else {
                model.addAttribute("OrdersEntity", orderDetails);
                model.addAttribute("shippingAddress", shippingAddress);
                model.addAttribute("billingAddress", billingAddress);
                model.addAttribute("cartItems", orderDetails.getCartId().getCartItemId());
                return "customer-invoice";
            }

        }
    }



}
