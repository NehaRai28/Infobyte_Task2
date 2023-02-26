

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adddata")
public class adddata extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String A=request.getParameter("A");
		String B=request.getParameter("B");
		String C=request.getParameter("C");
		String D=request.getParameter("D");
		String E=request.getParameter("E");
		try{

		    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","thelav28");
			String qr="insert into oasis2 values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, A);
			ps.setString(2, B);
			ps.setString(3, C);
			ps.setString(4, D);
			ps.setString(5, E);
		
			int i=ps.executeUpdate();
			out.println("<script>window.alert('You have successfully submitted!!')</script>");
			con.close();
			
			}catch(Exception e)
			{
				out.println(e);
			}
	}

}
