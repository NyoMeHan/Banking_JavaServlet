<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Branch List </title>
<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
 .modal {
    /* new custom width */
    width: 560px;
    /* must be half of the width, minus scrollbar on the left (30px) */
    margin-left: -280px;
}
#tbl
{
font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
width:100%;
border-collapse:collapse;
}
#tbl td, #tbl th 
{
font-size:1em;
border:1px solid #98bf21;
padding:3px 7px 2px 7px;
}
#tbl th 
{
font-size:1.1em;
text-align:left;
padding-top:5px;
padding-bottom:4px;
background-color:#A7C942;
color:#ffffff;
}
#tbl tr.alt td 
{
color:#000000;
background-color:#EAF2D3;
}
</style>
</head><h1>Bank Branch List </h1>
<br>
<body>
<form action = "${pageContext.request.contextPath}/NewBranch.iss" method = "post">
<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%>
	</span><br><br>
<table id="tbl">
<tr><th>BranchID</th><th>BranchName</th><th>Address</th><th>PhoneNumber</th><th>Email</th><th>Created By</th><th>Created On</th><th>View Detail</th><th>Delete</th>
<c:forEach var = "branchdetails" items= "${requestScope.branchdetails}">
<tr> <input type="hidden" id="ID" name="ID" value=" ${branchdetails.id}" />
	 <td> ${branchdetails.id} </td>
	<td> ${branchdetails.branchName} </td>
	<td> ${branchdetails.address} </td>
	<td> ${branchdetails.phone} </td>
	<td> ${branchdetails.email} </td>
	<td> ${branchdetails.createdBy} </td>
	<td> ${branchdetails.createdOn} </td>
	<td><a href="${pageContext.request.contextPath}/BranchDetail.iss?method=viewdetail&&ID=${branchdetails.id}">view detail</a></td>
	<td><a href="${pageContext.request.contextPath}/BranchDetail.iss?method=delete&&ID=${branchdetails.id}">delete</a></td>
	
</tr>
</c:forEach>
</table><br>
<table>
<tr>
<td><button class = "btn btn-primary" type="submit" name="method" value="New Branch">New Bank Branch</button></td>
</tr>
</table>
</form>
</body>
</html>