$(function() {
	
	//loginPage.html
	$("#linkClose").on("click", function() {
		$("#divError").hide("fade");
	});
	
	$("#signIn").on("click", function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var user2 = {};
		
		if(username === "" && password === "") {
			$("#unerror").show();
			$("#pwerror").show();
			return false;
		} else if(username === "") {
			$("#unerror").show();
			$("#pwerror").hide();
			return false;
		} else if(password === "") {
			$("#unerror").hide();
			$("#pwerror").show();
			return false;
		}
		
		$("#unerror").hide();
		$("#pwerror").hide();
		
		var obj = {
			username: username,
			password: password
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json'/*,
		        'Authorization': 'Basic ' + btoa(username + ':' + password)*/
		    },
			type: "POST",
			url: "/api/login",
			data: JSON.stringify(obj),
			dataType: "json",
			success: function(user) {
				//alert(user.role);
				sessionStorage.setItem("basicAuth", btoa(username + ':' + password));
				if(user.role === "guest") {
					window.location.href = "mainGuestPage.html";
				} else if(user.role === "systemManager") {
					window.location.href = "systemManagerPage.html";
				} else if(user.role === "restaurantManager") {
					window.location.href = "restaurantManagerPage.html";
				} else if(user.role === "staff") {
					window.location.href = "staffPage.html";
				} else if(user.role === "supplier") {
					window.location.href = "supplierPage.html";
				}
			},
			error: function(jqXHR) {
				//alert(jqXHR.status);
				$("#divErrorText").text("This user doesn't exist or username or password are incorrect!");
				$("#divError").show("fade");
				/*if(jqXHR.status == 401) {	
					$("#divErrorText").text("401 Unauthorized!");
					$("#divError").show("fade");
				}*/
			}
		});
	});
	
	//createAccount.html
	$("#linkClose1").on("click", function() {
		$("#divError1").hide("fade");
	});
	
	$("#closeModal").on("click", function() {
		window.location.href = "loginPage.html";
	});
	
	$("#closeModal1").on("click", function() {
		window.location.href = "loginPage.html";
	});
	
	$("#register").on("click", function() {
		var firstName = $("#firstname").val();
		var lastName = $("#lastname").val();
		var username = $("#username").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var rpassword = $("#rpassword").val();
		
		if(firstName === "" && lastName === "" && username === "" && email === "" && password === "" && rpassword === "") {
			$("#fnerror").text("First Name can't be empty!");
			$("#lnerror").text("Last Name can't be empty!");
			$("#unerror").text("Username can't be empty!");
			$("#eaerror").text("Email can't be empty!");
			$("#pwerror").text("Password can't be empty!");
			$("#rpwerror").text("Confirm Password can't be empty!");
			$("#fnerror").show();
			$("#lnerror").show();
			$("#unerror").show();
			$("#eaerror").show();
			$("#pwerror").show();
			$("#rpwerror").show();
			return false;
		} else if(firstName === "") {
			$("#fnerror").text("First Name can't be empty!");
			$("#fnerror").show();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").hide();
			return false;
		} else if(lastName === "") {
			$("#lnerror").text("Last Name can't be empty!");
			$("#fnerror").hide();
			$("#lnerror").show();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").hide();
			return false;
		} else if(username === "") {
			$("#unerror").text("Username can't be empty!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").show();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").hide();
			return false;
		} else if(username != "" && username.match(/^[a-z0-9_-]{3,16}$/i) == null) {
			$("#unerror").text("Username need's to be created from 3 or more characters!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").show();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").hide();
			return false;
		} else if(email === "") {
			$("#eaerror").text("Email can't be empty!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").show();
			$("#pwerror").hide();
			$("#rpwerror").hide();
			return false;
		} else if(email != "" && email.match(/^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,4}$/i) == null) {
			$("#eaerror").text("Email example - example@gmail.com");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").show();
			$("#pwerror").hide();
			$("#rpwerror").hide();
			return false;
		} else if(password === "") {
			$("#pwerror").text("Password can't be empty!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").show();
			$("#rpwerror").hide();
			return false;
		} else if(password != "" && password.match(/^[a-z0-9_-]{8,18}$/) == null) {
			$("#pwerror").text("Password need's to have at least 8 characters!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").show();
			$("#rpwerror").hide();
			return false;
		} else if(rpassword === "") {
			$("#pwerror").text("Confirm Password can't be empty!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").show();
			return false;
		} else if(rpassword != "" && rpassword.match(/^[a-z0-9_-]{8,18}$/) == null) {
			$("#rpwerror").text("Password need's to have at least 8 characters!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").show();
			return false;
		} else if(password !== rpassword) {
			$("#rpwerror").text("These to password's are not equale!");
			$("#fnerror").hide();
			$("#lnerror").hide();
			$("#unerror").hide();
			$("#eaerror").hide();
			$("#pwerror").hide();
			$("#rpwerror").show();
			return false;
		}
		
		$("#fnerror").hide();
		$("#lnerror").hide();
		$("#unerror").hide();
		$("#eaerror").hide();
		$("#pwerror").hide();
		
		var guest = {
			username: username,
			password: password,
			firstName: firstName,
			lastName: lastName,
			email: email
		};
		//sysmanagers
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			type: "POST",
			url: "/api/guests/add",
			data: JSON.stringify(guest),
			dataType: "json",
			success: function(newGuest) {
				$("#successModal").modal("show");
			},
			error: function(jqXHR) {
				$("#divErrorText1").text("User with this username or email already exists!");
				$("#divError1").show("fade");
			}
		});
	});
});
