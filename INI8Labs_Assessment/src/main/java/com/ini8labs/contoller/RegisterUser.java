package com.ini8labs.contoller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.ini8labs.model.UserDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/RegisterUser")

public class RegisterUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Fetching values from View(JSP)
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phone");
		String d = req.getParameter("dob");
		String gender = req.getParameter("gender");
		
		//Converting phone number to long
		long phone = Long.parseLong(phno);
		
		String status = UserDAO.registerUser(name, email, phone, d, gender);
		if (status.equals("existed")) {

            req.setAttribute("status", "This email or phone number exists");
            RequestDispatcher rd1 = req.getRequestDispatcher("Home.jsp");
            rd1.forward(req, resp);

        } else if (status.equals("success")) {
            req.setAttribute("status", "Successfully Registered");
            RequestDispatcher rd1 = req.getRequestDispatcher("Home.jsp");
            rd1.forward(req, resp);

        } else if (status.equals("failure")) {
            req.setAttribute("status", "Registration failed");
            RequestDispatcher rd1 = req.getRequestDispatcher("Home.jsp");
            rd1.forward(req, resp);

        }
	}
}
