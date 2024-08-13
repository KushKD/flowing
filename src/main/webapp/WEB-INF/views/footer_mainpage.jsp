<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


 <!-- modals -->
        <div class="modal fade" id="quickview_modal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content min-h-400">
            <div class="modal-body h-100 bg-white">
                <button type="button" class="btn-close float-end" data-bs-dismiss="modal" aria-label="Close"></button>

                <div class="data-preloader-wrapper d-flex align-items-center justify-content-center min-h-400">
                    <div class="" role="status">
                        <span class="sr-only"></span>
                    </div>
                </div>

                <div class="product-info">

                </div>
            </div>
        </div>
    </div>
</div>
<!-- modals -->




<!--- footer Starts --->
<!--footer section start-->
<div class="footer-curve position-relative overflow-hidden">
   <span class="position-absolute section-curve-wrapper top-0 h-100" data-background="${pageContext.request.contextPath}/resources/images/flowchakra_main/section-curve.png"></span>
</div>
<footer class="gshop-footer position-relative pt-8 bg-dark z-1 overflow-hidden">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/pata-lg.svg" alt="pata" class="position-absolute z--1 pata-lg vector-shape">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/pata-xs.svg" alt="pata" class="position-absolute z--1 pata-xs vector-shape">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/frame-circle.svg" alt="frame" class="position-absolute z--1 frame-circle vector-shape">
   <!--shape right -->
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/pata-xs.svg" alt="pata" class="position-absolute pata-xs-2 z--1 vector-shape">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/tomato-slice.svg" alt="tomato slice" class="position-absolute tomato-slice vector-shape z--1">
   <div class="container">
      <div class="row justify-content-center">
         <!-- <div class="col-xl-5 col-lg-6">
            <div class="gshop_subscribe_form text-center">
               <h4 class="text-white gshop-title">Subscribe to the us<mark class="p-0 position-relative text-secondary bg-transparent"> New Arrivals
                  <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/border-line.svg" alt="border line" class="position-absolute border-line"></mark><br class="d-none d-sm-block">&amp; Other Information.
               </h4>
               <form class="mt-5 d-flex align-items-center bg-white rounded subscribe_form" action="${pageContext.request.contextPath}/subscribe" method="POST">
                  <input type="email" class="form-control" placeholder="Enter Email Address" name="email" required="">
                  <button type="submit" class="btn btn-primary flex-shrink-0">Subscribe Now</button>
               </form>
            </div>
         </div>
      </div>
      <span class="gradient-spacer my-8 d-block"></span> -->
      <div class="row g-5">
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
            <div class="footer-widget">
               <h5 class="text-white mb-4">About Us</h5>
               <ul class="footer-nav">
                  <li>
                     <p style="color: #fff;">
                        <span>
                        Flowchakra was started in year 2021 with an aim of promoting flowarts culture in India. Flowchakra is all about providing the best spinning experience to all you people who are interested in this relatively new flowart activity.
                        </span>
                        <a href="${pageContext.request.contextPath}/about">Know More</a>
                     </p>
                  </li>
               </ul>
            </div>
         </div>
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
           <!-- <div class="footer-widget">
               <h5 class="text-white mb-4">Quick Links</h5>
               <ul class="footer-nav">
                  <li>
                     <a href="#">Terms &amp; Conditions</a>
                  </li>
                  <li>
                     <a href="#">Refund Policy</a>
                  </li>
                  <li>
                     <a href="#">Privacy Policy</a>
                  </li>
               </ul>
            </div> -->
         </div>
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
           <!-- <div class="footer-widget">
               <h5 class="text-white mb-4">Customer Pages</h5>
               <ul class="footer-nav">
                  <li><a href="${pageContext.request.contextPath}/">Your Account</a></li>
                  <li><a href="${pageContext.request.contextPath}/">Your Orders</a></li>
                  <li><a href="${pageContext.request.contextPath}/">Your Wishlist</a></li>
                  <li><a href="${pageContext.request.contextPath}/">Address Book</a></li>
                  <li><a href="${pageContext.request.contextPath}/">Update Profile</a></li>
               </ul>
            </div> -->
         </div>
         <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
            <div class="footer-widget">
               <h5 class="text-white mb-4">Contact Info</h5>
               <ul class="footer-nav">
                  <li class="text-white pb-2 fs-xs">Flat No &ndash; 701, Block No &ndash; 43, Sector 4, New Shimla, Shimla, 171009</li>
                  <li class="text-white pb-2 fs-xs">8091769589</li>
                  <li class="text-white pb-2 fs-xs">flowchakra21@gmail.com</li>
               </ul>
            </div>
         </div>
      </div>
   </div>
   <div class="footer-copyright pt-120 pb-3">
      <span class="gradient-spacer d-block mb-3"></span>
      <div class="container">
         <div class="row align-items-center g-3">
            <div class="col-lg-4">
               <div class="copyright-text text-light">
                  Copyright &copy; Flowchakra
               </div>
            </div>
            <div class="col-lg-4 d-none d-lg-block">
               <div class="logo-wrapper text-center">
                  <a href="${pageContext.request.contextPath}/" class="logo"><img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/p03FRhnqP0UP8Su7NNj0oM8PGdLaabzRsWD2r1Bl.png" alt="footer logo" class="img-fluid"></a>
               </div>
            </div>
            <div class="col-lg-4">
               <div class="footer-payments-info d-flex align-items-center justify-content-lg-end gap-2">
                  <div class="rounded-1 d-inline-flex align-items-center justify-content-center p-2 flex-shrink-0">
                     <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/cards.png" alt="accepted_payment" class="img-fluid">
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</footer>
<div class="mobile-toolbar d-block d-md-none d-lg-none">
   <div class="d-table table-layout-fixed w-100">
      <a class="d-table-cell mobile-toolbar-item  mobile-menu-toggle">
      <span class="mobile-toolbar-icon"><i class="fas fa-bars"></i></span><span class="mobile-toolbar-label">Category
      </span>
      </a>
      <div class="gshop-header-search dropdown d-table-cell mobile-toolbar-item">
         <button class="header-icon" type="button" data-bs-toggle="dropdown">
            <span class="mobile-toolbar-icon">
               <svg width="18" height="23" viewBox="0 0 22 23" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M9.68859 0.5C4.34645 0.5 0 4.84646 0 10.1886C0 15.5311 4.34645 19.8772 9.68859 19.8772C15.031 19.8772 19.3772 15.5311 19.3772 10.1886C19.3772 4.84646 15.031 0.5 9.68859 0.5ZM9.68859 18.0886C5.33261 18.0886 1.78866 14.5447 1.78866 10.1887C1.78866 5.83266 5.33261 2.28867 9.68859 2.28867C14.0446 2.28867 17.5885 5.83262 17.5885 10.1886C17.5885 14.5446 14.0446 18.0886 9.68859 18.0886Z" fill="#5D6374"></path>
                  <path d="M21.7406 20.9824L16.6436 15.8853C16.2962 15.538 15.7338 15.538 15.3865 15.8853C15.0391 16.2323 15.0391 16.7954 15.3865 17.1424L20.4835 22.2395C20.6571 22.4131 20.8845 22.5 21.1121 22.5C21.3393 22.5 21.5669 22.4131 21.7406 22.2395C22.0879 21.8925 22.0879 21.3294 21.7406 20.9824Z" fill="#5D6374"></path>
               </svg>
            </span>
            <span class="mobile-toolbar-label">Search</span>
         </button>
         <div class="dropdown-menu dropdown-menu-start border-0">
            <form class="search-form d-flex align-items-center" action="${pageContext.request.contextPath}/products">
               <input type="text" placeholder="Search products..." class="w-100" name="search">
               <button type="submit" class="submit-icon-btn-secondary"><i class="fa-solid fa-magnifying-glass"></i></button>
            </form>
         </div>
      </div>
      <a class="d-table-cell mobile-toolbar-item" href="${pageContext.request.contextPath}/customer-dashboard">
         <span class="mobile-toolbar-icon">
            <svg width="18" height="25" viewBox="0 0 22 25" fill="none" xmlns="http://www.w3.org/2000/svg">
               <path d="M11.092 11.9546C12.6656 11.9546 14.0281 11.3902 15.1416 10.2766C16.2547 9.16322 16.8193 7.80093 16.8193 6.2271C16.8193 4.65382 16.2549 3.29134 15.1414 2.1776C14.0279 1.0644 12.6654 0.5 11.092 0.5C9.51825 0.5 8.156 1.0644 7.04266 2.17778C5.92931 3.29116 5.36475 4.65363 5.36475 6.2271C5.36475 7.80093 5.92931 9.1634 7.04266 10.2768C8.15636 11.39 9.51879 11.9546 11.092 11.9546ZM8.0281 3.16308C8.88239 2.30877 9.88453 1.89349 11.092 1.89349C12.2993 1.89349 13.3017 2.30877 14.1561 3.16308C15.0104 4.01757 15.4259 5.01992 15.4259 6.2271C15.4259 7.43464 15.0104 8.43681 14.1561 9.2913C13.3017 10.1458 12.2993 10.5611 11.092 10.5611C9.88489 10.5611 8.88275 10.1456 8.0281 9.2913C7.17364 8.43699 6.7582 7.43464 6.7582 6.2271C6.7582 5.01992 7.17364 4.01757 8.0281 3.16308Z" fill="#5D6374" stroke="#5D6374" stroke-width="0.2"></path>
               <path d="M21.1339 18.893C21.1012 18.4201 21.0352 17.9043 20.9379 17.3596C20.8397 16.8108 20.7133 16.292 20.562 15.8178C20.4055 15.3277 20.1931 14.8438 19.9301 14.38C19.6575 13.8986 19.3371 13.4794 18.9776 13.1345C18.6016 12.7736 18.1414 12.4835 17.6091 12.2719C17.0787 12.0614 16.4909 11.9547 15.8621 11.9547C15.6152 11.9547 15.3763 12.0564 14.9151 12.3576C14.6313 12.5433 14.2993 12.7581 13.9287 12.9956C13.6118 13.1982 13.1825 13.3879 12.6523 13.5598C12.135 13.7277 11.6098 13.8129 11.0912 13.8129C10.5729 13.8129 10.0477 13.7277 9.53001 13.5598C9.00034 13.3881 8.57088 13.1984 8.25455 12.9958C7.88747 12.7605 7.55527 12.5457 7.26718 12.3574C6.80634 12.0562 6.56753 11.9545 6.32059 11.9545C5.69163 11.9545 5.10401 12.0614 4.57378 12.2721C4.04189 12.4833 3.58143 12.7734 3.20512 13.1347C2.84561 13.4798 2.52522 13.8988 2.25281 14.38C1.99019 14.8438 1.77758 15.3276 1.62108 15.818C1.46993 16.2922 1.34351 16.8108 1.24533 17.3596C1.14788 17.9035 1.082 18.4195 1.04933 18.8935C1.01722 19.3569 1.00098 19.8393 1.00098 20.3266C1.00098 21.5934 1.40238 22.6189 2.19394 23.3752C2.97572 24.1216 4.00996 24.5 5.26808 24.5H16.9157C18.1735 24.5 19.2077 24.1216 19.9897 23.3752C20.7814 22.6194 21.1828 21.5935 21.1828 20.3264C21.1826 19.8374 21.1662 19.3551 21.1339 18.893ZM19.0123 22.3449C18.4957 22.8381 17.8099 23.0779 16.9155 23.0779H5.26808C4.37354 23.0779 3.68773 22.8381 3.17135 22.3451C2.66474 21.8613 2.41854 21.2008 2.41854 20.3266C2.41854 19.8718 2.43349 19.4229 2.46339 18.9918C2.49255 18.569 2.55216 18.1044 2.64056 17.6108C2.72786 17.1233 2.83896 16.6658 2.9711 16.2516C3.09789 15.8545 3.27082 15.4612 3.48527 15.0824C3.68995 14.7214 3.92544 14.4116 4.18529 14.1621C4.42835 13.9286 4.73471 13.7375 5.0957 13.5942C5.42956 13.4616 5.80476 13.3891 6.21208 13.3781C6.26172 13.4046 6.35012 13.4552 6.49334 13.5488C6.78475 13.7394 7.12064 13.9567 7.49197 14.1946C7.91054 14.4624 8.44981 14.7042 9.09409 14.9128C9.75277 15.1265 10.4245 15.235 11.0913 15.235C11.7581 15.235 12.4301 15.1265 13.0884 14.913C13.7333 14.704 14.2723 14.4624 14.6915 14.1943C15.0715 13.9506 15.3979 13.7395 15.6894 13.5488C15.8326 13.4553 15.921 13.4046 15.9706 13.3781C16.3781 13.3891 16.7533 13.4616 17.0874 13.5942C17.4482 13.7375 17.7545 13.9288 17.9976 14.1621C18.2574 14.4114 18.4929 14.7212 18.6976 15.0826C18.9122 15.4612 19.0854 15.8547 19.212 16.2515C19.3443 16.6662 19.4556 17.1235 19.5427 17.6106C19.6309 18.1052 19.6907 18.5699 19.7199 18.992V18.9924C19.7499 19.4218 19.7651 19.8705 19.7653 20.3266C19.7651 21.201 19.5189 21.8613 19.0123 22.3449Z" fill="#5D6374" stroke="#5D6374" stroke-width="0.2"></path>
            </svg>
         </span>
         <span class="mobile-toolbar-label">Account</span>
      </a>
      <a class="d-table-cell mobile-toolbar-item" href="${pageContext.request.contextPath}/viewCart">
         <span class="mobile-toolbar-icon mobile-cart-icon">
            <svg width="18" height="25" viewBox="0 0 22 25" fill="none" xmlns="http://www.w3.org/2000/svg">
               <path d="M21.1704 23.9559L19.6264 7.01422C19.5843 6.55156 19.1908 6.19718 18.7194 6.19718H15.5355V4.78227C15.5355 2.14533 13.3583 0 10.6823 0C8.00628 0 5.82937 2.14533 5.82937 4.78227V6.19718H2.6433C2.17192 6.19718 1.77839 6.55156 1.73625 7.01422L0.186259 24.0225C0.163431 24.2735 0.248671 24.5223 0.421216 24.7082C0.593761 24.8941 0.837705 25 1.0933 25H20.2695C20.2702 25 20.2712 25 20.2719 25C20.775 25 21.1826 24.5982 21.1826 24.1027C21.1825 24.0528 21.1784 24.0036 21.1704 23.9559ZM7.65075 4.78227C7.65075 3.1349 9.01071 1.79465 10.6824 1.79465C12.3542 1.79465 13.7142 3.1349 13.7142 4.78227V6.19718H7.65075V4.78227ZM2.08948 23.2055L3.47591 7.99183H5.82937V9.59649C5.82937 10.0921 6.237 10.4938 6.74006 10.4938C7.24313 10.4938 7.65075 10.0921 7.65075 9.59649V7.99183H13.7142V9.59649C13.7142 10.0921 14.1219 10.4938 14.6249 10.4938C15.128 10.4938 15.5356 10.0921 15.5356 9.59649V7.99183H17.8869L19.2733 23.2055H2.08948Z" fill="#5D6374"></path>
            </svg>
            <small class="badge bg-primary cart-counter">0</small>
         </span>
         <span class="mobile-toolbar-label sub-total-price"> &#8377; 0.00</span>
      </a>
   </div>
