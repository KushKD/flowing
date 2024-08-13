package com.mis.education.Education.MIS.Controllers;


import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import com.mis.education.Education.MIS.modules.user.service.UserService;
import com.mis.education.Education.MIS.repositories.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {


    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainpage(Model model) {
        return "mainpage";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String homePage(Model model, HttpServletRequest request) {

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            for (GrantedAuthority authority : authorities) {
                authority_ = authority.getAuthority().toString();
                System.out.println(authority.getAuthority().toString());
            }


                List<UserEntity> data = userRepository.getUserGeoData(username);
                request.getSession().setAttribute("UserData", data.get(0));




       if(authority_.equalsIgnoreCase("OWNER") || authority_.equalsIgnoreCase("Admin")) { return "redirect:/dashboard";}
       else if(authority_.equalsIgnoreCase("CUSTOMER")) { return "redirect:/customer-dashboard"; }

       else { return "redirect:/vendorIndex";}
        }

    }





    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String gallery(Model model) {
        return "about";
    }




    @RequestMapping(value = "/privacypolicy", method = RequestMethod.GET)
    public String privacypolicy(Model model) {
        return "privacypolicy";
    }

    @RequestMapping(value = "/termsandconditions", method = RequestMethod.GET)
    public String termsandconditions(Model model) {
        return "termsandconditions";
    }
















}
