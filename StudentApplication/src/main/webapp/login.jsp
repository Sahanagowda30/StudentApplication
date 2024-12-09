<%@page import="com.Student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

</html><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="sli.css">
    <style>
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

.btn {
    text-align: center;
}

.label {
    font-size: 16px;
}

input{
    width: 100%;
}

.btn{
    padding: 8px 20px;
    font-size: 15px;
    border-radius: 5px;
    border: none;
    margin-bottom: 10px;
    width: 100px;
    background-color: black;
    color: white;
    cursor: pointer;
}

.failure{
     color:red;
 }
    </style>
</head>
<body>
    <div class="container">
        <form action="login" method="post">
            <h2>LOGIN</h2>
            
            <%String failure = (String)request.getAttribute("failure");
              if(failure!=null){%>
              <h3 class="failure"><%=failure%></h3>
              <%}%>
              
            <%String logout = (String)request.getAttribute("logout");
            if(logout!=null){%>
              <h3><%=logout%></h3>
              <%}%>
             
            <label for="" class="label"><b>Enter Your MailId</b></label>
            <br>
            <input type="text" name="mail" required="required" >
            <br>
            <br>
            <label for="" class="label"><b>Enter Password</b></label>
            <br>
            <input type="password" name="password" required="required">
            <br>
            <br>
            <div style="display: flex; justify-content: center;">
                <input type="submit" class="btn" value="Login">
            </div>
            <div style="text-align: center; margin-bottom: 10px; font-size: 16px; font-weight: bold;">
                <a href="forgotpin.jsp" style="color: black;">Forgot Pin?</a>
            </div>
        </form>
    </div>
</body>
</html>