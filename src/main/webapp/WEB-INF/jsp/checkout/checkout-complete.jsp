<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery-3.6.4.min.js"></script>
 <script src="https://checkout.razorpay.com/v1/checkout.js"></script>

<section>

 <form:form  id='razor-pay'  modelAttribute="checkoutcompleteForm">

        <form:input type="hidden" name="razorpay_payment_id" path="razorpay_payment_id" id="razorpay_payment_id"/>
        <form:input type="hidden" name="amount" id="amount" path="amount" value="${checkoutForm.total}"/>
        <form:input type="hidden" name="key" id="key" path="key" value="${key}"/>
        <form:input type="hidden" name="total" id="total" path="total" value="${checkoutForm.total}"/>
        <form:input type="hidden" name="order_id" id="order_id" path="order_id" value="${order}"/>
        <form:input type="hidden" name="name" id="name" path="name" value="${name}"/>
        <form:input type="hidden" name="email" id="email" path="email" value="${email}"/>
        <form:input type="hidden" name="phone" id="phone" path="phone" value="${checkoutForm.phone}"/>
        <form:input type="hidden" name="notes" id="notes" path="notes" value="Not Required"/>
    </form:form>

<section>



<script type="text/javascript">
    "use strict";

    $(document).ready(function() {
        var amount = $('#amount').val();
        var key = $('#key').val();
        var name = $('#name').val();
        var email = $('#email').val();
        var order_id = $('#order_id').val();
        var total_amount = amount * 100;

        var options = {
            "key": key,
            "amount": amount,
            "currency": "INR",
            "name": "Flow Chakra",
            "description": "Order Payment",
            "image": "https://www.flowchakra.in/public/uploads/media/zMk4tbj3wLszcjvYfpiUSyMM9zJoeo4QtpGtboDp.png",
            "order_id": order_id,
            "handler": function(response) {
                console.log(response);

                alert("Payment Successful");

                 // Call function to save payment details
                 savePaymentDetails(response.razorpay_payment_id, response.razorpay_signature, response.razorpay_order_id);
            },
            "prefill": {
                "name": name,
                "email": email
            },
            "theme": {
                "color": "#ff7529"
            },
            "modal": {
                "ondismiss": function() {
                    if (confirm("Are you sure you want to close the form?")) {
                        console.log("Checkout form closed by the user");
                        //location.replace("/");
                    } else {
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
        alert("We are inside the function");
            $.ajax({
                url: "/save-payment-details",
                type: "POST",
                data:{
                    razorpay_payment_id: paymentId,
                    razorpay_signature: signature,
                    razorpay_order_id: orderId
                },
                success: function(data) {
                    console.log("Response from server:", data);
                    // Optionally, redirect the user or perform any other action
                },
                error: function(xhr, status, error) {
                    console.error("Error:", error);
                    // Handle error
                    alert("Failed to save payment details. Please try again later.");
                }
            });
        }
</script>

