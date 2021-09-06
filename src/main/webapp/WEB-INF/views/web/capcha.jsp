<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
<html>
<head>
<title>Captcha Demo</title>
<style>
.error {
	color: red;
}
</style>

</head>

<body bgcolor="#EAEBEE">

${error }

	<form:form action="loginCapcha" role="form" modelAttribute="login" method="post" commandName="login">
		<div class="login">
			<table border="0" align="center">
				<tr>
					<td align="center"><h1>Login</h1></td>
				</tr>
				<tr>
				${error }
				
				
					<td colspan="2"><font color="red"><c:out
								value="${message}"></c:out></font></td>
				</tr>
				<tr>
					<td colspan="2"><form:errors path="username" cssClass="error" /></td>
				</tr>
				<tr>
				${error }
					<td>Enter User Id              
					</td>
					
					<form:input path="username" type="text"   class="form-control"   placeholder="Tên sản phẩm"  />
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter Password</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>Image#</td>
					<td>
						<div>
							<img id="captcha_id" name="imgCaptcha" src="captcha/a">
						</div>
					</td>


					<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'captcha/a' ;  return false">
							<img src="images/refresh.png" />
					</a></td>


 				

				</tr>
				
				
				<tr>
					<td>Image# 222</td>
					<td>
						<div>
							<img id="captcha_id2" name="imgCaptcha2" src="">
						</div>
					</td>


					


 				

				</tr>
				
				
				<tr>
					<td colspan="2"><form:errors path="captcha" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter above Image text#</td>
					<td><form:input path="captcha" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>

			</table>
		</div>

	</form:form>
	
	<button id="cc"> cc </button>
	
	<script type="text/javascript">
			
	$("#cc").click(function (e) {
		
		$.get("/xxcapcha", function(data, status){
    	 	alert(data);
    	 	console.log(data);
    	 	$("#captcha_id2").attr("src","data");
      });
		
		
		//$("#captcha_id2").attr("src","https://halotravel.vn/wp-content/uploads/2020/07/thach_trangg_101029297_573874646879779_1794923475739360981_n.jpg");
	});
			
	</script>


</body>
</html>