
<%@include file="/common/taglib.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:url var="changePass" value="/changePass"/>
<c:url var="changePass2" value="/changePass2"/>

<link href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/smart_wizard.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/smart_wizard_theme_dots.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/gh/bbbootstrap/libraries@main/jquery.smartWizard.min.js"></script>
<style>
form-control:focus {
    color: #495057;
    background-color: #fff;
    border-color: #80bdff;
    outline: 0;
    box-shadow: 0 0 0 0rem rgba(0, 123, 255, .25)
}

.btn-secondary:focus {
    box-shadow: 0 0 0 0rem rgba(108, 117, 125, .5)
}

.close:focus {
    box-shadow: 0 0 0 0rem rgba(108, 117, 125, .5)
}

.mt-200 {
   /*  margin-top: 200px */
}

</style>

<div id="fb-root"></div>
<!-- <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v11.0&appId=273178294430134&autoLogAppEvents=1" nonce="pveHedS2"></script> -->


	<div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Chào mừng quay trở l!!</h1>
                                    </div>
                                
						               <c:if test="${param.incorrectAccount != null}">
											<div class="alert alert-danger">	
													Sai tên đăng nhập hoặc mật khẩu 
											</div>
										</c:if>
										<c:if test="${param.accessDenied != null}">
											<div class="alert alert-danger">	
													Bạn không có quyền truy cập
											</div>
										</c:if>
										
										
                                    <form action="j_spring_security_check" id="formLogin" method="post">
                                    
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="exampleInputEmail" name="j_username" aria-describedby="emailHelp"
                                                placeholder="Nhập tài khoản...">
                                            <input type="hidden" name="returnUrl" value="${returnUrl}"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="exampleInputPassword" name="j_password" placeholder="Mật khẩu">
                                        </div>
                                        <div class="form-group">
                                        	<div class="row">
                                        	<div class="col-md-6">
                                        	<div class="custom-control custom-checkbox small">
                                                <input type="checkbox" name="remember-me" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">nhớ tài khoản</label>
                                            </div>
                                        	
                                        	</div>
                                        	<div class="col-md-6">
                                        	<div class="text-center">
                                       
                                  <!--       		<a class="small btnForget" href="">Quên mật khẩu</a> -->
                                        		
                                        		<a  class="small btnForget2" href="" data-toggle="modal" data-target="#exampleModal"> quên mật khẩu  </a> 
                                   			 </div>
                                        	
                                        	</div>
                                        	</div>
                                            
                                            
                                        </div>
                                       
                                        <button type="submit" class="btn btn-primary btn-user btn-block" >Đăng nhập</button>
                                        <hr>
                                        
                                      <!--   <div class="fb-login-button" data-width="" data-size="large" data-button-type="login_with" data-layout="rounded" data-auto-logout-link="false" data-use-continue-as="true"></div>
                                        <div class="fb-login-button" data-width="" data-size="large" data-button-type="login_with" data-layout="rounded" data-auto-logout-link="false" data-use-continue-as="false"></div>
                                         -->  <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Đăng nhập bằng Facebook
                                        </a>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Đăng nhập bằng Google
                                        </a>
                                      
                                    </form>
                                    <hr>
                                    
                                    <div class="text-center">
                                     <a class="nav-link" href="<c:url value='/dang-ky'/>">Đăng ký</a> 
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        </div>
        
        




 
 
  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        
        <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
            <div class="modal-content " style="width: 475px; margin: 0 auto;">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Lấy lại mật khẩu</h5> <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                </div>
                <div class="modal-body">
                    <div id="smartwizard">
                        <ul>
                            <li><a href="#step-1">Bước 1<br /><small>Nhập Email của bạn</small></a></li>
                            <li><a href="#step-2">Bước 2<br /><small>Nhập mã xác minh</small></a></li>
                            <li><a href="#step-3">Bước 3<br /><small>Nhập mật khẩu mới</small></a></li>
                            
                        </ul>
                        <div>
                            <div id="step-1">
                                <div class="row" style="width: 400px; margin: 0 auto;" >
                                   
                                    <div class="col-md-10"> <input type="text"  id="emailAddress" class="form-control" placeholder="Nhập  email của bạn....." required> <h5 id="result"></h5></div>
                                    <div class="col-md-2"> <button type="button" class="btnSendMail btn btn-success">Tiếp</button> </div>
                                
                                </div>
                                
                            </div>
                            <div id="step-2">
                                <div class="row"  style="width: 400px; margin: 0 auto;">
                                    <div class="col-md-10"> <input id="verifyCode" type="text" class="form-control" placeholder="Nhập mã Otp được gửi đến email của bạn....." required><h5 id="result2"></h5> </div>
                               			<div class="col-md-2"> <button type="button" class="btnCheckOtp btn btn-success">Tiếp</button> </div>
                                </div>
                                
                            </div>
                            <div id="step-3" >
                                <div class="row"  style="width: 400px; margin: 0 auto;">
                                    <div class="col-md-10"> <input type="text" class="form-control"  id="newPass" placeholder="Mật khẩu mới của bạn....." required> </div>
                                   <div class="col-md-2"> <button type="button" class="btnChangePass btn btn-success">Tiếp</button> </div>
                                </div>
                                
                            </div>
                            
                            
                        </div>
                    
              
                    </div>
                </div>
            
            	
            </div>
        </div>
         </div>
        

        

