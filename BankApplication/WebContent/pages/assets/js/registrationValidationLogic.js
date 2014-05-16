(function($, W, D) {
		var JQUERY4U = {};

		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#register-form")
						.validate(
								{
									rules : {
										firstName : "required",
										lastName : "required",
										passport: "required",
										dob:"required",
										phone : {
											required : true,
											number : true
										},
										email : {
											required : true,
											email : true
										},
										password : {
											required : true,
											minlength : 5
										},
										customerId:"required",
										confirmPassword:"required",
										address:"required",
										nationality: {
										      required: true
										    },
										    gender: {
										        required: true
										      },
									},
									messages : {
										firstName : "Please enter your firstname",
										lastName : "Please enter your lastname",
										passport : "Please enter your passport number",
										dob :"Please enter your date of birth",
										password : {
											required : "Please provide a password",
											minlength : "Your password must be at least 5 characters long"
										},
										email : "Please enter a valid email address",
										phone : "Please enter a valid phone number",
										customerId :"Please enter customer id",
										confirmPassword:"Please enter your password again",
										address:"Please enter address",
										nationality:"Please select country",
										gender:"Please select gender"
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