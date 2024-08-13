package com.mis.education.Education.MIS.modules.user.validator;


import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.user.forms.RegisterUser;
import com.mis.education.Education.MIS.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {


    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterUser user = (RegisterUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");




        if (user.getFirstName().length() <= 3 || user.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Please use between 4 and 32 characters.");
        }

        if (user.getLastName().length() <= 3 || user.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Please use between 4 and 32 characters.");
        }


        if( user.getEmail()!=null && !user.getEmail().isEmpty()){
            UserEntity userEntity = userService.getUserDetailsViaUsername(user.getEmail());
            if (userEntity !=null ) {
                errors.rejectValue("email", "Someone already has that username.");
            }
        }else{
            errors.rejectValue("email", "Please Enter Valid Email Address");
        }


        if(!user.getPassword().equalsIgnoreCase(user.getPasswordConfirm())){
            errors.rejectValue("passwordConfirm", "These passwords don't match.");
        }



    }
}
