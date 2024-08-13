<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery-3.6.4.min.js"></script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>


<!--breadcrumb-->
<div class="gstore-breadcrumb position-relative z-1 overflow-hidden mt--50">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/roll-1.png" alt="roll"
      class="position-absolute z--1 roll vector-shape">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/roll-2.png" alt="roll"
      class="position-absolute z--1 roll-2 vector-shape">
   <div class="container">
      <div class="row">
         <div class="col-12">
            <div class="breadcrumb-content">
               <h2 class="mb-2 text-center">Check Out</h2>
               <nav>
                  <ol class="breadcrumb justify-content-center">
                     <li class="breadcrumb-item fw-bold" aria-current="page"><a href="${pageContext.request.contextPath}/">Home</a></li>
                     <li class="breadcrumb-item fw-bold" aria-current="page">Checkout</li>
                  </ol>
               </nav>
            </div>
         </div>
      </div>
   </div>
</div>
<!--breadcrumb-->
<!--checkout form start-->

 <form:form  id='razor-pay'  modelAttribute="checkoutcompleteForm">

        <form:input type="hidden" name="razorpay_payment_id" path="razorpay_payment_id" id="razorpay_payment_id"/>
        <form:input type="hidden" name="amount" id="amount" path="amount" value="${checkoutForm.total}"/>
        <form:input type="hidden" name="key" id="key" path="key" value="${key}"/>
        <form:input type="hidden" name="total" id="total" path="total" value="${checkoutForm.total}"/>
        <form:input type="hidden" name="order_id" id="order_id" path="order_id" value="${order}"/>
        <form:input type="hidden" name="name" id="name" path="name" value="${name}"/>
        <form:input type="hidden" name="email" id="email" path="email" value="${email}"/>
        <form:input type="hidden" name="phone" id="phone" path="phone" value="${checkoutForm.phone}"/>
        <form:input type="hidden" name="notes" id="notes" path="notes" value=""/>
    </form:form>