</div>
<div class="offcanvas-left-menu position-fixed">
   <div class="mobile-menu">
      <button class="offcanvas-close"><i class="fa-solid fa-close"></i></button>
      <a href="${pageContext.request.contextPath}/" class="d-inline-block mb-5"><img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/cards.png" alt="logo"></a>
      <nav class="mobile-menu-wrapper scrollbar">
         <ul>
         </ul>
      </nav>
   </div>
</div>
<!--footer section end-->
</div>
<!--scroll bottom to top button start-->
<!-- <button class="scroll-top-btn">
<i class="fa-regular fa-hand-pointer"></i>
</button> -->
<!--scroll bottom to top button end-->
<!--build:js-->
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery-3.6.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/simplebar.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/parallax-scroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/isotop.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/countdown.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/range-slider.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/waypoints.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/counterup.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/clipboard.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/select2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flowchakra/app.js"></script>

<script>

$(document).ready(function() {
    GetCartDataOnLoad();
});

</script>
<script>
   "use strict";

       function showProductDetailsModal(productId) {
           $('#quickview_modal .product-info').html(null);
           $('.data-preloader-wrapper>div').addClass('spinner-border');
           $('.data-preloader-wrapper').addClass('min-h-400');
           $('#quickview_modal').modal('show');

           $.post('/api/getProductById', {
               id: productId,
           }, function(data) {
           console.log(data);
               setTimeout(() => {
                   $('.data-preloader-wrapper>div').removeClass('spinner-border');
                   $('.data-preloader-wrapper').removeClass('min-h-400');
                   $('#quickview_modal .product-info').html(generateProductQuickView(data));
                   TT.ProductSliders();
                   cartFunc();
               }, 200);
           });
       }

       $('#quickview_modal').on('hide.bs.modal', function(e) {
           $('#quickview_modal .product-info').html(null);
       });


