   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<h3>Customer Transactions</h3>
<br><br>
<form action="${pageContext.request.contextPath}/transaction.iss" method="post">
<table><tr><td>Account</td><td><select name="accountId">
<option value="0">select account </option>
<c:forEach var="account" items="${sessionScope.accounts}">
  <option value="${account.id}">${account.accountNumber} </option>
</c:forEach>
</select></td><td><button class="btn btn-primary" type="submit" name="showTransaction" value="showTransactionByAccountId">Go</button></td></tr></table>





</form>

<hr>
<table class="table table-hover">
<tr><td>From Account Number</td> <td>To Account Number</td> <td>Amount</td><td>Transaction Date</td><td>Message</td></tr>
<c:forEach var="transaction" items="${requestScope.transactions}">
<tr><td>${transaction.fromCustomerAccountNumber}</td><td>${transaction.toCustomerAccountNumber}</td><td>${transaction.amount}</td><td>${transaction.transactionDate}</td><td>${transaction.status}</td></tr>
</c:forEach>
</table>

