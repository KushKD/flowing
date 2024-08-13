package com.mis.education.Education.MIS.Controllers;

import com.mis.education.Education.MIS.modules.user.forms.RegisterUser;
import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("/login")
    public String login(Model model, String error, String logout, HttpSession httpSession) {

        logger.info("Inside Login Controller.");
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        Object message = httpSession.getAttribute("message");
        if (message != null) {
            model.addAttribute("message", message);
            httpSession.removeAttribute("message");
        }



        return "login";
    }




    @RequestMapping(value =  "/logout" , method = RequestMethod.GET)
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {

        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Clear authentication
        SecurityContextHolder.clearContext();

        System.out.println("Logout Successful");
        logger.info("Logout Successful");


        return "login";
    }
}
