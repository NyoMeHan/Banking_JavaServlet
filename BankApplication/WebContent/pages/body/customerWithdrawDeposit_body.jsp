 <html>
 <head>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <script type="text/javascript" src="jquery.validate.min.js"></script>
 <style>
 #withdraw_form .fieldgroup label.error {
    color: #FB3A3A;
    margin: 4px 0 5px 1px;
    padding: 0;
   
    width: 220px;
}
#deposit_form .fieldgroup label.error {
    color: #FB3A3A;
    margin: 4px 0 5px 1px;
    padding: 0;
   
    width: 220px;
}
</style>
<script type="text/javascript">
(function($,W,D)
{
    var JQUERY4U = {};

    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            $("#withdraw_form").validate({
                rules: {
                    amount: {required: true,
                             number: true}
                },
                messages: {
                    amount: "Please enter amount"
                                      
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });   
            $("#deposit_form").validate({
                rules: {
                    amount: {required: true,
                             number: true}
                },
                messages: {
                    amount: "Please enter amount"
                                      
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });   
        }
    }


    //when the dom has loaded setup form validation rules
    $(D).ready(function($) {
        JQUERY4U.UTIL.setupFormValidation();
    });

})(jQuery, window, document);
</script>
</head>
<body>
<div class="row">
<div align="left">
<span class="label label-important">
<% if(request.getAttribute("message")!=null){
out.println((String)request.getAttribute("message"));
}
	%></span></div>
<div class="span5">
<!-- withdraw start -->
<form id="withdraw_form" action="${pageContext.request.contextPath}/withdraw.iss" method="post" novalidate="novalidate">
<span class="label label-important">

	</span>
	<fieldset>
	<div class="fieldgroup">
                <label for="accountNumber">Select Account</label>
               <select name="accountNumber">
<c:forEach var="account" items="${sessionScope.accounts}">
  <option value="${account.accountNumber}">${account.accountNumber} </option>
</c:forEach>
</select><div class="fieldgroup">
             <label for="message">Message</label>
             <input type="text" name="status">
            </div>
            <div class="fieldgroup">
            <label for="amount">Amount</label>
            <input type="text" name="amount">
            </div>
            <div class="filedgroup"></div>
            <button class="btn btn-primary" type="submit" name="withdraw_deposit" value="withdraw">Withdraw</button>
            </div>
            
            
	</fieldset>
</form>
<!-- withdraw end -->
</div>
<div class="span4">

</div>
</div>
<hr>
<div class="row">
<div class="span5">

<!-- deposit start -->
<form id="deposit_form" action="${pageContext.request.contextPath}/deposit.iss" method="post" novalidate="novalidate">
<fieldset>
	<div class="fieldgroup">
                <label for="accountNumber">Select Account</label>
               <select name="accountNumber">
<c:forEach var="account" items="${sessionScope.accounts}">
  <option value="${account.accountNumber}">${account.accountNumber} </option>
</c:forEach>
</select>
            </div>
            
            <div class="fieldgroup">
             <label for="message">Message</label>
             <input type="text" name="status">
            </div>
            <div class="fieldgroup">
            <label for="amount">Amount</label>
            <input type="text" name="amount">
            </div>
            <div class="fieldgroup">
            <button class="btn btn-primary" type="submit" name="withdraw_deposit" value="deposit">Deposit</button>
            </div>
            
            
</fieldset>
</form>
<!-- deposit end -->
</div>
<div class="span4">

</div>
</div>
</body>
</html>
