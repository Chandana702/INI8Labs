package com.ini8labs.contoller;

import java.io.IOException;

import com.ini8labs.model.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteUser")

public class DeleteUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("id");
		int id = Integer.parseInt(uid);
		boolean b = UserDAO.deleteUser(id);
		if(b) {
			req.setAttribute("status", "User Deleted Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("status", "Failed to Delete the User");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, resp);
		}
	}
}