<form:form class="checkout-form" modelAttribute="checkoutForm" action="${pageContext.request.contextPath}/checkout-complete" method="POST">
   <form:input type="hidden" name="cartId" id="cartId" path="cartId" value="${cart}"/>

   <div class="checkout-section ptb-120">
      <div class="container">
         <div class="row g-4">
            <!-- form data -->
            <div class="col-xl-8">
               <div class="checkout-steps">
                  <!-- shipping address -->
                  <div class="d-flex justify-content-between">
                     <h4 class="mb-3">Shipping Address</h4>
                     <a href="javascript:void(0);" onclick="addNewAddress()" class="fw-semibold"><i class="fas fa-plus me-1"></i> Add Address</a>
                  </div>
                  <div class="row g-4">
                     <c:if test="${not empty address}">
                        <%-- Iterate over the list of addresses --%>
                        <c:forEach var="addr" items="${address}">
                              <div class="col-lg-6 col-sm-6">
                                 <div class="tt-address-content">
                                 <spring:bind path="shippingAddressId">
                                    <form:radiobutton path="shippingAddressId" checked="checked" class="tt-custom-radio" name="shipping_address_id" id="shipping-${addr.addressId}" value="${addr.addressId}" onchange="getLogistics()" />
                                    <label for="shipping-${addr.addressId}" class="tt-address-info bg-white rounded p-4 position-relative">

                                          <!-- address -->
                                          <address class="fs-sm mb-0">
                                             <strong>${addr.address} , ${addr.city}</strong>
                                          </address>

                                          <strong> City: </strong>${addr.city}
                                          <br>
                                          <strong>State: </strong>${addr.stateId.stateName}
                                          <br>
                                          <strong>Country: </strong>India
                                          <br>
                                          <strong>Pincode: </strong>${addr.pincode}
                                    <!-- address -->
                                   <!-- <a href="javascript:void(0);" onclick="editAddress(${addr.addressId})" class="tt-edit-address checkout-radio-link position-absolute">Edit</a>  -->
                                 </label>
                                  <form:errors style="color:red;" path="shippingAddressId"></form:errors>
                                 </spring:bind>
                                 </div>
                              </div>
                        </c:forEach>
                     </c:if>
                  </div>
                  <!-- shipping address -->
                  <!-- checkout-logistics -->
                  <div class="checkout-logistics"></div>
                  <!-- checkout-logistics -->


                  <!-- billing address -->
                 <!-- <h4 class="mb-3 mt-7">Billing Address</h4>
                  <div class="row g-4">

        <c:if test="${not empty address}">
           <c:forEach var="addr" items="${address}">
                 <div class="col-lg-6 col-sm-6">
                    <div class="tt-address-content">
                    <spring:bind path="billingAddressId">
                     <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:radiobutton class="tt-custom-radio" path="billingAddressId" name="billing_address_id" id="billing-${addr.addressId}" value="${addr.addressId}" onchange="getLogistics()" />
                       <label for="billing-${addr.addressId}" class="tt-address-info bg-white rounded p-4 position-relative">

                             <address class="fs-sm mb-0">
                                <strong>${addr.address} , ${addr.city}</strong>
                             </address>

                             <strong> City: </strong>${addr.city}
                             <br>
                             <strong>State: </strong>${addr.stateId.stateName}
                             <br>
                             <strong>Country: </strong>India
                             <br>
                             <strong>Pincode: </strong>${addr.pincode}
                      <a href="javascript:void(0);" onclick="editAddress(${addr.addressId})" class="tt-edit-address checkout-radio-link position-absolute">Edit</a>
                    </label>
                     <form:errors style="color:red;" path="billingAddressId"></form:errors>
                    </div>
                 </spring:bind>
                    </div>
                 </div>
           </c:forEach>
        </c:if> </div> -->  <!-- billing address -->


                  <!-- Delivery Time -->
                  <h4 class="mt-7 mb-3">Preferred Delivery Time</h4>
                  <div class="row g-4">
                     <div class="col-12">
                        <div class="tt-address-content">
                           <input type="radio" class="tt-custom-radio" name="shipping_delivery_type" id="regular-shipping" value="regular" checked>
                           <label for="regular-shipping" class="tt-address-info bg-white rounded p-4 position-relative">
                              <div class="d-flex flex-wrap justify-content-between align-items-center">
                                 <span class=""><i class="fas fa-truck me-1"></i>
                                 Regular Delivery
                                 </span>
                                 <p class="mb-0 fs-sm">
                                    We will deliver your products soon.
                                 </p>
                              </div>
                           </label>
                        </div>
                     </div>
                  </div>
                  <!-- personal information -->
                  <h4 class="mt-7">Personal Information</h4>
                  <div class="checkout-form mt-3 p-5 bg-white rounded-2">
                     <div class="row g-4">
                      <spring:bind path="phone">
                        <div class="col-sm-6 ${status.error ? 'has-error' : ''}">
                           <div class="label-input-field">
                              <label>Phone<span style="color:red;">*</span></label>
                              <form:input type="text" name="phone" path="phone" placeholder="Phone Number"  value="${checkoutForm.phone}" required="true" maxlength="10"></form:input>
                            <form:errors style="color:red;" path="phone"></form:errors>
                           </div>
                        </div>
                        </spring:bind>


                         <spring:bind path="alternatePhone">
                          <div class="col-sm-6 ${status.error ? 'has-error' : ''}">
                           <div class="label-input-field">
                              <label>Alternative Phone</label>
                              <form:input type="text" path="alternatePhone" name="alternative_phone" placeholder="Your Alternative Phone"  value="${checkoutForm.alternatePhone}" required="true" maxlength="10"></form:input>
                              <form:errors style="color:red;" path="alternatePhone"></form:errors>
                           </div>
                        </div>
                        </spring:bind>


                        <spring:bind path="additionalInfo">
                        <div class="col-sm-12 ${status.error ? 'has-error' : ''}">
                           <div class="label-input-field">
                              <label>Additional Info</label>
                              <form:textarea rows="3" path="additionalInfo" type="text" name="additional_info" value=""  placeholder="Type your additional informations here" />
                              <form:errors style="color:red;" path="additionalInfo"></form:errors>
                           </div>
                        </div>
                        </spring:bind>

                         <form:hidden path="total" id="hiddenField" />
                         <form:hidden path="items" id="hiddenFieldItems" />


                     </div>
                  </div>
                  <!-- personal information -->
                  <!-- payment methods -->
                  <!-- <h4 class="mt-7">Payment Method</h4>
                  <div class="checkout-radio d-flex align-items-center justify-content-between gap-3 bg-white rounded p-4 mt-3">
                     <spring:bind path="paymentMethord">
                     <div class="radio-left d-inline-flex align-items-center">
                        <div class="theme-radio ${status.error ? 'has-error' : ''}">
                           <form:radiobutton name="payment_method" id="razorpay" path="paymentMethord" value="razorpay" required="true" />
                           <span class="custom-radio"></span>
                            <form:errors style="color:red;" name="paymentMethord"></form:errors>
                        </div>
                        <label for="razorpay" class="ms-2 h6 mb-0">Pay with Razorpay</label>
                     </div>
                     </spring:bind>
                     <div class="radio-right text-end">
                        <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/razorpay.svg" alt="razorpay" class="img-fluid">
                     </div>
                  </div> -->
                  <!-- payment methods -->
               </div>
            </div>
            <!-- form data -->
            <!-- order summary -->



                    <div class="col-xl-4">
                       <div class="checkout-sidebar">
                       
                     <!--  <div class="sidebar-widget py-6 px-4 bg-white rounded-2">
                       <div class="widget-title d-flex">
                       <h5 class="mb-0 flex-shrink-0">Order Summary</h5>
                       <span class="hr-line w-100 position-relative d-block align-self-end ms-1"></span>
                       </div>
                       <table class="sidebar-table w-100 mt-5">
                       <tr><td>(+) Items(1):</td>
                       <td class="text-end">₹1400.0</td></tr>
                       
                       <tr>
                       <td>(+) Tax:</td>
                       <td class="text-end">₹168.0</td>
                       </tr>
                       </table>
                       
                       <span class="sidebar-spacer d-block my-4 opacity-50">
                       </span><div class="d-flex align-items-center justify-content-between">
                       <h6 class="mb-0 fs-md">Total</h6>
                       <h6  class="mb-0 fs-md"> &#8377; 1568.0</h6>
                       
                       </div>
                       <button type="submit" class="btn btn-primary btn-md rounded mt-6 w-100">Place Order</button></div>
                       
                       -->
                       
                       </div>
                    </div>

            <!-- order summary -->
         </div>
      </div>
   </div>
