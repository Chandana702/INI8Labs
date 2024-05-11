package com.ini8labs.contoller;

import java.io.IOException;

import com.ini8labs.model.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Edit")

public class Edit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Fetching values from View(JSP)
		String user_id = req.getParameter("id");
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				String phno = req.getParameter("phone");
				String d = req.getParameter("dob");
				String gender = req.getParameter("gender");
				
				//Converting user_id to int
				int id = Integer.parseInt(user_id);
				
				//Converting phone number to long
				long phone = Long.parseLong(phno);
				
				Boolean b = UserDAO.editUser(id, name, email, phone, d, gender);
				if (b) {
		            req.setAttribute("status", "User Information edited successfully");
		            RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		            rd.forward(req, resp);

		        } else {
		            req.setAttribute("status", "Failed to edit the user information");
		            RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		            rd.forward(req, resp);

		        }
	}
}
