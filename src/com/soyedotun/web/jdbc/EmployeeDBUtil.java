package com.soyedotun.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDBUtil {
	
	private DataSource dataSource;
	
	Connection conn = null;
	ResultSet res = null;
	String sql;
	int employeeId;
	
	public EmployeeDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Employee> getEmployee() throws Exception {
		List<Employee> employees = new ArrayList<>();
		
		Statement stt = null;
		
		try {
			//
			conn = dataSource.getConnection();
			sql = "SELECT * FROM employee ORDER BY last_name";
			stt = conn.createStatement();
			res = stt.executeQuery(sql);
			while(res.next()) {
				int id = res.getInt("id");
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String username = res.getString("username");
				String department = res.getString("department");
				String email = res.getString("email");
				String phoneNumber = res.getString("phone_number");
				String password = res.getString("password");
				String designation = res.getString("designation");
				String address = res.getString("address");
				String dor = res.getString("dor");
				
				Employee tempEmployee = new Employee(id, firstName, lastName, username, department, email, 
														phoneNumber, password, designation, address, dor);
						
				employees.add(tempEmployee);
			}

			return employees;
		} finally {
			close(conn, stt, res);
		}

	}

	private void close(Connection conn, Statement stt, ResultSet res) {
		try {
			if(res != null) {
				res.close();
			}
			if(stt != null) {
				stt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addEmployee(Employee theEmployee) throws Exception {
		
		PreparedStatement stt = null;
		
		try {
			conn = dataSource.getConnection();
			sql = "INSERT INTO employee "
					+ "(first_name, last_name, username, department, email, phone_number, password, designation, address, dor) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			stt = conn.prepareStatement(sql);
			stt.setString(1,  theEmployee.getFirstName());
			stt.setString(2, theEmployee.getLastName());
			stt.setString(3, theEmployee.getUsername());
			stt.setString(4, theEmployee.getDepartment());
			stt.setString(5, theEmployee.getEmail());
			stt.setString(6, theEmployee.getPhoneNumber());
			stt.setString(7, theEmployee.getPassword());
			stt.setString(8, theEmployee.getDesignation());
			stt.setString(9, theEmployee.getDor());
			stt.setString(10, theEmployee.getAddress());
			stt.execute();
		} finally {
			close(conn, stt, null);
		}
	}

	public Employee getEmployee(String theEmployeeId) throws Exception {
		Employee theEmployee = null;
		PreparedStatement stt = null;
		try {
			// convert employeeId to int
			employeeId = Integer.parseInt(theEmployeeId);
			// get a connection
			conn = dataSource.getConnection();
			// create sql statement to get selcted employee
			sql = "SELECT * FROM employee WHERE id=?";
			// create prepared statement
			stt = conn.prepareStatement(sql);
			// set params
			stt.setInt(1, employeeId);
			// execute statement
			res = stt.executeQuery();
			// retrieve data from result set row
			if(res.next()) {
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String username = res.getString("username");
				String department = res.getString("department");
				String email = res.getString("email");
				String phoneNumber = res.getString("phone_number");
				String password = res.getString("password");
				String designation = res.getString("designation");
				String address = res.getString("address");
				String dor = res.getString("dor");
				// use the employee during construction
				theEmployee = new Employee(employeeId, firstName, lastName, username, department, 
						email, phoneNumber, password, designation, address, dor);
			} else {
				throw new Exception("could not find employee id " + employeeId);
			}
			return theEmployee;
		} finally {
			// Close JDBC
			close(conn, stt, res);
		}
	}

	public void updateEmployee(Employee theEmployee) throws Exception {
		PreparedStatement stt = null;
		try {
			conn = dataSource.getConnection();
			sql = "UPDATE employee SET "
					+ "first_name=?, last_name=?, username=?, department=?, email=?, "
					+ "phone_number=?, password=?, designation=?, address=?, dor=? "
					+ "where id=?";
			stt = conn.prepareStatement(sql);
			stt.setString(1, theEmployee.getFirstName());
			stt.setString(2, theEmployee.getLastName());
			stt.setString(3, theEmployee.getUsername());
			stt.setString(4, theEmployee.getDepartment());
			stt.setString(5, theEmployee.getEmail());
			stt.setString(6, theEmployee.getPhoneNumber());
			stt.setString(7, theEmployee.getPassword());
			stt.setString(8, theEmployee.getDesignation());
			stt.setString(9, theEmployee.getAddress());
			stt.setString(10, theEmployee.getDor());
			stt.setInt(11, theEmployee.getId());
			stt.execute();
		} finally {
			close(conn, stt, null);
		}
		
	}

	public void deleteEmployee(String theEmployeeId) throws Exception {
		PreparedStatement stt = null;
		try {
			// convert employeeId to int
			employeeId = Integer.parseInt(theEmployeeId);
			// get a connection to the database
			conn = dataSource.getConnection();
			// create sql query to delete employee
			sql = "DELETE FROM employee WHERE id=?";
			// prepare statements
			stt = conn.prepareStatement(sql);
			// set params
			stt.setInt(1,  employeeId);
			// execute sql statement
			stt.execute();
		} finally {
			close(conn, stt, null);
		}
		
	}

	public List<Employee> searchEmployees(String theSearchName) throws Exception {
		List<Employee> employees = new ArrayList<>();
        PreparedStatement stt = null;
        int employeeId;
        
        try {
            
            // get connection to database
            conn = dataSource.getConnection();
            
            //
            // only search by name if theSearchName is not empty
            //
            if (theSearchName != null && theSearchName.trim().length() > 0) {
                // create sql to search for students by name
                sql = "SELECT * FROM employee WHERE lower(first_name) like ? or lower(last_name) like ?";
                // create prepared statement
                stt = conn.prepareStatement(sql);
                // set params
                String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
                stt.setString(1, theSearchNameLike);
                stt.setString(2, theSearchNameLike);
                
            } else {
                // create sql to get all customers
                String sql = "select * from employee order by last_name";
                // create prepared statement
                stt = conn.prepareStatement(sql);
            }
            
            // execute statement
            res = stt.executeQuery();
            
            // retrieve data from result set row
            while (res.next()) {
                
                // retrieve data from result set row
            	employeeId = res.getInt("id");
				String firstName = res.getString("first_name");
				String lastName = res.getString("last_name");
				String username = res.getString("username");
				String department = res.getString("department");
				String email = res.getString("email");
				String phoneNumber = res.getString("phone_number");
				String password = res.getString("password");
				String designation = res.getString("designation");
				String address = res.getString("address");
				String dor = res.getString("dor");
                
                // create new customer object
				Employee tempCustomer = new Employee(employeeId, firstName, lastName, username, department, 
						email, phoneNumber, password, designation, address, dor);
                
                // add it to the list of customers
				employees.add(tempCustomer);            
            }
            
            return employees;
        }
        finally {
            // clean up JDBC objects
            close(conn, stt, res);
        }
	}

}
