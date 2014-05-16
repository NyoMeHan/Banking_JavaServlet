<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Branch Detail</title>
</head><h1>Branch Detail </h1>
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

<form name="branchdetail" action="${pageContext.request.contextPath}/BranchUpdate.iss" id = "BankBranch">
<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%>
	</span>
		
<input type="hidden" name="ID"  value="${requestScope.br.id}">
<table>

<tr><td>BranchName</td><td><input type="text" id = "branchName" name="branchName" value="${requestScope.br.branchName}"></td></tr>
<tr><td>Address</td><td><input type="text" id="address" name="address" value="${requestScope.br.address}"></td></tr>
<tr><td>PhoneNumber</td><td><input type="text" id="phone" name="phone" value="${requestScope.br.phone}"></td></tr>
<tr><td>Email</td><td><input type="text" id="email" name="email" value="${requestScope.br.email}"></td></tr>
<tr><td>Created_By</td><td><input type="text"  name="created_by" value="${requestScope.br.createdBy}" disabled = true></td></tr>
<tr><td>Created_On</td><td><input type="text"  name="create_on" value="${requestScope.br.createdOn}"  disabled = true></td></tr>
</table>
<table>
<tr>
<!-- <td><input  type="submit" name="method" value="Update" /></td> -->
<td><button class="btn btn-primary" type="submit" name="method" value="Update">Update</button></td>
<td><a href="${pageContext.request.contextPath}/BranchListing.iss?method=exit">Exit</a></td>

<td><input type="hidden" name = "method" value="performupdate"/></td>
</tr>
</table>
</form>
</body>
</html>