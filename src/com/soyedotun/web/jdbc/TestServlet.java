package com.soyedotun.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/neptune_sodiq")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// PrintWriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		Connection conn = null;
		Statement stt = null;
		ResultSet res = null;
		
		try {
			//connection
			conn = dataSource.getConnection();
			// sql
			String sql = "select * from employee";
			stt = conn.createStatement();
			
			// query
			res = stt.executeQuery(sql);
			
			// resultset
			while(res.next()) {
				String dept = res.getString("department");
				out.println(dept);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
