<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.ini8labs.model.User"%>
<%@page import="com.ini8labs.model.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="style.css" rel="stylesheet">
<title>INI8 LABS</title>
</head>
<body>
<% if (request.getParameter("id") != null) {
   int id = Integer.parseInt(request.getParameter("id"));
   System.out.println(id);
   User u = UserDAO.getUserinfo(id);
   if(u != null){%>
	<section class="container">
		<header>Edit User Form</header>
		<form action="Edit" method="post" class="form">
			<input type="text" name="id" value="<%=id %>" hidden="hidden">
			<div class="input-box">
				<label>Full Name</label> <input type="text"
					placeholder="Enter full name" name="name" required="required" value="<%=u.getName() %>">
			</div>
			<div class="input-box">
				<label>Email Address</label> <input type="email"
					placeholder="Enter email address" name="email" required="required" value="<%=u.getEmail() %>">
			</div>
			<div class="input-box">
				<label>Phone Number</label> <input type="number"
					placeholder="Enter phone number" name="phone" required="required" maxlength="10" minlength="10" value="<%=u.getPhone() %>">
			</div>
			<div class="input-box">
				<label>Date of Birth</label> <input type="date"
					placeholder="Enter birth date" name="dob" id="dob" max="" required="required" value="<%=u.getDate() %>">
			</div>
			<div class="gender-box">
				<h3>Gender</h3>
				<div class="gender-option">
				<%String gender = u.getGender(); %>
					<div class="gender">
						<input type="radio" id="check-male" value="Male" name="gender" required="required" <% if(gender.equals("Male")){%> checked="checked" <%} %>/> 
						<label for="check-male">Male</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-female" value="Female" name="gender" required="required" <% if(gender.equals("Female")){%> checked="checked" <%} %>/>
						<label for="check-female">Female</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-other" value="Others" name="gender" required="required" <% if(gender.equals("Others")){%> checked="checked" <%} %>/> 
						<label for="check-other">Others</label>
					</div>
				</div>
			</div>
			<input type="submit" value="Submit" class="button">
		</form>
		<button class="show-button"><a href="Home.jsp">Home</a></button>
	</section>
	<%}
   }%>
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