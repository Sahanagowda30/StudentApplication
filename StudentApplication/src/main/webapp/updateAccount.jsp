<%@page import="com.Student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
    body {
    background-color: #f4f4f4;
    height: 100vh;
}

.container {
    display: flex;
    justify-content:center;
    align-items: center;
    margin: 100px auto;
    width: 470px;
    border-radius: 30px;
    background-color: #ffffff;
    box-shadow: 10px 10px 4px 4px rgb(85 73 73);
}

h2 {
    text-align: center;
    margin-bottom: 30px;
    margin-top: 40px;
}


.label {
    font-size: 16px;
}

input{
    width: 100%;
}

.btn {
    padding: 8px 10px;
    width: 100px;
    font-size: 15px;
    border-radius: 5px;
    border: none;
    margin : 8px;
    margin-bottom: 20px;
    background-color: black;
    color: white;
    cursor: pointer;
    text-align: center;
}

.success{
   color : green;
   text-align : center;
}

.failure{
color : red;
text-align:center;
}
    </style>
</head>
<body>
    <div class="container">
    
    <%Student s = (Student)session.getAttribute("student");%>
        <form action="updateAccount" method="post">
          
            <h2>UPDATE ACCOUNT</h2>
            
            <%String success = (String)request.getAttribute("success");
          if(success!=null){%>
          <h3 class="success"><%=success%></h3>
          <%}%>
          
          <%String failure = (String)request.getAttribute("failure");
          if(failure!=null){%>
          <h3 class="success"><%=failure%></h3>
          <%}%>
          
            <label for="" class="label"><b>Name</b></label>
            <br>
            <input type="text"name="name" value="<%=s.getName()%>">
            <br>
            <br>
            <label for="" class="label"><b>Mail ID</b></label>
            <br>
            <input type="email" name="mail" value="<%=s.getMailid()%>">
            <br>
            <br>
            <label for="" class="label"><b>Location</b></label>
            <br>
            <input type="text" name="location" value="<%=s.getLocation()%>">
            <br>
            <br>
            <label for="" class="label"><b>Branch</b></label>
            <br>
            <input type="text" name="branch" value="<%=s.getBranch()%>">
            <br>
            <br>
            <label for="" class="label"><b>Phone Number</b></label>
            <br>
            <input type="tel" name="phone" value="<%=s.getPhone()%>">
            <br>
            <br>
            <div style="display: flex; justify-content: center;" >
            <input type="submit" class="btn">
            <a href="dashboard.jsp" class="btn" style="text-decoration: none;">Back</a> 
            </div> 
        </form>
    </div>
</body>
</html>