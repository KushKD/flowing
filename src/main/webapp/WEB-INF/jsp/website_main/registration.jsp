<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section style="margin-top:20px;">
   <div class="container">
      <div class="row justify-content-center">
         <div class="col-lg-12 col-12 bg-white d-flex p-0 tt-login-col shadow">
            <div class="form-group">
               <c:if test="${serverError != null}">
                  <div id="serverError" style="padding:10px; margin:10px;" class="alert alert-danger alert-dismissable fade show plErroMessage">
                     <button class="close" onclick="closeAlert();"><i class="fa fa-lg fa-fw fa-close"> </i></button>
                     <strong>Warning!</strong> ${serverError}
                  </div>
               </c:if>
               <c:if test="${successMessage != null}">
                  <div id="successMessage" style="padding:10px; margin:10px;" class="alert alert-success alert-dismissable fade show plErroMessage">
                     <button class="close" onclick="closeAlertsuccessMessage();"><i class="fa fa-lg fa-fw fa-close"> </i></button>
                     <strong>Success!</strong> ${successMessage}
                  </div>
               </c:if>
            </div>
         </div>
         <div class="col-lg-5 col-12 tt-login-img" >
            <div class="mb-7">
               <a href="${pageContext.request.contextPath}/">
               <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/login_screen.jpg" alt="logo" style="max-height:800px;">
               </a>
            </div>
         </div>
         <div class="col-lg-5 col-12 bg-white d-flex p-0 tt-login-col shadow">
            <form:form method="post" modelAttribute="registerUser" class="tt-login-form-wrap p-3 p-md-6 p-lg-6 py-7 w-100" action="${pageContext.request.contextPath}/saveuser">
               <h2 class="mb-4 h3">Hey there!
                  <br>Register as a Customer
               </h2>
               <div class="row g-3">
                  <spring:bind path="firstName">
                     <div class="col-sm-6 ${status.error ? 'has-error' : ''}" >
                        <div class="input-field">
                           <label class="fw-bold text-dark fs-sm mb-1">First name<sup class="text-danger">*</sup>
                           </label>
                           <form:input type="text" path="firstName" id="firstName" placeholder="First name" class="theme-input" autocomplete="off"  oncopy="return false" onpaste="return false"></form:input>
                           <form:errors style="color:red;" path="firstName"></form:errors>
                        </div>
                     </div>
                  </spring:bind>
                  <spring:bind path="lastName">
                     <div class="col-sm-6 ${status.error ? 'has-error' : ''}" >
                        <div class="input-field">
                           <label class="fw-bold text-dark fs-sm mb-1">Last name<sup class="text-danger">*</sup>
                           </label>
                           <form:input type="text" path="lastName" id="firstName" placeholder="Last name" class="theme-input" autocomplete="off"  oncopy="return false" onpaste="return false"></form:input>
                           <form:errors style="color:red;" path="lastName"></form:errors>
                        </div>
                     </div>
                  </spring:bind>
                  <spring:bind path="email">
                     <div class="col-sm-12 ${status.error ? 'has-error' : ''}" >
                        <div class="input-field">
                           <label class="fw-bold text-dark fs-sm mb-1">Email<sup class="text-danger">*</sup></label>
                           <form:input type="text" path="email" id="email" placeholder="Email" class="theme-input" autocomplete="off"  oncopy="return false" onpaste="return false"></form:input>
                           <form:errors style="color:red;"  path="email"></form:errors>
                        </div>
                     </div>
                  </spring:bind>
                  <spring:bind path="password">
                     <div class="col-sm-12 ${status.error ? 'has-error' : ''}" >
                        <div class="input-field check-password">
                           <label class="fw-bold text-dark fs-sm mb-1">Password<sup class="text-danger">*</sup></label>
                           <div class="check-password">
                              <form:input type="password" path="password" name="password" placeholder="Password" class="theme-input" required=""></form:input>
                              <span class="eye eye-icon"><i class="fa-solid fa-eye"></i></span>
                              <span class="eye eye-slash"><i class="fa-solid fa-eye-slash"></i></span>
                           </div>
                           <form:errors style="color:red;" path="password"></form:errors>
                        </div>
                     </div>
                  </spring:bind>
                  <spring:bind path="passwordConfirm">
                     <div class="col-sm-12 ${status.error ? 'has-error' : ''}" >
                        <div class="input-field check-password">
                           <label class="fw-bold text-dark fs-sm mb-1">Confirm Password<sup class="text-danger">*</sup></label>
                           <div class="check-password">
                              <form:input type="password" path="passwordConfirm" name="passwordConfirm" placeholder="Confirm Password" class="theme-input" required=""></form:input>
                              <span class="eye eye-icon"><i class="fa-solid fa-eye"></i></span>
                              <span class="eye eye-slash"><i class="fa-solid fa-eye-slash"></i></span>
                           </div>
                           <form:errors style="color:red;" path="passwordConfirm"></form:errors>
                        </div>
                     </div>
                  </spring:bind>
               </div>
               <div class="row g-4 mt-4">
                  <div class="col-sm-12">
                     <button type="submit" class="btn btn-primary w-100">Sign Up</button>
                  </div>
               </div>
               <p class="mb-0 fs-xs mt-4">Already have an Account? <a href="${pageContext.request.contextPath}/login">Sign In</a></p>
            </form:form>
         </div>
      </div>
   </div>
   </div>
</section>
<script>
   function closeAlert(){
                      var serverError = document.getElementById('serverError');
                              serverError.style.display = 'none'; // Hide the pop-up
                      }

                       function closeAlertsuccessMessage(){
                                          var serverError = document.getElementById('successMessage');
                                                  serverError.style.display = 'none'; // Hide the pop-up
                                          }
</script>

