package com.mis.education.Education.MIS.modules.cartitems;

import com.mis.education.Education.MIS.modules.cart_items.CartItemsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import com.mis.education.Education.MIS.repositories.cart_items.CartItemRepository;
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
import java.util.Map;

@RestController
public class CartItemsRestController {

    @Autowired
    CartItemRepository cartItemRepository;

    @PersistenceContext
    private EntityManager entityManager;



    @RequestMapping(value = "/apidataTable/cartItems", method = RequestMethod.GET)
    public DataTablesOutput<CartItemsEntity> wishlist_customer(@Valid DataTablesInput input, HttpServletRequest request) {

        UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

        Specification<CartItemsEntity> userId = (root, query, criteriaBuilder) -> {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CartItemsEntity> cq = cb.createQuery(CartItemsEntity.class);
            Root<CartItemsEntity> book = cq.from(CartItemsEntity.class);
            Predicate schoolId_ = cb.equal(book.get("userId"), user.getUserId());
            cq.where(schoolId_);
            TypedQuery<CartItemsEntity> queryq =  entityManager.createQuery(cq);
            return cq.getRestriction();
        };



        return cartItemRepository.findAll(input,userId);
    }

}
