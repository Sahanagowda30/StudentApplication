<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Pin</title>
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
    margin-bottom : 10px;
    background-color: black;
    color: white;
    cursor: pointer;
    text-align: center;
}

.mismatch{
  color:red;
}
</style>
</head>
<body>
    <div class="container">
        <form action="forgotpin" method="post">
            <h2>FORGOT PIN?</h2>
            
            <%String mismatch = (String)request.getAttribute("mismatch");
              if(mismatch!=null){%>
              <h3 class="mismatch"><%=mismatch %></h3>
              <%}%>
              
              <%String invalidData = (String)request.getAttribute("invalidData");
              if(invalidData!=null){%>
              <h3 class="mismatch"><%=invalidData %></h3>
              <%}%>
              
              
            <label for="" class="label"><b>Enter Your Phone Number</b></label>
            <br>
            <input type="tel" name="phone" required>
            <br>
            <br>
            <label for="" class="label"><b>Enter Your Mail ID</b></label>
            <br>
            <input type="email" name="mail" required>
            <br>
            <br>
            <label for="" class="label"><b>New Password</b></label>
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
        </form>
    </div> 
</body>
</html>