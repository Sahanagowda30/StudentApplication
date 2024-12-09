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
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet{
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        //collect data from user
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		
		
		//JDBC logic
		StudentDAO sdao = new StudentDAOImplementation();
		Student s = sdao.getStudent(mail, password);
		PrintWriter out =  resp.getWriter();
		
		
//		=====used to write the content ont the web browser=======
//		if(s!=null)
//		{
//			out.println("<h1> Login Successfull, Welcome " +s.getName()+ "</h1>"
//					+ "<br>" 
//				    + "<a href=\"login.html\">Back</a>");
//		}
//		else {
//			out.println("<h1>Invalid Mail or Password</h1>"
//					+ "<br>"
//					+ "<a href=\"login.html\">Back</a>");
//		}
		
		
//		========to redirect the from one page to another======
		if(s!=null) {
//		    resp.sendRedirect("success.html");
            //this method is used to redirect the servlet to the next page or next resource
		    //the next resource can be either html, jsp or another servlet
		    //syntax : pulbic void resp.sendRedirect("url/next_resource");
		    //drawback : does not take the data to next oage
		    //can happen from post to get and get to get only
			
			
			
//			=======use jsp and reuqest dispatcher for dynamic response============
			
//			req.setAttribute("student",s);
//			RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
//			rd.forward(req, resp);
			
//			===================using session=======================================
			//session object-can use the data anywhere in the project wherever we call the session object
			
			HttpSession hs = req.getSession();
			hs.setAttribute("student", s);
			
			if(s.getId()==1) {
				RequestDispatcher rd = req.getRequestDispatcher("admindash.jsp");
				rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
				rd.forward(req, resp);
			}
			
			
		}
		else {
//			resp.sendRedirect("Failure.html");
			
			req.setAttribute("failure","Login Failed");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	
	}
}
