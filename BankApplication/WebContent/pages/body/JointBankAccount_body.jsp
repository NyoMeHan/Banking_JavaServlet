<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>

<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<script type = "text/javascript">

function validate(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /[0-9]|\./;
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}
	
</script>
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

<title>Joint Bank Account</title>
</head>
<body>
<h1> Joint Bank Account </h1>
<form action="${pageContext.request.contextPath}/BankAccount.iss" method="post">

<!-- <span class="label label-important"> -->

<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%>
	</span><br><br>
<div>
			<fieldset>
				<div class="fieldgroup">
					<label for="AccountNumber">Account Number </label> <input type="hidden" id="AccountID" name="AccountID" value="${AccountID}" />
					<input type="text" name="AccountNumber" value="${AccountNumber} "  />  
				</div>
				<div class="fieldgroup">
					<label for="Balance">Balance</label> <input type="text" name="Balance"  value="${Balance}" id = "Balance"  onkeypress='validate(event)'> 
				</div>
				<div class="fieldgroup">
					<label for="Branch">Branch Name</label> 
					<select name="Branch">
					<c:forEach items="${sBranch}" var="Branch">
						<option value="${Branch.id}" ${Branch.id == BindBranch ? 'selected="selected"' : ''}>${Branch.branchName}</option>
					</c:forEach>
					</select>
				</div>
				
				<div class="fieldgroup">
					<label for="AcType">Account Type</label> 
						<select name="AcType">
						
							<c:forEach items="${sAcType}" var="AcType">
								<option value="${AcType.id}" ${AcType.id == BindAcType ? 'selected="selected"' : ''}>${AcType.type}</option>
							</c:forEach>
						
						</select>
				</div>
				<div class="fieldgroup">
					<label for="customer">Customer</label> 
					<select name="customer">
					<c:forEach items="${scus}" var="customer">
		
					<option value="${customer.id}" ${customer.id == BindCustomer ? 'selected="selected"' : ''}>${customer.loginName}</option>
					</c:forEach>
					</select>
				</div>
				<div class="fieldgroup">
					<label for="Created_By">Created By</label> <input type="text" name="Created_By"  value="${Created_By}"  disabled = true > 
				</div>
				<div class="fieldgroup">
					<label for="Created_On">Created On</label> <input type="text" name="Created_On"  value="${Created_On}" disabled = true > 
				</div>
				
				<div class="fieldgroup">
						<!-- <button class="btn btn-primary" type="submit" name="button" value="Submit" onclick="alert('submit is clicked');performValidation(jQuery, window, document.getElementById('submit'));">Save
						</button>	 -->
						<button class="btn btn-primary" type="submit" name="button" value="Submit" >Submit
						</button>
<!-- 						<button class="btn btn-primary" type="submit" name="button" value="Delete">Delete -->
<!-- 						</button> -->
						<button class="btn btn-primary" type="submit" name="button" value="Clear">Clear
						</button>
						<button class="btn btn-primary" type="submit" name="button" value="Exit">Exit
						</button>	
				 </div>			
			</fieldset>
			  
		</div>
</form>
</body>
</html>
