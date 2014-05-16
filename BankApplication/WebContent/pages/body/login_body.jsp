
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="jquery.validate.min.js"></script>
<style>
#login-form .fieldgroup label.error {
	color: #FB3A3A;
	margin: 4px 0 5px 1px;
	padding: 0;
	width: 220px;
}
</style>
<script type="text/javascript">
	(function($, W, D) {
		var JQUERY4U = {};

		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#login-form").validate({
					rules : {
						username : "required",
						password : "required",
					},
					messages : {
						username : "Please enter username",
						password : "Please enter password"
					},
					submitHandler : function(form) {
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
	<h1>Login</h1>
	<span class="label label-important"> <%
 	if (request.getAttribute("message") != null) {
 		out.println((String) request.getAttribute("message"));
 	}
 %>
	</span>
	<form id="login-form" action="${pageContext.request.contextPath}/login.iss"
		method="post" name="login-form" novalidate="novalidate">

		<fieldset>
			<div class="fieldgroup">
				Customer<input type="radio"
					name="loginType" value="customer" checked> 
					Banker<input
					type="radio" name="loginType" value="banker">
			</div>
			<div class="fieldgroup">
				<label for="username">Username</label> <input type="text"
					name="username">
			</div>
			<div class="fieldgroup">
				<label for="password">Password</label> <input type="password"
					name="password">
			</div>
			<div class="fieldgroup">
				<button class="btn btn-primary" type="submit" name="login"
					value="Login">Login</button>
			</div>

		</fieldset>

	</form>

</body>
</html>
