package com.sandeep.testDb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Set up connection variables
		String userId = "hbstudent";
		String password = "hbstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3307/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		//Get connection to the database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to URL: "+jdbcUrl);
			Class.forName(driver);
			Connection myConn= DriverManager.getConnection(jdbcUrl,userId,password);
			
			out.println("Connection Established");
			myConn.close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}
