<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery-3.6.4.min.js"></script>


<!--hero section start-->
<section class="gshop-hero pt-120 bg-white position-relative z-1 overflow-hidden">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/leaf-shadow.png" alt="leaf" class="position-absolute leaf-shape z--1 rounded-circle d-none d-lg-inline">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/mango.png" alt="mango" class="position-absolute mango z--1" data-parallax="{" y":="" -120}"="">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/hero-circle-sm.png" alt="circle" class="position-absolute hero-circle circle-sm z--1 d-none d-md-inline">


   <div class="container">
      <div class="gshop-hero-slider swiper">
         <div class="swiper-wrapper">
            <div class="swiper-slide gshop-hero-single">
               <div class="row align-items-center justify-content-between">
                  <div class="col-xl-5 col-lg-7">
                     <div class="hero-left-content">
                        <span class="gshop-subtitle fs-5 text-secondary mb-2 d-block">Get your Chakra from FlowChakra</span>
                        <h1 class="display-4 mb-3">Discover the Magic of Flow</h1>
                        <p class="mb-5 fs-6">Get away from your screen and get into nature with your FlowChakra to experience your unique and personal self.</p>
                        <div class="hero-btns d-flex align-items-center gap-3 gap-sm-5 flex-wrap">
                           <a href="https://www.youtube.com/watch?v=JXQnONhvy8U" class="btn btn-secondary">Explore Now<span class="ms-2"><i class="fa-solid fa-arrow-right"></i></span></a>
                           <a href="${pageContext.request.contextPath}/about" class="btn btn-primary">About Us<span class="ms-2"><i class="fa-solid fa-arrow-right"></i></span></a>
                        </div>
                     </div>
                  </div>
                  <div class="col-xl-6 col-lg-5">
                     <div class="hero-right text-center position-relative z-1 mt-6 mt-xl-0">
                        <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/pe7IKeIfimi4Y81fTfFLupbRk2wQ5UcPzctoVeay.png" alt="" class="img-fluid position-absolute end-0 top-50 hero-img">
                        <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/hero-circle-lg.png" alt="circle shape" class="img-fluid hero-circle">
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
  <!-- <div class="at-header-social d-none d-xl-flex align-items-center position-absolute">
      <span class="title fw-medium">Follow on</span>
      <ul class="social-list ms-3">
         <li>
            <a href="https://www.facebook.com/" target="_blank"><i class="fab fa-facebook-f"></i></a>
         </li>
         <li><a href="https://twitter.com/" target="_blank"><i class="fab fa-twitter"></i></a></li>
         <li><a href="https://www.youtube.com/watch?v=JXQnONhvy8U" target="_blank"><i class="fab fa-youtube"></i></a></li>
      </ul>
   </div>
   <div class="gshop-hero-slider-pagination theme-slider-control position-absolute top-50 translate-middle-y z-5">
   </div> -->
</section>
<!--hero section end-->



<!--featured products start-->
<section class="featured-products pt-120 pb-200 bg-shade position-relative overflow-hidden z-1">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/roll-1.png" alt="roll" class="position-absolute roll-1 z--1" data-parallax="{" y":="" -120}"="">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/roll-2.png" alt="roll" class="position-absolute roll-2 z--1" data-parallax="{" y":="" 120}"="">
   <div class="container">
      <div class="row justify-content-center">
         <div class="col-xl-6">
            <div class="section-title text-center mb-4">
               <h3 class="mb-2">Our Featured Products</h3>
               <p class="mb-0">Platform mindshare through effective infomediaries Dynamically implement.</p>
            </div>
         </div>
      </div>
      <div class="row g-4 justify-content-center ">
         <!-- Left Column Starts -->
         <div class="col-xxl-4 col-lg-6" id="featuredLeft">

         </div>
         <!-- Left Column Ends -->


         <!-- banner -->
         <div class="col-xxl-4 col-lg-6 order-3 order-xxl-2 d-none d-xl-block d-none-1399">
            <div class="product-card-lg bg-light rounded-2 d-flex flex-column h-100">
               <a href="${pageContext.request.contextPath}/products" class="my-auto">
               <img style="max-width:420px; max-height:330px; padding:30px; margin-left:40px;" src="${pageContext.request.contextPath}/resources/images/flowchakra_main/pe7IKeIfimi4Y81fTfFLupbRk2wQ5UcPzctoVeay.png" alt="Products">
               </a>
            </div>
         </div>
         <!-- right column -->
         <div class="col-xxl-4 col-lg-6 order-2 order-xxl-3" id="featuredRight">


         </div>
         <!-- right column ends -->
      </div>
   </div>
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/bg-shape-2.png" alt="bg shape" class="position-absolute start-0 bottom-0 w-100 z--1">
</section>
<!--featured products end-->



