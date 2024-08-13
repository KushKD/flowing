<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapd.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>


<div class="content-wrapper">
            <!-- START PAGE CONTENT-->
<sec:authorize access="hasAnyAuthority('OWNER','Directorate', 'Admin')">
            <div class="page-content fade-in-up">
                <div class="row">

                <div class="col-lg-3 col-md-6">
                    <div class="ibox bg-danger color-white widget-stat">
                        <div class="ibox-body">
                            <h2 class="m-b-5 font-strong">${paymentsReceived}</h2>
                            <a href="#" style="color:white;"><div class="m-b-5">Payments Received </div><i class="fa fa-inr widget-stat-icon"></i></a>
                            <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                        </div>
                    </div> </div>


                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-success color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalCustomers}</h2>
                               <a href="${pageContext.request.contextPath}/viewUsers" style="color:white;">  <div class="m-b-5">Customers</div><i class="ti-user widget-stat-icon"></i> </a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    </a>

                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-info color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalProducts}</h2>
                                 <a href="${pageContext.request.contextPath}/viewProducts" style="color:white;"> <div class="m-b-5">Products</div><i class="fa fa-shopping-basket widget-stat-icon"></i></a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="ibox bg-warning color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${getCompletedOrders}</h2>
                                <a href="${pageContext.request.contextPath}/viewOrders" style="color:white;"> <div class="m-b-5">Orders (Completed)</div><i class="fa fa-shopping-cart widget-stat-icon"></i> </a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>



                 <br>
                                <h4 class="form-signin-heading" style="color:#006FB9;padding:10px;">Options</h4>
                                <div class="row" style="margin-top:10px; padding:10px;">

                                        <div class="col-md-6 col-lg-3">
                                             <div class="card">
                                               <div class="row no-gutters">
                                                 <div class="col-md-4">
                                                   <img src="${pageContext.request.contextPath}/resources/images/school/customers.png" style="padding:15px;" class="card-img" alt="Image">
                                                 </div>
                                                 <div class="col-md-8">
                                                   <div class="card-body">
                                                     <h5 class="card-title">View Customers</h5>
                                                     <a href="${pageContext.request.contextPath}/viewUsers" class="btn btn-success">View</a>
                                                   </div>
                                                 </div>
                                               </div>
                                             </div>
                                        </div>

                                        <div class="col-md-6 col-lg-3">
                                                     <div class="card">
                                                       <div class="row no-gutters">
                                                         <div class="col-md-4">
                                                          <img src="${pageContext.request.contextPath}/resources/images/school/products.png" style="padding:15px;" class="card-img" alt="Image">

                                                         </div>
                                                         <div class="col-md-8">
                                                           <div class="card-body">
                                                             <h5 class="card-title">View Products</h5>
                                                             <a href="${pageContext.request.contextPath}/viewProducts" class="btn btn-warning">View</a>
                                                           </div>
                                                         </div>
                                                       </div>
                                                     </div>
                                                </div>

                                        <div class="col-md-6 col-lg-3">
                                                     <div class="card">
                                                       <div class="row no-gutters">
                                                         <div class="col-md-4">
                                                           <img src="${pageContext.request.contextPath}/resources/images/school/orders.png" style="padding:15px;" class="card-img" alt="Image">
                                                         </div>
                                                         <div class="col-md-8">
                                                           <div class="card-body">
                                                             <h5 class="card-title">View Orders</h5>
                                                             <a href="${pageContext.request.contextPath}/viewOrders" class="btn btn-primary">View</a>
                                                           </div>
                                                         </div>
                                                       </div>
                                                     </div>
                                                </div>

                                        <div class="col-md-6 col-lg-3">
                                                     <div class="card">
                                                       <div class="row no-gutters">
                                                         <div class="col-md-4">
                                                           <img src="${pageContext.request.contextPath}/resources/images/school/grievance.png" style="padding:15px;" class="card-img" alt="Image">

                                                         </div>
                                                         <div class="col-md-8">
                                                           <div class="card-body">
                                                             <h5 class="card-title">View Grievances</h5>
                                                             <a href="${pageContext.request.contextPath}/contact-us" class="btn btn-danger">View</a>
                                                           </div>
                                                         </div>
                                                       </div>
                                                     </div>
                                                </div>
                                  </div>

                                <br>



