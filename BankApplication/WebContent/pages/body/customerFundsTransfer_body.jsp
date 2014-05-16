 
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<h3>Funds Transfer</h3>
<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%>
	</span>
<div class="row">
<div class="span5">
<!-- deposit start -->
<form action="${pageContext.request.contextPath}/fundsTransfer.iss" method="post">
<table>
<tr><td>From Account</td>
<td>
<select name="accountNumber">
<c:forEach var="account" items="${sessionScope.accounts}">
  <option value="${account.accountNumber}">${account.accountNumber} </option>
</c:forEach>
</select>
</td>
<tr>
<td>To Account</td><td><input type="text" name="to_accountNumber"></td></tr>
<tr><td>Message</td><td><input type="text" name="status"></td></tr>
<tr><td>Amount</td><td><input type="text" name="amount"></td></tr>
<tr><td colspan="2"><button class="btn btn-primary" type="submit" name="fundsTranfer" value="fundsTransfer">Transfer Fund</button></td></tr>
</table>
</form>
<!-- deposit end -->
</div>
<div class="span4">
Some information about the Withdraw will be shown here..
</div>
</div>
