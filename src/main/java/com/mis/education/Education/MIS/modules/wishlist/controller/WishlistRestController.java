package com.mis.education.Education.MIS.modules.wishlist.controller;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import com.mis.education.Education.MIS.repositories.wishlist.WishlistDatatableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WishlistRestController {

    @Autowired
    WishlistDatatableRepository wishlistDatatableRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/api/addToWishList", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addToWishList(@RequestParam int productId, HttpServletRequest request) {
        try {

            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");
            if (user == null) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", " Please Login to Add Products to Wishlist.");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            } else {

                //Check is the product is already added to the Wishlist
                if((wishlistDatatableRepository.getProductViaId(productId, user.getUserId())).isEmpty()){
                    WishlistEntity addToWishlist = new WishlistEntity();
                    addToWishlist.setActive(true);
                    addToWishlist.setQuantity(1);
                    ProductsEntity product = new ProductsEntity();
                    product.setProductId(Long.valueOf(productId));
                    addToWishlist.setProductId(product);
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserId(user.getUserId());
                    addToWishlist.setUserId(userEntity);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    Date date = new Date(timestamp.getTime());
                    addToWishlist.setCreatedDate(date);

                    WishlistEntity addedWish = wishlistDatatableRepository.save(addToWishlist);
                    Map<String, Object> response = new HashMap<>();
                    response.put("data", "Product added to Wishlist.");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }else{
                    Map<String, Object> response = new HashMap<>();
                    response.put("data", "Product already exist in your wishlist");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }


            }


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @RequestMapping(value = "/apidataTable/wishlist", method = RequestMethod.GET)
    public DataTablesOutput<WishlistEntity> wishlist_customer(@Valid DataTablesInput input, HttpServletRequest request) {

        UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

        Specification<WishlistEntity> userId = (root, query, criteriaBuilder) -> {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<WishlistEntity> cq = cb.createQuery(WishlistEntity.class);
            Root<WishlistEntity> book = cq.from(WishlistEntity.class);
            Predicate schoolId_ = cb.equal(book.get("userId").get("userId"), user.getUserId());
            cq.where(schoolId_);
            TypedQuery<WishlistEntity> queryq =  entityManager.createQuery(cq);
            return cq.getRestriction();
        };



        return wishlistDatatableRepository.findAll(input,userId);
    }

}
