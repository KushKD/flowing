<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapd.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/pace.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.spring-friendly.js"></script>
<style>
   .app-content {
   background-color: #FFFFFF;
   }

   .fixed-width-with-wrap {
     width: 400px; /* Set your desired fixed width */
     word-wrap: break-word;
   }

   /* Style for modal content */
   .modal-content {
       background-color: #fefefe;
       margin: 1% auto;
       padding: 0px;
       border: 1px solid #888;
       width: 100%;
   }

   /* Style for modal row */
   .modal-row {
       display: flex;
       margin-bottom: 10px;
   }

   /* Style for label */
   .label {
       color: blue; /* Change the color as desired */
       width: 150px; /* Adjust width as needed */
       font-weight: bold;
   }

   /* Style for value */
   .value {
       color: black;
       flex-grow: 1;
   }





</style>
<div class="content-wrapper">
   <div class="row" style="box-shadow: 0 0 8px 2px #888; padding:10px;">

      <h2 class="form-signin-heading text-left" style="color:#006FB9; padding 20px;">Grievance</h2>
         <table id="sampleTable" class="table table-striped table-bordered">
          <caption style="color: red;">
              <ul>
                  <li>Addressing grievances through open dialogue, empathy, and fair resolution fosters trust, strengthens relationships, and promotes positive change within communities or organizations.</li>
              </ul>
          </caption>
           <thead style="background-color:#006FB9 !important; font-weight: bold !important; padding:10px !important; justify-content: center !important;">
               <tr>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Name</th>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Email</th>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Mobile</th>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Support For</th>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Message</th>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Created Date</th>
                   <th class="text-center" style="font-weight: bold !important; justify-content: center !important; color:#FFFFFF !important;">Action</th>
               </tr>
           </thead>
         </table>
      </div>
   </div>
</main>
<!-- Modal -->
<div class="modal fade" id="detailsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Message Details</h5>
            </div>
            <div class="modal-body">
                <!-- Modal content will be dynamically populated here -->
                <div id="modalContent"></div>
            </div>

        </div>
    </div>
</div>




<script>

   $('table#sampleTable').DataTable({
      ajax: '/apidataTable/getQueries',
      serverSide: true,
      iDisplayLength: 10,
      order: [[ 4, "desc" ]],
      columns: [
       {
         data: 'name',
       },
       {
                data: 'email',
              },

       {
          data: 'phone',
       },
         {
            data: 'supportFor',
         },
         {
                     data: 'message',
                  },

         {
            data: 'createdDate',
            render: function (data) {
                   const d = new Date( data );
                   date =  d.toDateString() + ", " + d.getHours() + ":" + d.getMinutes() ;

                       return '<div class="badge bg-warning" style="width:100%">' + date + '</div>'

               }
         },


         {
             data: 'queryId',
             render: function (data) {
                 return '<div class="btn-group"><button type="button" class="btn btn-success" onclick="openDetailsModal(' + data + ')">View Details</button></div>';
             }
         }
      ]
   });


   // Function to open modal and populate with details
   function openDetailsModal(dataId) {
       // AJAX call to fetch details
       $.ajax({
           url: '/getDetails',
           type: 'GET',
           data: { id: dataId },
           success: function(response) {
               // Populate modal with details
               populateModal(response);
               // Open the modal
               $('#detailsModal').modal('show');
           },
           error: function(xhr, status, error) {
               console.error("Error fetching details:", error);
               // Display error message or handle error as required
           }
       });
   }

function populateModal(data) {
    if (data && data.success) {
        var modalContent = "<div class='modal-content'>";

        // Order Code
        modalContent += "<div class='modal-row'><div class='label'>Order Code:</div><div class='value'>" + data.orderDetails.receipt + "</div></div>";

        // Date
        modalContent += "<div class='modal-row'><div class='label'>Date:</div><div class='value'>" + data.orderDetails.createdDate + "</div></div>";

        // Shipping Address
        modalContent += "<div class='modal-row'><div class='label'>Shipping Address:</div><div class='value'>" + data.shippingAddress.address + ", " + data.shippingAddress.city + "-" + data.shippingAddress.pincode + ", " + data.shippingAddress.stateId.stateName + "</div></div>";

        // Billing Address
        modalContent += "<div class='modal-row'><div class='label'>Billing Address:</div><div class='value'>" + data.billingAddress.address + ", " + data.billingAddress.city + "-" + data.billingAddress.pincode + ", " + data.billingAddress.stateId.stateName + "</div></div>";

        // Cart Items
        modalContent += "<div><div class='label'>Cart Items:</div><div class='value'>";
        modalContent += "<table class='table table-responsive table-bordered'><thead><tr><th>S.No</th><th>Products</th><th>Unit Price</th><th>Quantity</th><th>Total Price</th></tr></thead><tbody>";

        // Populate cart items
        data.cartItems.forEach(function(item, index) {
            modalContent += "<tr>";
            modalContent += "<td>" + (index + 1) + "</td>";
            modalContent += "<td>" + item.productsEntity.productName + "</td>";
            modalContent += "<td>&#8377;" + item.productsEntity.productPrice + "</td>";
            modalContent += "<td>" + item.productQuantity + "</td>";
            modalContent += "<td>&#8377;" + (item.productsEntity.productPrice * item.productQuantity) + "</td>";
            modalContent += "</tr>";
        });

        modalContent += "</tbody></table></div></div>";

        // Subtotal and Total Price
        modalContent += "<div class='modal-row'><div class='label'>Subtotal:</div><div class='value'>&#8377;" + data.orderDetails.amount + "</div></div>";
        modalContent += "<div class='modal-row'><div class='label'>Total Price:</div><div class='value'>&#8377;" + data.orderDetails.amount + "</div></div>";

        // Payment Method
        modalContent += "<div class='modal-row'><div class='label'>Payment Method:</div><div class='value'>" + data.orderDetails.paymentMethord + "</div></div>";

        modalContent += "</div>"; // Close modal-content

        $('#modalContent').html(modalContent);
    } else {
        $('#modalContent').html('<p>No data available</p>');
    }

    // Ensure close button works
    $('#closeModal').on('click', function() {
        $('#myModal').modal('hide');
    });
}




</script>