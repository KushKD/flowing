package com.mis.education.Education.MIS.modules.checkout.validator;


import com.mis.education.Education.MIS.modules.checkout.CheckoutForm;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.form.ProductForm;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class CheckoutValidator implements Validator {




    @Override
    public boolean supports(Class<?> aClass) {
        return CheckoutForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CheckoutForm user = (CheckoutForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shippingAddressId", "Please Select Shipping Address.");
    //    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billingAddressId", "Please Select Billing Address");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productPrice", "NotEmpty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortDescription", "NotEmpty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortDescription", "NotEmpty");




//        if (user.getProductName().length() <= 3 || user.getProductName().length() > 32) {
//            errors.rejectValue("productName", "Product Name should be between 4 and 32 characters.");
//        }
//
//        if (user.getShortDescription().length() <= 10 || user.getShortDescription().length() > 100) {
//            errors.rejectValue("shortDescription", "Short Description should be between 10 and 100 characters.");
//        }
//
//        if (user.getLongDescription().length() <= 10 || user.getLongDescription().length() > 150) {
//            errors.rejectValue("longDescription", "Long Description should be between 10 and 150 characters.");
//        }

//
//        if( user.getProductName()!=null && !user.getProductName().isEmpty()){
//            List<ProductsEntity> productsEntity = productsDatatableRepository.checkProductName(user.getProductName());
//            if (productsEntity.size()>0 ) {
//                errors.rejectValue("productName", "Product Name already available. Please try with the different Product Name.");
//            }
//        }else{
//            errors.rejectValue("productName", "Please Enter Valid Product Name");
//        }

    }
}
