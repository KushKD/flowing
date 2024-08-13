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
    <img src="https://www.flowchakra.in/public/frontend/default/assets/img/shapes/roll-1.png?v=v2.1.0" alt="roll"
        class="position-absolute z--1 roll vector-shape">
    <img src="https://www.flowchakra.in/public/frontend/default/assets/img/shapes/roll-2.png?v=v2.1.0" alt="roll"
        class="position-absolute z--1 roll-2 vector-shape">
    <div class="container">
        <div class="row">
            <div class="col-12">
                    <div class="breadcrumb-content">
        <h2 class="mb-2 text-center">My Wishlist</h2>
        <nav>
            <ol class="breadcrumb justify-content-center">
                <li class="breadcrumb-item fw-bold" aria-current="page"><a
                        href="#">Home</a></li>
                <li class="breadcrumb-item fw-bold" aria-current="page">My Wishlist</li>
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
         <table id="sampleTable" class="wishlist-table w-100 bg-white">
            <thead style="background-color:#006FB9; font-weight: bold; padding:10px; justify-content: center;">
               <tr>
            <th class="text-center" style="font-weight: bold; justify-content: center; ">Product Image</th>
            <th class="text-center" style="font-weight: bold; justify-content: center; ">Product Name</th>
             <th class="text-center" style="font-weight: bold; justify-content: center;">Product Price</th>
            <th class="text-center" style="font-weight: bold; justify-content: center; ">Product Tax</th>
            <th class="text-center" style="font-weight: bold; justify-content: center; "> Action</th>
               </tr>
            </thead>
         </table>
      </div>
</div>
</section>


<script>

	 var datatable =  $('table#sampleTable').DataTable({
		ajax: '/apidataTable/wishlist',
		serverSide: true,
		iDisplayLength: 10,

		columns: [


                			{
                				data: 'productId.productImage',
                				render: function (data) {
                                console.log(data)
                                    return '<div><img src="${pageContext.request.contextPath}/downloadFile/${"' + data + '"}" class="thumbnail img-responsive" style="max-height:80px; max-width:80px;"/></div>'
                                }
                			},

                			{
                                                                    				data: 'productId.productName'
                                                                    			},

                            			{
                                        				data: 'productId.productPrice',
                                        				render: function(data){
                                        				 return '<span class="text-dark fw-bold"><span class="fw-bold h4 text-danger">'+data+'</span></span>'
                                        				}

                                        			},
                			{
                            	data: 'productId.productTax'
                            },


                			{
                				data: 'productId.productId',
                				render: function (data) {
                				console.log(data)
                					return '<div><a href="javascript:void(0);" class="btn btn-secondary btn-sm ms-5 rounded-1"  onclick="showProductDetailsModal(' + data + ');">Add to Card</a>  <a href="#" class="close-btn ms-3" onclick="showProductDetailsModal(' + data + ');"><i class="fas fa-close"></i></a></div>'
                				}


                			}
                		]
	});


</script>