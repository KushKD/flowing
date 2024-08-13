<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <meta name="viewport" content="width=device-width initial-scale=1.0">
      <title>FlowChakra</title>
      <!-- GLOBAL MdINLY STYLES-->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css" rel="stylesheet" />
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/font-awesome.min.css" rel="stylesheet" />
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/themify-icons.css" rel="stylesheet" />
      <!-- PLUGINS STYLES-->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/jquery-jvectormap-2.0.3.css" rel="stylesheet" />
      <!-- THEME STYLES-->
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/main.min.css" rel="stylesheet" />
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vendor/datatables.min.css" rel="stylesheet" />
      <!-- PAGE LEVEL STYLES-->
   </head>
   <body class="fixed-navbar">
      <div>
         <!-- START HEADER class="page-wrapper"-->
         <header class="header">
            <div class="page-brand">
               <a class="link" href="index.html">
               <span class="brand">FlowChakra Admin </span>
               </a>
            </div>
            <div class="flexbox flex-1">
               <!-- START TOP-LEFT TOOLBAR-->
               <ul class="nav navbar-toolbar">
                  <li>
                     <a class="nav-link sidebar-toggler js-sidebar-toggler">
                     <i class="ti-menu"></i>
                     </a>
                  </li>
               </ul>
               <!-- END TOP-LEFT TOOLBAR-->
               <!-- START TOP-RIGHT TOOLBAR-->
               <ul class="nav navbar-toolbar">
                  <li class="dropdown dropdown-user">
                     <a class="nav-link dropdown-toggle link" data-toggle="dropdown">
                           <img src="${pageContext.request.contextPath}/resources/images/admin-avatar.png" />
                        <span></span>Test User<i class="fa fa-angle-down m-l-5"></i>
                     </a>
                     <ul class="dropdown-menu dropdown-menu-right">
                        <li class="dropdown-divider"></li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                        <i class="fa fa-power-off"></i>Logout </a>
                     </ul>
                  </li>
               </ul>
               <!-- END TOP-RIGHT TOOLBAR-->
            </div>
         </header>
         <!-- END HEADER-->
         <!-- START SIDEBAR-->
         <nav class="page-sidebar" id="sidebar">
            <div id="sidebar-collapse">
               <div class="admin-block d-flex">
                  <div>
                        <img src="${pageContext.request.contextPath}/resources/images/admin-avatar.png" />
                  </div>
                  <div class="admin-info">
                     <div class="font-strong">Test User</div>
                     <div class="font-strong">Role: ${authority_}</div>
                  </div>
               </div>
               <ul class="side-menu metismenu">
                  <sec:authorize access="hasAnyAuthority('Super Admin','Admin','OWNER')">
                     <li>
                        <a class="active" href="${pageContext.request.contextPath}/dashboard">
                        <i class="sidebar-item-icon fa fa-th-large"></i>
                        <span class="nav-label">Dashboard</span>
                        </a>
                     </li>
                  </sec:authorize>
                  <li class="heading">OPTIONS</li>
                  <sec:authorize access="hasAnyAuthority('Super Admin', 'Admin','OWNER')">
                     <li>
                        <a href="javascript:;">
                        <i class="sidebar-item-icon fa fa-lock"></i>
                        <span class="nav-label">Roles Master</span>
                        <i class="fa fa-angle-left arrow"></i>
                        </a>
                        <ul class="nav-2-level collapse">
                           <li>
                              <a href="${pageContext.request.contextPath}/createRole">Create Roles</a>
                           </li>
                           <li>
                              <a href="${pageContext.request.contextPath}/getRoles"> Update Role</a>
                           </li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                        <i class="sidebar-item-icon fa fa-users"></i>
                        <span class="nav-label">Customers</span>
                        <i class="fa fa-angle-left arrow"></i>
                        </a>
                        <ul class="nav-2-level collapse">
                           <li>
                              <a href="${pageContext.request.contextPath}/viewUsers"> View Customers</a>
                           </li>
                        </ul>
                     </li>

                     <li>
                     <a href="javascript:;">
                     <i class="sidebar-item-icon fa fa-shopping-bag"></i>
                     <span class="nav-label">Products Master</span>
                     <i class="fa fa-angle-left arrow"></i>
                     </a>
                     <ul class="nav-2-level collapse">
                        <li>
                           <a href="${pageContext.request.contextPath}/createProduct">Add Products</a>
                        </li>
                        <li>
                           <a href="${pageContext.request.contextPath}/viewProducts"> Update Products</a>
                        </li>
                     </ul>
                  </li>

                   <li>
                   <a href="javascript:;">
                   <i class="sidebar-item-icon fa fa-shopping-cart"></i>
                   <span class="nav-label">Orders</span>
                   <i class="fa fa-angle-left arrow"></i>
                   </a>
                   <ul class="nav-2-level collapse">
                      <li>
                         <a href="${pageContext.request.contextPath}/viewOrders">View Orders</a>
                      </li>

                   </ul>
                </li>

                 <li>
                 <a href="javascript:;">
                 <i class="sidebar-item-icon fa fa-question-circle"></i>
                 <span class="nav-label">Queries </span>
                 <i class="fa fa-angle-left arrow"></i>
                 </a>
                 <ul class="nav-2-level collapse">
                    <li>
                       <a href="${pageContext.request.contextPath}/contact-us">View Queries</a>
                    </li>
                 </ul>
              </li>


               <li>
                  </sec:authorize>


               </ul>
            </div>
         </nav>
         <!-- END SIDEBAR-->
      </div>
   </body>
</html>