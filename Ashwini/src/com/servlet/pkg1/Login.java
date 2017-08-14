/**
 * 
 */


/**
 * @author DELL
 *
 */
package com.servlet.pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet

{

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("userName");  
	    String p=request.getParameter("userPass");  
	          
	    if(p.isEmpty()||n.isEmpty())
	    		{  
	    	out.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd=request.getRequestDispatcher("/Login.html");  
	        rd.include(request, response); 
	        //RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
	        //rd.forward(request, response);  
	    }  
	    else{  
	    	RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
	        rd.forward(request, response);
	        //out.print("Sorry UserName or Password Error!");  
	        //RequestDispatcher rd=request.getRequestDispatcher("/Login.html");  
	        //rd.include(request, response);  
	                      
	        }  
	    }  
	  
	}  

