function onLoad() {
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpass").keyup(checkPasswordsMatch);	
	$("#details").submit(canSubmit);
}

function canSubmit() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();	

	if (password != confirmpass) {
		alert("Passwords do not match.");
		return false;
	}
	
	return true;
}

function checkPasswordsMatch() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();	
	
	if (password.length > 3 || confirmpass.length > 3) {
		if (password == confirmpass) {
			$("#matchpass").css("color", "#00ff00");
			$("#matchpass").text("Passwords match.");
			$("#matchpass").addClass("valid");
			$("#matchpass").removeClass("error");
		} else {
			$("#matchpass").css("color", "#ff0000");
			$("#matchpass").text("Passwords do not match.");		
			$("#matchpass").addClass("erorr");
			$("#matchpass").removeClass("valid");
		}
	}	
}

function success(data) {
	// Show the correct heading when searching
	$("#nosearchresults").hide();
	$("#searchresultstitle").show();
	$("#searchresult").show();
	// Don't show what was there
	$("#nosearchresultstitle").hide();
}

function error(data) {
	alert("Error: " + data.responseText);
}