<script type="text/javascript">

function Swalalert(mess,icon) {
	Swal.fire({
		  position: 'top',
		  icon: icon,
		  title: mess,
		  showConfirmButton: false,
		  timer: 1500
		});
};
function emailCheck(email) {
	  const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
};


$(document).ready(function(){

	$('#smartwizard').smartWizard({
		selected: 0,
		theme: 'dots',
		autoAdjustHeight:true,
		transitionEffect:'fade',
		showStepURLhash: false,	
		toolbarSettings: { showNextButton: false, showPreviousButton: false},
	});
	
	
	
	$(".btnSendMail").click(function(e){	
		 e.preventDefault(); 
		 const $mess = $("#result");
		 const email = $("#emailAddress").val();	  
		if (emailCheck(email)) {
			$.get('/sendMailResetPass/'+email, function(result){  
				if (result=="true") {
					Swalalert("Đã gửi mail. Vui lòng kiểm tra email của bạn!","success");
					$('#smartwizard').smartWizard("next");
				}else{
					Swalalert("Gửi mail lỗi !","error")	
				};
			 });
		} else  {
			$mess.text( "email không đúng định dạng !");
		    $mess.css("color", "red");
		}
		
		
		
	});
	$(".btnCheckOtp").click(function(e){	
		e.preventDefault(); 
		const $mess = $("#result2");
		var email=$("#emailAddress").val();
		var code=$("#verifyCode").val();
	    $.post("/checkCodeResetPass2", {
	    	email : email,
	    	code : code
	    }, function(data) {

	    	if (data=="expires") {
				$mess.text( "Mã đã hết hạn !");
			    $mess.css("color", "red");
			}else
	    	if (data=="true") {
				Swalalert("Xác thực thành công","success");
				$('#smartwizard').smartWizard("next");
			}else{
				$mess.text( " Mã bạn vừa nhập sai !");
			    $mess.css("color", "red");
			};
	    });
	});
	
	
	$(".btnChangePass").click(function(e){	
		e.preventDefault(); 
		$.post("/changePass2", {
	    	email : $("#emailAddress").val(),
	    	pass : $("#newPass").val()
	    }, function(data) {

	    	if (data=="true"){
	    		Swalalert("Đổi mật khẩu thành công","success");		
	   		 	$('#exampleModal').modal('hide');
			}else{
				Swalalert("Đổi mật khẩu không thành công!","error")	
			};
	    });  
	});


	
});





	
		
	/* function phoneCheck(str) {
		  return /^(84|0[3|5|7|8|9])+([0-9]{8})$/.test(str);
		 
		}
	
	function validate() {
		  const $result = $("#result");
		  const email = $("#emailAddress").val();
		  $result.text("");

		  if (phoneCheck(email)) {
		    $result.text( " is valid :)");
		    $result.css("color", "green");
		  } else {
		    $result.text(" is not valid :(");
		    $result.css("color", "red");
		  }
		  return false;
		}
	
	$("#emailAddress").on("input", validate); */










	
	
	


</script>	



