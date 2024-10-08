<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/vendor/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrapd.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vendor/multiselect/select2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<div class="content-wrapper">
   <form:form method="POST" modelAttribute="registerUser" action="${pageContext.request.contextPath}/updateSelectedUserSpecific" enctype="multipart/form-data" class="form-signin">
      <c:if test="${not empty successMessage}">
         <div id="serverError" class="successMessage">${successMessage}</div>
      </c:if>
      <br>
      <c:if test="${not empty serverError}">
         <div id="serverError" class="plErroMessage">${serverError}</div>
      </c:if>
      <h4 class="form-signin-heading" style="color:#006FB9">Registration</h4>
      <hr>
      <div class="row">
         <spring:bind path="userId">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:input type="text" autocomplete="off"  oncopy="return false" onpaste="return false" path="userId" readonly="true" value="${usersDetails.userId}" class="form-control" autofocus="true"></form:input>
               <form:errors path="userId"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="firstName">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="firstName" class="form-control" autocomplete="off" value="${usersDetails.firstName}" oncopy="return false" onpaste="return false" placeholder="First Name"
                  autofocus="true"></form:input>
               <form:errors  path="firstName"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="lastName">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="lastName" class="form-control" autocomplete="off"  oncopy="return false" value="${usersDetails.lastName}" onpaste="return false" placeholder="Last Name"
                  autofocus="true"></form:input>
               <form:errors  path="lastName"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="username">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="username" class="form-control" autocomplete="off"  oncopy="return false" value="${usersDetails.username}"  onpaste="return false" placeholder="Username"
                  autofocus="true"></form:input>
               <form:errors  path="username"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="mobileNumber">
            <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
               <form:label path="aadhaar" for="aadhaar">Mobile Number</form:label>
               <form:input type="text"  required="required" path="mobileNumber" maxlength="10" autocomplete="off"  oncopy="return false" onpaste="return false" minlength="10" value="${usersDetails.mobileNumber}"  class="form-control"  name="mobileNumber" placeholder="Mobile Number" ></form:input>
               <form:errors  path="mobileNumber"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="aadhaar">
            <div class="form-group col-lg-3  ${status.error ? 'has-error' : ''}">
               <form:label path="aadhaar" for="aadhaar">Aadhaar Number</form:label>
               <form:input type="text"  required="required" path="aadhaar" maxlength="12" autocomplete="off" value="${usersDetails.aadhaar}"  oncopy="return false" onpaste="return false" minlength="10"  class="form-control"  name="aadhaar" placeholder="Aadhaar Number" ></form:input>
               <form:errors  path="aadhaar"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="gender">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="gender" for="gender">Gender</form:label>
               <form:select path="gender"  name="gender" class="form-control" id="gender">
               </form:select>
               <form:errors  path="gender"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="caste">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="caste" for="caste">Caste</form:label>
               <form:select path="caste" name="caste" class="form-control" id="caste" >
               </form:select>
               <form:errors class="text-danger" path="caste"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="subcaste">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="subcaste" for="subcaste">Religion</form:label>
               <form:select path="subcaste" name="subcaste" class="form-control" id="subcaste" >
               </form:select>
               <form:errors class="text-danger" path="subcaste"></form:errors>
            </div>
         </spring:bind>
          <spring:bind path="blood_group">
                          <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                             <form:label path="blood_group" for="blood_group">Blood Group</form:label>
                             <form:select path="blood_group" name="blood_group" class="form-control" id="blood_group" >
                             </form:select>
                             <form:errors class="text-danger" path="blood_group"></form:errors>
                          </div>
                       </spring:bind>


             <spring:bind path="dob">
                                    <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                                    <form:label path="dob" for="dob">Date of Birth</form:label>
                                       <form:input type="text" path="dob" class="form-control datepick" autocomplete="off"  oncopy="return false" value="${usersDetails.dob}" onpaste="return false" placeholder="Date of Birth"
                                          autofocus="true" id="dob"></form:input>
                                       <form:errors  path="dob"></form:errors>
                                    </div>
                                 </spring:bind>
         <spring:bind path="teacherType">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="teacherType" for="teacherType">Teacher Type</form:label>
               <form:select path="teacherType" onchange="hide_unhide(this.value);" name="teacherType" class="form-control" id="teacherType">
               </form:select>
               <form:errors  path="teacherType"></form:errors>
            </div>
         </spring:bind>
          <spring:bind path="employeeCode">
                         <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                            <form:label path="teacherType" for="teacherType">Employee Code (PMIS)</form:label>
                            <form:input type="text" path="employeeCode" class="form-control" autocomplete="off" value="${usersDetails.employeeCode}" oncopy="return false" onpaste="return false" placeholder="Employee Code"
                               autofocus="true"></form:input>
                            <form:errors  path="employeeCode"></form:errors>
                         </div>
                      </spring:bind>

                      <spring:bind path="salaryCode">
                                      <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                                         <form:label path="salaryCode" for="salaryCode">Salary Code (IP)</form:label>
                                         <form:input type="text" path="salaryCode" class="form-control" autocomplete="off"  value="${usersDetails.salarycode}" oncopy="return false" onpaste="return false" placeholder="Salary Code"
                                            autofocus="true"></form:input>
                                         <form:errors  path="salaryCode"></form:errors>
                                      </div>
                                   </spring:bind>
         <spring:bind path="qualification">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="qualification" for="qualification">Qualification</form:label>
               <form:select path="qualification"  name="qualification" class="form-control" id="qualification">
               </form:select>
               <form:errors  path="qualification"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="pro_qualification">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="pro_qualification" for="pro_qualification">Professional Qualification</form:label>
               <form:select path="pro_qualification"  name="pro_qualification" class="form-control" id="pro_qualification">
               </form:select>
               <form:errors  path="pro_qualification"></form:errors>
            </div>
         </spring:bind>
      </div>
      <br>
      <div id="vtp">
         <h4 class="form-signin-heading" style="color:#006FB9">Teaching Type Details</h4>
         <hr>
         <div class="row">
            <!-- ,employeeCode , subSector -->
            <spring:bind path="Company_vtp">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="Company_vtp" for="Company_vtp">Company</form:label>
                  <form:select path="Company_vtp" name="Company_vtp" class="form-control" id="Company_vtp"></form:select>
                  <form:errors path="Company_vtp"></form:errors>
               </div>
            </spring:bind>
             <spring:bind path="Sector_vtp">
                           <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                              <form:label path="Sector_vtp" for="Sector_vtp">Sector</form:label>
                              <form:select path="Sector_vtp"  name="Sector_vtp" class="form-control" id="Sector_vtp">
                              </form:select>
                              <form:errors  path="Sector_vtp"></form:errors>
                           </div>
                        </spring:bind>

                 <spring:bind path="phase_vtp">
                             <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                                <form:label path="phase_vtp" for="phase_vtp">Phase</form:label>
                                <form:select path="phase_vtp"  name="phase_vtp" class="form-control" id="phase_vtp">
                                </form:select>
                                <form:errors  path="phase_vtp"></form:errors>
                             </div>
                          </spring:bind>
         </div>
      </div>
      <div id="vocational">
         <h4 class="form-signin-heading" style="color:#006FB9">Teaching Type Details</h4>
         <hr>
         <div class="row">
            <!-- ,employeeCode , subSector -->
            <spring:bind path="Company">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="Company" for="Company">Company</form:label>
                  <form:select path="Company"  name="Company" class="form-control" id="Company">
                  </form:select>
                  <form:errors  path="Company"></form:errors>
               </div>
            </spring:bind>
            <spring:bind path="Sector">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="Sector" for="Sector">Sector</form:label>
                  <form:select path="Sector"  name="Sector" class="form-control" id="Sector">
                  </form:select>
                  <form:errors  path="Sector"></form:errors>
               </div>
            </spring:bind>
            <spring:bind path="natureOfPosting">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="natureOfPosting" for="natureOfPosting">Posting Nature</form:label>
                  <form:select path="natureOfPosting"  name="natureOfPosting" class="form-control" id="natureOfPosting">
                  </form:select>
                  <form:errors  path="natureOfPosting"></form:errors>
               </div>
            </spring:bind>
            <spring:bind path="phase">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="phase" for="phase">Phase</form:label>
                  <form:select path="phase"  name="phase" class="form-control" id="phase">
                  </form:select>
                  <form:errors  path="phase"></form:errors>
               </div>
            </spring:bind>
            <spring:bind path="dojFirst">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:input type="text" path="dojFirst" class="form-control datepick" autocomplete="off"  oncopy="return false" value="${usersDetails.dojFirst}" onpaste="return false" placeholder="First Date of Joining"
                     autofocus="true" id="dojFirst"></form:input>
                  <form:errors  path="dojFirst"></form:errors>
               </div>
            </spring:bind>
            <spring:bind path="dojLPresentSchool">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:input type="text" path="dojLPresentSchool" class="form-control datepick" value="${usersDetails.dojLPresentSchool}" autocomplete="off"  oncopy="return false" onpaste="return false" placeholder="Last Date of Joining Present School"
                     autofocus="true" id="dojLPresentSchool"></form:input>
                  <form:errors  path="dojLPresentSchool"></form:errors>
               </div>
            </spring:bind>
         </div>
      </div>
      <br>
      <div id="tgt_pgt">
         <h4 class="form-signin-heading" style="color:#006FB9">Subject</h4>
         <hr>
         <div class="row">
            <!-- ,employeeCode , subSector -->
            <spring:bind path="subject">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="subject" for="subject">Subject</form:label>
                  <form:select path="subject"  name="subject" class="form-control"  id="subject">
                  </form:select>
                  <form:errors  path="subject"></form:errors>
               </div>
            </spring:bind>
         </div>
      </div>
      <br>
      <h4 class="form-signin-heading" style="color:#006FB9">Address & Email</h4>
      <hr>
      <div class="row">
         <spring:bind path="address">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="address" class="form-control" autocomplete="off" value="${usersDetails.address}"  oncopy="return false" onpaste="return false" placeholder="Address"
                  autofocus="true"></form:input>
               <form:errors  path="address"></form:errors>
            </div>
         </spring:bind>
        <spring:bind path="c_address">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:input type="text" path="c_address" class="form-control" autocomplete="off" value="${usersDetails.c_address}" oncopy="return false" onpaste="return false" placeholder="Correspondence Address"
                     autofocus="true"></form:input>
                  <form:errors  path="c_address"></form:errors>
               </div>
            </spring:bind>
              <spring:bind path="email">
                 <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" class="form-control" autocomplete="off" value="${usersDetails.email}"   oncopy="return false" onpaste="return false" placeholder="Email"
                       autofocus="true"></form:input>
                    <form:errors  path="email"></form:errors>
                 </div>
              </spring:bind>
              <spring:bind path="whatsapp_number">
                       <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                          <form:input type="text" path="whatsapp_number" class="form-control" autocomplete="off"  value="${usersDetails.whatsapp_number}" oncopy="return false" onpaste="return false" placeholder="Whats App Number"
                             autofocus="true"></form:input>
                          <form:errors  path="whatsapp_number"></form:errors>
                       </div>
                    </spring:bind>
      </div>

        <h4 class="form-signin-heading" style="color:#006FB9">Select Role and Set Password</h4>
            <hr>
            <div class="row">
               <spring:bind path="roleId">
                  <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                     <form:label path="roleId" for="roles">Select Role</form:label>
                     <form:select path="roleId" name="roleId" autocomplete="off" onchange="hideUnhideLocation(this.value);"  oncopy="return false" onpaste="return false" class="form-control" id="roles">
                     </form:select>
                     <form:errors  path="roleId"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="password">
                  <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                     <form:label path="roleId" for="roles">Password</form:label>
                     <form:input type="password" path="password" autocomplete="off"  oncopy="return false" maxLength="20"  size="20" onpaste="return false" class="form-control" placeholder="Password"></form:input>
                     <form:errors path="password"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="passwordConfirm">
                  <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                     <form:label path="roleId" for="roles">Confirm Password</form:label>
                     <form:input type="password" path="passwordConfirm" autocomplete="off"  oncopy="return false" maxLength="20"  size="20" onpaste="return false" class="form-control"
                        placeholder="Confirm your password"></form:input>
                     <form:errors path="passwordConfirm"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="stateIsActive">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:label  path="stateIsActive" > Is Active </form:label>
                     <form:select  path="stateIsActive" class="form-control" id="earlierService" autocomplete="off"  oncopy="return false" onpaste="return false">
                        <form:option value=""> --Select-- </form:option>
                        <form:option value="T"> Yes </form:option>
                        <form:option value="F"> No </form:option>
                     </form:select>
                     <form:errors  style="color:red;" path="stateIsActive"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="stateIsDeleted">
                  <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:label  path="stateIsDeleted" > Is Deleted </form:label>
                     <form:select  path="stateIsDeleted" class="form-control" id="earlierService" autocomplete="off"  oncopy="return false" onpaste="return false">
                        <form:option value=""> --Select-- </form:option>
                        <form:option value="T"> Yes </form:option>
                        <form:option value="F"> No </form:option>
                     </form:select>
                     <form:errors  style="color:red;" path="stateIsDeleted"></form:errors>
                  </div>
               </spring:bind>
               <spring:bind path="oldroleid">
                  <div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
                     <form:input type="hidden" path="oldroleid" id="oldroleid" class="form-control"  value="${userRoleIdOld}" />
                     <form:errors style="color:red;"  path="oldroleid"></form:errors>
                  </div>
               </spring:bind>
            </div>

            <br>


      <div id="location">
      <h4 class="form-signin-heading" style="color:#006FB9">School Location Details</h4>
      <hr>
      <div class="row">
         <spring:bind path="state">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="state" for="state">State</form:label>
               <form:select path="state" onchange="getDistrictsViaStates(this.value);" name="state" class="form-control" id="state">
               </form:select>
               <form:errors  path="state"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="district">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="district" for="district">District</form:label>
               <form:select path="district"  name="district" class="form-control" id="district" onchange="getBlocksViaDistrict(this.value); getEducationalBlocksViaDistrict(this.value); getConstituency(this.value);">
               </form:select>
               <form:errors  path="district"></form:errors>
            </div>
         </spring:bind>
         <spring:bind path="block">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="block" for="block">Block</form:label>
               <form:select path="block"   name="block" class="form-control" id="block">
               </form:select>
               <form:errors  path="block"></form:errors>
            </div>
         </spring:bind>
          <spring:bind path="educationalBlock">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="educationalBlock" for="educationalBlock">Educational Block</form:label>
                  <form:select path="educationalBlock"  name="educationalBlock" class="form-control" id="educationalBlock" onchange="getSchools($('#state').val(), $('#district').val(), this.value );">
                  </form:select>
                  <form:errors  path="educationalBlock"></form:errors>
               </div>
            </spring:bind>
            <spring:bind path="constituency">
               <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
                  <form:label path="constituency" for="constituency">Constituency </form:label>
                  <form:select path="constituency"   name="constituency" class="form-control" id="constituency" >
                  </form:select>
                  <form:errors  path="constituency"></form:errors>
               </div>
            </spring:bind>
         <spring:bind path="school">
            <div class="form-group col-lg-3 ${status.error ? 'has-error' : ''}">
               <form:label path="school" for="school">School </form:label>
               <form:select path="school"  name="school" class="form-control" id="school">
               </form:select>
               <form:errors  path="school"></form:errors>
            </div>
         </spring:bind>
      </div>
      </div>

      <h4 class="form-signin-heading" style="color:#006FB9">Documentary Proof</h4>
      <hr>
      <div class="row">
         <div  class="form-group col-lg-3">
            <label for="photo" class="form-label">Photo* </label>
            <form:input class="form-control" oncopy="return false" onpaste="return false" type="file" id="photo" path="photo" name="photo" />
            <form:errors style="color:red;" path="photo"></form:errors>
            <div  class="form-group col-lg-12">  <a style="text-decoration:none;" href="${pageContext.request.contextPath}/downloadFile/${usersDetails.photo}" target="_blank">View Uploaded Image &nbsp; ${usersDetails.photo}</a></div>
         </div>
      </div>
      <hr>
      <div class="col-lg-12" style="margin-top:20px;">
         <button class="btn btn-lg btn-primary col-lg-5" type="submit">Save</button>
         <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-lg btn-danger col-lg-5">Go Back</a>
         <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
      </div>
      <c:remove var="successMessage" scope="session" />
   </form:form>