</form:form>

    <!--add address modal start-->
                <div class="modal fade addAddressModal" id="addAddressModal">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <button type="button" class="btn-close float-end" data-bs-dismiss="modal" aria-label="Close"></button>

                                <div class="gstore-product-quick-view bg-white rounded-3 py-6 px-4">
                                    <h2 class="modal-title fs-5 mb-3">Add New Address</h2>
                                    <div class="row align-items-center g-4 mt-3">
                                        <form:form method="POST" modelAttribute="addressForm" action="${pageContext.request.contextPath}/saveAddressCart"  class="form-signin">

                                            <div class="row g-4">
                                                <spring:bind path="country">
                                                <div class="col-sm-6">
                                                    <div class="w-100 label-input-field">
                                                        <label>Country<span style="color:red;">*</span></label>
                                                        <form:select path="country" class="select2Address" name="country_id" onchange="getStates();">
                                                            <form:option value="">Select Country</form:option>
                                                            <form:option value="1">India</form:option>
                                                        </form:select>
                                                    </div>
                                                     <form:errors style="color:red;" path="country"></form:errors>
                                                </div>
                                                </spring:bind>

                                                <spring:bind path="state">
                                                <div class="col-sm-6">
                                                    <div class="w-100 label-input-field">
                                                        <label>State<span style="color:red;">*</span></label>
                                                        <form:select path="state" id="state_id" class="select2Address"  name="state_id">
                                                        </form:select>
                                                    </div>
                                                     <form:errors style="color:red;" path="state"></form:errors>
                                                </div>
                                                </spring:bind>

                                                <spring:bind path="city">
                                                <div class="col-sm-6">
                                                    <div class="w-100 label-input-field">
                                                        <label>City<span style="color:red;">*</span></label>
                                                        <form:input path="city" name="city" type="text"  placeholder="Enter City" value="" maxlength="36" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" ></form:input>

                                                    </div>
                                                     <form:errors style="color:red;" path="city"></form:errors>
                                                </div>
                                                </spring:bind>

                                                 <spring:bind path="defaultAddress">
                                                <div class="col-sm-6">
                                                    <div class="w-100 label-input-field">
                                                        <label>Default Address?</label>
                                                        <form:select class="select2Address" path="defaultAddress" name="is_default">
                                                            <form:option value="0">No</form:option>
                                                            <form:option value="1">Set Default</form:option>
                                                        </form:select>
                                                    </div>
                                                    <form:errors style="color:red;" path="defaultAddress"></form:errors>
                                                </div>
                                                </spring:bind>

                                                <spring:bind path="address">
                                                <div class="col-sm-6">
                                                    <div class="label-input-field">
                                                        <label>Address<span style="color:red;">*</span></label>
                                                         <form:textarea path="address"  rows="4" placeholder="2/5 Elephant Road, New Town" name="address"></form:textarea>
                                                    </div>
                                                    <form:errors path="address"></form:errors>
                                                </div>
                                                </spring:bind>

                                                <spring:bind path="pincode">
                                                <div class="col-sm-6">
                                                    <div class="label-input-field">
                                                        <label>Pin Code<span style="color:red;">*</span></label>
                                                         <form:input type="number" name="pincode" path="pincode" placeholder="000000" value="" maxlength="6" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" />
                                                    </div>
                                                     <form:errors path="pincode"></form:errors>
                                                </div>
                                                </spring:bind>

                                            </div>
                                            <div class="mt-6 d-flex">
                                                <button type="submit" class="btn btn-secondary btn-md me-3">Save</button>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade editAddressModal" id="editAddressModal">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <button type="button" class="btn-close float-end" data-bs-dismiss="modal" aria-label="Close"></button>
                                <div class="gstore-product-quick-view bg-white rounded-3 py-6 px-4">
                                    <h2 class="modal-title fs-5 mb-3">Update Address</h2>

                                    <div class="spinner pt-6 pb-8 d-none">
                                        <div class="row align-items-center g-4 mt-3">
                                            <div class="d-flex justify-content-center">
                                                <div class="spinner-border" role="status">
                                                    <span class="visually-hidden">Loading...</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="edit-address d-none">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade deleteAddressModal" id="deleteAddressModal">
                    <div class="modal-dialog address-delete-modal modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-body">
                                <button type="button" class="btn-close float-end" data-bs-dismiss="modal" aria-label="Close"></button>
                                <div class="bg-white rounded-3 py-6 px-4">
                                    <h2 class="modal-title fs-5 mb-3">Delete Address</h2>
                                    <div class="pt-6 pb-8 text-center">
                                        <h6>Want to delete this address?</h6>
                                    </div>
                                    <div class="text-center">
                                        <a href="" class="btn btn-secondary delete-address-link">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!--add address modal end-->

