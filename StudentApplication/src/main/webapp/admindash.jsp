<%@page import="com.Student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentDashBoARD</title>
    <style>
     * {
    margin: 0px;
    padding: 0px;
}
body {
    background-color: #f4f4f4;
    height: 100vh;
}
.container {
    background-color: black;
    padding: 25px;
}
.header {
    display: flex;
    justify-content: space-between; /* Align <h3> to start and <ul> to end */
    align-items: center;
}
h3 {
    color: white;
    font-size: 25px;
    margin: 0;
}
ul {
    display: flex;
    list-style-type: none;
    margin: 0;
    padding: 0;
}
ul li a {
    text-decoration: none;
    padding: 20px;
    color: white;
    font-size: 20px;
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

.failure{
   color : red;
   text-align: center;
}
    </style>
</head>
<body>
    <div class="container">
        <nav>
            <div class="header">
                <%-- using request dispatcher
                <%Student s1 =(Student)request.getAttribute("student");%>
                <h3>Welcome <%=s1.getName()%></h3>--%>
                
                <%-- using session--%> 
                <%Student s1 =(Student)session.getAttribute("student");%>
                <h3>Welcome <%=s1.getName()%></h3>
                <ul>
 
                      <!-- <li><a href="">Create</a></li> -->
                    <li><a href="updateAccount.jsp">Update Data</a></li>
                    <li><a href="forgotpin.jsp">Reset Password</a></li>
                    <li><a href="viewUsers.jsp">View Users</a></li>
                    <form action="logout" method="post">
                    <li><a href="login.jsp">Logout</a></li>
                    </form>
                </ul>
            </div>
        </nav>
        </div>

        <div class="tables">
            <table>
                <thead>
                      
                      <%--to get the failure message while using view users --%>
               		  <%String failure = (String)request.getAttribute("ListFailure");
               		  if(failure!=null){%>
               		  <h3 class="failure"><%=failure%></h3>
                	  <%}%>
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
                    <tr>
                       <td><%=s1.getId()%></td> 
                       <td><%=s1.getName()%></td>
                       <td><%=s1.getPhone()%></td>
                       <td><%=s1.getMailid()%></td>   
                       <td><%=s1.getBranch()%></td>
                       <td><%=s1.getLocation()%></td>  
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
