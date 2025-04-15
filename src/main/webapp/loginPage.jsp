<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page </title>
<link rel="stylesheet" href="style.css"/>
</head>
<body>

<%
String message=(String)request.getAttribute("message");
if(message!=null){
%>
<div class="message"> <%= message %></div>
<%
}
%>

<div class="container">
<h2> Login Page </h2>
<form action="loginPage" method="post">
E-mail:<br><input type="email"  name="email1" placeholder="E-mail" required/><br/><br/>
password:<br><input type="password" name="password1"  placeholder="Password" required/><br/><br/>
<input type="submit" value="Login"/>

</form>
</div>
</body>
</html>