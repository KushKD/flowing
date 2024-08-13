package com.mis.education.Education.MIS.modules.role.controller;


import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.modules.role.form.RolesForm;
import com.mis.education.Education.MIS.modules.role.service.RoleService;
import com.mis.education.Education.MIS.modules.role.validator.RoleValidator;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import com.mis.education.Education.MIS.repositories.roles.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class RolesController {

    @Autowired
    private RoleValidator roleValidator;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolesRepository rolesRepository;

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);


    @RequestMapping(value = "/getRoles", method = RequestMethod.GET)
    public String viewBarrier(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            System.out.println(user);


            if(user==null){
                return "login";
            }else{
                return "getRoles";
            }
        }
    }

    @RequestMapping(value = "/updateRole/{district_id}", method = RequestMethod.GET)
    public String updateDistrict(@PathVariable("district_id")Integer role_id, Model model, HttpServletRequest request) throws Exception {

        System.out.println(role_id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            System.out.println(user);

            if(user==null){
                return "login";
            }else{

                RolesEntity role =rolesRepository.getRoleViaId(role_id);
                System.out.println(role.toString());
                model.addAttribute("role_to_update", role);
                model.addAttribute("rolesForm", new RolesForm());
                return "updatrole";
            }
        }
    }


    @RequestMapping(value = "/updateRoleEntity", method = RequestMethod.POST)
    @Transactional
    public String updateModuleEntity(@ModelAttribute("rolesForm") RolesForm rolesForm,
                                     BindingResult bindingResult, Model model, HttpServletRequest request,
                                     HttpSession session, RedirectAttributes redirectAttributes) {


        // moduleValidatorUpdate.validate(moduleForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "rolesForm";
        }
        try {

            RolesEntity savedModule = null;
            RolesEntity roleToUpdate = new RolesEntity();

            roleToUpdate = rolesRepository.getRoleViaId(Integer.parseInt(rolesForm.getRoleId()));

            roleToUpdate.setRoleName(rolesForm.getRoleName().toString());
            roleToUpdate.setRoleDescription(rolesForm.getRoleDescription());

            if (rolesForm.getIsActive().equalsIgnoreCase("T")) {
                roleToUpdate.setActive(true);
            } else {
                roleToUpdate.setActive(false);
            }


            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            roleToUpdate.setUpdatedOn(date);

            savedModule = rolesRepository.save(roleToUpdate);
            rolesForm.setRoleName("");
            rolesForm.setRoleDescription("");
            request.getSession().setAttribute("successMessage", "Role Updated Successfully. ");
            return "redirect:/getRoles";
        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "updatemodule";
        }

    }


    @RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String createRole(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        } else {
            model.addAttribute("rolesForm", new RolesForm());
            return "createrole";
//        }
    }


    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("rolesForm") RolesForm roleForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        roleValidator.validate(roleForm, bindingResult);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            if (bindingResult.hasErrors()) {
                return "createrole";
            }
            try {
                RolesEntity rolesEntity = new RolesEntity();
                rolesEntity.setActive(true);
                rolesEntity.setRoleName(roleForm.getRoleName());
                rolesEntity.setRoleDescription(roleForm.getRoleDescription());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date(timestamp.getTime());
                rolesEntity.setCreatedDate(date);


                RolesEntity savedData = roleService.saveRole(rolesEntity);
                roleForm.setRoleName("");
                roleForm.setRoleDescription("");
                request.getSession().setAttribute("successMessage", savedData.getRoleName() + " role Successfully Saved. ID is" + savedData.getRoleId());
                return "redirect:/getRoles";
            } catch (Exception ex) {
                roleForm.setRoleName("");
                roleForm.setRoleDescription("");
                model.addAttribute("serverError", ex.toString());
                return "createrole";
            }
       }


    }
}
