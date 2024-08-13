<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--contact us section start-->
    <section>
        <div class="container">
            <div class="contact-box rounded-2 bg-white overflow-hidden mt-8">
                <div class="row g-4">
                    <div class="col-xl-5">
                        <div class="contact-left-box position-relative overflow-hidden z-1 bg-primary p-6 d-flex flex-column h-100" data-background="${pageContext.request.contextPath}/resources/images/flowchakra_main/circle-half-fill.png">
                            <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/texture-overlay.png" alt="texture" class="position-absolute w-100 h-100 start-0 top-0 z--1">
                            <h3 class="text-white mb-3">Contact Details</h3>
                            <p class="fs-sm text-white"><strong>Office Address:
                                </strong>Flat No &ndash; 701, Block No &ndash; 43, Sector 4, New Shimla, Shimla, 171009
                            </p>
                            <span class="spacer my-5"></span>
                            <ul class="contact-list">
                                <li class="d-flex align-items-center gap-3 flex-wrap">
                                    <span class="icon d-inline-flex align-items-center justify-content-center rounded-circle flex-shrink-0">
                                        <i class="fa-brands fa-whatsapp"></i>
                                    </span>
                                    <div class="info">
                                        <span class="fw-medium text-white fs-xs">Emergency Call</span>
                                        <h5 class="mb-0 mt-1 text-white">8091769589</h5>
                                    </div>
                                </li>
                                <li class="d-flex align-items-center gap-3 flex-wrap mt-3">
                                    <span class="icon d-inline-flex align-items-center justify-content-center rounded-circle flex-shrink-0">
                                        <i class="fa-regular fa-envelope"></i>
                                    </span>
                                    <div class="info">
                                        <span class="fw-medium text-white fs-xs">General Communicationl</span>
                                        <p class="mb-0 mt-1 text-white fw-medium">flowchakra21@gmail.com</p>
                                    </div>
                                </li>
                            </ul>
                            <div class="mt-5">
                                <span class="fw-bold text-white mb-3 d-block">Find us on:</span>
                                <div class="social-links d-flex align-items-center gap-2">
                                    <a href="https://www.facebook.com/"><i class="fab fa-facebook-f"></i></a>
                                    <a href="https://twitter.com/" target="_blank"><i class="fab fa-twitter"></i></a>
                                    <a href="https://www.youtube.com/watch?v=JXQnONhvy8U" target="_blank"><i class="fab fa-youtube"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-7">
                        <form:form class="contact-form ps-4 ps-xl-0 py-8 pe-5 contact-form ps-5 ps-xl-4 py-6 pe-6" action="${pageContext.request.contextPath}/contact-us" method="POST" modelAttribute="contactusForm">
                            <h3 class="mb-6">Need Help? Send Message</h3>
                            <div class="row g-4">
                                <div class="col-sm-12">
                                    <div class="label-input-field">
                                        <form:label path="name">Name</form:label>
                                        <form:input path="name" placeholder="Your name" required="true"/>
                                        <form:errors path="name"/>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="label-input-field">
                                        <form:label path="email">Email</form:label>
                                        <form:input path="email" placeholder="Your email" required="true" type="email"/>
                                        <form:errors path="email"/>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="label-input-field">
                                        <form:label path="phone">Phone</form:label>
                                        <form:input path="phone" placeholder="Your phone" required="true"/>
                                        <form:errors path="phone"/>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="checkbox-fields d-flex align-items-center gap-3 flex-wrap my-2">
                                        <div class="single-field d-inline-flex align-items-center gap-2">
                                            <form:radiobutton path="support_for" value="delivery_problem" checked="true"/>
                                            <form:label path="support_for" class="text-dark fw-semibold">Delivery Problem</form:label>
                                        </div>
                                        <div class="single-field d-inline-flex align-items-center gap-2">
                                            <form:radiobutton path="support_for" value="customer_service"/>
                                            <form:label path="support_for" class="text-dark fw-semibold">Customer Service</form:label>
                                        </div>
                                        <div class="single-field d-inline-flex align-items-center gap-2">
                                            <form:radiobutton path="support_for" value="other_service"/>
                                            <form:label path="support_for" class="text-dark fw-semibold">Others Service</form:label>
                                        </div>
                                        <form:errors path="support_for"/>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="label-input-field">
                                        <form:label path="message">Messages</form:label>
                                        <form:textarea path="message" placeholder="Write your message" rows="6" required="true"/>
                                        <form:errors path="message"/>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-md rounded-1 mt-6">Send Message</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--contact us section end-->