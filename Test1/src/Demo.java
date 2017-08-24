

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String department=" ";
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("hello");
		
		
		// TODO Auto-generated method stub
		String JDBC_DRIVER = "org.postgresql.Driver";
		String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
		String USER = "postgres";
		String PASS = "numan";
		Connection conn = null;
		Statement stmt = null;
		   
		
			String department="";
		    String fname=request.getParameter("fname").toString();
			String lname=request.getParameter("lname").toString();
			String num=request.getParameter("num").toString();
			String[] dept = request.getParameterValues("dept");
		       for(int i=0; i<dept.length; i++){
		       department+=dept[i]+" ";
		       }
		       
		       
		   try{
			   Class.forName("org.postgresql.Driver");
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   
			   String query = "insert into contact(fname,lname,num,dept) VALUES('"+fname+"','"+lname+"','"+num+"','"+department+"')";
			   stmt = conn.createStatement();
			   stmt.executeUpdate(query);
			   String sql=null;
			   sql="select * from contact";
			   //ResultSet rs=stmt.executeQuery(sql);
			   
			   
			   
			   
			   pw.print("<table width=50% border=1>");  
			   pw.print("<caption>Result:</caption>");  
			   ResultSet rs=stmt.executeQuery(sql);   
			                 
			   /* Printing column names */  
			   ResultSetMetaData rsmd=rs.getMetaData();  
			   int total=rsmd.getColumnCount();  
			   pw.print("<tr>");  
			   for(int i=1;i<=total;i++)  
			   {  
			   pw.print("<th>"+rsmd.getColumnName(i)+"</th>");  
			   }  
			     
			   pw.print("</tr>");  
			   
			   while(rs.next())
			   {
				   pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");  
						                     
			   }

			  pw.print("thank you");
			 
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Auto-generated method stub
		doGet(request, response);
	}

}