</div>
<input class="form-control col-md-6"  id="gid" type="hidden" value="${usersDetails.gender}"  />
<input class="form-control col-md-6"  id="caste_" type="hidden" value="${usersDetails.caste}"  />
<input class="form-control col-md-6"  id="subcaste_" type="hidden" value="${usersDetails.subcaste}"  />
<input class="form-control col-md-6"  id="rid" type="hidden" value="${usersDetails.roleId}"  />
<input class="form-control col-md-6"  id="sid" type="hidden" value="${usersDetails.state}"  />
<input class="form-control col-md-6"  id="did" type="hidden" value="${usersDetails.district}"  />
<input class="form-control col-md-6"  id="bid" type="hidden" value="${usersDetails.block}"  />
<input class="form-control col-md-6"  id="ebid" type="hidden" value="${usersDetails.educationalBlock}"  />
<input class="form-control col-md-6"  id="cid" type="hidden" value="${usersDetails.constituency}"  />
<input class="form-control col-md-6"  id="schoolId" type="hidden" value="${usersDetails.school}"  />
<input class="form-control col-md-6"  id="teacher" type="hidden" value="${usersDetails.teacherType}"  />
<input class="form-control col-md-6"  id="qualification_" type="hidden" value="${usersDetails.qualification}"  />
<input class="form-control col-md-6"  id="pro_qualification_" type="hidden" value="${usersDetails.pro_qualification}"  />
<input class="form-control col-md-6"  id="blood_group_" type="hidden" value="${usersDetails.bg_id}"  />


