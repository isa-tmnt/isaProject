$(document).ready(function() {
	
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
			url: "/api/guests/" + username,
			dataType: "json",
			success: function(guest) {
				$("#profile").append(span + " " + username);
				$("#txtId").text(guest.id);
				$("#txtFirstName").text(guest.firstName);
				$("#txtLastName").text(guest.lastName);
				$("#txtEmail").text(guest.email);
				$("#txtUsername").text(guest.username);
				$("#txtPassword").text(guest.password);
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
	
	//Edit Guest
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
		
		var guest = {
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
			url: "/api/guests/" + id,
			data: JSON.stringify(guest),
			dataType: "json",
			success: function(guest) {
				sessionStorage.setItem("basicAuth", btoa(username + ':' + password));
				alert("User updated!");
				window.location.href = "mainGuestPage.html";
			},
			error: function() {
				alert("Error: User with this username or email already exists!");
			}
		});
	});
	
	//List of Restaurants
	$("#home").ready(function() {
		var t = $('#exampleH').DataTable();
		
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
					t.row.add( [
			            restaurant.id,
			            restaurant.name,
			            restaurant.typeDescription,
			            "<a href=\"#menu5\" data-id=\"" + restaurant.id + "\" data-toggle=\"tab\" class=\"reserve btn btn-primary btn-sm\" role=\"button\">Reservation</a>"
			            /*"<td><button data-id=\"" + restaurant.id + "\" type=\"button\" class=\"reserve btn btn-primary btn-sm\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Reservation\">Reservation</button></td>"*/
			        ] ).draw( false );
				});
			}
		});
	});
	
	//Get data for reservation
	$("#exampleH").delegate(".reserve", "click", function() {
		var restaurantId = $(this).attr("data-id");
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/restaurants/get/" + restaurantId,
			dataType: "json",
			success: function(restaurant) {
				$("#restId5").val(restaurant.id);
				$("#restaurant5").val(restaurant.name);
			}
		});
	});
	
	$("#linkClose6").on("click", function() {
		$("#divError6").hide("fade");
	});
	
	//Add Reservation
	$("#next5").on("click", function() {
		var restaurantId = $("#restId5").val();
		var guestId = $("#txtId").text();
		var date = $("#date5").val();
		var duration = document.getElementById("duration5").value;
		//var dateTime = date.split("T");
		//alert(dateTime[0] + " " + dateTime[1] + ":00");
		
		if(date === "") {
			$("#divErrorText6").text("Date and Time field can't be empty!");
			$("#divError6").show("fade");
			return false;
		} else if(duration == 0) {
			$("#divErrorText6").text("Duration field can't be empty!");
			$("#divError6").show("fade");
			return false;
		}
		
		var reservation = {
			restaurantId: restaurantId,
			guestId: guestId,
			reservationDate: date + ":00",
			duration: duration
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "POST",
			url: "/api/reservations",
			data: JSON.stringify(reservation),
			dataType: "json",
			success: function(reservation) {
				$("#reserId6").val(reservation.id);
				$("#restId6").val(reservation.restaurantId);
				$("#restaurant6").text($("#restaurant5").val());
				$("#date6").text(new Date(reservation.reservationDate).toUTCString());
				$("#duration6").text(reservation.duration);
				alert("Reservation made!");
			}
		});
	});
	
	//List of friends to add to reservation
	$("#menu6").ready(function() {
		var $table6 = $("#table6");
		var friend6Template = $("#friend6-template").html();
		var s = String($("#txtId").text());
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/friends",
			dataType: "json",
			success: function(friendships) {
				$.each(friendships, function(i, friendship) {
					if(friendship.currentGuestId == $("#txtId").text()) {
						$.ajax({
							headers: { 
						        'Accept': 'application/json',
						        'Content-Type': 'application/json',
						        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
						    },
							type: "GET",
							url: "/api/guests/get/" + String(friendship.friendId),
							dataType: "json",
							success: function(guest) {
								$table6.append(Mustache.render(friend6Template, guest));
							}
						});
					}
				});
			}
		});
	});
	
	// /api/reservationfriends
	//Add friends to reservation 
	$("#table6").delegate(".add6", "click", function() {
		var reservationId = $("#reserId6").val();
		var friendId = $(this).attr("data-id");
		
		var reservationFriends = {
			reservationId: reservationId,
			friendId: friendId
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "POST",
			url: "/api/reservationfriends",
			data: JSON.stringify(reservationFriends),
			dataType: "json",
			success: function(reservationFriends) {
				alert("Add friend to reservation!");
			},
			error: function(jqXHR) {
				alert("This user is already added in this reservation!");
			}
		});
	});
	
	//Add friends to restaurant reservations
	$("#next6").on("click", function() {
		$("#reserId7").val($("#reserId6").val());
		$("#restId7").val($("#restId6").val());
		$("#restaurant7").text($("#restaurant6").text());
		$("#date7").text($("#date6").text());
		$("#duration7").text($("#duration6").text());
		
		var arrayOfFriends = [];
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/reservationfriends",
			dataType: "json",
			success: function(reservationFriends) {
				$.each(reservationFriends, function(i, resFriend) {
					if(resFriend.reservationId == $("#reserId7").val()) {
						$.ajax({
							headers: { 
						        'Accept': 'application/json',
						        'Content-Type': 'application/json',
						        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
						    },
							type: "GET",
							url: "/api/guests",
							dataType: "json",
							success: function(guests) {
								$.each(guests, function(j, guest) {
									if(resFriend.friendId == guest.id) {
										arrayOfFriends.push(guest.firstName + " " + guest.lastName);
									}
								});
								$("#friends7").text(arrayOfFriends);
							}
						});
					}
				});
			}
		});
	});
	
	function cancelReservation(s) {
		if(s === "menu6") {
			var reservationId = $("#reserId6").val();
		} else if(s === "menu7") {
			var reservationId = $("#reserId7").val();
		}
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "DELETE",
			url: "/api/reservationfriends/" + reservationId,
			dataType: "json",
			success: function() {},
			error: function() {
				$.ajax({
					headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json',
				        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
				    },
					type: "DELETE",
					url: "/api/reservations/" + reservationId,
					dataType: "json",
					success: function() {},
					error: function() {
						window.location.href = "mainGuestPage.html";
					}
				});
			}
		});
	}
	
	//Cancel Reservation in menu6
	$("#back6").on("click", function() {
		cancelReservation("menu6");
	});
	
	//Cancel Reservation in menu7
	$("#cancel7").on("click", function() {
		cancelReservation("menu7");
	});
	
	//List of guests
	function listOfGuests() {
		var decodedUser = atob(sessionStorage.getItem("basicAuth"));
		var userData = decodedUser.split(":");
		var username = userData[0];
		var password = userData[1];
		
		var $table1 = $("#table1");
		var guestTemplate = $("#guest-template").html();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/guests",
			dataType: "json",
			success: function(guests) {
				$.each(guests, function(i, guest) {
					if(guest.username !== username) {
						$table1.append(Mustache.render(guestTemplate, guest));
					}
				});
				$("#example").DataTable();
			}
		});
	}
	
	listOfGuests();
	
	//Add friend to list of pending friend requests 
	$("#table1").delegate(".add1", "click", function() {
		
		var pendingFriendship = {
			currentGuestId: $("#txtId").text(),
			penFriendId: $(this).attr("data-id")
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "POST",
			url: "/api/pendingfriends",
			data: JSON.stringify(pendingFriendship),
			dataType: "json",
			success: function(pendingFriendship2) {
				alert("Friend request sent!");
				window.location.href = "mainGuestPage.html";
			},
			error: function() {
				alert("This user is already your friend or you already sent him your friend request!");
			}
		});
	});
	
	//List of Friends
	function listOfFriends() {
		var $table2 = $("#table2");
		var friendTemplate = $("#friend-template").html();
		var s = String($("#txtId").text());
		
		var t = $('#example2').DataTable();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/friends",
			dataType: "json",
			success: function(friendships) {
				$.each(friendships, function(i, friendship) {
					if(friendship.currentGuestId == $("#txtId").text()) {
						$.ajax({
							headers: { 
						        'Accept': 'application/json',
						        'Content-Type': 'application/json',
						        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
						    },
							type: "GET",
							url: "/api/guests/get/" + String(friendship.friendId),
							dataType: "json",
							success: function(guest) {
								//$table2.append("<tr><td>" + friendship.id + "</td>" + Mustache.render(friendTemplate, guest) + "<td><button data-id=\"" + friendship.id + "\" type=\"button\" class=\"delete2 btn btn-danger btn-sm\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Delete Friend\">&times;</button></td>" + "</tr>");
								t.row.add( [
						            friendship.id,
						            guest.id,
						            guest.firstName,
						            guest.lastName,
						            guest.username,
						            "<td><button data-id=\"" + friendship.id + "\" type=\"button\" class=\"delete2 btn btn-danger btn-sm\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Delete Friend\">&times;</button></td>"
						        ] ).draw( false );
							}
						});
					}
				});
			}
		});
	}
	
	listOfFriends();
	
	//Delete Friend from list of friends
	$("#example2").delegate(".delete2", "click", function() {
		var $tr = $(this).closest("tr");
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "DELETE",
			url: "/api/friends/" + $(this).attr("data-id"),
			dataType: "json",
			success: function() {
				
			},
			error: function() {
				$tr.fadeOut(300, function() {
					$(this).remove();
				});
			}
		});
	});
	
	//List of Received Friends
	function listOfReceivedFriends() {
		var decodedUser = atob(sessionStorage.getItem("basicAuth"));
		var userData = decodedUser.split(":");
		var username = userData[0];
		var password = userData[1];
		
		var $table3 = $("#table3");
		var resfriendTemplate = $("#resfriend-template").html();
		var resfriend1Template = $("#resfriend1-template").html();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/pendingfriends",
			dataType: "json",
			success: function(pendingfriends) {
				$.each(pendingfriends, function(i, pendingfriend) {
					if(pendingfriend.penFriendId == $("#txtId").text()) {
						$.ajax({
							headers: { 
						        'Accept': 'application/json',
						        'Content-Type': 'application/json',
						        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
						    },
							type: "GET",
							url: "/api/guests/get/" + String(pendingfriend.currentGuestId),
							dataType: "json",
							success: function(guest) {
								$table3.append("<tr><td>" + pendingfriend.id + "</td>" + Mustache.render(resfriendTemplate, guest) + Mustache.render(resfriend1Template, pendingfriend) + "</tr>");
							}
						});
					}
				});
			}
		});
	}
	
	$("#menu3").ready(function() {
		listOfReceivedFriends();
	});
	
	//Add friend from list of received friends to list of friends
	$("#table3").delegate(".accept3", "click", function() {
		var $tr = $(this).closest("tr");
		var s = $(this).attr("data-id");
		
		var friendship = {
			currentGuestId: $("#txtId").text(),
			friendId: $tr.find("td.id3").html()
		};
		
		var friendship1 = {
			currentGuestId: $tr.find("td.id3").html(),
			friendId: $("#txtId").text()
		};
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "POST",
			url: "/api/friends",
			data: JSON.stringify(friendship),
			dataType: "json",
			success: function(friendship2) {
				$.ajax({
					headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json',
				        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
				    },
					type: "POST",
					url: "/api/friends",
					data: JSON.stringify(friendship1),
					dataType: "json",
					success: function(friendship3) {
						$.ajax({
							headers: { 
						        'Accept': 'application/json',
						        'Content-Type': 'application/json',
						        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
						    },
							type: "DELETE",
							url: "/api/pendingfriends/" + s,
							dataType: "json",
							success: function() {
								
							},
							error: function() {
								$tr.fadeOut(300, function() {
									$(this).remove();
								});
							}
						});
					},
					error: function() {
						alert("error1!");
					}
				});
			},
			error: function() {
				alert("error!");
			}
		});
	});
	
	//Decline friend request
	$("#table3").delegate(".decline3", "click", function() {
		var $tr = $(this).closest("tr");
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "DELETE",
			url: "/api/pendingfriends/" + $(this).attr("data-id"),
			dataType: "json",
			success: function() {
				
			},
			error: function() {
				$tr.fadeOut(300, function() {
					$(this).remove();
				});
			}
		});
	});
	
	//List of sent friend requests
	function listOfSentFriends() {
		var decodedUser = atob(sessionStorage.getItem("basicAuth"));
		var userData = decodedUser.split(":");
		var username = userData[0];
		var password = userData[1];
		
		var $table4 = $("#table4");
		var sentfriendTemplate = $("#sentfriend-template").html();
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "GET",
			url: "/api/pendingfriends",
			dataType: "json",
			success: function(pendingfriends) {
				$.each(pendingfriends, function(i, pendingfriend) {
					if(pendingfriend.currentGuestId == $("#txtId").text()) {
						$.ajax({
							headers: { 
						        'Accept': 'application/json',
						        'Content-Type': 'application/json',
						        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
						    },
							type: "GET",
							url: "/api/guests/get/" + String(pendingfriend.penFriendId),
							dataType: "json",
							success: function(guest) {
								$table4.append("<tr><td>" + pendingfriend.id + "</td>" + Mustache.render(sentfriendTemplate, guest) + "<td><button data-id=\"" + pendingfriend.id + "\" type=\"button\" class=\"cancel4 btn btn-danger btn-sm\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Cancel Friend Request\">Cancel</button></td>" + "</tr>");
							}
						});
					}
				});
			}
		});
	}
	
	listOfSentFriends();
	
	$("#table4").delegate(".cancel4", "click", function() {
		var $tr = $(this).closest("tr");
		
		$.ajax({
			headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json',
		        'Authorization': 'Basic ' + sessionStorage.getItem('basicAuth') 
		    },
			type: "DELETE",
			url: "/api/pendingfriends/" + $(this).attr("data-id"),
			dataType: "json",
			success: function() {
				
			}, 
			error: function() {
				$tr.fadeOut(300, function() {
					$(this).remove();
				});
			}
		});
	});
});