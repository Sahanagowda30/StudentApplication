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

@WebServlet("/signup")

public class signup extends HttpServlet {
	
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   Student s = new Student();
	   StudentDAO sdao = new StudentDAOImplementation();
	   PrintWriter out =  resp.getWriter();
	   
	   //Collect the data from the user
	   String uname = req.getParameter("username");
	   String phonenumber = req.getParameter("phone");
	   String mailid = req.getParameter("mail");
	   String branch = req.getParameter("branch");
	   String location = req.getParameter("location");
	   String pwd = req.getParameter("password");
	   String confirm = req.getParameter("confirm");
	   
	   
	   //parse phone to long
	   long phone = Long.parseLong(phonenumber);
	   
	   //JDBC implementation
	   if(pwd.equals(confirm)) {
		   
		   s.setName(uname);
		   s.setPhone(phone);
		   s.setMailid(mailid);
		   s.setBranch(branch);
		   s.setLocation(location);
		   s.setPassword(confirm);
		   
		   boolean res = sdao.insertStudent(s);
		   if(res) {
			   //just using printWriter
			   //out.println("<h1>Data Added Succesfully</h1>");
			   //out.println("<h1>Data added successfully. Your Student ID is " +s.getId()+ "</h1>");
			   
//			   ======using requestdispatcher==========
			   //1.set the attribute to wrap the data to send it to next resource
			   req.setAttribute("success", "SignUp Succesfull");
			   //2.ref of request dispatcher which takes next resource/url
			   RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			   //signup.jsp bcoz the msg is to be dislayed on signup.jsp itself
			   rd.forward(req, resp);
		   }
		   else {
			 //just using printWriter
			 //out.println("<h1>Could not add the data</h1>");
			   
			   req.setAttribute("failure", "Signup Failed");
			   RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			   rd.forward(req, resp);
		   }
	   }
   }
  
  
}
