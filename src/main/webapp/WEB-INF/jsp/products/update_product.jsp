<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>

<style>
    .product-thumbnail-container {
        display: flex;
        flex-wrap: wrap;
        position: relative; /* Required for absolute positioning of icons */
    }

    .product-thumbnail {
        position: relative; /* Required for absolute positioning of icons */
        width: calc(10.33% - 20px); /* Adjust the width as per your design */
        margin: 10px;
        overflow: hidden; /* Hide overflow to prevent icons from being visible outside thumbnail */
        cursor: pointer; /* Change cursor to pointer on hover */
    }

    .product-thumbnail img {
        width: 100%; /* Make sure image covers the entire thumbnail */
        height: auto; /* Maintain aspect ratio */
        transition: transform 0.2s; /* Add smooth transition effect */
    }

    .product-thumbnail:hover img {
        transform: scale(1.1); /* Scale up image on hover */
    }

    .product-icons {
        position: absolute;
        top: 15%;
        left: 15%;
        transform: translate(-50%, -50%);
        display: none; /* Hide icons by default */
    }

    .product-thumbnail:hover .product-icons {
        display: flex; /* Show icons on hover */
    }

    .product-icons img {
        margin: 0 1px; /* Adjust spacing between icons */
        cursor: pointer;
    }
</style>


<div class="content-wrapper">


   <form:form method="POST" modelAttribute="productForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/updateProductEntity"  class="form-signin">

     <c:if test="${not empty successMessage}">
              <div id="serverError" class="successMessage">${successMessage}</div>
           </c:if>
           <br>
           <c:if test="${not empty serverError}">
              <div id="serverError" class="plErroMessage">${serverError}</div>
           </c:if>

      <h2 class="form-signin-heading">Update Product</h2>
      <spring:bind path="productId">
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="productId" readonly="true" value="${product_to_update.productId}" autocomplete="off"  oncopy="return false" onpaste="return false"  class="form-control" autofocus="true"></form:input>
            <form:errors path="productId"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="productName">
         <label for="productName" class="form-label">
            <spring:message  text="Product Name" />
            *
         </label>
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="productName" autocomplete="off" onfocus="this.removeAttribute('readonly');" value="${product_to_update.productName}" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Product Name"
               autofocus="true"></form:input>
            <form:errors style="color:red;" path="productName"></form:errors>
         </div>
      </spring:bind>


      <div  id="productImage" class="form-group col-lg-4">
              <label for="productImage" class="form-label"> <spring:message  text="Product Photo" /> *  </label>
              <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" id="productImage" path="productImage" name="productImage" />
              <form:errors style="color:red;" path="productImage"></form:errors>
           </div>

              <div  class="form-group col-lg-4">
             <a style="text-decoration:none;" href="${pageContext.request.contextPath}/downloadFile/${product_to_update.productImage}" target="_blank">View Uploaded Image &nbsp; ${product_to_update.productImage}</a>
             </div>


      <spring:bind path="productTax">
         <label for="productTax" class="form-label">
            <spring:message  text="Product Tax" />
            *
         </label>
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" path="productTax" value="${product_to_update.productTax}" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"   class="form-control"  name="productTax" placeholder="Product Tax" ></form:input>
            <form:errors style="color:red;" path="productTax"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="productPrice">
         <label for="productPrice" class="form-label">
            <spring:message  text="Product Price" />
            *
         </label>
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" path="productPrice" onkeypress="return alpha(event)" value="${product_to_update.productPrice}" oncopy="return false" onpaste="return false"   class="form-control"  name="productPrice" placeholder="Product Price" ></form:input>
            <form:errors style="color:red;" path="productPrice"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="shortDescription">
         <label for="shortDescription" class="form-label">
            <spring:message  text="Short Description" />
            *
         </label>
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input style="height:80px;" type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" value="${product_to_update.shortDescription}" path="shortDescription" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"   class="form-control"  name="longDescription" placeholder="Short Description" />
            <form:errors style="color:red;" path="shortDescription"></form:errors>
         </div>
      </spring:bind>
      <spring:bind path="longDescription">
         <label for="longDescription" class="form-label">
            <spring:message  text="Long Description" />
            *
         </label>
         <div class="form-group  ${status.error ? 'has-error' : ''}">
            <form:input style="height:80px;" onfocus="this.removeAttribute('readonly');" path="longDescription" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false" class="form-control" name="longDescription" placeholder="Long Description" value="${product_to_update.longDescription}" />
            <form:errors style="color:red;" path="longDescription"></form:errors>
         </div>
      </spring:bind>

    <div class="product-thumbnail-container">
        <c:forEach var="product" items="${product_images_to_update}">
            <!-- Check if images are present -->
            <c:if test="${not empty product.documentName}">
                <!-- Display the responsive image -->
                <div class="product-thumbnail">
                    <img src="${pageContext.request.contextPath}/downloadFile/${product.documentName}" alt="${product.documentName}"/>
                    <!-- Product icons -->
                    <div class="product-icons">
                        <!-- View icon -->
                        <!-- Delete icon -->
                        <img src="${pageContext.request.contextPath}/downloadFile/delete_icon.png" style="height:20px; width:20px;" alt="Delete" onclick="deleteProduct(${product.thumbnailId})">
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>

      <div  id="attachFiles1" class="form-group col-lg-12">
         <label for="attachFiles" class="form-label">
            <spring:message code="form.documentry.aadhaar" text="Attach Images of the Product" />
            *
         </label>
         <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" id="attachFiles" multiple="multiple" path="productThumbnails" name="productThumbnails" />
         <form:errors style="color:red;" path="productThumbnails"></form:errors>
         <div class="col-lg-12">
            <div class="image-preview row col-lg-12"></div>
         </div>
      </div>
      <spring:bind path="isActive">
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:label path="isActive"> Is Active </form:label>
            <form:select path="isActive" class="form-control" autocomplete="off"  oncopy="return false" onpaste="return false" id="earlierService">
               <form:option value="T"> Yes </form:option>
               <form:option value="F"> No </form:option>
            </form:select>
            <form:errors style="color:red;" path="isActive"></form:errors>
         </div>
      </spring:bind>

      <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
      <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
      <c:remove var="successMessage" scope="session" />
   </form:form>
</div>
</div>
<script>
   let file_input = document.querySelector('#attachFiles');
   let image_preview = document.querySelector('.image-preview');

   const handle_file_preview = (e) => {

    image_preview.innerHTML = '';

    let files = e.target.files;
     let length = files.length;

     for(let i = 0; i < length; i++) {


      var div = document.createElement('div');
      div.style.cssText += 'display: inline; align-items: center; justify-content: center';
      div.classList.add("col-lg-3");
      div.id = 'div'+i;

         let image = document.createElement('img');
         image.style.cssText += 'height: 75px; border: 1px solid #000; margin: 5px';

         image.src = window.URL.createObjectURL(files[i]);
         console.log(files[i].name);
         image_preview.appendChild(image);
          let label = document.createElement('label');
          label.style.cssText += 'color:black; margin: 5px';
          label.innerHTML = files[i].name;
          div.appendChild(image);
          div.appendChild(label);
          image_preview.appendChild(div);

     }
   }

   file_input.addEventListener('change', handle_file_preview);
</script>
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


<script>

function deleteProduct(id){
$.ajax({
            url: '/ajax/deleteThumbnail/' + id,
            type: 'DELETE',
            success: function(response) {
                // Reload the page after successful deletion
                window.location.reload();
                // Display success message (optional)
                alert('Product Thumbnail deleted successfully');
            },
            error: function(xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
}

</script>