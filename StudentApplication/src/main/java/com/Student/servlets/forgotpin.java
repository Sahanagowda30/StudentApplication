package com.Student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.Student.dao.StudentDAO;
import com.Student.dao.StudentDAOImplementation;
import com.Student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgotpin")
public class forgotpin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//collect data from user
		String phonenumber = req.getParameter("phone");
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirm");
		
		//parse phone number
		long phone = Long.parseLong(phonenumber);
		
		//JDBC implementation
		StudentDAO sdao = new StudentDAOImplementation();
		PrintWriter out = resp.getWriter();
		Student s = sdao.getStudent(phone, mail);
		
		if(s!=null){
			if(password.trim().equals(confirm.trim())) {
				
			    s.setPassword(password);
			    
				boolean res = sdao.updateStudent(s);
				if(res) {
					//out.println("<h1>Password Changed Successfully </h1>");
					req.setAttribute("pwdchanged", s);
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
				else {
					//out.println("<h1>Password Update Failed</h1>");
					req.setAttribute("failure", s);
					RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				//out.println("<h1>Password Mismatch</h1>");
				req.setAttribute("mismatch","Password Mismatch");
				RequestDispatcher rd = req.getRequestDispatcher("forgotpin.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Invalid Phone Number or Mail Id</h1>");
			req.setAttribute("invalidData", "Invalid Phone Number or Mail Id");
			RequestDispatcher rd = req.getRequestDispatcher("forgotpin.jsp");
			rd.forward(req, resp);
		}
	}

}
