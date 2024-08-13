package com.mis.education.Education.MIS.modules.contactus;


import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.modules.role.form.RolesForm;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.contactus.ContactusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

@Controller
public class ContactUsController {

    @Autowired
    ContactusRepository contactusRepository;


    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactus(Model model) {
        model.addAttribute("contactusForm", new ContactusForm());
        return "contactus";
    }


    @RequestMapping(value = "/contact-us", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("contactusForm") ContactusForm contactusForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
       // roleValidator.validate(roleForm, bindingResult);


            if (bindingResult.hasErrors()) {
                return "contactus";
            }
            try {
                ContactusEntity contactusEntity = new ContactusEntity();
                contactusEntity.setActive(true);
                contactusEntity.setName(contactusForm.getName());
                contactusEntity.setEmail(contactusForm.getEmail());
                contactusEntity.setMessage(contactusForm.getMessage());
                contactusEntity.setSupportFor(contactusForm.getSupport_for());
                contactusEntity.setPhone(contactusForm.getPhone());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date(timestamp.getTime());
                contactusEntity.setCreatedDate(date);
                ContactusEntity savedData = contactusRepository.save(contactusEntity);
                contactusForm.setName("");
                contactusForm.setMessage("");
                contactusForm.setEmail("");
                request.getSession().setAttribute("successMessage", "Query Successfully Saved. ID is" + savedData.getQueryId());
                return "contactus";
            } catch (Exception ex) {
                contactusForm.setName("");
                contactusForm.setMessage("");
                contactusForm.setEmail("");
                model.addAttribute("serverError", ex.toString());
                return "contactus";
            }
    }


    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String viewBarrier(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                return "login";
            } else {
                return "contact-us";
            }
        }
    }
}
