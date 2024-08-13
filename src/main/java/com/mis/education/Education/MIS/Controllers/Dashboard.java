package com.mis.education.Education.MIS.Controllers;

import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import com.mis.education.Education.MIS.repositories.orders.OrdersRepository;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import com.mis.education.Education.MIS.repositories.user.UserRepository;
import com.mis.education.Education.MIS.repositories.userdatatables.UserDatatableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.Collection;

@Controller
public class Dashboard {

    @Autowired
    ProductsDatatableRepository productsDatatableRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    UserRepository userDatatableRepository;



    //dashboard  homepage_new
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, HttpServletRequest request, HttpSession session) {



        request.getSession().setAttribute("successMessage", "");
        String authority_ = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            for (GrantedAuthority authority : authorities) {
                authority_ = authority.getAuthority().toString();
                System.out.println(authority.getAuthority().toString());
            }


            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

            Double totalAumount = ordersRepository.getTotalPaymentsReceived();
            Long totalCustomers = userDatatableRepository.getTotalCustomers();
            Integer getCompletedOrders = ordersRepository.getCompletedOrders();
            Long totalProducts = productsDatatableRepository.getTotalProducts();

            if (user != null) {

                if ( authority_.equalsIgnoreCase("OWNER")  ||authority_.equalsIgnoreCase("Super Admin")) {
                    model.addAttribute("authority_", authority_);
                    model.addAttribute("paymentsReceived", totalAumount);
                    model.addAttribute("totalCustomers", totalCustomers);
                    model.addAttribute("getCompletedOrders", getCompletedOrders);
                    model.addAttribute("totalProducts",totalProducts);

                    return "homepage_new";

                }else{
                    return "homepage_new";
                }

            } else {
                return "errorPage";
            }

        }
    }

}
