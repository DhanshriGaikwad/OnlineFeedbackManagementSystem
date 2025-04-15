<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin  Registration or Login Page</title>
<style>

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
    background-color:pink;
    
  }
  
h3{
    text-align:center;
    margin-right:50px;
    margin-top:100px;
}

.container {
    display: flex;
    justify-content: center;
    margin: 100px ;
    padding: 50px;
    background-color:white;
    border:100px;
  }
  
.form-box {
    background-color: white;
   
    padding: 25px 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    width: 300px;
    margin: 10px;
  }
  
  
  
input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  margin-top: 6px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  color:black;
    background-color: #f9f9f9; /* Optional: adds light background */
  
}

input[type="submit"] {
    background-color:#007BFF;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
      background-color: #0056b3;
  }



</style>
</head>
<body>

<div class="navbar">
<a href="index.html">
   <button>Back</button>
</a>
 </div>

<div class="container">
<h3>Registration form</h3>
<form action="adminRegistrationSevlet" method="post">
<label>Name:</label><br><input type="text"  name="name1" placeholder="Enter the Full-name" required/><br/><br/>
<label>E-mail:</label><br><input type="email"  name="email1" placeholder="E-mail" required/><br/><br/>
<label>Password:</label><br><input type="password" name="password1"  placeholder="Password" required/><br/><br/>
<input type="submit" value="submit"/>
</form>

</div>



<div class="container">
<h3>Login form</h3>
<form action="adminloginPage" method="post">
<label>E-mail:</label><br><input type="email"  name="email1" placeholder="E-mail" required/><br/><br/>
<label>Password:</label><br><input type="password" name="password1"  placeholder="Password" required/><br/><br/>
<input type="submit" value="Login"/>

</form>

</div>

</body>
</html>