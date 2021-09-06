
	<%@include file="/common/taglib.jsp"%>

<script src='https://www.google.com/recaptcha/api.js?hl=vi' type="text/javascript"></script>	


    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            
                            
                            <form:form action="xu-ly-dang-ky" modelAttribute="s" method="post" >
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="username"
                                            placeholder="User Name" required>
                                            
                                         <%-- <form:input  path="username" />  --%>  
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="password"
                                            placeholder="Password" required>
                                           <%--  <form:input  path="password" />   --%>
                                    </div>
                                </div>
                                
                                <!-- <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            name="exampleInputPassword" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            name="exampleRepeatPassword" placeholder="Repeat Password">
                                    </div>
                                </div> -->
                                
                                
                                
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="fullname"
                                        placeholder="fullname"required>
                                      <%--   <form:input  path="fullname" />   --%>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="address"
                                        placeholder="address"required>
                                       <%--  <form:input  path="address" /> --%>  
                                </div>
                                
                                <div class="g-recaptcha" data-sitekey="6Lcrf7UZAAAAAKBr-JociylacHDZugnSQDlZbmfQ"></div>
						        <span id="messeger" style=" color: red; font-size:20px;margin:20px 0;padding:20px;">
						          
						        </span>
                                <input class="btn btn-primary btn-user btn-block" type="submit" value="Register Account"/>
                                <%-- <a href="<c:url value='/xu-ly-dang-ky'/>" class="btn btn-primary btn-user btn-block">
                                    Register Account
                                </a> --%>
                                
                                
                                
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a id="cc" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form:form>
                            
                            
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                           
                            <div class="text-center">
                                <a class="small" href="<c:url value='/dang-nhap'/>">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

 
    <script type="text/javascript">


$("#cc").click(function (e) {
	e.preventDefault();
	var response = grecaptcha.getResponse();
    if (response.length == 0) {
        //the recaptcha is checked
        // Do what you want here
    	$("#messeger").text("vui long check vao o");    
    }
});


/* $(document).on('click','.btn-capcha',function () {
	alert("clcok");
    var response = grecaptcha.getResponse();
    if (response.length == 0) {
        //the recaptcha is checked
        // Do what you want here
        alert('Vui lòng click vào tôi không phải là người máy');
    }}); */

	

	/* if (${alert}!=null) {
		
		if (${alert}==true) {
			Swal.fire({
				  position: 'top',
				  icon: 'success',
				  title: 'dang ky thanh cong',
				  showConfirmButton: false,
				  timer: 1500
				});
				
			
		}
		else{
			Swal.fire({
				  position: 'top',
				  icon: 'error',
				  title: 'dang ky khong thanh cong',
				  showConfirmButton: false,
				  timer: 1500
				});
				
			}
		
	} */
</script>

    
    
    