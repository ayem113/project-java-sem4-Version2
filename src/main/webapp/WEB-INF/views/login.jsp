
<%@include file="/common/taglib.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:url var="ProAPI" value="/changePass"/>

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
                                        <%-- <a class="small" href="<c:url value='/quen-mat-khau'/>">Quên mật khẩu</a> --%>
                                        <a class="small btnForget" href="">Quên mật khẩu</a>
                                   			 </div>
                                        	
                                        	</div>
                                        	</div>
                                            
                                            
                                        </div>
                                       
                                        <button type="submit" class="btn btn-primary btn-user btn-block" >Đăng nhập</button>
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Đăng nhập bằng Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Đăng nhập bằng Facebook
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
        
        
<div id="emailModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
   
      <div class="modal-body">
        
        <form:form id="formSubmit" role="form" action="" modelAttribute="model" method="POST">
        
        <div class="row">
        <div class="col-md-9">
        	
        <form:input path="email" type="email"  id="emailAddress" class="form-control"   placeholder="Nhập email của bạn"  />
        <h5 id="result"></h5>
        </div>
        <div class="col-md-3">
        	<button  style=" width: 100%;"  type="button" class="btnSendMail btn btn-info">Gửi mã</button>
        </div>
        
        </div> 
        
        <br>
        <div class="row">
        <div class="col-md-9">
        	<form:input path="otp" class="form-control" style="width: 100%; height: 40px;"  id="verifyCode" type="text" placeholder="Nhập mã xác minh bạn nhận được"/> 
        </div>
        <div class="col-md-3">
        	<button style=" width: 100%;" type="submit" class="btnVerifyCode btn btn-info">Xác thực</button>
        </div>
        
        </div>
         <br>
        
        <div class="row">
        <div class="col-md-9">
        	<form:input path="password"  class="form-control" style="width: 100%; height: 40px;"  id="changePass" type="hidden" placeholder="Nhập mật khẩu mới của bạn"/>
        </div>
        <div class="col-md-3">
        	<button  style=" width: 100%;display:none;  " type="submit" class="btnChangePass btn btn-info">OK</button>
        </div>
        
        </div> 
        
        </form:form>

         
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

$("a.btnForget").bind('click', function (e) {
	e.preventDefault(); 
	$('#emailModal').modal("show");
});


	function emailCheck(email) {
	  const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}
		
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

 $('.btnSendMail').click(function (e) { 
	 e.preventDefault(); 
	 
	 const $result = $("#result");
	  const email = $("#emailAddress").val();
	  
	if (emailCheck(email)) {
		$.get('/sendMailResetPass/'+email, function(result){  
			if (result=="true") {
				Swalalert("Đã gửi mail. Vui lòng kiểm tra email của bạn!","success");
				$result.text("");
			}else
			{
				Swalalert("Gửi mail lỗi !","error")
				
			};
		 });
	} else  {
		$result.text( " vui lòng nhập email đúng định dạng !");
	    $result.css("color", "red");
	}
	 
	 
	
	
	
}); 




/* $('.btnVerifyCode').click(function (e) {
	e.preventDefault(); 
	var email=$("#emailAddress").val();
	var code=$("#verifyCode").val();
	$.get('/checkCodeResetPass/'+code+"&"+email, function(result){  
		Swalalert(result,"success")  ;
		console.log(result);
		if (result=="true") {
			$('.btnChangePass').css({ display: 'block'	});	
			$("#changePass").prop("type", "text");
		}	
	});
}); */


$('.btnVerifyCode').click(function (e) {
	e.preventDefault(); 
	var email=$("#emailAddress").val();
	var code=$("#verifyCode").val();
    $.post("/checkCodeResetPass2", {
    	email : email,
    	code : code
    }, function(data) {

    	if (data=="expires") {
			Swalalert("Mã đã hết hạn","warning");
		}else
    	if (data=="true") {
			Swalalert("Xác thực thành công","success");
			$('.btnChangePass').css({ display: 'block'	});	
			$("#changePass").prop("type", "text");
			$('.btnVerifyCode').css({ display: 'none'	});	
			$("#verifyCode").prop("type", "hidden");
			
		}else
		{
			Swalalert("Sai mã code!","error")
			
		};
    });
                
    
});





$('#formSubmit').submit(function (e) {
	e.preventDefault(); //huy bo su kien mac dinh cua trang 

	   $.ajax({
           url: '${ProAPI}',
           type: 'POST',
           dataType: "text",
           //enctype: 'multipart/form-data',
           data: new FormData(this),
           processData: false,
           contentType: false,
           success: function (data) {
        	   if (data=="true") {
       			Swalalert("Đổi mật khẩu thành công","success");
       			$('.btnChangePass').css({ display: 'block'	});	
       			$("#changePass").prop("type", "text");
       			$('#emailModal').modal("hide");
       			$('#emailModal').find('form')[0].reset();
       		}else
       		{
       			Swalalert("Đổi mật khẩu không thành công!","error")
       			
       		};
           },
           error: function (error) {
        		console.log(error);
           }
       });
}); 

</script>	