</sec:authorize>




               <sec:authorize access="hasAnyAuthority('SEX','Directorate', 'Admin')">
               <hr><h4 class="form-signin-heading" style="color:#006FB9">Students (Gender/Religion/Economic Level Wise)</h4><hr>
                           <div class="row" style="padding:10px; margin-left:10px;">

                   <div class="row col-lg-4">
                      <div class="col-lg-12" style="background-color:#FFFFFF">
                         <div class="tile" style="height:100%; width:100%;">
                            <h5 class="tile-title text-center">Gender Wise Students</h5>
                            <div>
                               <canvas style="width:100%; height:90%;" id="barChartGender"></canvas>
                            </div>
                         </div>
                      </div>
                   </div>

                  <div class="row col-lg-4" >
                     <div class="col-lg-12" style="background-color:#FFFFFF">
                        <div class="tile" style="height:100%; width:100%;">
                           <h5 class="tile-title text-center">Religion Wise Students</h5>
                           <div>
                              <canvas style="width:100%; height:90%;" id="barChartReligion"></canvas>
                           </div>
                        </div>
                     </div>
                  </div>

               <div class="row col-lg-4" >
                  <div class="col-lg-12" style="background-color:#FFFFFF">
                     <div class="tile" style="height:100%; width:100%;">
                        <h5 class="tile-title text-center">Economic Level Wise Students</h5>
                        <div>
                           <canvas style="width:100%; height:90%;" id="barChartEconomic"></canvas>
                        </div>
                     </div>
                  </div>
               </div>
                </sec:authorize>
            </div>



<script>

function setChartgetGenderWiseStudents(data) {
            		var obj = JSON.constructor(JSON.parse(data));
            		console.log(obj);

            		var labels = obj.members.map(e => e.gender);
            		console.log(labels);
            		var data = obj.members.map(e => e.totalStudents);
            		console.log(data);

            		Chart.defaults.global.defaultFontColor = '#75787c';
            		// ------------------------------------------------------- //
            		// Pie Chart Custom 2
            		// ------------------------------------------------------ //
            		var $chart = $('#barChartGender');
            		var pieChartHome = new Chart($chart[0].getContext("2d"), {
            			type: 'bar',
            			data: {
            				labels: labels,
            				datasets: [{
            					label: 'Gender Wise',
            					data: data,
            					backgroundColor: [
                                      'rgb(54, 162, 235)',
                                      'rgb(255, 205, 86)',
                                      'rgb(255, 205, 86)',
                                      'rgb(255, 205, 86)',
                                      'rgb(255, 205, 86)'
                                    ],
                                    hoverOffset: 4
            				}]

            			}
            		})
            	}



//setChartgetReligionWiseStudents
function setChartgetReligionWiseStudents(data) {
    var obj = JSON.constructor(JSON.parse(data));
    console.log(obj);

    var labels = obj.members.map(e => e.gender);
    console.log(labels);
    var data = obj.members.map(e => e.totalStudents);
    console.log(data);

    Chart.defaults.global.defaultFontColor = '#75787c';
    // ------------------------------------------------------- //
    // Pie Chart Custom 2
    // ------------------------------------------------------ //
    var $chart = $('#barChartReligion');
    var pieChartHome = new Chart($chart[0].getContext("2d"), {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Religion',
                data: data,
                backgroundColor: [
                      'rgb(54, 162, 235)',
                      'rgb(255, 205, 86)',
                      'rgb(255, 205, 86)',
                      'rgb(255, 205, 86)',
                      'rgb(255, 205, 86)'
                    ],
                    hoverOffset: 4
            }]

        }
    })


}

function setChartgetEconomicWiseStudents(data) {
    var obj = JSON.constructor(JSON.parse(data));
    console.log(obj);

    var labels = obj.members.map(e => e.gender);
    console.log(labels);
    var data = obj.members.map(e => e.totalStudents);
    console.log(data);

    Chart.defaults.global.defaultFontColor = '#75787c';
    // ------------------------------------------------------- //
    // Pie Chart Custom 2
    // ------------------------------------------------------ //
    var $chart = $('#barChartEconomic');
    var pieChartHome = new Chart($chart[0].getContext("2d"), {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Economic Level',
                data: data,
                backgroundColor: [
                      'rgb(54, 162, 235)',
                      'rgb(255, 205, 86)',
                      'rgb(255, 205, 86)',
                      'rgb(255, 205, 86)',
                      'rgb(255, 205, 86)'
                    ],
                    hoverOffset: 4
            }]

        }
    })


}

$(document).ready(function() {
       getGenderWiseStudents();
       getReligionWiseStudents();
       getEconomicWiseStudents();
   });




</script>