package com.soyedotun.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDBUtil employeeDBUtil;
	@Resource(name="jdbc/neptune_sodiq")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			employeeDBUtil = new EmployeeDBUtil(dataSource);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the command parameter
			String theCommand = request.getParameter("command");
			
			// if the command is not defined, default to listing employees
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to appropriate method
			switch(theCommand) {
			
				case "LIST":
					listEmployees(request, response);
					break;
					
				case "ADD":
					addEmployee(request, response);
					break;
					
				case "LOAD":
					loadEmployee(request, response);
					break;
					
				case "UPDATE":
					updateEmployee(request, response);
					break;
					
				case "DELETE":
					deleteEmployee(request, response);
					break;
					
				case "SEARCH":
	                searchEmployees(request, response);
	                break;
					
				default:
					listEmployees(request, response);
					
			}
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}



	private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read search name from form data
        String theSearchName = request.getParameter("theSearchName");
        
        // search customers from db util
        List<Employee> employees = employeeDBUtil.searchEmployees(theSearchName);
        
        // add customers to the request
        request.setAttribute("EMPLOYEE_LIST", employees);
                
        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
        dispatcher.forward(request, response);
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read employee id from form data
		String  theEmployeeId = request.getParameter("employeeId");
		// delete employee from database
		employeeDBUtil.deleteEmployee(theEmployeeId);
		// send back to "list-employee" page
		listEmployees(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read employee info from form data
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String address = request.getParameter("address");
		String dor = request.getParameter("dor");
		
		// create a new employee object
		Employee theEmployee = new Employee(id, firstName, lastName, username, department, email, 
				phoneNumber, password, designation, address, dor);
		
		// perform update on database
		employeeDBUtil.updateEmployee(theEmployee);
		
		// send back to the "list-employee" page
		listEmployees(request, response);
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		// read employee id from form data
		String  theEmployeeId = request.getParameter("employeeId");
		
		// get employee from db (db util)
		Employee theEmployee = employeeDBUtil.getEmployee(theEmployeeId);
		
		// place employee in the request attribute
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
		// send to jsp page : update-employee-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read the employee info from from data 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String dor = request.getParameter("dor");
		String address = request.getParameter("address");
		
		// craete a new employee object
		Employee theEmployee = new Employee(firstName, lastName, username, department, email, 
				phoneNumber, password, designation, dor, address);
		
		// add the employee to the database
		employeeDBUtil.addEmployee(theEmployee);
		
		// send back to main page (the employee list)
		listEmployees(request, response);
		
		// 
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// Get employees from employeedbutil
		List<Employee> employees = employeeDBUtil.getEmployee();
		
		// Add employee to the request
		request.setAttribute("EMPLOYEE_LIST", employees);
		
		// Send to JSP page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
		dispatcher.forward(request, response);
		
	}

}
