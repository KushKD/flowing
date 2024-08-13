 <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="ibox bg-success color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalStudent}</h2>
                               <a href="${pageContext.request.contextPath}/viewstudentsv" style="color:white;">  <div class="m-b-5">Total Students</div><i class="ti-user widget-stat-icon"></i> </a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                    </a>


                    <div class="col-lg-4 col-md-6">
                        <div class="ibox bg-warning color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalMale}</h2>
                                <a href="#" style="color:white;"> <div class="m-b-5">Total Male Students</div><i class="fa fa-money widget-stat-icon"></i> </a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-6">
                        <div class="ibox bg-danger color-white widget-stat">
                            <div class="ibox-body">
                                <h2 class="m-b-5 font-strong">${totalFemale}</h2>
                                <a href="#" style="color:white;"><div class="m-b-5">Total Female Students</div><i class="ti-user widget-stat-icon"></i></a>
                                <div><i class="m-r-5"></i><small>&nbsp;</small></div>
                            </div>
                        </div>
                    </div>
                </div>

                <br>
                <h4 class="form-signin-heading" style="color:#006FB9">Options</h4><hr>
                <div class="row" style="margin-top:10px;">

                        <div class="col-md-6 col-lg-3">
                             <div class="card">
                               <div class="row no-gutters">
                                 <div class="col-md-4">
                                   <img src="${pageContext.request.contextPath}/resources/images/school/teacher.png" style="padding:15px;" class="card-img" alt="Image">
                                 </div>
                                 <div class="col-md-8">
                                   <div class="card-body">
                                     <h5 class="card-title">View Teachers</h5>
                                     <a href="${pageContext.request.contextPath}/viewuserschool" class="btn btn-success">View</a>
                                   </div>
                                 </div>
                               </div>
                             </div>
                        </div>

                        <div class="col-md-6 col-lg-3">
                                     <div class="card">
                                       <div class="row no-gutters">
                                         <div class="col-md-4">
                                          <img src="${pageContext.request.contextPath}/resources/images/school/attendance.png" style="padding:15px;" class="card-img" alt="Image">

                                         </div>
                                         <div class="col-md-8">
                                           <div class="card-body">
                                             <h5 class="card-title">View Attendance</h5>
                                             <a href="${pageContext.request.contextPath}/viewAttendanceSchool" class="btn btn-warning">View</a>
                                           </div>
                                         </div>
                                       </div>
                                     </div>
                                </div>

                        <div class="col-md-6 col-lg-3">
                                     <div class="card">
                                       <div class="row no-gutters">
                                         <div class="col-md-4">
                                           <img src="${pageContext.request.contextPath}/resources/images/school/students.png" style="padding:15px;" class="card-img" alt="Image">
                                         </div>
                                         <div class="col-md-8">
                                           <div class="card-body">
                                             <h5 class="card-title">View Students</h5>
                                             <a href="${pageContext.request.contextPath}/viewstudentsv" class="btn btn-primary">View</a>
                                           </div>
                                         </div>
                                       </div>
                                     </div>
                                </div>

                        <div class="col-md-6 col-lg-3">
                                     <div class="card">
                                       <div class="row no-gutters">
                                         <div class="col-md-4">
                                           <img src="${pageContext.request.contextPath}/resources/images/school/school.png" style="padding:15px;" class="card-img" alt="Image">

                                         </div>
                                         <div class="col-md-8">
                                           <div class="card-body">
                                             <h5 class="card-title">View Schools</h5>
                                             <a href="${pageContext.request.contextPath}/viewschoolspecific" class="btn btn-danger">View</a>
                                           </div>
                                         </div>
                                       </div>
                                     </div>
                                </div>
                  </div>

                <br>
                <div class="row" style="margin-top:10px;">

                        <div class="col-md-6 col-lg-3">
                             <div class="card">
                               <div class="row no-gutters">
                                 <div class="col-md-4">
                                   <img src="${pageContext.request.contextPath}/resources/images/school/teacher_report.png" style="padding:15px;" class="card-img" alt="Image">
                                 </div>
                                 <div class="col-md-8">
                                   <div class="card-body">
                                     <h5 class="card-title"> Reports (Teachers)</h5>
                                     <a href="${pageContext.request.contextPath}/viewTeacherReportSchool" class="btn btn-danger">View</a>
                                   </div>
                                 </div>
                               </div>
                             </div>
                        </div>

                        <div class="col-md-6 col-lg-3">
                                     <div class="card">
                                       <div class="row no-gutters">
                                         <div class="col-md-4">
                                          <img src="${pageContext.request.contextPath}/resources/images/school/student_report.png" style="padding:15px;" class="card-img" alt="Image">

                                         </div>
                                         <div class="col-md-8">
                                           <div class="card-body">
                                             <h5 class="card-title">Reports (Students)</h5>
                                             <a href="${pageContext.request.contextPath}/viewStudentReportSchool" class="btn btn-primary">View</a>
                                           </div>
                                         </div>
                                       </div>
                                     </div>
                                </div>

                         <div class="col-md-6 col-lg-3">
                              <div class="card">
                                 <div class="row no-gutters">
                                    <div class="col-md-4">
                                       <img src="${pageContext.request.contextPath}/resources/images/school/lifestyle.png" style="padding:15px;" class="card-img" alt="Image">
                                    </div>
                                    <div class="col-md-8">
                                       <div class="card-body">
                                          <h5 class="card-title">Activities</h5>
                                          <a href="${pageContext.request.contextPath}/createactivity" class="btn btn-warning">View</a>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>

                        <div class="col-md-6 col-lg-3">
                                     <div class="card">
                                       <div class="row no-gutters">
                                         <div class="col-md-4">
                                           <img src="${pageContext.request.contextPath}/resources/images/school/job.png" style="padding:15px;" class="card-img" alt="Image">

                                         </div>
                                         <div class="col-md-8">
                                           <div class="card-body">
                                             <h5 class="card-title">Placements</h5>
                                             <a href="${pageContext.request.contextPath}/studentplacement" class="btn btn-danger">View</a>
                                           </div>
                                         </div>
                                       </div>
                                     </div>
                                </div>
                  </div>

                <br>
                <h4 class="form-signin-heading" style="margin-top:10px; color:#006FB9">Students (Gender/Religion/Economic Level Wise)</h4><hr>
                            <div class="row" style="padding:10px; margin-left:10px;">



                                   <div class="row col-lg-6">
                                      <div class="col-lg-12" style="background-color:#FFFFFF">
                                         <div class="tile" style="height:100%; width:100%;">
                                            <h5 class="tile-title text-center">Gender Wise Students</h5>
                                            <div>
                                               <canvas style="width:100%; height:100%;" id="barChartGender"></canvas>
                                            </div>
                                         </div>
                                      </div>
                                   </div>

                                  <div class="row col-lg-6" >
                                     <div class="col-lg-12" style="background-color:#FFFFFF">
                                        <div class="tile" style="height:100%; width:100%;">
                                           <h5 class="tile-title text-center">Religion Wise Students</h5>
                                           <div>
                                              <canvas style="width:100%; height:100%;" id="barChartReligion"></canvas>
                                           </div>
                                        </div>
                                     </div>
                                  </div>

                               <div class="row col-lg-6" >
                                  <div class="col-lg-12" style="background-color:#FFFFFF">
                                     <div class="tile" style="height:100%; width:100%;">
                                        <h5 class="tile-title text-center">Economic Level Wise Students</h5>
                                        <div>
                                           <canvas style="width:100%; height:100%;" id="barChartEconomic"></canvas>
                                        </div>
                                     </div>
                                  </div>
                               </div>

                               <div class="row col-lg-6" >
                                 <div class="col-lg-12" style="background-color:#FFFFFF">
                                    <div class="tile" style="height:100%; width:100%;">
                                       <h5 class="tile-title text-center">Category Wise Category</h5>
                                       <div>
                                          <canvas style="width:100%; height:100%;" id="barChartcategory"></canvas>
                                       </div>
                                    </div>
                                 </div>
                              </div>


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

                            function setChartgetCategoryWiseStudents(data) {
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
                                var $chart = $('#barChartcategory');
                                var pieChartHome = new Chart($chart[0].getContext("2d"), {
                                    type: 'bar',
                                    data: {
                                        labels: labels,
                                        datasets: [{
                                            label: 'Category',
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
                                   getGenderWiseStudentsSchool();
                                   getReligionWiseStudentsSchool();
                                   getEconomicWiseStudentsSchool();
                                   getChartgetCategoryWiseStudents();
                               });




                            </script>