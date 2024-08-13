package com.mis.education.Education.MIS.modules.user.controller;

import com.mis.education.Education.MIS.fileStorage.FileStorageService;
import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.modules.role.service.RoleService;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.user.forms.RegisterUser;
import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import com.mis.education.Education.MIS.modules.user.service.UserService;
import com.mis.education.Education.MIS.modules.user.validator.UserValidator;
import com.mis.education.Education.MIS.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userservice;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    UserValidator userValidator;



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model, HttpServletRequest request) {
        model.addAttribute("registerUser", new RegisterUser());
        //request.getSession().removeAttribute("successMessage");
        //request.getSession().removeAttribute("serverError");
        return "register";
    }



    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    @Transactional
    public String saveUser(@ModelAttribute("registerUser") RegisterUser registerUser, BindingResult bindingResult, Model model, HttpServletRequest request) {
        userValidator.validate(registerUser, bindingResult);

            if (bindingResult.hasErrors()) {
                request.getSession().removeAttribute("successMessage");
                request.getSession().removeAttribute("serverError");
                return "register";
            }
            try {

                UserEntity user = new UserEntity();
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                user.setActive(true);
                user.setFirstName(registerUser.getFirstName());
                user.setLastName(registerUser.getLastName());
                user.setEmail(registerUser.getEmail());
                user.setPassword(encoder.encode(registerUser.getPassword()));
                user.setUserName(registerUser.getEmail());

                Optional<RolesEntity> role = roleService.getRoleDetails("2");

                List<RolesEntity> list = new ArrayList<>();
                list.add(role.get());
                user.setRoles(list);

                UserEntity savedData = userservice.saveUser(user);
                request.getSession().setAttribute("successMessage", " User successfully created with Email as" + savedData.getUserName() + " \t Please login to your account using the registered email and password.");
                registerUser.setPasswordConfirm("");
                registerUser.setPassword("");
                registerUser.setUsername("");
                return "redirect:/register";

            } catch (Exception ex) {
                registerUser.setPasswordConfirm("");
                registerUser.setUsername("");
                registerUser.setPassword("");
                model.addAttribute("serverError", ex.toString());
                return "register";
            }


    }


    @RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
    public String viewBarrier(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            System.out.println(user);

            if (user == null) {
                return "login";
            } else {
                return "viewUsers";
            }
        }
    }

    @RequestMapping(value = "/viewuserspecific", method = RequestMethod.GET)
    public String viewuserspecific(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            LoggedInUserLocationSession user = (LoggedInUserLocationSession) request.getSession().getAttribute("UserData");
            System.out.println(user);

            if (user == null) {
                return "login";
            } else {
                return "viewuserspecific";
            }
        }
    }


    @RequestMapping(value = "/viewuserschool", method = RequestMethod.GET)
    public String viewuserschool(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            LoggedInUserLocationSession user = (LoggedInUserLocationSession) request.getSession().getAttribute("UserData");
            System.out.println(user);

            if (user == null) {
                return "login";
            } else {
                return "viewuserschool";
            }
        }
    }


}
