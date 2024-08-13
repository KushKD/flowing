<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapd.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/pace.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/dataTables.rowGroup.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.spring-friendly.js"></script>
<style>
   .app-content {
   background-color: #FFFFFF;
   }


   #sampleTable_length{ display:none;  }
   .dataTables_filter { display: block; text-align: right;}


   .dtrg-group {
       background-color: #ddd;
       font-weight: bold;
       text-align: center;
   }


</style>

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
        <h2 class="mb-2 text-center">My Cart</h2>
        <nav>
            <ol class="breadcrumb justify-content-center">
                <li class="breadcrumb-item fw-bold" aria-current="page"><a
                        href="${pageContext.request.contextPath}/">Home</a></li>
                <li class="breadcrumb-item fw-bold" aria-current="page">My Cart</li>
            </ol>
        </nav>
    </div>
            </div>
        </div>
    </div>
</div>
    <!--breadcrumb-->

 <section class="wishlist-section">
<div class="container">
  <div class="rounded-2 overflow-hidden">
         <table id="sampleTable" >
            <thead style="background-color:#F2F2F2; font-weight: bold; padding:10px; justify-content: center;">
               <tr>
            <th class="text-center" style="font-weight: bold; justify-content: center; ">Product Image</th>
            <th class="text-center" style="font-weight: bold; justify-content: center; ">Product Name</th>
             <th class="text-center" style="font-weight: bold; justify-content: center;">Product Price</th>
            <th class="text-center" style="font-weight: bold; justify-content: center; ">Product Quantity</th>
            <th class="text-center" style="font-weight: bold; justify-content: center; "> Remove</th>
               </tr>
            </thead>
         </table>
      </div>

      <div class="col-12">
        <a href="${pageContext.request.contextPath}/checkout" class="btn btn-primary btn-md mt-4 w-100"><span class="me-2"><i class="fa-solid fa-credit-card"></i></span>Checkout</a>
     </div>
</div>
</section>


<script>



	 var datatable =  $('table#sampleTable').DataTable({
		ajax: '/apidataTable/cartItems',
		serverSide: true,
		iDisplayLength: 10,

		columns: [


                			{
                				data: 'productsEntity.productImage',
                				render: function (data) {
                               // console.log(data)
                                    return '<div><img src="${pageContext.request.contextPath}/downloadFile/${"' + data + '"}" class="thumbnail img-responsive" style="max-height:80px; max-width:80px;"/></div>'
                                }
                			},

                			{
                                                                    				data: 'productsEntity.productName'
                                                                    			},

                            			{
                                        				data: 'productsEntity.productPrice',
                                        				render: function(data){
                                        				 return '<span class="text-dark fw-bold"><span class="fw-bold h4 text-danger">'+data+'</span></span>'
                                        				}

                                        			},
                			{
                            	data: 'productQuantity'
                            },


                			{
                				data: 'productsEntity.productId',
                				render: function (data) {
                                        return '<div><a href="#" class="close-btn ms-3" onclick="handleCartItem2(' + data + ','  + data + ');"><i class="fas fa-close"></i></a></div>';
                                    }


                			}
                		]
	});


	 // handleCartItem
        function handleCartItem2(action, id) {
            let data = {
                action: action,
                id: id,
            };
            $.ajax({
                type: "POST",
                url: '/api/update-cart',
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function(data) {
                    if (data.success == true) {
                        $('.apply-coupon-btn').removeClass('d-none');
                        $('.clear-coupon-btn').addClass('d-none');
                        $('.apply-coupon-btn').prop('disabled', false);
                        $('.apply-coupon-btn').html(TT.localize.applyCoupon);
                        notifyMe('success', data.message);
                        updateCarts(data);
                        datatable.ajax.reload();
                    }
                }
            });
        }


</script>