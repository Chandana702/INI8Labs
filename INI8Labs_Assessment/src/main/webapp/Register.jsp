<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="style.css" rel="stylesheet">
<title>INI8 LABS</title>
</head>
<body>
<div>
</div>
	<section class="container">
		<header>Registration Form</header>
		<form action="RegisterUser" method="post" class="form" id="myForm">
			<div class="input-box">
				<label>Full Name</label> <input type="text"
					placeholder="Enter full name" name="name" required="required">
			</div>
			<div class="input-box">
				<label>Email Address</label> <input type="email"
					placeholder="Enter email address" name="email" required="required">
			</div>
			<div class="input-box">
				<label>Phone Number</label> 
				<input type="text"
					placeholder="Enter phone number" name="phone" required="required" maxlength="10" minlength="10">
			</div>
			<div class="input-box">
				<label>Date of Birth</label> <input type="date"
					placeholder="Enter birth date" name="dob" id="dob" max="" required="required">
			</div>
			<div class="gender-box">
				<h3>Gender</h3>
				<div class="gender-option">
					<div class="gender">
						<input type="radio" id="check-male" value="Male" name="gender" required="required"> 
						<label for="check-male">Male</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-female" value="Female" name="gender" required="required">
						<label for="check-female">Female</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-other" value="Others" name="gender" required="required"> 
						<label for="check-other">Others</label>
					</div>
				</div>
			</div>
			<input type="submit" value="Submit" class="button">
		</form>
		<button class="show-button"><a href="Home.jsp">Home</a></button>
	</section>
	<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		  var today = new Date().toISOString().split('T')[0];
		  document.getElementById("dob").setAttribute("max", today);
		  
		  document.getElementById("myForm").addEventListener("submit", function(event) {
		    	    
		  });
		});

	</script>
</body>
</html>