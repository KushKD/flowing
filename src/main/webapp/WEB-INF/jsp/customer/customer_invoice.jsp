<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<section class="invoice-section pt-6 pb-120">
   <div class="container">
      <div class="invoice-box bg-white rounded p-4 p-sm-6">
         <div class="row g-5 justify-content-between">
            <div class="col-lg-6">
               <div class="invoice-title d-flex align-items-center">
                  <h3>INVOICE</h3>
                  <span class="badge rounded-pill bg-primary-light text-primary fw-medium ms-3">
                  <c:if test="${OrdersEntity.status eq 'created'}">
                      Order Placed (Payment Unsuccessful: ${OrdersEntity.status})
                  </c:if>
                  <c:if test="${OrdersEntity.status eq 'completed'}">
                      Order Placed (Payment Successful: ${OrdersEntity.status})
                  </c:if>
                  </span>
               </div>
               <table class="invoice-table-sm">
                  <tr>
                     <td><strong>Order Code:</strong></td>
                     <td>${OrdersEntity.receipt}</td>
                  </tr>
                  <tr>
                     <td><strong>Date:</strong></td>
                     <td>${OrdersEntity.createdDate}</td>
                  </tr>
               </table>
            </div>
            <div class="col-lg-5 col-md-8">
               <div class="text-lg-end">
                  <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/logo.png"
                     alt="logo" class="img-fluid"></a>
                  <h6 class="mb-0 text-gray mt-4">Flat No &ndash; 701, Block No &ndash; 43, Sector 4, New Shimla, Shimla, 171009</h6>
               </div>
            </div>
         </div>
         <span class="my-6 w-100 d-block border-top"></span>
         <div class="row justify-content-between g-5">
            <div class="col-xl-7 col-lg-6">
               <div class="welcome-message">
                  <h4 class="mb-2">${OrdersEntity.userId.firstName} ${OrdersEntity.userId.lastName}</h4>
                  <p class="mb-0">
                     Here are your order details. We thank you for your purchase.
                  </p>
                  <p class="mb-0">Delivery Type:
                     <span
                        class="badge bg-primary">Regular</span>
                  </p>
               </div>
            </div>
            <div class="col-xl-5 col-lg-6">
               <div class="shipping-address d-flex justify-content-md-end">
                  <div class="border-end pe-2">
                     <h6 class="mb-2">Shipping Address</h6>
                     <p class="mb-0">${shippingAddress.address} ${shippingAddress.city}-${shippingAddress.pincode},
                         ${shippingAddress.stateId.stateName}</p>
                  </div>
                  <div class="ms-4">
                     <h6 class="mb-2">Billing Address</h6>
                     <p class="mb-0">${billingAddress.address} ${billingAddress.city}-${billingAddress.pincode},
                                              ${billingAddress.stateId.stateName}</p>
                  </div>
               </div>
            </div>
         </div>
         <div class="table-responsive mt-6">
             <table class="table invoice-table">
                 <tr>
                     <th>S.No</th>
                     <th>Products</th>
                     <th>U.Price</th>
                     <th>Qty</th>
                     <th>T.Price</th>
                 </tr>
                 <!-- Check if cartItems is not empty -->
                 <c:if test="${not empty cartItems}">
                     <!-- Loop through cartItems -->
                     <c:forEach items="${cartItems}" var="item" varStatus="status">
                         <tr>
                             <td>${status.index + 1}</td>
                             <td class="text-nowrap">
                                 <div class="d-flex">
                                     <img src="${item.productsEntity.productImage}"
                                          alt="${item.productsEntity.productName}"
                                          class="img-fluid product-item d-none">
                                     <div class="">
                                         <span>${item.productsEntity.productName}</span>
                                         <div>${item.productsEntity.shortDescription}</div>
                                     </div>
                                 </div>
                             </td>
                             <td> &#x20B9; ${item.productsEntity.productPrice}</td>
                             <td>${item.productQuantity}</td>
                             <td> &#x20B9; ${item.productsEntity.productPrice * item.productQuantity}</td>
                         </tr>
                     </c:forEach>
                 </c:if>
             </table>
         </div>
         <div class="mt-4 table-responsive">
            <table class="table footer-table">
               <tr>
                  <td>
                     <strong class="text-dark d-block text-nowrap">Payment Method</strong>
                     <span> ${OrdersEntity.paymentMethord}</span>
                  </td>
                  <td>
                     <strong class="text-dark d-block text-nowrap">Sub Total</strong>
                     <span>&#x20B9;${OrdersEntity.amount}</span>
                  </td>
                  <td>
                     <strong class="text-dark d-block text-nowrap">Shipping Cost</strong>
                     <span>&#x20B9; 0.00</span>
                  </td>
                  <td>
                     <strong class="text-dark d-block text-nowrap">Total Price</strong>
                     <span
                        class="text-primary fw-bold">&#x20B9; ${OrdersEntity.amount}</span>
                  </td>
               </tr>
            </table>
         </div>
      </div>
   </div>
</section>
<!--invoice section end-->