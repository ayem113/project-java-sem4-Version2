
<%@include file="/common/taglib.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
                                <h1 class="h4 text-gray-900 mb-4">Tạo mới tài khoản!</h1>
                            </div>
                            
                            
                            <form:form id="formSubmit" action="xu-ly-dang-ky" modelAttribute="s" method="post" >
                                <div class="form-group row">
                                    <div class="  col-sm-6 mb-3 mb-sm-0">
    									 <form:input name="username"   path="username" placeholder="Nhập tên tài khoản" class="form-control" />   
                                    		<p id="txtCheckUserName" ></p>
                                    </div>
                                    <div class="col-sm-6">
                                           <form:input  path="fullname" placeholder="Nhập tên đầy đủ" class="form-control"/>   
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <form:input name="password" type="password"  path="password" placeholder="Nhập  password" class="form-control"/>  
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            name="repeatPass" placeholder="Gõ lại password">
                                            <p id="txtRepeatPass" ></p>
                                    </div>
                                </div>
                                 
                                
                                <div class="form-group">
                                   <form:input  name="email" path="email" placeholder="Nhập địa chỉ email" class="form-control" />   
                                	<p id="txtCheckEmail" ></p>
                                </div>
                                
                                
                                
                                <div class="g-recaptcha" data-sitekey="6Lcrf7UZAAAAAKBr-JociylacHDZugnSQDlZbmfQ"></div>
						        <span id="messeger" style=" color: red; font-size:20px;margin:20px 0;padding:20px;">
						          
						        </span>
						        
						        
						        <div class="row" style="    margin-left: 20px;"> 
						        
						        	<div class="col-md6"> 
						        			<div class="row">
									        	<div> 
									        		<img id="captcha_id1" name="imgCaptcha" src="captcha/getCapcha1">
												</div>
												<div>
													<a href="javascript:;" 
														onclick="document.getElementById('captcha_id1').src = 'http://localhost:8080/captcha/getCapcha1' ;  ">
														<img src="images/refresh.png" />
													</a>  
													
												</div>
												
											</div>
						        	</div>
						        	<div class="col-md6" style="margin-left: 44px;">  
						        			<div class="row">
									        	<div> 
									        		<img id="captcha_id2" name="imgCaptcha2" src="captcha/getCapcha2">
												</div>
												<div>
													<a href="javascript:;" 
														onclick="document.getElementById('captcha_id2').src = 'http://localhost:8080/captcha/getCapcha2' ; return false  ">
														<img src="images/refresh.png" />
													</a>  
													
												</div>
									
											</div>
						        	</div>
						        </div>
						        <br>		        
                                <input class="btn btn-primary btn-user btn-block" type="submit" value="Đăng ký"/>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Đăng ký bằng Google
                                </a>
                                <a id="cc" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Đăng ký bằng Facebook
                                </a>
                          </form:form>
                            
                            
                            <hr> 
                            <div class="text-center">
                                <a class="small" href="<c:url value='/dang-nhap'/>">Đã có tài khỏan? Đăng nhập!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

 
<script type="text/javascript">


function swalAlert(mess,icon){
	Swal.fire({
		 position: 'top',
		 icon: icon,
		 title: mess,
		 showConfirmButton: false,
		 timer: 1500
	});
};	 
$('input[name=username]').keyup(function() { 
	var name=$(this).val();
	if (name.length>0){
		$.get("/isExistUserName/"+name, function(data,stt){
			console.log(stt);
	    	if (data=="true") {
	    		$("#txtCheckUserName").text("Tên khả dụng ").css({"color":"green"});
			}
	    	else{
	    		$("#txtCheckUserName").text("Tên này đã được đăng ký! ").css({"color":"red"});
	    	}	
		}); 
	}
	
});

$('input[name=repeatPass]').keyup(function() { 
	var pass=$("#password").val();
	var repeatPass=$(this).val();
	
	    	if (pass==repeatPass) {
	    		$("#txtRepeatPass").text("Trùng khớp").css({"color":"green"});
			}
	    	else{
	    		$("#txtRepeatPass").text("Mật khẩu không trùng khớp! ").css({"color":"red"});
	    	}	
});

function emailCheck(email) {
	  const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
};


$('input[name=email]').keyup(function() { 
			
	
	    	if (emailCheck($(this).val())) {
	    		$("#txtCheckEmail").text("Email đúng định dạng").css({"color":"green"});
			}
	    	else{
	    		$("#txtCheckEmail").text("Email không đúng định dạng! ").css({"color":"red"});
	    	}	
});

$('#formSubmit').submit(function (e) {
	e.preventDefault();
	var response = grecaptcha.getResponse();
	
	
    if (response.length == 0) {   
    	$("#messeger").text("vui lòng check vào ô!");    
    }
    else{
    	$.ajax({
            url: '/xu-ly-dang-ky',
            type: 'POST',
            dataType: "JSON",
            data: new FormData(this),
            processData: false,
            contentType: false,
            success: function (data) {
            	console.log(data==true);
            	if (data==true) {
            		swalAlert("Đăng ký thành công","success");
            		window.location = 'http://localhost:8080/dang-nhap';
				}
            	else{
            		swalAlert("Đăng ký không thành công","error");
            	}	
            },
            error: function (error) {
            	swalAlert("lỗi ajax","error");
            }
        });
    }
	
    
});


</script>

    
    
    