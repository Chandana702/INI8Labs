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
<header class="header">
	<div class="box">
		<h1 class="heading">
			<span class="heading-main">Welcome</span>
			<span class="heading-sub">Application demonstrating CRUD Operations</span>
		</h1>
		<%String status = (String)request.getAttribute("status"); %>
		<%if(status!=null){ %>
		<div class="message">
			<h2><%=status %></h2>
		</div>
		<%} %>
		<a href="Register.jsp" class="btn btn-white">Register User</a>
		<a href="ViewUsers.jsp" class="btn btn-white">View Users</a>
	</div>
</header>
</body>
</html>