<!--trending products start-->
<section class="pt-8 pb-100 bg-white position-relative overflow-hidden z-1 trending-products-area">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/garlic.png" alt="garlic" class="position-absolute garlic z--1" data-parallax="{" y":="" 100}"="">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/carrot.png" alt="carrot" class="position-absolute carrot z--1" data-parallax="{" y":="" -100}"="">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/mashrom.png" alt="mashrom" class="position-absolute mashrom z--1" data-parallax="{" x":="" 100}"="">
   <div class="container">
      <div class="row align-items-center">
         <div class="col-xl-5">
            <div class="section-title text-center text-xl-start">
               <h3 class="mb-0">Top Trending Products</h3>
            </div>
         </div>
         <div class="col-xl-7">
            <div class="filter-btns gshop-filter-btn-group text-center text-xl-end mt-4 mt-xl-0">
               <button class="active" data-filter="*">All Products</button>
               <button data-filter=".1">Flowchakra</button>
            </div>
         </div>
      </div>
      <div class="row justify-content-center g-4 mt-5 filter_group" id="trendingProductContainer">

      </div>
   </div>
</section>
<!--trending products end-->
<!--banner section start-->
<section class="banner-section position-relative z-1 overflow-hidden bg-white">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/bg-shape-3.png" alt="bg shape" class="position-absolute start-0 bottom-0 z--1 w-100">
   <div class="container">
      <div class="row align-items-center g-4">
      </div>
   </div>
</section>
<!--banner section end-->

<!--banner 2 section start-->
<section class="position-relative banner-section z-1 overflow-hidden">
   <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/bg-shape-4.png" alt="bg shape" class="position-absolute start-0 bottom-0 w-100 z--1">
   <div class="container">
      <div class="row g-4">
         <div class="col-xl-8">
            <a href="">
            </a>
         </div>
         <div class="col-xl-4 d-none d-xl-block">
            <a href="">
            </a>
         </div>
      </div>
   </div>
</section>
<!--banner 2 section end-->






 <!--feedback section start-->
    <section class="ptb-120 bg-shade position-relative overflow-hidden z-1 feedback-section">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/bg-shape-5.png" alt="bg shape" class="position-absolute start-0 bottom-0 z--1 w-100">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/map-bg.png" alt="map" class="position-absolute start-50 top-50 translate-middle z--1">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/fd-1.png" alt="shape" class="position-absolute z--1 fd-1">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/fd-2.png" alt="shape" class="position-absolute z--1 fd-2">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/fd-3.png" alt="shape" class="position-absolute z--1 fd-3">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/fd-4.png" alt="shape" class="position-absolute z--1 fd-4">
    <img src="${pageContext.request.contextPath}/resources/images/flowchakra_main/fd-5.png" alt="shape" class="position-absolute z--1 fd-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="section-title text-center">
                    <h2 class="mb-6">What Our Clients Say</h2>
                </div>
            </div>
            <div class="col-xl-8">
                <div class="gshop-feedback-slider-wrapper">
                    <div class="swiper gshop-feedback-thumb-slider">
                        <div class="swiper-wrapper">
                                                    </div>
                    </div>
                    <div class="swiper gshop-feedback-slider mt-4">
                        <div class="swiper-wrapper">
                                                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
    <!--feedback section end-->


