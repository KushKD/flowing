<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/flight_application_form.js"></script>




<div class="content-wrapper">

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

        <form:form method="POST" modelAttribute="productForm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/saveProduct" class="form-signin">
            <br>
            <h2 class="form-signin-heading">Add Product</h2>

            <spring:bind path="productName">
            <label for="productName" class="form-label"> <spring:message  text="Product Name" />*</label>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="productName" autocomplete="off" onfocus="this.removeAttribute('readonly');" onkeypress="return alpha(event) "  oncopy="return false" onpaste="return false" class="form-control" placeholder="Product Name"
                                autofocus="true"></form:input>
                    <form:errors style="color:red;" path="productName"></form:errors>
                </div>
            </spring:bind>


             <div  id="productImage" class="form-group col-lg-12">
             <label for="productImage" class="form-label"> <spring:message  text="Attach Image of the Product" />
                * </label>
             <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" id="product_image"  path="productImage" name="productImage" />
             <form:errors style="color:red;" path="productImage"></form:errors>
             <div class="col-lg-12"><div class="image-preview-product row col-lg-12"></div></div>
             </div>

            <spring:bind path="productTax">
            <label for="productTax" class="form-label"> <spring:message  text="Product Tax" />*</label>
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:input type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" path="productTax" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"   class="form-control"  name="productTax" placeholder="Product Tax" ></form:input>
                <form:errors style="color:red;" path="productTax"></form:errors>
            </div>
        </spring:bind>

             <spring:bind path="productPrice">
              <label for="productPrice" class="form-label"> <spring:message  text="Product Price" />*</label>
                <div class="form-group  ${status.error ? 'has-error' : ''}">
                    <form:input type="text" autocomplete="off" onfocus="this.removeAttribute('readonly');" path="productPrice" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"   class="form-control"  name="productPrice" placeholder="Product Price" ></form:input>
                    <form:errors style="color:red;" path="productPrice"></form:errors>
                </div>
            </spring:bind>

              <spring:bind path="shortDescription">
                        <label for="shortDescription" class="form-label"> <spring:message  text="Short Description" />*</label>
                        <div class="form-group  ${status.error ? 'has-error' : ''}">
                            <form:textarea type="text" autocomplete="off"  rows="5" cols="20" onfocus="this.removeAttribute('readonly');" path="shortDescription" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"   class="form-control"  name="longDescription" placeholder="Short Description" />
                            <form:errors style="color:red;" path="shortDescription"></form:errors>
                        </div>
                    </spring:bind>

            <spring:bind path="longDescription">
            <label for="longDescription" class="form-label"> <spring:message  text="Long Description" />*</label>
            <div class="form-group  ${status.error ? 'has-error' : ''}">
                <form:textarea type="text" autocomplete="off"  rows="5" cols="20" onfocus="this.removeAttribute('readonly');" path="longDescription" onkeypress="return alpha(event)" oncopy="return false" onpaste="return false"   class="form-control"  name="longDescription" placeholder="Long Description" />
                <form:errors style="color:red;" path="longDescription"></form:errors>
            </div>
        </spring:bind>

             <div  id="attachFiles1" class="form-group col-lg-12">
                 <label for="attachFiles" class="form-label"> <spring:message code="form.documentry.aadhaar" text="Attach Images of the Product" />
                    * </label>
                 <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" id="attachFiles" multiple="multiple" path="productThumbnails" name="productThumbnails" />
                 <form:errors style="color:red;" path="productThumbnails"></form:errors>
                 <div class="col-lg-12"><div class="image-preview row col-lg-12"></div></div>
              </div>


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
    let file_input_product = document.querySelector('#product_image');
    let image_preview_product = document.querySelector('.image-preview-product');

    const handle_file_preview_product = (e) => {

     image_preview_product.innerHTML = '';

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
          image_preview_product.appendChild(image);
           let label = document.createElement('label');
           label.style.cssText += 'color:black; margin: 5px';
           label.innerHTML = files[i].name;
           div.appendChild(image);
           div.appendChild(label);
           image_preview_product.appendChild(div);

      }
    }

    file_input_product.addEventListener('change', handle_file_preview_product);
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