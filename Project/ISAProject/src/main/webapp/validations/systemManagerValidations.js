$(document).ready(function() {
	//$("#example").DataTable();
	
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
			url: "/api/sysmanagers/" + username,
			dataType: "json",
			success: function(sysmanager) {
				$("#profile").append(span + " " + username);
				$("#txtId").text(sysmanager.id);
				$("#txtFirstName").text(sysmanager.firstName);
				$("#txtLastName").text(sysmanager.lastName);
				$("#txtEmail").text(sysmanager.email);
				$("#txtUsername").text(sysmanager.username);
				$("#txtPassword").text(sysmanager.password);
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
	
	//Edit SystemManager
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
		
		var sysmanager = {
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
			url: "/api/sysmanagers/" + id,
			data: JSON.stringify(sysmanager),
			dataType: "json",
			success: function(sysmanager) {
				sessionStorage.setItem("basicAuth", btoa(username + ':' + password));
				alert("User updated!");
				window.location.href = "systemManagerPage.html";
			},
			error: function() {
				alert("Error: User with this username or email already exists!");
			}
		});
	});
	
	//Add Restaurant Manager
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
		$("#rpwerror").hide();
		
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
		        'Content-Type': 'application/json' 
		    },
			type: "POST",
			url: "/api/resmanagers",
			data: JSON.stringify(resmanager),
			dataType: "json",
			success: function(newResmanager) {
				$("#successModal").modal("show");
			},
			error: function(jqXHR) {
				$("#divErrorText1").text("User with this username or email already exists!");
				$("#divError1").show("fade");
			}
		});
	});
	
	//List of Restaurant Managers
	$("#menu2").ready(function() {
		var $table2 = $("#table2");
		var resmanagerTemplate = $("#resmanager-template").html();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/resmanagers",
			dataType: "json",
			success: function(resmanagers) {
				$.each(resmanagers, function(i, resmanager) {
					$table2.append(Mustache.render(resmanagerTemplate, resmanager));
				});
			}
		});
	});
	
	$("#linkClose1").on("click", function() {
		$("#divError1").hide("fade");
	});
	
	$("#closeModal").on("click", function() {
		window.location.href = "systemManagerPage.html";
	});
	
	$("#closeModal1").on("click", function() {
		window.location.href = "systemManagerPage.html";
	});
	
	//Add Restaurant
	$("#addrest").on("click", function() {
		alert("nesto si pogresno napisao");
		var name = $("#name").val();
		var type = $("#type").val();
		
		if(name === "" && type === "") {
			$("#naerror").text("Name field can't be empty");
			$("#tyerror").text("Type of restaurant field can't be empty");
			$("#naerror").show();
			$("#tyerror").show();
			return false;
		} else if(name === "") {
			$("#naerror").text("Name field can't be empty");
			$("#naerror").show();
			$("#tyerror").hide();
			return false;
		} else if(type === "") {
			$("#tyerror").text("Type of restaurant field can't be empty");
			$("#naerror").hide();
			$("#tyerror").show();
			return false;
		}
		
		var restaurant = {
			name: name,
			typeDescription: type
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "POST",
			url: "/api/restaurants",
			data: JSON.stringify(restaurant),
			dataType: "json",
			success: function(restaurant) {
				alert("Restaurant added!");
				window.location.href = "systemManagerPage.html";
			}
		});
	});
	
	//List of Restaurants
	$("#menu4").ready(function() {
		var $table4 = $("#table4");
		var restaurantTemplate = $("#restaurant-template").html();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/restaurants",
			dataType: "json",
			success: function(restaurants) {
				$.each(restaurants, function(i, restaurant) {
					$table4.append(Mustache.render(restaurantTemplate, restaurant));
				});
			}
		});
	});
	
	//Add System Manager
	$("#register5").on("click", function() {
		var firstName = $("#firstname5").val();
		var lastName = $("#lastname5").val();
		var username = $("#username5").val();
		var email = $("#email5").val();
		var password = $("#password5").val();
		var rpassword = $("#rpassword5").val();
		
		if(firstName === "" && lastName === "" && username === "" && email === "" && password === "" && rpassword === "") {
			$("#fnerror5").text("First Name can't be empty!");
			$("#lnerror5").text("Last Name can't be empty!");
			$("#unerror5").text("Username can't be empty!");
			$("#eaerror5").text("Email can't be empty!");
			$("#pwerror5").text("Password can't be empty!");
			$("#rpwerror5").text("Confirm Password can't be empty!");
			$("#fnerror5").show();
			$("#lnerror5").show();
			$("#unerror5").show();
			$("#eaerror5").show();
			$("#pwerror5").show();
			$("#rpwerror5").show();
			return false;
		} else if(firstName === "") {
			$("#fnerror5").text("First Name can't be empty!");
			$("#fnerror5").show();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").hide();
			return false;
		} else if(lastName === "") {
			$("#lnerror5").text("Last Name can't be empty!");
			$("#fnerror5").hide();
			$("#lnerror5").show();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").hide();
			return false;
		} else if(username === "") {
			$("#unerror5").text("Username can't be empty!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").show();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").hide();
			return false;
		} else if(username != "" && username.match(/^[a-z0-9_-]{3,16}$/i) == null) {
			$("#unerror5").text("Username need's to be created from 3 or more characters!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").show();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").hide();
			return false;
		} else if(email === "") {
			$("#eaerror5").text("Email can't be empty!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").show();
			$("#pwerror5").hide();
			$("#rpwerror5").hide();
			return false;
		} else if(email != "" && email.match(/^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,4}$/i) == null) {
			$("#eaerror5").text("Email example - example@gmail.com");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").show();
			$("#pwerror5").hide();
			$("#rpwerror5").hide();
			return false;
		} else if(password === "") {
			$("#pwerror5").text("Password can't be empty!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").show();
			$("#rpwerror5").hide();
			return false;
		} else if(password != "" && password.match(/^[a-z0-9_-]{8,18}$/) == null) {
			$("#pwerror5").text("Password need's to have at least 8 characters!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").show();
			$("#rpwerror5").hide();
			return false;
		} else if(rpassword === "") {
			$("#pwerror5").text("Confirm Password can't be empty!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").show();
			return false;
		} else if(rpassword != "" && rpassword.match(/^[a-z0-9_-]{8,18}$/) == null) {
			$("#rpwerror5").text("Password need's to have at least 8 characters!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").show();
			return false;
		} else if(password !== rpassword) {
			$("#rpwerror5").text("These to password's are not equale!");
			$("#fnerror5").hide();
			$("#lnerror5").hide();
			$("#unerror5").hide();
			$("#eaerror5").hide();
			$("#pwerror5").hide();
			$("#rpwerror5").show();
			return false;
		}
		
		$("#fnerror5").hide();
		$("#lnerror5").hide();
		$("#unerror5").hide();
		$("#eaerror5").hide();
		$("#pwerror5").hide();
		$("#rpwerror5").hide();
		
		var sysmanager = {
			username: username,
			password: password,
			firstName: firstName,
			lastName: lastName,
			email: email,
			boss: false
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
			type: "POST",
			url: "/api/sysmanagers",
			data: JSON.stringify(sysmanager),
			dataType: "json",
			success: function(newSysmanager) {
				$("#successModal").modal("show");
			},
			error: function(jqXHR) {
				$("#divErrorText5").text("User with this username or email already exists!");
				$("#divError5").show("fade");
			}
		});
	});
	
	$("#linkClose5").on("click", function() {
		$("#divError5").hide("fade");
	});
	
	//List of System Managers
	$("#menu6").ready(function() {
		var decodedUser = atob(sessionStorage.getItem("basicAuth"));
		var userData = decodedUser.split(":");
		var username = userData[0];
		var password = userData[1];
		
		var $table6 = $("#table6");
		var sysmanagerTemplate = $("#sysmanager-template").html();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/sysmanagers",
			dataType: "json",
			success: function(sysmanagers) {
				$.each(sysmanagers, function(i, sysmanager) {
					if(sysmanager.username !== username) {
						$table6.append(Mustache.render(sysmanagerTemplate, sysmanager));
					}
				});
			}
		});
	});
});