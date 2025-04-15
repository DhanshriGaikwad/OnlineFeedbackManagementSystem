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

@WebServlet("/feedbackPage")
public class feedbackpage extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
	String id=req.getParameter("id1");
	String student_id=req.getParameter("stdrollno1");
	String subject_name=req.getParameter("subjectname1");
	String teacher_name=req.getParameter("teachername1");
	String comments=req.getParameter("comment1");
	int rating=Integer.parseInt(req.getParameter("rating1"));
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/feedbacks";
		String user="root";
		String password="radha@0417";
		Connection cn=DriverManager.getConnection(url,user,password);
		PreparedStatement ps=cn.prepareStatement("insert into feedbackform value(?,?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, student_id);
		ps.setString(3, subject_name);
		ps.setString(4, teacher_name);
		ps.setString(5, comments);
		ps.setInt(6, rating);
		
		int result=ps.executeUpdate();
		if(result>0) {
			out.print("<h3 style=color:green>feedback added successfully!...</h3>");
            RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
            rd.include(req, resp);

			
		}
		else {
			out.print("<h3 style=color:red> try again!..</h3>");
            RequestDispatcher rd=req.getRequestDispatcher("feedbackPage.jsp");
             rd.include(req, resp);
		}
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
		out.print("<h3 style=color:orange>"+e.toString()+"</h3>");
	}
	}

}