<script type="text/javascript">
"use strict";

$(document).ready(function() {
    console.log("Document is ready");
    getLogistics();
});

        function getLogistics() {
         console.log("getLogistics called");
            $.ajax({
                url: "api/get-checkout-summary",
                type: 'GET',
                success: function(data) {
                    $('.checkout-sidebar').empty();
                    $('.checkout-sidebar').html(data.summary);
                    $('#hiddenField').val(data.total);
                    $('#hiddenFieldItems').val(data.items);
                }
            });
        }
    </script>

<script>
 // address modal select2
       function addressModalSelect2(parent = '.addAddressModal') {
           $('.select2Address').select2({
               dropdownParent: $(parent)
           });
       }



 function addNewAddress() {
                $('#addAddressModal').modal('show');
                parent = '.addAddressModal';
                addressModalSelect2(parent);
            }





 function getStates() {
           $.ajax({
               type: "GET",
               url: "/ajax/getStates",

               success: function (data) {
                   //Tomcat
                   var json_ = JSON.parse(JSON.stringify(data));
                   //Jboss
                   //var json_ = JSON.parse(data);
                   console.log(json_);
                   var selectRole = $('#state_id'); // the state select element
                   selectRole.find('option').remove();
                   selectRole.append("<option value=" + 0 + " >" + "---Select States---" + "</option>")
                   for (i = 0; i < json_.RESPONSE.length; i++) {
                       if (document.getElementById('did') != null && document.getElementById('did')
                           .value == json_.RESPONSE[i].districtId) {
                           selectRole.append("<option selected value=" + json_.RESPONSE[i].stateID + " >" + json_.RESPONSE[i].stateName + "</option>")
                       } else {
                           selectRole.append("<option value=" + json_.RESPONSE[i].stateID + " >" + json_.RESPONSE[i].stateName + "</option>")
                       }
                   }

               },
               error: function (data) {
                   console.log(data)
               }

           });


       }
