<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/flight_application_form.js"></script>
                <section class="container" style="margin-top:10px; margin-bottom:10px;">
                    <div class="row">
                        <h2 class="col-lg-12 text-center" style="color:#77332F;"> <spring:message code="loginpage.heading" text="Login"/> </h2>

                    </div>
                    <div class="row">
                        <div class="col-lg-2">&nbsp;</div>
                        <div class="col-lg-4">
                            <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/login_screen.jpg" style="max-height:500px;" class="img-responsive" />
                        </div>
                        <div class="col-lg-4" style=" background-color:#FFFFFF; ">
                            <form method="post" onsubmit="return submit_form()"  class="loginForm" action="${pageContext.request.contextPath}/login">
                                <h3 class="login-head" style="margin:20px; text-align:center;"><i class="fa fa-lg fa-fw fa-user"></i><spring:message code="loginpage.heading.two" text="Sign In using Username and Password"/></h3>
                                <div class="form-group col-lg-11" style="margin:10px;">
                                    <input class="form-control" type="text" oncopy="return false" placeholder="Enter your Email" autocomplete="off" onfocus="this.removeAttribute('readonly');" onpaste="return false" maxlength="50" value="" required autofocus name="username" id="username">
                                </div>
                                <div class="form-group col-lg-11" style="margin:10px;">
                                    <input class="form-control" type="password" autocomplete="off" placeholder="Password" onfocus="this.removeAttribute('readonly');" oncopy="return false" onpaste="return false" name="password" id="password" value="">
                                </div>
                                <!-- Captcha -->
                                <div class="col-lg-11" style="margin:10px;">
                                    <img id="captcha_id" class="col-lg-8" name="imgCaptcha" src="captcha.jpg">
                                    <a href="javascript:;" class="col-lg-2" title="change captcha text" onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
                                        <i class="fa fa-refresh"></i>
                                    </a>
                                </div>
                                <div class="col-lg-11" style="margin:10px;">
                                    <input autocomplete="off" placeholder="Enter Captcha" onfocus="this.removeAttribute('readonly');" class="form-control" maxlength="5" required onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"
                                    id="captcha" name="captcha" />
                                </div>
                                <br>
                                <!-- Captcha Ends -->
                                <div class="form-group col-lg-12">
                                    <input type="submit" name="submit" class="col-lg-12 btn btn-primary" value="Sign In">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                </div>
                                                         <p class="mb-0 fs-xs mt-4">Dont have an Account? <a href="${pageContext.request.contextPath}/register">Sign Up</a></p>

                            </form>
                            <div class="form-group">
                                <c:if test="${error != null}">
                                    <div id="serverError" style="padding:10px; margin:10px;" class="alert alert-danger alert-dismissable fade show plErroMessage">
                                        <button class="close" onclick="closeAlert();"><i class="fa fa-lg fa-fw fa-close"> </i></button>
                                        <strong>Warning!</strong> ${error}
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div class="col-lg-2"> &nbsp </div>
                    </div>
                </section>

                <script>
                    function closeAlert(){
                    var serverError = document.getElementById('serverError');
                            serverError.style.display = 'none'; // Hide the pop-up
                    }
                    function submit_form() {
                        var submitData = validateFields();
                        if (!submitData) return false;
                    }

                    function validateFields(){
                        var username = document.getElementById('username').value;
                        var password = document.getElementById('password').value;
                        var captcha = document.getElementById('captcha').value;

                        var encodedStringUsername = btoa(username);
                        var encodedStringPassword = btoa(password);
                        var encodedStringCaptcha = btoa(captcha);

                        document.getElementById('username').value=encodedStringUsername;
                        document.getElementById('password').value=encodedStringPassword;
                        document.getElementById('captcha').value=encodedStringCaptcha;


                                return true;
                    }
                </script>