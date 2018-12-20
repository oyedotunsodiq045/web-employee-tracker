<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page import="java.util.*, com.soyedotun.web.jdbc.*" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%-- <% List<Employee> theEmployees = (List<Employee>) request.getAttribute("EMPLOYEE_LIST"); %> --%>
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    
    <!-- Animate CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<meta charset="ISO-8859-1">
<title>EMPLOYEES LIST</title>
</head>
<body>
<%-- <%= theEmployees %> --%>

	<!-- As a heading -->
	<nav class="navbar navbar-dark bg-primary">
	  <span class="navbar-brand mb-0 h1 animated bounceInLeft delay-2s">Neptune Employees</span>
	  
	<form class="form-inline" action="EmployeeControllerServlet" method="GET">
		<input type="hidden" name="command" value="SEARCH" />
	    <input name="theSearchName" class="form-control mr-sm-2" type="search" placeholder="Search Employee" aria-label="Search">
	    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
  	</form>	  
	  
	</nav>
	
	<button type="button" 
			onclick="window.location.href='add-employee-form.jsp'; return false;"
			class="btn btn-success ml-3 mt-3 mb-3">Add Employee <i class="fas fa-user-plus"></i></button>
	
	<table class="table table-hover">
	  <thead class="">
	    <tr>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Department</th>
	      <th scope="col">Email</th>
	      <th scope="col">Designation</th>
	      <th scope="col">Phone</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
	  	<!-- Set up link for each employee -->
	  	<c:url var="tempLink" value="EmployeeControllerServlet">
	  		<c:param name="command" value="LOAD" />
	  		<c:param name="employeeId" value="${tempEmployee.id}" />
	  	</c:url>
	  	<!-- Set up delete link for each employee -->
	  	<c:url var="deleteLink" value="EmployeeControllerServlet">
	  		<c:param name="command" value="DELETE" />
	  		<c:param name="employeeId" value="${tempEmployee.id}" />
	  	</c:url>
		    <tr>
		      <td>${tempEmployee.firstName}</td>
		      <td>${tempEmployee.lastName}</td>
		      <td>${tempEmployee.department}</td>
		      <td>${tempEmployee.email}</td>
		      <td>${tempEmployee.designation}</td>
		      <td>${tempEmployee.phoneNumber}</td>
		      <td>
		      	<a class="btn btn-warning" href="${tempLink}" role="button">Edit <i class="fas fa-user-edit"></i></a>
		      	<a class="btn btn-danger" href="${deleteLink}" 
		      		onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false" role="button">Delete <i class="fas fa-user-times"></i></a>
		      </td>
		    </tr>
		</c:forEach>
	  </tbody>
	</table>	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>