<script>
$(document).ready(function() {
    $.ajax({
        url: "/api/fetchProductsTrending",
        type: "GET",
        data: {
            page: 0,
            size: 10
        },
        success: function(response) {
            // Handle the successful response
           // console.log(response);
            var container = document.getElementById("trendingProductContainer");
            response.data.forEach(function(product) {
                var productCard = document.createElement("div");
                productCard.className = "col-xxl-3 col-lg-4 col-md-6 col-sm-10 filter_item1" ;
                //productCard.style.position = "absolute";
                //productCard.style.left = "0px";
                //productCard.style.top = "0px";

                var innerHtml = "";
                innerHtml += "<div class='vertical-product-card rounded-2 position-relative'>";

                innerHtml += "<div class='thumbnail position-relative text-center p-4'>";
                innerHtml += "<img style='max-width:150px; max-height:150px;'  src='${pageContext.request.contextPath}/downloadFile/" + product.productImage + "' alt='" + product.productName + "' class='img-fluid'/>";

                    innerHtml += "<div class='product-btns position-absolute d-flex gap-2 flex-column'>";
                        innerHtml += "<a href='javascript:void(0);' class='rounded-btn'>";
                        innerHtml += "<i class='fa-regular fa-heart' onclick='addToWishlist(" + product.productId + ")'></i></a>";
                        innerHtml += "<a href='javascript:void(0);' class='rounded-btn' onclick='showProductDetailsModal(" + product.productId + ")'>";
                        innerHtml += "<i class='fa-regular fa-eye'></i></a>";
                    innerHtml += "</div>";
                    innerHtml += "</div>";

                innerHtml += "<div class='card-content'>";
                    innerHtml += "<div class='mb-2 tt-category tt-line-clamp tt-clamp-1'>";
                    innerHtml += "<a href='#' class='d-inline-block text-muted fs-xxs'> Flowchakra </a>";
                    innerHtml += "</div>";

                    innerHtml += "<a href='javascript:void(0);' onclick='showProductDetailsModal(" + product.productId + ")' class='card-title fw-bold mb-2 tt-line-clamp tt-clamp-1'>" + product.productName + "</a>";
                    innerHtml += "<h6 class='price'>";
                    innerHtml += "<span class='fw-bold h4 text-danger'> &#8377;"+ product.productPrice + "</span>";
                    innerHtml += "</h6>";
                innerHtml += "</div>";

                innerHtml += " <div class='card-btn bg-white'>";
                  innerHtml += "<form action='' class='direct-add-to-cart-form'>";
                   innerHtml += "<input type='hidden' value='1' name='quantity'>";
                   innerHtml += "<input type='hidden' value='"+ product.productId + "' name='product_variation_id'>";
                   innerHtml += "<a href='javascript:void(0);' onclick='directAddToCartFormSubmit(this)' class='fs-xs fw-bold mt-10 d-inline-block explore-btn direct-add-to-cart-btn'>";
                   innerHtml +="<span class='add-to-cart-text'>Buy Now</span>";
                   innerHtml += "<span class='ms-1'><i class='fa-solid fa-arrow-right'></i></span>"

                   innerHtml += "</form>";
               innerHtml += "</div>";

                innerHtml += "</div></div>";

                // Set the innerHTML of the product card
                productCard.innerHTML = innerHtml;

                // Append the product card to the container
                container.appendChild(productCard);
            });
        },
        error: function(xhr, status, error) {
            // Handle errors
           // console.error("Error:", error);
            // Optionally, you can display an error message on the page
            var container = document.getElementById("trendingProductContainer");
            container.innerHTML = "<p>Error loading products. Please try again later.</p>";
        }
    });
});
</script>





<script>
$(document).ready(function() {
    $.ajax({
        url: "/api/fetchProductsFeatured",
        type: "GET",
        data: {
            page: 0,
            size: 2
        },
        success: function(response) {
            // Handle the successful response
          //  console.log(response);
            var container = document.getElementById("featuredLeft");
            response.data.forEach(function(product) {
                var productCard = document.createElement("div");


                var innerHtml = "";
                innerHtml += "<div class='mb-3'>";
                innerHtml += "<div class='horizontal-product-card d-sm-flex align-items-center p-3 bg-white rounded-2 border card-md gap-4'>";


                innerHtml += "<div class='thumbnail position-relative rounded-2'>";
                    innerHtml += "<a href='javascript:void(0);'><img src=${pageContext.request.contextPath}/downloadFile/" + product.productImage + " alt='product.productName' class='img-fluid'></a>";
                    innerHtml += "<div class='product-overlay position-absolute start-0 top-0 w-100 h-100 d-flex align-items-center justify-content-center gap-1 rounded-2'>";
                        innerHtml += "<a href='javascript:void(0);' class='rounded-btn fs-xs'>";
                        innerHtml += "<i class='fa-regular fa-heart' onclick='addToWishlist(" + product.productId + ")'></i></a>";
                        innerHtml += "<a href='javascript:void(0);' class='rounded-btn fs-xs' onclick='showProductDetailsModal(" + product.productId + ")'>";
                        innerHtml += "<i class='fa-regular fa-eye'></i></a>";
                    innerHtml += "</div>";
                innerHtml += "</div>";

                innerHtml += "<div class='card-content mt-4 mt-sm-0'>";
                    innerHtml += "<a href='javascript:void(0);' onclick='showProductDetailsModal(" + product.productId + ")' class='fw-bold text-heading title fs-sm tt-line-clamp tt-clamp-1'>" + product.productName + "</a>";
                        innerHtml += "<div class='pricing mt-2'>";
                        innerHtml += "<span class='fw-bold h4 text-danger'> &#8377;"+ product.productPrice + "</span>";
                        innerHtml += "</div>";

                   innerHtml += "<form action='' class='direct-add-to-cart-form'>";
                   innerHtml += "<input type='hidden' value='1' name='quantity'>";
                   innerHtml += "<input type='hidden' value='"+ product.productId + "' name='product_variation_id'>";
                   innerHtml += "<a href='javascript:void(0);' onclick='directAddToCartFormSubmit(this)' class='fs-xs fw-bold mt-10 d-inline-block explore-btn direct-add-to-cart-btn'>";
                   innerHtml +="<span class='add-to-cart-text'>Buy Now</span>";
                   innerHtml += "<span class='ms-1'><i class='fa-solid fa-arrow-right'></i></span>"

                   innerHtml += "</form>";
                innerHtml += "</div>";

                innerHtml += "</div>";

                // Set the innerHTML of the product card
                productCard.innerHTML = innerHtml;

                // Append the product card to the container
                container.appendChild(productCard);
            });
        },
        error: function(xhr, status, error) {
            // Handle errors
           // console.error("Error:", error);
            // Optionally, you can display an error message on the page
            var container = document.getElementById("trendingProductContainer");
            container.innerHTML = "<p>Error loading products. Please try again later.</p>";
        }
    });
});
</script>


