$(function() {
	
	function userProfile() {
		var decodedUser = atob(sessionStorage.getItem("basicAuth"));
		var userData = decodedUser.split(":");
		var username = userData[0];
		var password = userData[1];
		
		var span = "<span class=\"glyphicon glyphicon-user\"></span>";
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth')
		    },
			type: "GET",
			url: "/api/resmanagers/" + username,
			dataType: "json",
			success: function(resmanager) {
				$("#profile").append(span + " " + username);
				$("#txtId").text(resmanager.id);
				$("#txtFirstName").text(resmanager.firstName);
				$("#txtLastName").text(resmanager.lastName);
				$("#txtEmail").text(resmanager.email);
				$("#txtUsername").text(resmanager.username);
				$("#txtPassword").text(resmanager.password);
			}, error: function(jqXHR) {
				
			}
		});
	}
	
	userProfile();
	
	$("#logout").on("click", function() {
		sessionStorage.removeItem("basicAuth");
	});
	
	$("#profile").on("click", function() {
		$("#myModal").modal("show");
	});
	
	$("#editModal").on("click", function() {
		myModal("edit")
	});
	
	function myModal(string) {
		if(string === "cancel") {
			$("#saveModal").addClass("edit");
			$("#cancelModal").addClass("edit");
			$("#txtId").removeClass("edit");
			$("#txtFirstName").removeClass("edit");
			$("#txtLastName").removeClass("edit");
			$("#txtEmail").removeClass("edit");
			$("#txtUsername").removeClass("edit");
			$("#txtPassword").removeClass("edit");
			$("#id0").addClass("edit");
			$("#firstname0").addClass("edit");
			$("#lastname0").addClass("edit");
			$("#username0").addClass("edit");
			$("#email0").addClass("edit");
			$("#password0").addClass("edit");
			$("#closeModal").removeClass("edit");
			$("#closeModal1").removeClass("edit");
			$("#editModal").removeClass("edit");
		} else if(string === "edit") {
			$("#saveModal").removeClass("edit");
			$("#cancelModal").removeClass("edit");
			$("#txtId").addClass("edit");
			$("#txtFirstName").addClass("edit");
			$("#txtLastName").addClass("edit");
			$("#txtEmail").addClass("edit");
			$("#txtUsername").addClass("edit");
			$("#txtPassword").addClass("edit");
			$("#id0").removeClass("edit");
			$("#firstname0").removeClass("edit");
			$("#lastname0").removeClass("edit");
			$("#username0").removeClass("edit");
			$("#email0").removeClass("edit");
			$("#password0").removeClass("edit");
			$("#closeModal").addClass("edit");
			$("#closeModal1").addClass("edit");
			$("#editModal").addClass("edit");
			
			$("#id0").val($("#txtId").text());
			$("#firstname0").val($("#txtFirstName").text());
			$("#lastname0").val($("#txtLastName").text());
			$("#username0").val($("#txtUsername").text());
			$("#email0").val($("#txtEmail").text());
			$("#password0").val($("#txtPassword").text());
		}
	}
	
	$("#cancelModal").on("click", function() {
		myModal("cancel");
	});
	
	//Edit RestaurantManager
	$("#saveModal").on("click", function() {
		var id = $("#id0").val();
		var firstName = $("#firstname0").val();
		var lastName = $("#lastname0").val();
		var username = $("#username0").val();
		var email = $("#email0").val();
		var password = $("#password0").val();
		
		if(firstName === "" && lastName === "" && username === "" && email === "" && password === "") {
			$("#fnerror0").text("First Name can't be empty!");
			$("#lnerror0").text("Last Name can't be empty!");
			$("#unerror0").text("Username can't be empty!");
			$("#eaerror0").text("Email can't be empty!");
			$("#pwerror0").text("Password can't be empty!");
			$("#fnerror0").show();
			$("#lnerror0").show();
			$("#unerror0").show();
			$("#eaerror0").show();
			$("#pwerror0").show();
			return false;
		} else if(firstName === "") {
			$("#fnerror0").text("First Name can't be empty!");
			$("#fnerror0").show();
			$("#lnerror0").hide();
			$("#unerror0").hide();
			$("#eaerror0").hide();
			$("#pwerror0").hide();
			return false;
		} else if(lastName === "") {
			$("#lnerror0").text("Last Name can't be empty!");
			$("#fnerror0").hide();
			$("#lnerror0").show();
			$("#unerror0").hide();
			$("#eaerror0").hide();
			$("#pwerror0").hide();
			return false;
		} else if(username === "") {
			$("#unerror0").text("Username can't be empty!");
			$("#fnerror0").hide();
			$("#lnerror0").hide();
			$("#unerror0").show();
			$("#eaerror0").hide();
			$("#pwerror0").hide();
			return false;
		} else if(username != "" && username.match(/^[a-z0-9_-]{3,16}$/i) == null) {
			$("#unerror0").text("Username need's to be created from 3 or more characters!");
			$("#fnerror0").hide();
			$("#lnerror0").hide();
			$("#unerror0").show();
			$("#eaerror0").hide();
			$("#pwerror0").hide();
			return false;
		} else if(email === "") {
			$("#eaerror0").text("Email can't be empty!");
			$("#fnerror0").hide();
			$("#lnerror0").hide();
			$("#unerror0").hide();
			$("#eaerror0").show();
			$("#pwerror0").hide();
			return false;
		} else if(email != "" && email.match(/^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,4}$/i) == null) {
			$("#eaerror0").text("Email example - example@gmail.com");
			$("#fnerror0").hide();
			$("#lnerror0").hide();
			$("#unerror0").hide();
			$("#eaerror0").show();
			$("#pwerror0").hide();
			return false;
		} else if(password === "") {
			$("#pwerror0").text("Password can't be empty!");
			$("#fnerror0").hide();
			$("#lnerror0").hide();
			$("#unerror0").hide();
			$("#eaerror0").hide();
			$("#pwerror0").show();
			return false;
		} else if(password != "" && password.match(/^[a-z0-9_-]{8,18}$/) == null) {
			$("#pwerror0").text("Password need's to have at least 8 characters!");
			$("#fnerror0").hide();
			$("#lnerror0").hide();
			$("#unerror0").hide();
			$("#eaerror0").hide();
			$("#pwerror0").show();
			return false;
		}
		
		$("#fnerror0").hide();
		$("#lnerror0").hide();
		$("#unerror0").hide();
		$("#eaerror0").hide();
		$("#pwerror0").hide();
		
		var resmanager = {
			username: username,
			password: password,
			firstName: firstName,
			lastName: lastName,
			email: email
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "PUT",
			url: "/api/resmanagers/" + id,
			data: JSON.stringify(resmanager),
			dataType: "json",
			success: function(resmanager) {
				sessionStorage.setItem("basicAuth", btoa(username + ':' + password));
				alert("User updated!");
				window.location.href = "restaurantManagerPage.html";
			},
			error: function() {
				alert("Error: User with this username or email already exists!");
			}
		});
	});
});