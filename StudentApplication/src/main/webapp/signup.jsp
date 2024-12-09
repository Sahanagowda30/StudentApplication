<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentSignUp</title>
    <style>
      body {
    background-color: #f4f4f4;
    height: 100vh;
}

.container {
    display: flex;
    justify-content:center;
    align-items: center;
    margin: 20px auto;
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

.btn{
    padding: 8px 20px;
    font-size: 15px;
    border-radius: 5px;
    border: none;
    background-color: black;
    color: white;
    cursor: pointer;
}

.success{
    color:green;
   }
   
.failure{  
    color:red;
  }  
    </style>
    
</head>
<body>
    <div class="container">
        <form action="signup" method="post">
            <h2>SIGNUP</h2>
            
            <!-- get the dispatched data from the key name, use string because string is to be printed and type casted as it is object -->
            <%String success = (String)request.getAttribute("success");
              if(success!=null){%>
              <h3 class="success"><%=success %></h3>
              <%}%>
              
             <%String failure = (String)request.getAttribute("failure");
              if(failure!=null){%>
              <h3 class="failure"><%=failure %></h3>
              <%}%>
              
              
            <label class="label"><b>Enter Your Name</b></label>
            <br>
            <input type="text"name="username" >
            <br>
            <br>
            <label for="" class="label"><b>Enter Phone Number</b></label>
            <br>
            <input type="tel" name="phone">
            <br>
            <br>
            <label for="" class="label"><b>Enter Mail ID</b></label>
            <br>
            <input type="email" name="mail">
            <br>
            <br>
            <label for="" class="label"><b>Enter Your Branch</b></label>
            <br>
            <input type="text" name="branch">
            <br>
            <br>
            <label for="" class="label"><b>Enter Your Location</b></label>
            <br>
            <input type="text" name="location">
            <br>
            <br>
            <label for="" class="label"><b>Enter Password</b></label>
            <br>
            <input type="password" name="password">
            <br>
            <br>
            <label for="" class="label"><b>Confirm Password</b></label>
            <br>
            <input type="password" name="confirm">
            <br>
            <br>
            <div style="display: flex; justify-content: center;" >
            <input type="submit" class="btn"> 
            </div> 
           <div style="text-align: center;">
            <p style="font-size: 18px;">Already have an account? <a href="login.jsp" style="font-weight: bold;">Login</a></p>
           </div>
        </form>
    </div>
</body>
</html>