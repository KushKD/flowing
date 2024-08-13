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

</style>
<div class="content-wrapper">
   <div class="row" style="box-shadow: 0 0 8px 2px #888; padding:10px;">

      <h2 class="form-signin-heading text-left" style="color:#006FB9; padding 20px;">Teachers Profile</h2>
         <table id="sampleTable" class="table table-striped table-bordered">
            <thead style="background-color:#006FB9; font-weight: bold; padding:10px; justify-content: center;">
               <tr>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF">Username Name</th>
                  <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF">District Name</th>
                  <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Educational Block</th>
                  <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> School Name</th>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Teacher Type</th>
                   <th class="text-center " style="font-weight: bold; justify-content: center; color:#FFFFFF"> WhatsApp No.</th>
                  <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Active/Inactive</th>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Download ID</th>
                  <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Update</th>
                  </tr>
            </thead>
         </table>
      </div>
   </div>
</main>


<script>
	$('table#sampleTable').DataTable({
		ajax: '/apidataTable/alluserSchoolWise',
		serverSide: true,
		columns: [


			{
				data: 'username'
			},
            {
               data: 'districtId.districtName'
            },

            {
               data: 'edublock.districtName'
            },

            {
               data: 'schoolId.schoolName'
            },
            {
               data: 'ttype_id.ttypeName'
            },

                        {
                           data: 'whatsapp_number'
                        },
			{
				data: 'active',
				render: function (data) {
					if (data == true) {
						return '<div class="button-group btn btn-success" style="width:90%">' + data + '</div>'
					} else {
						return '<div class="button-group btn btn-danger" style="width:90%">' + data + '</div>'
					}
				}
			},
			{
                        data: 'userId',
                        render: function (data) {
                            return '<div class="btn-group"><a href="${pageContext.request.contextPath}/generateTeacherId/${"' + data + '"}" class="btn btn-primary" target="_blank" ;>Download ID</a></div>'
                        }
                        },
			{
            data: 'userId',
            render: function (data) {
                return '<div class="btn-group"><a href="${pageContext.request.contextPath}/updateUserSpecific/${"' + data + '"}" class="btn btn-primary" ;>Update</a></div>'
            }
            }
		]
	});

</script>