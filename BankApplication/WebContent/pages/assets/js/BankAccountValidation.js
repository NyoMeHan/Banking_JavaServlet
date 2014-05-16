(function($, W, D) {
		var JQUERY4U = {};

		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#bankaccount-form").validate(
								{
									rules : {
										AccountNumber : "required",
										customer : "required",
										Branch : "required",
										AcType:"required",
										Balance : {
											required : true,
											number : true
										},
										
									},
									messages : {
										AccountNumber : "Please enter your Account Number",
										customer : "Please select the customer name",
										Branch : "Please select the Bank Branch Name",
										AcType :"Please select the Account Type",
										Balance : {
											required : "Please enter a valid Balance Amount",
											number : true
										},
									},
									submitHandler : function(form) {
										form.submit("Submit");
									}
								});
			}
		};

		//when the form has loaded setup form validation rules
		$(D).ready(function($) {
			JQUERY4U.UTIL.setupFormValidation();
		});

	})(jQuery, window, document);
/*
performValidation($, W, D){
	alert("inside peerform validation");
	$("#bankaccount-form").validate(
			{
				rules : {
					AccountNumber : "required",
					customer : "required",
					Branch : "required",
					AcType:"required",
					Balance : {
						required : true,
						number : true
					},
					
				},
				messages : {
					AccountNumber : "Please enter your Account Number",
					customer : "Please select the customer name",
					Branch : "Please select the Bank Branch Name",
					AcType :"Please select the Account Type",
					Balance : {
						required : "Please enter a valid Balance Amount",
						number : true
					},
				}
			});};(jQuery, window, document);*/