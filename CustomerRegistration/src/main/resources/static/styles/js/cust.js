$(document).ready(function() {
	    		
$("#first_form").validate({
	rules: {
	  	firstName : 'required',
	    lastName : 'required',
	    dateOfBirth : 'required',
	    mobile : {
			required : true,
			minlength : 10,
			maxlength : 17,
		},
	    address1 : 'required',
	    address2 : 'required',
	    age : {
			required : true,
			min : 18,
			max : 100,	
		},
	    gender : 'required',
	    email : {
	    	required : true,
	    	email : /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/,
	    },
	},
	messages: {
		firstName: 'First Name is required',
		lastName : 'Last Name is required',
	    dateOfBirth : 'Date Of Birth is required',
	    mobile : {
			required : 'Mobile number is required',
			minlength : 'Mobile number accept between 10 to 17 digit',
			maxlength : 'Mobile number accept between 10 to 17 digit',
		},
	    	address1 : 'Address is required',
	    	address2 : 'Address is required',
	    age : {
			required : 'Age is required',
			min : 'Age between 18 to 100',
			max : 'Age between 18 to 100',	
		},
	    gender : 'please select gender',
	    email : {
	    	required : 'Email is required',
	    	email : 'Enter valid Email',
	    }, 
	},
	submitHandler: function(form) {
	    form.submit();
	}
});
	
});