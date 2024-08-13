package com.mis.education.Education.MIS.modules.order;

import com.mis.education.Education.MIS.modules.customer_address.CustomerAddressEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import com.mis.education.Education.MIS.repositories.customer_address.CustomerAddressRepository;
import com.mis.education.Education.MIS.repositories.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OrdersRestController {

    @Autowired
    OrdersRepository ordersRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CustomerAddressRepository customerAddressRepository;



    //
    @RequestMapping(value = "/apidataTable/getUserOrders", method = RequestMethod.GET)
    public DataTablesOutput<OrdersEntity> wishlist_customer(@Valid DataTablesInput input, HttpServletRequest request) {

        UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

        Specification<OrdersEntity> userId = (root, query, criteriaBuilder) -> {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<OrdersEntity> cq = cb.createQuery(OrdersEntity.class);
            Root<OrdersEntity> book = cq.from(OrdersEntity.class);
            Predicate schoolId_ = cb.equal(book.get("userId").get("userId"), user.getUserId());
            Predicate completed = cb.equal(book.get("status"), "completed");
            cq.where(schoolId_, completed);
            TypedQuery<OrdersEntity> queryq =  entityManager.createQuery(cq);
            return cq.getRestriction();
        };



        return ordersRepository.findAll(input,userId);
    }


    @RequestMapping(value = "/apidataTable/getOrders", method = RequestMethod.GET)
    public DataTablesOutput<OrdersEntity> orders(@Valid DataTablesInput input) {

//        Specification<OrdersEntity> userId = (root, query, criteriaBuilder) -> {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<OrdersEntity> cq = cb.createQuery(OrdersEntity.class);
//            Root<OrdersEntity> book = cq.from(OrdersEntity.class);
//          //  Predicate completed = cb.equal(book.get("status"), "completed");
//           // cq.where( completed);
//            TypedQuery<OrdersEntity> queryq =  entityManager.createQuery(cq);
//            return cq.getRestriction();
//        };


        return ordersRepository.findAll(input);
    }






    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getDetails(@RequestParam Long id, HttpServletRequest request) {
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("UserData");

            OrdersEntity orderDetails = ordersRepository.findOrderById(Math.toIntExact(id));
            if (orderDetails == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            CustomerAddressEntity shippingAddress = customerAddressRepository.getAddressByAddressId(orderDetails.getShippingaddressId());
            CustomerAddressEntity billingAddress = customerAddressRepository.getAddressByAddressId(orderDetails.getBillingaddressId());

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("orderDetails", orderDetails);
            response.put("cartItems", orderDetails.getCartId().getCartItemId());
            response.put("shippingAddress", shippingAddress);
            response.put("billingAddress", billingAddress);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
