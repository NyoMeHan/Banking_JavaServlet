<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Branch</title>
</head><h1>Bank Branch </h1>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
  <script type="text/javascript" src="pages/assets/js/BankBranch.js"></script>

  <script type="text/javascript" src="pages/assets/js/jquery.validate.min.js"></script>
<style>

/* styles for validation form */
#register-form .fieldgroup label.error {
	color: #FB3A3A;
}

body {
	padding-top: 60px;
	padding-bottom: 40px;
}

</style>
<body>
	<form name="NewBranch" action="${pageContext.request.contextPath}/NewBranch.iss" method="post" id="BankBranch" >
		<span class="label label-important" >
		<%if(request.getAttribute("message")!=null){
		out.println((String)request.getAttribute("message"));} %>
		</span>
		<table>
			<tr>
				<td><input type="hidden" name="ID" id="ID" ></td>
			</tr>
			<tr>
				<td>Branch Name</td>
				<td><input type="text" name="branchName" id = "branchName"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" id="address" ></td>
			</tr>
				<tr>
				<td>Phone Number</td>
				<td><input type="text" name="phone" id="phone" ></td>
			</tr>
			<tr>
			
				<td>Email</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
		
			<tr>
				<td>Created_By</td>
				<td><input type="text" name="createdBy" id = "createdBy" disabled = true value = "${createdBy}"></td>
			</tr>
			<tr>
				<td>Created_On</td>
				<td><input type="text" name="createdon" id = "createdon" disabled = true value = "${createdon}"></td>
			</tr>
			<tr>
			<td><button class="btn btn-primary" type="submit" name="method" value="Save">Save</button></td>
			
<!-- 			<td><input  type="submit" name="method" value="Save" /></td> -->

			<td><a href="${pageContext.request.contextPath}/BranchListing.iss?method=Exit">Back</a></td>
			</tr>		
		</table>
	</form>
</body>
</html>