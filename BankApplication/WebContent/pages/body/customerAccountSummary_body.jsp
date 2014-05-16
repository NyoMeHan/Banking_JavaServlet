   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<div id="header">
<h1>Account Summary</h1>

<table class="table table-bordered">
<tr><td>#</td><td>Account Number</td><td>Balance</td><td>Branch Name</td><td>Created On</td></tr>
<c:forEach var="summary" items="${requestScope.summaries}">
  <tr><td>${summary.accountId}</td><td>${summary.accountNumber}</td><td>${summary.balance}</td><td>${summary.branchName}</td><td>${summary.createdOn}</td></tr>
</c:forEach>
</table>
</div>