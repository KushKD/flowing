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
</style>
<div class="content-wrapper">
   <div class="row" style="box-shadow: 0 0 8px 2px #888; padding:10px;">

      <h2 class="form-signin-heading text-left" style="color:#006FB9; padding 20px;">Roles Master</h2>
         <table id="sampleTable" class="table table-striped table-bordered">
            <thead style="background-color:#006FB9; font-weight: bold; padding:10px; justify-content: center;">
               <tr>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF">Role Id</th>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF">Role Name</th>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF">Role Description</th>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Active/Inactive</th>
                   <th class="text-center" style="font-weight: bold; justify-content: center; color:#FFFFFF"> Action</th>
               </tr>
            </thead>
         </table>

   </div>
</div>


<script>
	$('table#sampleTable').DataTable({
		ajax: '/apidataTable/getRoles',
		serverSide: true,
		columns: [

			{
				data: 'roleId'
			},
			{
				data: 'roleName'
			},
			{
            				data: 'roleDescription'
            			},

			{
				data: 'active',
				render: function (data) {
					console.log(data);
					if (data == true) {
						return '<div class="button-group btn btn-success" style="width:100%">' + data + '</div>'
					} else {
						return '<div class="button-group btn btn-danger" style="width:100%">' + data + '</div>'
					}
				}
			},


			{
				data: 'roleId',
				render: function (data) {
					return '<div class="btn-group"><a href="${pageContext.request.contextPath}/updateRole/${"' + data + '"}" class="btn btn-warning" ;>Update</a></div>'
				}


			}
		]
	});

</script>