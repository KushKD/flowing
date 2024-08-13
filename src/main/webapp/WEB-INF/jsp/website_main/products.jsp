<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${pageContext.request.contextPath}/resources/js/flowchakra/jquery-3.6.4.min.js"></script>

 <!--breadcrumb-->
      <div
        class="gstore-breadcrumb position-relative z-1 overflow-hidden mt--50"
      >
        <img
          src="${pageContext.request.contextPath}/resources/images/flowchakra_main/roll-1.png"
          alt="roll"
          class="position-absolute z--1 roll vector-shape"
        />
        <img
          src="${pageContext.request.contextPath}/resources/images/flowchakra_main/roll-2.png"
          alt="roll"
          class="position-absolute z--1 roll-2 vector-shape"
        />
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="mb-2 text-center">Products</h2>

              </div>
            </div>
          </div>
        </div>
      </div>
      <!--breadcrumb-->

       <section class="gshop-gshop-grid ptb-120">
                <div class="container">
                  <div class="row g-4">
                    <div class="col-xl-3 d-none d-xl-block">
                      <div class="gshop-sidebar bg-white rounded-2 overflow-hidden">
                        <!--Filter by search-->
                        <div class="sidebar-widget search-widget bg-white py-5 px-4">
                          <div class="widget-title d-flex">
                            <h6 class="mb-0 flex-shrink-0">Search Now</h6>
                            <span
                              class="hr-line w-100 position-relative d-block align-self-end ms-1"
                            ></span>
                          </div>
                          <!-- <div class="search-form d-flex align-items-center mt-4">
                            <input type="hidden" name="view" value="grid" />
                            <input
                              type="text"
                              id="search"
                              name="search"
                              placeholder="Search"
                            />
                            <button type="submit" class="submit-icon-btn-secondary">
                              <i class="fa-solid fa-magnifying-glass"></i>
                            </button>
                          </div> -->
                        </div>
                        <!--Filter by search-->

                        <!--Filter by Price-->
                       <!-- <div
                          class="sidebar-widget price-filter-widget bg-white py-5 px-4 border-top"
                        >
                          <div class="widget-title d-flex">
                            <h6 class="mb-0 flex-shrink-0">Filter by Price</h6>
                            <span
                              class="hr-line w-100 position-relative d-block align-self-end ms-1"
                            ></span>
                          </div>
                          <div class="at-pricing-range mt-4">
                            <div class="price-filter-range"></div>
                            <div class="d-flex align-items-center mt-3">
                              <input
                                type="number"
                                min="0"
                                oninput="validity.valid||(value='0');"
                                class="min_price price-range-field price-input price-input-min"
                                name="min_price"
                                data-value="0"
                                data-min-range="0"
                              />
                              <span class="d-inline-block ms-2 me-2 fw-bold">-</span>
                              <input
                                type="number"
                                max="24.390243902439"
                                oninput="validity.valid||(value='24.390243902439');"
                                class="max_price price-range-field price-input price-input-max"
                                name="max_price"
                                data-value="24.390243902439"
                                data-max-range="24.390243902439"
                              />
                            </div>
                            <button type="submit" class="btn btn-primary btn-sm mt-3">
                              Filter
                            </button>
                          </div>
                        </div>  -->
                        <!--Filter by Price-->
                        <!--Filter by Tags-->
                        <!--<div class="sidebar-widget tags-widget py-5 px-4 bg-white">
                          <div class="widget-title d-flex">
                            <h6 class="mb-0">Tags</h6>
                            <span
                              class="hr-line w-100 position-relative d-block align-self-end ms-1"
                            ></span>
                          </div>
                          <div class="mt-4 d-flex gap-2 flex-wrap"></div>
                        </div> -->
                        <!--Filter by Tags-->
                      </div>
                    </div>



                    <!--rightbar-->
                    <div class="col-xl-9">
                      <div class="shop-grid">
                        <!--filter-->
                       <!-- <div class="listing-top d-flex align-items-center justify-content-between flex-wrap gap-3 bg-white rounded-2 px-4 py-4 mb-5">
                          <p class="mb-0 fw-bold">Showing 1-9 of 18 results</p>
                          <div class="listing-top-right text-end d-inline-flex align-items-center gap-3 flex-wrap" >
                           <div class="number-count-filter d-flex align-items-center gap-3" >
                              <label class="fw-bold fs-xs text-dark flex-shrink-0"  >Show:</label>
                              <input  type="number"  value="9"  name="per_page"  class="product-listing-pagination"/>
                            </div>
                            <div class="select-filter d-inline-flex align-items-center gap-3" >
                              <label class="fw-bold fs-xs text-dark flex-shrink-0"  >Sort by:</label>
                              <select name="sort_by" class="sort_by form-select fs-xxs fw-medium theme-select select-sm"  >
                                <option value="new" selected="">Newest First</option>
                                <option value="best_selling">Best Selling</option>
                              </select>
                            </div>
                            <a  href="#" style="display:none" class="grid-btn active"  >
                              <svg width="17" height="16"  viewBox="0 0 17 16" fill="none"  xmlns="http://www.w3.org/2000/svg" >
                                <path d="M5.97196 0H1.37831C0.706579 0 0.160156 0.546422 0.160156 1.21815V5.8118C0.160156 6.48353 0.706579 7.02996 1.37831 7.02996H5.97196C6.64369 7.02996 7.19011 6.48353 7.19011 5.8118V1.21815C7.19 0.546422 6.64369 0 5.97196 0Z"
                                  fill="#FF7C08"  >
                                 </path>
                                <path d="M14.9407 0H10.3471C9.67533 0 9.12891 0.546422 9.12891 1.21815V5.8118C9.12891 6.48353 9.67533 7.02996 10.3471 7.02996H14.9407C15.6124 7.02996 16.1589 6.48353 16.1589 5.8118V1.21815C16.1589 0.546422 15.6124 0 14.9407 0Z"
                                  fill="#FF7C08" ></path>
                                <path  d="M5.97196 8.96973H1.37831C0.706579 8.96973 0.160156 9.51609 0.160156 10.1878V14.7815C0.160156 15.4532 0.706579 15.9996 1.37831 15.9996H5.97196C6.64369 15.9996 7.19011 15.4532 7.19011 14.7815V10.1878C7.19 9.51609 6.64369 8.96973 5.97196 8.96973Z"
                                  fill="#FF7C08" ></path>
                                <path  d="M14.9407 8.96973H10.3471C9.67533 8.96973 9.12891 9.51615 9.12891 10.1879V14.7815C9.12891 15.4533 9.67533 15.9997 10.3471 15.9997H14.9407C15.6124 15.9996 16.1589 15.4532 16.1589 14.7815V10.1878C16.1589 9.51609 15.6124 8.96973 14.9407 8.96973Z"
                                  fill="#FF7C08"  ></path>
                              </svg>
                            </a>

                          </div>
                        </div>  -->
                        <!--filter-->




                        <!--products-->
                        <div class="row g-4" id="productContainer">  <!-- Products to be displayed in this grid via JS--> </div>

                        <!-- Pagination -->
                      <!--  <ul style="display=none;" class="d-flex align-items-center gap-3 mt-7">
                          <nav>
                            <ul class="pagination">
                              <li
                                class="page-item disabled"
                                aria-disabled="true"
                                aria-label="« Previous"
                              >
                                <span class="page-link" aria-hidden="true">&lt;</span>
                              </li>
                              <li class="page-item active" aria-current="page">
                                <span class="page-link">1</span>
                              </li>
                              <li class="page-item">
                                <a
                                  class="page-link"
                                  href="https://www.flowchakra.in/products?view=grid&amp;page=2"
                                  >2</a
                                >
                              </li>
                              <li class="page-item">
                                <a
                                  class="page-link"
                                  href="https://www.flowchakra.in/products?view=grid&amp;page=2"
                                  rel="next"
                                  aria-label="Next »"
                                  >&gt;</a
                                >
                              </li>
                            </ul>
                          </nav>
                        </ul> -->
                        <!--Pagination Ends-->
                      </div>
                    </div>
                    <!--rightbar-->
                  </div>
                </div>
              </section>


