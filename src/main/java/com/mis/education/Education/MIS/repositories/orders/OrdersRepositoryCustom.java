package com.mis.education.Education.MIS.repositories.orders;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.order.OrdersEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepositoryCustom {

    OrdersEntity findOrderByOrderId(String razorpay_order_id);
    OrdersEntity findOrderById(Integer id);

    Integer getCompletedOrders();
    Integer getCreatedOrders();

    Integer getCompletedOrdersViaUserID(Integer UserID);
    Integer getCreatedOrdersViaUserID(Integer UserId);

    Double getTotalPaymentsReceived();


}
