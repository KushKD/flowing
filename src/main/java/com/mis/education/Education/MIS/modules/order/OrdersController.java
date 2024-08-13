package com.mis.education.Education.MIS.modules.order;

import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrdersController {

    //viewOrders
    @RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
    public String viewOrders(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

            if (user == null) {
                return "login";
            } else {
                return "viewOrders";
            }
        }
    }

}
