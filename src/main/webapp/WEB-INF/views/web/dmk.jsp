
<%@include file="/common/taglib.jsp"%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:url var="ProAPI" value="/changePass"/>
<form:form id="formSubmit" role="form" action="" modelAttribute="model" method="POST">
        
        <div class="row">
        <div class="col-md-8">
        	
        <form:input path="email" type="text"   class="form-control"   placeholder="Nhập email của bạn"  />
        
        </div>
        <div class="col-md-4">
        	<button type="button" class="btnSendMail btn btn-primary">Gửi mã</button>
        </div>
        
        </div> 
        
        <br>
        <div class="row">
        <div class="col-md-8">
        	<form:input path="codeCheckPass"  style="width: 100%; height: 50px;"  id="verifyCode" type="text" placeholder="Nhập mã xác minh bạn nhận được"/> 
        </div>
        <div class="col-md-4">
        	<button type="submit" class="btnVerifyCode btn btn-primary">Xác thực</button>
        </div>
        
        </div>
         <br>
        
        <div class="row">
        <div class="col-md-8">
        	<form:input path="password"   style="width: 100%; height: 50px;"  id="changePass" type="text" placeholder="Nhập mật khẩu mới của bạn"/>
        </div>
        <div class="col-md-4">
        	<button type="submit" class="btnChangePass btn btn-primary">OK</button>
        </div>
        
        </div> 
        
        </form:form>




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
$('#formSubmit').submit(function (e) {
	e.preventDefault(); //huy bo su kien mac dinh cua trang 

	console.log(new FormData(this));
	   $.ajax({
           url: '${ProAPI}',
           type: 'POST',
           dataType: "text",
           //enctype: 'multipart/form-data',
           data: new FormData(this),
           processData: false,
           contentType: false,
           success: function (result) {
           	Swalalert(result,"success");
           	console.log(result);
           },
           error: function (error) {
        		console.log(error);
           	Swalalert(error,"error");
           }
       });
}); 
</script>
