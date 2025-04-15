import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationPage")
public class registrastionPage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String rollNo=req.getParameter("rollno1");
		String name=req.getParameter("name1");
		String email=req.getParameter("email1");
		String password=req.getParameter("password1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/feedbacks";
			String user="root";
			String pass="radha@0417";
			Connection cn=DriverManager.getConnection(url,user,pass);
			
			PreparedStatement ps=cn.prepareStatement("insert into studentInfo value(?,?,?,?)");
			ps.setString(1,rollNo);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			
			int result=ps.executeUpdate();
			if(result>0) {
				req.setAttribute("message", "Registered successfully..");
				RequestDispatcher rd=req.getRequestDispatcher("loginPage.jsp");
				rd.forward(req, resp);
				
			}
			else {
				req.setAttribute("message", "Registration failed. Please try again.");
				RequestDispatcher rd=req.getRequestDispatcher("registrastionPage.html");
				rd.forward(req, resp);

			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			out.print("<h3 style= color:orange>error:"+ e.toString() +"</h3>");
		}
		
		
		
		
	}
}
