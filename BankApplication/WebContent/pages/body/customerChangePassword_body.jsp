<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head><h1>Change Password</h1>

<body>
	<form name="ChangePassword" action="${pageContext.request.contextPath}/ChangePassword.iss" method="post">
		<span class="label label-important" >
		<%if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));} %></span>
<br><br>
		<table>
			<tr>
				<td>Current Password</td>
				<td><input type="text" name="curpassword"></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type="text" name="newpassword"></td>
			</tr>
			<tr>
				<td>Confirm	 Password</td>
				<td><input type="text" name="conpassword"></td>
			
          <!--  <td><input  type="submit" name="method" value="Save" /></td> -->
			<td><button class="btn btn-primary" type="submit" name="method" value="Save">Save</button></td>	
		</table>

	</form>
</body>
</html>