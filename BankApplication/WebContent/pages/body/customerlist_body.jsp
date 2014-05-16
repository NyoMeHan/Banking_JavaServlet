<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="pages/assets/css/bootstrap.css" rel="stylesheet">
<link href="pages/assets/css/custom.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer </title>
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
</head>
<body>

<h1>Customer List</h1>
<br>
<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%>
</span>


<form action="${pageContext.request.contextPath}/Newcustomer.iss" method = "post" >

<!-- <input type="submit" name="method" value="New Customer"/> -->
<!-- </form> -->

<!-- <form action="/Team4bBankApplication/customerDetail.iss" > -->
<%if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));} %>

<br><br>
<table id="tbl">

<tr>
<th>CustomerID</th><th>FistNmae</th><th>LastName</th><th>Passport</th><th>Nationality</th>
<th>Gender</th><th>Phone</th><th>View Detail</th><th>Delete</th>

</tr>


<c:forEach var="customers" items="${requestScope.customers}">

 <tr >
    
    <td> ${customers.customerID}</td>	
	<td> ${customers.firstName } </td>
	<td> ${customers.lastName } </td>
	<td> ${customers.passport } </td>
	<td> ${customers.nationality } </td>
	<td> ${customers.gender } </td>
	<td> ${customers.phone } </td>
	<td><a href="${pageContext.request.contextPath}/customerDetail.iss?method=viewdetail&&cid=${customers.customerID}">view detail</a></td>
	<td><a href="${pageContext.request.contextPath}/customerDetail.iss?method=delete&&cid=${customers.customerID}">delete</a></td>
</tr>

</c:forEach>
</table><br><br>
<table>
<tr>
<td><button class="btn btn-primary" type="submit" name="method" value="New Customer">New Customer
	</button></td>
</tr>

</table>
</form>
</body>
</html>