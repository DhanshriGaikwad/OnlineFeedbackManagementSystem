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

@WebServlet("/adminRegistrationSevlet")
public class adminRegistrationSevlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String name=req.getParameter("name1");
		String email=req.getParameter("email1");
		String password=req.getParameter("password1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/feedbacks";
			String user="root";
			String pass="radha@0417";
			Connection cn=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = cn.prepareStatement("INSERT INTO adminInfo(name, email, password) VALUES (?, ?, ?)");
			 ps.setString(1, name);
			 ps.setString(2, email);
			 ps.setString(3, password);
			 
			 int result=ps.executeUpdate();
			 if(result>0) {

				 RequestDispatcher rd=req.getRequestDispatcher("admin.jsp");
				 rd.forward(req, resp);
			 }
			 else {
				 
				 out.print("<h3 style=color:red>registration failed ..try again.. </h3>");
				 
			 }
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			 out.print("<h3 style=color:orange>"+ e.toString()+" </h3>");

			
		}
	}

}
