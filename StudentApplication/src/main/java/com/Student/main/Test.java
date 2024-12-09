package com.Student.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.Student.dao.StudentDAO;
import com.Student.dao.StudentDAOImplementation;
import com.Student.dto.Student;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s = new Student();
		StudentDAO sdao = new StudentDAOImplementation();
		
		int choice = 0;
		do{
			System.out.println("<=========Welcome to Student Database=============>");
			System.out.println("1.Student SignUp");
			System.out.println("2.Get Entire Student Data");
			System.out.println("3.Student login");
			System.out.println("4.Update Student data");
			System.out.println("5.Delete Student Data");
			System.out.println("6.Exit Application");	
		
			System.out.println("Enter your Choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			
	//========================TO INSERT STUDENT DATA===============================
			case 1 : System.out.println("Enter the name of the Student : ");
				     s.setName(sc.next());
					 System.out.println("enter the phone number of the student: ");
					 s.setPhone(sc.nextLong());
					 System.out.println("enter the mailid of the student: ");
				     s.setMailid(sc.next());
				     System.out.println("enter the branch of the student: ");
				     s.setBranch(sc.next());
				     System.out.println("enter the location of the student: ");
				     s.setLocation(sc.next());
				     System.out.println("set a password: ");
				     String password = sc.next();
				     System.out.println("confirm the password:");
				     String confirmPwd = sc.next();
				    
				     if(password.equals(confirmPwd)) {
				    	s.setPassword(password);
				    	boolean result1 = sdao.insertStudent(s);
				    	
				    	if(result1) {
				    		System.out.println("data added successfully");
				    	}
				    	else {
				    		System.out.println("Failed to add the data");
				    	}
				     }
				     break;
			
	//===========================TO GET THE ENTIRE STUDENT DATA=====================
			case 2 :  List<Student> stds = sdao.getStudent();
					  Iterator<Student> itr = stds.iterator();
					  while(itr.hasNext()) {
					  s = itr.next();
					  System.out.println(s);
	                  }
					  break;
		
	//==============TO GET THE SINGLE STUDENT DATA BASED ON EMAIL AND PASS==========
			case 3 :  System.out.println("enter the mailid of the student :");
					  s.setMailid(sc.next());
					  System.out.println("enter the password : ");
					  s.setPassword(sc.next());
			 
					  s=sdao.getStudent(s.getMailid(), s.getPassword());
					  System.out.println(s);   
					  break;
			
	//======================TO UPDATE PHONE NUMBER BASED ON ID=========================
			case 4 : System.out.println("Enter the id of the student you want to update : ");
					 s.setId(sc.nextInt());
					 System.out.println("Enter the new phone number : ");
					 s.setPhone(sc.nextLong());
					
				     boolean result = sdao.updateStudent(s);
				    
				     if(result) {
				    	System.out.println("Phone number updated successfully!!");
				     }
				     else {
				    	System.out.println("Update Failed!");
				     }
				     break;
			
	//==========================TO DELETE A STUDENT DATA BASED ON ID========================
			case 5 :  System.out.println("enter the id of the student whose record is to be deleted : ");
	                  s.setId(sc.nextInt());
	      
	                  boolean result2 = sdao.deleteStudent(s);
	                  if(result2) {
	    	          System.out.println("data deleted successfully");
	                  }
	                  else {
	                	  System.out.println("Invalid Student Id");
	                  }
	                  break;
	                  
	        case 6 :  System.out.println("Thank You");
	        		  System.exit(0);
	                  break;
	        		  
	         default : System.out.println("Invalid Choice!!");
	         		   break; 
		   }
		}
		while(choice!=6);
	 }
}
