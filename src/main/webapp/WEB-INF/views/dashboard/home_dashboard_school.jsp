<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapd.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>


<div class="content-wrapper">

            <sec:authorize access="hasAnyAuthority('School')">
                        <%@ include file="profiles/school.jsp" %>
            </sec:authorize>

             <sec:authorize access="hasAnyAuthority('Teacher')">
                        <%@ include file="profiles/teacher.jsp" %>
            </sec:authorize>

            <sec:authorize access="hasAnyAuthority('VTP')">
                <%@ include file="profiles/vtp.jsp" %>
            </sec:authorize>

        </div>

