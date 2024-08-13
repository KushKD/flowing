package com.mis.education.Education.MIS.modules.updateprofile;

import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.modules.role.form.RolesForm;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.customer_address.CustomerAddressRepository;
import com.mis.education.Education.MIS.repositories.orders.OrdersRepository;
import com.mis.education.Education.MIS.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

@Controller
public class UpdateProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @RequestMapping(value = "/update-profile", method = RequestMethod.GET)
    public String updateProfile(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

            Integer completedStatus = ordersRepository.getCompletedOrdersViaUserID(Math.toIntExact(user.getUserId()));
            Integer createdStatus = ordersRepository.getCreatedOrdersViaUserID(Math.toIntExact(user.getUserId()));
            model.addAttribute("completed", completedStatus);
            model.addAttribute("created", createdStatus);

            model.addAttribute("customerProfile", user);
            model.addAttribute("passwordReset", new PasswordReset());

            if (user == null) {
                return "login";
            } else {
                return "update-profile";
            }
        }
    }


    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    @Transactional
    public String resetPassword(@ModelAttribute("passwordReset") PasswordReset passwordReset,
                                     BindingResult bindingResult, Model model, HttpServletRequest request,
                                     HttpSession session, RedirectAttributes redirectAttributes) {


        // moduleValidatorUpdate.validate(moduleForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "rolesForm";
        }
        try {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            UserEntity userUpdate = userRepository.findByUsername(user.getEmail());
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            userUpdate.setPassword(encoder.encode(passwordReset.getNewPassword()));
            userRepository.save(userUpdate);

            Integer completedStatus = ordersRepository.getCompletedOrdersViaUserID(Math.toIntExact(user.getUserId()));
            Integer createdStatus = ordersRepository.getCreatedOrdersViaUserID(Math.toIntExact(user.getUserId()));
            model.addAttribute("completed", completedStatus);
            model.addAttribute("created", createdStatus);

            model.addAttribute("customerProfile", user);
            model.addAttribute("passwordReset", new PasswordReset());

            request.getSession().setAttribute("successMessage", "Password Updated Successfully. ");
            return "update-profile";
        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "update-profile";
        }

    }
}