<script>
$(document).ready(function() {
    $.ajax({
        url: "/api/fetchProductsFeatured",
        type: "GET",
        data: {
            page: 0,
            size: 2
        },
        success: function(response) {
            // Handle the successful response
           // console.log(response);
            var container = document.getElementById("featuredRight");
            response.data.forEach(function(product) {
                var productCard = document.createElement("div");


                var innerHtml = "";
                innerHtml += "<div class='mb-3'>";
                innerHtml += "<div class='horizontal-product-card d-sm-flex align-items-center p-3 bg-white rounded-2 border card-md gap-4'>";


                innerHtml += "<div class='thumbnail position-relative rounded-2'>";
                 innerHtml += "<a href='javascript:void(0);'><img src=${pageContext.request.contextPath}/downloadFile/" + product.productImage + " alt='product.productName' class='img-fluid'></a>";
                  innerHtml += "<div class='product-overlay position-absolute start-0 top-0 w-100 h-100 d-flex align-items-center justify-content-center gap-1 rounded-2'>";
                        innerHtml += "<a href='javascript:void(0);' class='rounded-btn fs-xs'>";
                        innerHtml += "<i class='fa-regular fa-heart' onclick='addToWishlist(" + product.productId + ")'></i></a>";
                        innerHtml += "<a href='javascript:void(0);' class='rounded-btn fs-xs' onclick='showProductDetailsModal(" + product.productId + ")'>";
                        innerHtml += "<i class='fa-regular fa-eye'></i></a>";
                    innerHtml += "</div>";
                innerHtml += "</div>";

                innerHtml += "<div class='card-content mt-4 mt-sm-0'>";
                    innerHtml += "<a href='javascript:void(0);' onclick='showProductDetailsModal(" + product.productId + ")' class='fw-bold text-heading title fs-sm tt-line-clamp tt-clamp-1'>" + product.productName + "</a>";
                        innerHtml += "<div class='pricing mt-2'>";
                        innerHtml += "<span class='fw-bold h4 text-danger'> &#8377;"+ product.productPrice + "</span>";
                        innerHtml += "</div>";

innerHtml += "<form action='' class='direct-add-to-cart-form'>";
innerHtml += "<input type='hidden' value='1' name='quantity'>";
innerHtml += "<input type='hidden' value='"+ product.productId + "' name='product_variation_id'>";
innerHtml += "<a href='javascript:void(0);' onclick='directAddToCartFormSubmit(this)' class='fs-xs fw-bold mt-10 d-inline-block explore-btn direct-add-to-cart-btn'>";
innerHtml +="<span class='add-to-cart-text'>Buy Now</span>";
innerHtml += "<span class='ms-1'><i class='fa-solid fa-arrow-right'></i></span>"

innerHtml += "</form>";


                innerHtml += "</div>";

                innerHtml += "</div>";

                // Set the innerHTML of the product card
                productCard.innerHTML = innerHtml;

                // Append the product card to the container
                container.appendChild(productCard);
            });
        },
        error: function(xhr, status, error) {
            // Handle errors
           // console.error("Error:", error);
            // Optionally, you can display an error message on the page
            var container = document.getElementById("trendingProductContainer");
            container.innerHTML = "<p>Error loading products. Please try again later.</p>";
        }
    });
});
</script>