</script>



<script type="text/javascript">
        "use strict";

        $(document).ready(function() {


           // e.preventDefault();
            var amount = $('#amount').val();
            var key = $('#key').val();
            var name = $('#name').val();
            var email = $('#email').val();
            var order_id = $('#order_id').val();
            var total_amount = amount * 100;
            var options = {
                "key": key,
                "amount":amount,
                "currency": "INR",
                "name": "Flow Chakra",
                "description": "Order Payment",
                "image": "https://www.flowchakra.in/public/uploads/media/zMk4tbj3wLszcjvYfpiUSyMM9zJoeo4QtpGtboDp.png",
                "order_id": order_id,
                "handler": function (response){
                console.log(response);
                var generatedSignature = CryptoJS.HmacSHA256(order_id + "|" + response.razorpay_payment_id, "VVp4CWE7Rzj95uH6HEkmL3Ux").toString(CryptoJS.enc.Hex);
                var isSignatureValid = generatedSignature == response.razorpay_signature;
                if (isSignatureValid) {
                    savePaymentDetails(response.razorpay_payment_id, response.razorpay_signature, response.razorpay_order_id);
                }

                },
                "prefill": {
                    "name": name,
                    "email": email
                },
                "theme": {
                    "color": "#ff7529"
                },
                "modal":{
                    "ondismiss": function(){

                    if (confirm("Are you sure, you want to close the form?")) {
                              //txt = "You pressed OK!";
                              console.log("Checkout form closed by the user");
                              window.location.replace("/checkout");
                            } else {
                              txt = "You pressed Cancel!";
                              console.log("Complete the Payment")
                    }
                   }
                }

            };
            var rzp1 = new Razorpay(options);
            rzp1.open();

        });



       // Function to save payment details
             function savePaymentDetails(paymentId, signature, orderId) {
                 $.ajax({
                     url: "/save-payment-details",
                     type: "POST",
                     data:{
                         razorpay_payment_id: paymentId,
                         razorpay_signature: signature,
                         razorpay_order_id: orderId
                     },
                     success: function(data) {
                         alert(data);
                           window.location.replace("/customer-dashboard");
                     },
                     error: function(xhr, status, error) {
                         alert("Failed to save payment details. Please try again later.");
                         window.location.replace("/customer-dashboard");
                     }
                 });
             }
    </script>