// check if it can be added to cart
    function isValidForAddingToCart() {

        var count = 0;
        $('.variation-for-cart').each(function() {
            // how many variations
            count++;
        });

        if ($('.product-radio-btn input:radio:checked').length == count) {
            return true;
        }

        return false;
    }

        function cartFunc() {
                  // on selection of variation
                  $(".product-radio-btn input").on("change", function () {
                    getVariationInfo();
                  });

                  // increase qty
                  $(".qty-increase-decrease .increase").on("click", function () {
                    var prevValue = $(".product-qty input[name=quantity]").val();
                    var maxValue = $(".product-qty input[name=quantity]").attr("max");
                    if (
                      maxValue == undefined ||
                      parseInt(prevValue) < parseInt(maxValue)
                    ) {
                      $(".qty-increase-decrease input[name=quantity]").val(
                        parseInt(prevValue) + 1
                      );
                    }
                  });

                   // decrease qty
                          $(".qty-increase-decrease .decrease").on("click", function () {
                            var prevValue = $(".product-qty input[name=quantity]").val();
                            if (prevValue > 1) {
                              $(".qty-increase-decrease input[name=quantity]").val(
                                parseInt(prevValue) - 1
                              );
                            }
                          });


                           // add to cart form submit
                                  $('.add-to-cart-form').on('submit', function(e) {
                                      e.preventDefault();
                                      if (isValidForAddingToCart()) {
                                          $('.add-to-cart-btn').prop('disabled', true);
                                          $('.add-to-cart-btn .add-to-cart-text').html(TT.localize.addingToCart);

                                          // add to cart here
                                          let data = $('.add-to-cart-form').serializeArray();


                                          let datax = {};
                                          data.forEach(item => {
                                              if (item.name === "quantity") {
                                                  datax.quantity = item.value;
                                              } else if (item.name === "product_variation_id") {
                                                  datax.product_variation_id = item.value;
                                              }
                                          });


                                          $.ajax({
                                              type: "POST",
                                              url: '/api/add-to-cart',
                                              contentType: "application/json",
                                              data: JSON.stringify(datax),
                                              success: function(data) {
                                                  $('.add-to-cart-btn').prop('disabled', false);
                                                  $('.add-to-cart-btn .add-to-cart-text').html(TT.localize.addToCart);
                                                  updateCarts(data);
                                                  notifyMe('success', data.message);
                                                 // GetCartDataOnLoad();
                                              },
                                               error: function(jqXHR, textStatus, errorThrown) {
                                                      $('.add-to-cart-btn').prop('disabled', false);
                                                      $('.add-to-cart-btn .add-to-cart-text').html(TT.localize.addToCart);
                                                      notifyMe('error', 'Please Login to add the Item to cart.');
                                                      console.error("Error adding to cart:", textStatus, errorThrown);
                                                  }
                                          });

                                      } else {
                                          optionsAlert();
                                      }
                                  })

                }




               function generateProductQuickView(data) {
                   // Initialize HTML string
                   let html = '';

                   // Create a container for the quick view
                   html += "<div class='gstore-product-quick-view bg-white rounded-3 py-6 px-4'>";

                   // Create the inner HTML content based on the provided data
                   html += "<div class='row g-4'>";
                   html += "<div class='col-xl-6 align-self-end'>";
                   html += "<div class='quickview-double-slider'>";
                   html += "<div class='quickview-product-slider swiper'>";
                   html += "<div class='swiper-wrapper'>";
                   data.productThumbnails.forEach(thumbnail => {
                       html += "<div class='swiper-slide text-center'><img style='width:300px; height:300px;' src='${pageContext.request.contextPath}/downloadFile/"+ thumbnail.documentName + "' class='img-fluid'> </div>";
                   });
                   html += "</div>";
                   html += "</div>";
                   html += "<div class='product-thumbnail-slider swiper mt-80'>";
                   html += "<div class='swiper-wrapper'>";
                   data.productThumbnails.forEach(thumbnail => {
                       html += "<div class='swiper-slide product-thumb-single rounded-2 d-flex align-items-center justify-content-center'><img src='${pageContext.request.contextPath}/downloadFile/" + thumbnail.documentName + "' alt='data.productName' class='img-fluid'></div>";
                   });
                   html += "</div>";
                   html += "</div>";
                   html += "</div>";
                   html += "</div>";
                   html += "<div class='col-xl-6'>";
                   html += "<div class='product-info'>";
                   html += "<h3 class='mt-1 mb-3 h5'>" + data.data.productName + "</h3>";
                   html += "<div class='pricing all-pricing mt-2'>";
                   html += "<span class='fw-bold h4 text-danger'> &#8377;"+ data.data.productPrice +"</span>";
                   html += "</div>";
                   html += "<div class='widget-title d-flex mt-4'>";
                   html += "<h6 class='mb-1 flex-shrink-0'>Description</h6>";
                   html += "<span class='hr-line w-100 position-relative d-block align-self-end ms-1'></span>";
                   html += "</div>";
                   html += "<p class='mb-3'>" + data.data.longDescription + "</p>";
                   html += "<form action='' class='add-to-cart-form'>";
                   html+= "<input type='hidden' name='product_variation_id'  value='"+data.data.productId+"' >";
                   //html+= "<input type='hidden' name='product_variation_id'  value='12' >";
                   html += "<div class='d-flex align-items-center gap-3 flex-wrap mt-5'>"
                    html += "<div class='product-qty qty-increase-decrease d-flex align-items-center'>";
                    html += "<button type='button' class='decrease'>-</button>";
                    html += "<input type='text' readonly value='1' name='quantity' min='1' max='2000'>";
                    html += "<button type='button' class='increase'>+</button>";
                    html += "</div>";
                   html += "<button type='submit' class='btn btn-secondary btn-md add-to-cart-btn'>";
                   html += "<span class='me-2'>";
                   html += "<i class='fa-solid fa-shopping-cart'></i>";
                   html += "</span>";
                   html += "<span class='add-to-cart-text'>Add to Cart</span>";
                   html += "</button>";

                   html += "<button type='button' class='btn btn-primary'  onclick='addToWishlist("+ data.data.productId +")'>";
                   html += "<i class='fa-solid fa-heart'></i>";
                   html += "</button>";

                   html += "</div>"

                   html += "</form>";
                   html += "<div class='tt-category-tag mt-'>";
                   html += "<a href='#' class='text-muted fs-xxs'>"+ data.data.productName +"</a>";
                   html += "</div>";
                   html += "</div>";
                   html += "</div>";
                   html += "</div>";
                   html += "</div>";

                   let quickViewContainer = document.createElement('div');
                   quickViewContainer.innerHTML = html;

                   return quickViewContainer;
               }

 function addToWishlist(productId) {
        $.ajax({
            url: "/api/addToWishList",
            type: "POST",
            data: {
                productId: productId,
            },
            success: function(response) {
                notifyMe("success", response.data);
            },
            error: function(xhr, status, error) {
               notifyMe("warning", "Please Login to add Products to wishlist.");
            }
        });
    }


  // ajax toast
      function notifyMe(level, message) {
        if (level == "danger") {
          level = "error";
        }
        toastr.options = {
          timeOut: "5000",
          closeButton: true,
          positionClass: "toast-top-center",
        };
        toastr[level](message);
      }



 // handleCartItem
    function handleCartItem(action, id) {
        let data = {
            action: action,
            id: id,
        };
        $.ajax({
            type: "POST",
            url: '/api/update-cart',
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(data) {
                if (data.success == true) {
                    $('.apply-coupon-btn').removeClass('d-none');
                    $('.clear-coupon-btn').addClass('d-none');
                    $('.apply-coupon-btn').prop('disabled', false);
                    $('.apply-coupon-btn').html(TT.localize.applyCoupon);
                    notifyMe('success', data.message);
                    updateCarts(data);

                }
            }
        });
    }



       // without variation form submit
