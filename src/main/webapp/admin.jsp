<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page </title>
<style>

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }

    table, th, td {
        border: 2px solid #555;
        border-radius:6px;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    h2, h3 {
        text-align:center;
        color:white;
    }
    
    table tr:nth-child(even) {
    background-color: #f9f9f9;

}

 table tr:nth-child(odd) {
    background-color: #f9f9f9;
}

table tr:hover {
    background-color: #e0f7fa;
}

body {
    font-family: Arial, sans-serif;
    background-color: black;
    padding: 20px;
}

.container {
    max-width: 960px;
    margin: 0 auto;
}

button{
      background-color: #f44336;
      border: none;
      color: white;
      padding: 8px 16px;
      text-decoration: none;
      font-size: 16px;
      cursor: pointer;
      border-radius: 4px;
      display:flex;
      justify-content:center;
}

 button:hover {
      background-color: #d32f2f;
    }

.navbar{
display:flex;
justify-content:space-between;
align-items:center;
padding:10px 20px;
}

    
</style>
</head>


<body>

<div class="navbar">
<h3 style="color: white; margin:0;">Admin Page</h3>
<a href="adminRegistration.jsp">
   <button>Back</button>
</a>
 </div>
 
<div class="container">


<h2>Feedback Submitted by Students</h2>

<%
Connection cn=null;
Statement stmt=null;
ResultSet rs=null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedbacks", "root", "radha@0417");

    stmt = cn.createStatement();
    String sql = "SELECT subject_name,teacher_name,comments, rating FROM feedbackform";
    rs = stmt.executeQuery(sql);



%>

<table>
<tr>
<th> -Subject- </th>
<th> -Teacher- </th>
<th> -Comments- </th>
<th> -Rating- </th>
</tr>

<%
 while(rs.next()){
%>

   <tr>
        <td><%= rs.getString("subject_name") %></td>
        <td><%= rs.getString("teacher_name") %></td>
        <td><%= rs.getString("comments") %></td>
        <td><%= rs.getInt("rating") %></td>
    </tr>
    
 <%
    }
%>
    
 </table>
 
 <%
}
catch(Exception e){
	out.println("<p style=color:orange>"+e.getMessage()+"</p>");
}
finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(cn!=null)cn.close();
}
 %>
 
 
 </div>
 
 
</body>
</html>