<c:if test="${usersDetails.company ne null}">
   <input class="form-control col-md-6"  id="comp" type="hidden" value="${usersDetails.company}"  />
   <input class="form-control col-md-6"  id="company_vtp" type="hidden" value="${usersDetails.company}"  />
</c:if>
<c:if test="${usersDetails.sector ne null}">
   <input class="form-control col-md-6"  id="sec" type="hidden" value="${usersDetails.sector}"  />
    <input class="form-control col-md-6"  id="sec_vtp" type="hidden" value="${usersDetails.sector}"  />
</c:if>
<c:if test="${usersDetails.phase ne null}">
   <input class="form-control col-md-6"  id="phas" type="hidden" value="${usersDetails.phase}"  />
   <input class="form-control col-md-6"  id="phas_vtp" type="hidden" value="${usersDetails.phase}"  />
</c:if>
<c:if test="${usersDetails.postingNature ne null}">
   <input class="form-control col-md-6"  id="natureposting" type="hidden" value="${usersDetails.postingNature}"  />
</c:if>
<script type="text/javascript">
   function getStatesOnLoad(){
                if(document.getElementById('sid') != null && document.getElementById('sid').value  != null ){
                        getStatesUpdate(document.getElementById('sid').value);
                        }
                    }

    function getdistrictsOnLoad(){
                   if(document.getElementById('did') != null && document.getElementById('did').value  != null ){
                           getdistrictsUpdate(document.getElementById('sid').value);
                           }
                       }

     function getblocksOnLoad(){
                     if(document.getElementById('bid') != null && document.getElementById('bid').value  != null ){
                             getblocksUpdate(document.getElementById('did').value);
                             }
                         }

                     function getedublocksOnLoad(){
                     if(document.getElementById('ebid') != null && document.getElementById('ebid').value  != null ){
                                               getedublocksUpdate(document.getElementById('did').value);
                                               }
                         }



    function getconstituenctUpdate(){
                     if(document.getElementById('cid') != null && document.getElementById('cid').value  != null ){
                                               getconstituencyUpdate(document.getElementById('did').value);
                                               }
                         }

    function getcasteupdate(){
                        if(document.getElementById('caste_') != null && document.getElementById('caste_').value  != null ){
                                                  getcaste();
                                                  }
                            }


           function getreliginupdate(){
                            if(document.getElementById('subcaste_') != null && document.getElementById('subcaste_').value  != null ){
                                                      getreligion();
                                                      }
                                }
    function getGenderOnLoad(){
                   if(document.getElementById('gid') != null && document.getElementById('gid').value  != null ){
                           getGendersUpdate();
                           }
                       }

        function getrolesOnLoad(){
                            if(document.getElementById('rid') != null && document.getElementById('rid').value  != null ){
                                    getRolesUpdated(document.getElementById('rid').value);
                                    }
                                }

        function getTeacheTypeOnLoad (){
        if(document.getElementById('teacher') != null && document.getElementById('teacher').value  != null ){
                                         getTeacherType();
                                         }
                                     }


      $(document).ready(function() {
          getStatesOnLoad();
          getdistrictsOnLoad();
          getblocksOnLoad();
          getedublocksOnLoad();
        getconstituenctUpdate();
        getGenderOnLoad();
        getcasteupdate();
        getreliginupdate();
         getrolesOnLoad();
         getTeacheTypeOnLoad();
         getQualification();
         getProQualification();
      getCompany();
           getCompany_vtp();
           getSector();
           getPhases();
            getSector_vtp();
                   getPhases_vtp();
           getNaturePosting();
           getSubjects();
           getbg();

       getSchools($('#sid').val(),$('#did').val(),$('#ebid').val());

         var date = new Date();
                var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());

              $('#dojFirst').datetimepicker({
                      	format: 'DD-MM-YYYY'
                      });

                 $('#dojLPresentSchool').datetimepicker({
                              	format: 'DD-MM-YYYY'
                              });

                               $('#dob').datetimepicker({
                                                               	format: 'DD-MM-YYYY'
                                                               });
  var value = document.getElementById('teacher').value;

        if (value == "1") {
                       hide_ctrl('tgt_pgt~location~vtp', true);
                        unhide_ctrl('vocational', true);
                }else if( value=="3"){
                 hide_ctrl('vocational~vtp', true);
                 unhide_ctrl('tgt_pgt', true);
                 }else if(value=="7"){
                  hide_ctrl('vocational~tgt_pgt', true);
                   unhide_ctrl('vtp', true);
                 }
                 else{
                 hide_ctrl('vocational~tgt_pgt~vtp', true);
                 }

          var value = document.getElementById('rid').value;
                 if(value == "18" || value == "19"){
                                 hide_ctrl('location', true);
                                 }else{
                                 unhide_ctrl('location', true);
                                 }

      });



      function hide_unhide(value){
             if (value == "1") {
              hide_ctrl('vtp', true);
              unhide_ctrl('vocational', true);
            }else if( value=="3"){
             hide_ctrl('vocational~vtp', true);
             unhide_ctrl('tgt_pgt', true);
             }else if(value=="7"){
              hide_ctrl('vocational~tgt_pgt', true);
               unhide_ctrl('vtp', true);
             }
             else{
             hide_ctrl('vocational~tgt_pgt~vtp', true);
             }

            }

        function hideUnhideLocation(value){

                if(value == "18" || value == "19"){
                hide_ctrl('location', true);
                }else{
                unhide_ctrl('location', true);
                }

              }


</script>