<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ini8labs.model.User"%>
<%@page import="com.ini8labs.model.UserDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INI8 LABS</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<table class="content-table">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL ID</th>
				<th>PHONE NUMBER</th>
				<th>DATE OF BIRTH</th>
				<th>GENDER</th>
				<th>EDIT USER</th>
				<th>DELETE USER</th>
			</tr>
		</thead>
		<tbody>
		<% ArrayList<User> mydata = UserDAO.getUserinfo();
   Iterator<User> itr = mydata.iterator();
   while (itr.hasNext()) {
   User u = itr.next();
   int id = u.getId();
 %>
			<tr>
				<td><%=u.getId() %></td>
				<td><%=u.getName() %></td>
				<td><%=u.getEmail() %></td>
				<td><%=u.getPhone() %></td>
				<td><%=u.getDate() %></td>
				<td><%=u.getGender() %></td>
				<td><button class="edit">
						<a href="EditUser.jsp?id=<%=id%>">Edit</a>
					</button></td>
				<td><button class="delete">
						<a href="DeleteUser?id=<%=id%>">Delete</a>
					</button></td>
			</tr>
			<%} %>
			<tr>
			<td colspan="6"><button class="show-button"><a href="Home.jsp">Home</a></button></td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>