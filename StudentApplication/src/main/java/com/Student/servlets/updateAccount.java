package com.Student.servlets;

import java.io.IOException;

import com.Student.dao.StudentDAO;
import com.Student.dao.StudentDAOImplementation;
import com.Student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateAccount")
public class updateAccount extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 
	 StudentDAO sdao = new StudentDAOImplementation();
	 
	 //collect data from user
	 String name = req.getParameter("name");
	 String phonenumber = req.getParameter("phone");
	 Long phone = Long.parseLong(phonenumber);
	 String mail= req.getParameter("mail");
	 String location = req.getParameter("location");
	 String branch = req.getParameter("branch");
	 
	 //to not create new session objects pass false
	 HttpSession session = req.getSession(false);
	 Student s = (Student)session.getAttribute("student");
	 
	 if(s!=null) {
		 s.setName(name);
		 s.setBranch(branch);
		 s.setLocation(location);
		 s.setMailid(mail);
		 s.setPhone(phone);
		 
		 boolean result = sdao.updateStudent(s);
		 
		 if(result){
			 req.setAttribute("success", "Update Successfull");
			 RequestDispatcher rd = req.getRequestDispatcher("updateAccount.jsp");
			 rd.forward(req, resp);
		 } 
		 else {
			 req.setAttribute("failure", "Update Failed");
			 RequestDispatcher rd = req.getRequestDispatcher("updateAccount.jsp");
			 rd.forward(req, resp);
		 }
	 }
	 
  }
}
