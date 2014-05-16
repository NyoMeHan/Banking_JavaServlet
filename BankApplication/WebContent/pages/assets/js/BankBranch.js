(function($, W, D) {
		var JQUERY4U = {};

		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#BankBranch")
						.validate(
								{
									rules : {
										branchName : "required",
										address : "required",
										phone : {
											required : true,
											number : true
										},
										email : {
											required : true,
											email : true
										},
									},
									messages : {
										branchName : "Please enter your Bank Branch Name",
										address : "Please enter your Bank Branch Address",
										
										email : "Please enter a valid email address",
										phone : "Please enter a valid phone number",
										
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