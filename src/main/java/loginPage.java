import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginPage")
public class loginPage extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String email=req.getParameter("email1");
		String password=req.getParameter("password1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/feedbacks";
			String user="root";
			String pass="radha@0417";
            Connection cn=DriverManager.getConnection(url,user,pass);
			
			PreparedStatement ps=cn.prepareStatement("select email,password from studentInfo where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet result=ps.executeQuery();
			if(result.next()) {
				out.print("<h3 style=color:green>login successfully..</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("feedbackPage.jsp");
				rd.include(req, resp);
				
			}
			else {
				out.print("<h3 style=color:red>password not correct..</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("loginPage.jsp");
				rd.include(req, resp);
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			out.print("<h3 style=color:orange>"+e.toString()+"</h3>");
		}
		
		
	}

}