<script>
$(document).ready(function() {
    $.ajax({
        url: "/api/fetchProducts",
        type: "GET",
        data: {
            page: 0,
            size: 30
        },
        success: function(response) {
            // Handle the successful response
           // console.log(response);
            var container = document.getElementById("productContainer");
            response.data.forEach(function(product) {
               // console.log("product", product);
                var productCard = document.createElement("div");
                productCard.className = "col-lg-4 col-md-6 col-sm-10";

                var innerHtml = "";
                innerHtml += "<div class='vertical-product-card rounded-2 position-relative swiper-slide bg-white'>";
                innerHtml += "<div class='thumbnail position-relative text-center p-4'>";
                innerHtml += "<img style='max-height:150px; max-width:150px;' src='${pageContext.request.contextPath}/downloadFile/" + product.productImage + "' alt='" + product.productName + "' class='img-fluid'/>";
                innerHtml += "<div class='product-btns position-absolute d-flex gap-2 flex-column'>";
                innerHtml += "<a href='javascript:void(0);' class='rounded-btn'>";
                innerHtml += "<i class='fa-regular fa-heart' onclick='addToWishlist(" + product.productId + ")'></i></a>";
                innerHtml += "<a href='javascript:void(0);' class='rounded-btn' onclick='showProductDetailsModal(" + product.productId + ")'>";
                innerHtml += "<i class='fa-regular fa-eye'></i></a>";
                innerHtml += "</div></div>";

                innerHtml += "<div class='card-content'>";
                innerHtml += "<a href='javascript:void(0);' onclick='showProductDetailsModal(" + product.productId + ")' class='card-title fw-semibold mb-2 tt-line-clamp tt-clamp-1'>" + product.productName + "</a>";
                innerHtml += "<h6 class='price'>";
                innerHtml += "<span class='fw-bold h4 text-danger'>&#8377;"+ product.productPrice + "</span>";
                innerHtml += "</h6>";

                 innerHtml += "<form action='' class='direct-add-to-cart-form'>";
                 innerHtml += "<input type='hidden' value='1' name='quantity'>";
                 innerHtml += "<input type='hidden' value='"+ product.productId + "' name='product_variation_id'>";
                innerHtml += "<a href='javascript:void(0);' onclick='directAddToCartFormSubmit(this)' class='btn btn-outline-secondary btn-md border-secondary d-block mt-4 w-100 direct-add-to-cart-btn add-to-cart-text'>Add to Cart</a>";
                 innerHtml +="</form>";

                innerHtml += "</div></div>";

                // Set the innerHTML of the product card
                productCard.innerHTML = innerHtml;

                // Append the product card to the container
                container.appendChild(productCard);
            });
        },
        error: function(xhr, status, error) {
            // Handle errors
            console.error("Error:", error);
            // Optionally, you can display an error message on the page
            var container = document.getElementById("productContainer");
            container.innerHTML = "<p>Error loading products. Please try again later.</p>";
        }
    });
});
</script>

