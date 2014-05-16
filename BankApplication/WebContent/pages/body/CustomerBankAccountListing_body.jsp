<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../pages/assets/css/bootstrap.css" rel="stylesheet">
<link href="/pages/assets/css/custom.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
 <title>Bank Accoount Listing</title>
 <h1>Bank Account Listing</h1><br><br>
</head>
<body>
<form action="${pageContext.request.contextPath}/BankAccount.iss" method="post">
<!-- <span class="label label-important"> -->
<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%>
	</span><br><br>
<!-- <table class="table table-bordered" > -->
<table id="tbl">
		<tr>
			<th>Account Number</th><th>Balance</th><th>Account Type Name</th>
			<th>Branch Name</th><th>Customer</th><th>Created On</th><th>Created By</th><th colspan=2>action</th>
		</tr>
		<c:forEach var="list" items="${requestScope.slist}">
			<tr><input type="hidden" id="accountID" name="accountID" value="${list.accountid}">
			<td>${list.accountNumber}</td>
			<td>${list.balance}</td>
			<td>${list.accountType_Name}</td>
			<td>${list.branchName}</td>
			<td>${list.loginName}</td>
			<td>${list.createdOn}</td>
			<td>${list.createdBy}</td>
			
<!-- 			<input type="hidden" id="button" name="button" value="" /> -->
			
			<td><a href= "${pageContext.request.contextPath}/BankAccount.iss?accountID=${list.accountid}" >View Details</a></td>
			<td><a href= "${pageContext.request.contextPath}/BankAccount.iss?button=Delete&&accountID=${list.accountid}" >Delete</a></td>
			</tr>
		</c:forEach>
		</table><br>
		<table>
		<tr><td><button class="btn btn-primary" type="submit" name="button" value="New Account">New Account
		</button>  </td>
<!-- 		<td><button class="btn btn-primary" type="submit" name="joint" value="Joint Account">Create Joint Account
		</button>  </td> -->
		</tr>
		</table>
</form>
</body>
</html>