function directAddToCartFormSubmit($this) {
  // add to cart here
  let parent = $($this).parent('.direct-add-to-cart-form');

  parent.find('.direct-add-to-cart-btn').prop('disabled', true);

  let text = parent.find('.add-to-cart-text').html();
  parent.find('.add-to-cart-text').html(TT.localize.pleaseWait);

    let quantity = parent.find('input[name="quantity"]').val();
    let product_variation_id = parent.find('input[name="product_variation_id"]').val();
            let data = {
                "quantity": quantity,
                "product_variation_id": product_variation_id
            };

            let jsonData = JSON.stringify(data);

              $.ajax({
                  type: "POST",
                  url: '/api/add-to-cart',
                  data: jsonData,
                  contentType: "application/json", // Set content type to JSON
                  success: function(data) {
                      parent.find('.direct-add-to-cart-btn').prop('disabled', false);

                      if (text.includes("Buy Now")) {
                          parent.find('.add-to-cart-text').html(TT.localize.buyNow);
                      } else {
                          parent.find('.add-to-cart-text').html(TT.localize.addToCart);
                      }
                      updateCarts(data);
                      notifyMe('success', data.message);
                  },
                  error: function(xhr, status, error) {
                                 notifyMe("danger", "Please Login to add Products to cart.");
                                  if (text.includes("Please Wait")) {
                                       parent.find('.add-to-cart-text').html(TT.localize.addToCart);
                                   } else {
                                       parent.find('.add-to-cart-text').html(TT.localize.buyNow);
                                   }
                              }
              });
          }




           // GetCartDataOnLoad
          function GetCartDataOnLoad() {
                        $.ajax({
                            type: "GET",
                            url: '/api/add-to-cart-check',
                            success: function(data) {
                                updateCarts(data);
                            },
                            error: function(xhr, status, error) { }
                        });
                    }

    function updateCarts(data) {
        $('.cart-counter').empty();
        $('.sub-total-price').empty();

        $('.cart-navbar-wrapper .simplebar-content').empty();
        $('.cart-listing').empty();

        if (data.cartCount > 0) {
            $('.cart-counter').removeClass('d-none');
        } else {
            $('.cart-counter').addClass('d-none');
        }

        $('.cart-counter').html(data.cartCount);
        $('.sub-total-price').html(data.subTotal);
        $('.cart-navbar-wrapper .simplebar-content').html(data.navCarts);
        $('.cart-listing').html(data.carts);
        $('.coupon-discount-wrapper').addClass('d-none');
        //$('.checkout-sidebar').empty();

    }







   // function disableBack() {window.history.forward()};
   //  window.onload = disableBack();
   //  window.onpageshow = function (evt) {if (evt.persisted) disableBack()};

</script>




</body></html>