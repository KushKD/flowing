package com.mis.education.Education.MIS.modules.products.controller;

import com.mis.education.Education.MIS.fileStorage.FileStorageService;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import com.mis.education.Education.MIS.modules.products.form.ProductForm;
import com.mis.education.Education.MIS.modules.products.validator.ProductsUpdateValidator;
import com.mis.education.Education.MIS.modules.products.validator.ProductsValidator;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.repositories.ProductThumbnails.ProductThumbnailsDatatableRepository;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductsDatatableRepository productsDatatableRepository;

    @Autowired
    ProductThumbnailsDatatableRepository productThumbnailsDatatableRepository;

    @Autowired
    ProductsValidator productsValidator;

    @Autowired
    ProductsUpdateValidator productsUpdateValidator;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
    public String createTransfer(Model model, HttpServletRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            System.out.println(user);

            if (user == null) {
                return "login";
            } else {
                model.addAttribute("productForm", new ProductForm());
                return "createProduct";
            }

        }
    }


    //viewProducts
    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
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
                return "viewProducts";
            }
        }
    }


    @RequestMapping(value = "/updateProduct/{product_id}", method = RequestMethod.GET)
    public String updateDistrict(@PathVariable("product_id") Integer productId, Model model, HttpServletRequest request) throws Exception {

        System.out.println(productId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                return "login";
            } else {

                ProductsEntity product = productsDatatableRepository.getProductViaId(productId);
                System.out.println(product.toString());

                /**
                 * Get Images Via Product Id
                 */
                List<ProductsThumbnail> productImages = productThumbnailsDatatableRepository.getProductThumbnailsViaId(productId);
                model.addAttribute("product_to_update", product);
                model.addAttribute("product_images_to_update", productImages);
                model.addAttribute("productForm", new ProductForm());
                return "updateProduct";
            }
        }
    }


    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveDetails(@ModelAttribute("productForm") ProductForm transferForm, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {


        productsValidator.validate(transferForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createProduct";
        }
        try {
            UserEntity userSession = (UserEntity) request.getSession().getAttribute("UserData");
            ProductsEntity productsEntity = new ProductsEntity();
            ProductsEntity savedTransferRequest = null;
            productsEntity.setProductTax(transferForm.getProductTax());
            productsEntity.setProductName(transferForm.getProductName());
            productsEntity.setProductPrice(transferForm.getProductPrice());
            productsEntity.setLongDescription(transferForm.getLongDescription());
            productsEntity.setShortDescription(transferForm.getShortDescription());
            productsEntity.setProductTax(transferForm.getProductTax());
            String productName = fileStorageService.storeFile(transferForm.getProductImage());
            productsEntity.setProductImage(productName);
            productsEntity.setActive(true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            productsEntity.setCreatedDate(date);
            savedTransferRequest = productsDatatableRepository.save(productsEntity);


            /**
             * Saving Files
             */
            List<ProductsThumbnail> documentsList = new ArrayList<>();
            for (int i = 0; i < transferForm.getProductThumbnails().length; i++) {
                ProductsThumbnail trd = new ProductsThumbnail();
                String fileName = fileStorageService.storeFile(transferForm.getProductThumbnails()[i]);
                trd.setActive(true);
                trd.setDocumentName(fileName);
                Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                Date date2 = new Date(timestamp2.getTime());
                trd.setCreatedDate(date2);
                trd.setEnteredBy(userSession.getUserId().intValue());
                trd.setProductId(Math.toIntExact(savedTransferRequest.getProductId()));
                documentsList.add(trd);
            }
            productThumbnailsDatatableRepository.saveAll(documentsList);
            transferForm.setProductName("");
            transferForm.setLongDescription("");
            transferForm.setShortDescription("");
            transferForm.setProductTax("");
            transferForm.setProductPrice("");
            request.getSession().setAttribute("successMessage", "Product saved Successfully. Generated Product Id is:- " + "Flowchkra-Product--" + savedTransferRequest.getProductName());
            return "redirect:/viewProducts";

        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "createProduct";
        }

    }


    // updateModuleEntity
    @RequestMapping(value = "/updateProductEntity", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateModuleEntity(@ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {


        productsUpdateValidator.validate(productForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "updateProduct";
        }
        try {
            UserEntity userSession = (UserEntity) request.getSession().getAttribute("UserData");
            ProductsEntity savedModule = null;
            ProductsEntity productToUpdate = new ProductsEntity();
            productToUpdate = productsDatatableRepository.getProductViaId(Integer.parseInt(productForm.getProductId()));
            productToUpdate.setProductName(productForm.getProductName());
            productToUpdate.setProductTax(productForm.getProductTax());
            productToUpdate.setProductPrice(productForm.getProductPrice());
            productToUpdate.setLongDescription(productForm.getLongDescription());
            productToUpdate.setShortDescription(productForm.getShortDescription());

            if (!productForm.getProductImage().getOriginalFilename().isEmpty()) {
             String productImage = fileStorageService.storeFile(productForm.getProductImage());
             productToUpdate.setProductImage(productImage);
            }


            productToUpdate.setActive(productForm.getIsActive().equalsIgnoreCase("T"));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            productToUpdate.setCreatedDate(date);

            savedModule = productsDatatableRepository.save(productToUpdate);

            List<ProductsThumbnail> documentsList = new ArrayList<>();

            if (productForm.getProductThumbnails() != null) {
                for (int i = 0; i < productForm.getProductThumbnails().length; i++) {
                    if (productForm.getProductThumbnails()[i].getSize() > 0 && !productForm.getProductThumbnails()[i].getName().isEmpty()) {
                        ProductsThumbnail trd = new ProductsThumbnail();
                        String fileName = fileStorageService.storeFile(productForm.getProductThumbnails()[i]);
                        trd.setActive(true);
                        trd.setDocumentName(fileName);
                        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                        Date date2 = new Date(timestamp2.getTime());
                        trd.setCreatedDate(date2);
                        trd.setEnteredBy(userSession.getUserId().intValue());
                        trd.setProductId(Math.toIntExact(savedModule.getProductId()));
                        documentsList.add(trd);
                    }
                }
                productThumbnailsDatatableRepository.saveAll(documentsList);
            }


            request.getSession().setAttribute("successMessage", "Module Updated Successfully. ");
            return "redirect:/viewProducts";
        } catch (Exception ex) {
            request.getSession().setAttribute("successMessage", ex.getLocalizedMessage());
            return "updateProduct";
        }

    }



    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model) {
        return "products";
    }


}
