<%@page import="java.util.ListIterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.Student.dto.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>view users</title>
    <style>
       * {
    margin: 0px;
    padding: 0px;
}
body {
    background-color: #f4f4f4;
    height: 100vh;
}
h2{
    margin: 30px;
}
table {
    border-collapse: collapse;
    width: 100%;
    margin: 20px;
}
th, td {
    border: 1px solid #ddd;
    text-align: left;
    padding: 10px;
}
th {
    background-color: #f4f4f4;
}
       
    </style>
</head>
<body>
    <div class="tables">
        <h2 style="text-align: center;">USER DETAILS</h2>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Mail ID</th>
                    <th>Branch</th>
                    <th>Location</th>
                </tr>
            </thead>

            <tbody>
                  <%
                  ArrayList<Student> students = (ArrayList<Student>) request.getAttribute();

          		  if(students!=null){
          			      out.println("Slist has data: " + students.size() + " students.");
		           		  ListIterator<Student> itr = students.listIterator();
		          		  while(itr.hasNext()){
		             	  Student s = itr.next();%>
		                <tr>
		                    <td><%=s.getId()%></td>
		                    <td><%=s.getName()%></td>
		                    <td><%=s.getPhone()%></td>
		                    <td><%=s.getMailid()%></td>
		                    <td><%=s.getBranch()%></td>
		                    <td><%=s.getLocation()%></td>  
		                </tr>
		                <%}
		            }
          		    else { 
					%>
					<tr>
					    <td colspan="6">No students found</td>
					</tr>
					<% 
					    } 
					%>
            </tbody>
        </table>
    </div>
</body>
</html>