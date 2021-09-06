<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Account</title>
</head>
<body>

<h3 style="color:red">${filesuccess}</h3>
<s:form method="post" action="savefile2" enctype="multipart/form-data">
<p><label for="image">Choose Image</label></p>
<p><input  path="file" name="file" id="fileToUpload" type="file" /></p>
<p><input type="submit" value="Upload"></p>
</s:form>





<img src="<c:url value="resources"/>/images/ere2r.PNG"/>
<img src="<c:url value="resources"/>/images/214561987_1641724892683447_7850794836916544953_n.jpg"/>
<img src="<c:url value="resources"/>/images/hyhy.jpg"/>
<img src="<c:url value="images"/>/hyhy.jpg"/>
<img src="<c:url value="images"/>/hyhy.jpg"/>
 

	<h3>Register Account</h3>
	<s:form method="post" modelAttribute="account"
		action="/account/save">
		<table>
			<tr>
				<td>Username</td>
				<td>
					<s:input path="username" required="required"/>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<s:password path="password" required="required"/>
				</td>
			</tr>
			<tr>
				<td>Captcha</td>
				<td>
					<img src="${pageContext.request.contextPath }/captcha">
					<br>
					<input type="text" name="captcha" required="required" style="margin-top: 5px;">
					<br>
					${error }
					${error2 }
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Save">
				</td>
			</tr>
		</table>
	</s:form>

</body>
</html>