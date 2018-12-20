<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    
    <!-- Animate CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
    
    <title>Update Employee Page</title>
  </head>
  <body>
    <!-- As a heading -->
	<nav class="navbar navbar-dark bg-primary">
	  <span class="navbar-brand mb-0 h1 animated bounceInLeft">Neptune Employees</span>
	</nav>
	
	<!-- Start Container -->
	<div class="container mt-3">
		<span class="text-left"><a href="EmployeeControllerServlet"><i class="fas fa-arrow-left">Back</i></a></span>
		<h2 class="text-center mb-3">Update an Employee</h2>	
	
	<form action="EmployeeControllerServlet" method="GET">
	
	  <input type="hidden" name="command" value="UPDATE" />
	  <input type="hidden" name="employeeId" value="${THE_EMPLOYEE.id}" />
	  <!-- <select type="hidden" name="command" value="ADD"></select> -->
	  <!-- <textarea type="hidden" name="command" value="ADD"></textarea> -->
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputFirstname">First Name</label>
	      <input type="text" name="firstName" value="${THE_EMPLOYEE.firstName}" class="form-control" id="inputFirstname" placeholder="First name">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputLastname">Last Name</label>
	      <input type="text" name="lastName" value="${THE_EMPLOYEE.lastName}" class="form-control" id="inputLastname" placeholder="Last name">
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputUsername">Username</label>
	      <div class="input-group">
	      	<div class="input-group-prepend">
	      		<span class="input-group-text" id="inputGroupPrepend2">@</span>
	      	</div>
	      		<input type="text" name="username" value="${THE_EMPLOYEE.username}" class="form-control" id="inputUsername" placeholder="Username">
		  </div>	      
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputDepartment">Department</label>
	      	<input type="text" name="department" value="${THE_EMPLOYEE.department}" class="form-control" id="inputUsername" placeholder="department">
	      <!-- <select name="department" value="${THE_EMPLOYEE.department}" id="inputDepartment" class="form-control">
	        <option value="Technology">Technology</option>
	        <option value="Cloud Specialist">Cloud Specialist</option>
	        <option value="Human Resource">Human Resource</option>
	        <option value="Quality Assurance">Quality Assurance</option>
	      </select> -->
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputEmail">Email</label>
	    <input type="email" name="email" value="${THE_EMPLOYEE.email}" class="form-control" id="inputEmail" placeholder="email@example.com">
	  </div>
	  
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputPhonenumber">Phone</label>
	      <input type="text" name="phoneNumber" value="${THE_EMPLOYEE.phoneNumber}" class="form-control" id="inputFirstname" placeholder="0812 345 6789">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputPassword">Password</label>
	      <input type="password" name="password" value="${THE_EMPLOYEE.password}" class="form-control" id="inputPassword" placeholder="" disabled>
	    </div>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputDesignation">Designation</label>
	      	<input type="text" name="designation" value="${THE_EMPLOYEE.designation}" class="form-control" id="inputUsername" placeholder="designation">
	      <!-- <select name="designation" value="${THE_EMPLOYEE.designation}" id="inputDesignation" class="form-control">
	        <option value="HR Personnel">HR Personnel</option>
	        <option value="Software Engineer">Software Engineer</option>
	        <option value="Cloud Engineer">Cloud Engineer</option>
	        <option value="Software Tester">Software Tester</option>
	        <option value="Choose 1">Choose 1</option>
	        <option value="Choose 2">Choose 2</option>
	      </select> -->
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputDOR">Date of Registration</label>
			<input type="date" name="dor" value="${THE_EMPLOYEE.dor}" class="form-control" min="2018-12-01" max="2019-12-31">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputAdress">Address</label>
	      	<input type="text" name="address" value="${THE_EMPLOYEE.address}" class="form-control" id="inputUsername" placeholder="address">
	    <!-- <textarea name="address" value="${THE_EMPLOYEE.address}" class="form-control" id="exampleFormControlTextarea1" rows="2" placeholder="73, Jebba Street, Ebutemetta, Oyingbo, Lagos"></textarea> -->
	  </div>
	  <button type="submit" class="btn btn-primary">Update</button>
	</form>
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>