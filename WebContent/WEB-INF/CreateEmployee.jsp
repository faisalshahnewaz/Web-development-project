<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>CFS for Employee</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="page-header">
  					<h1>Carnegie Financial Services <small>Mutual Fund</small></h1>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
  			<div class="col-md-2">
  
			<ul class="nav nav-pills nav-stacked">
  				<li role="presentation"><a href="EmployeeLogin.do">Login</a></li>
 				<li role="presentation"><a href="ChangeEmployeePassword.do">Change Password</a></li>
  				<li role="presentation" class="active"><a href="createEmployee.do">Create Employee Account</a></li>
  				<li role="presentation"><a href="CreateCustomer.do">Create Customer Account</a></li>
  				<li role="presentation"><a href="ChangeCustomerPassword.do">Reset Customer Password</a></li>
  				<li role="presentation"><a href="#">View Customer Account</a></li>
  				<li role="presentation"><a href="#">View Customer Transaction History</a></li>
  				<li role="presentation"><a href="DepositCheck.do">Deposit Check</a></li>
  				<li role="presentation"><a href="CreateFund.do">Create Fund</a></li>
  				<li role="presentation"><a href="#">Transition Day</a></li>
  				<li role="presentation"><a href="EmployeeLogout.do">Log Out</a></li>
  			</div>
			</ul>
			
			<div class="col-md-6">
				<br>
				<br>
				<br>
				<div class="col-sm-1"></div>
				<div class="col-sm-11">
					<div class="header"><h3>Create Employee Account</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<form class="form-horizontal" action="createEmployee.do" method="POST">
					<div class="form-group">
    					<label for="username" class="col-sm-4 control-label">User Name</label>
    					<div class="col-sm-8">
      						<input type="text" name="username" value="${form.username}" class="form-control" id="username">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="firstname" class="col-sm-4 control-label">First Name</label>
    					<div class="col-sm-8">
      						<input type="text" name="firstname" value="${form.firstname}" class="form-control" id="firstname">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-4 control-label">Last Name</label>
    					<div class="col-sm-8">
      						<input type="text" name="lastname" value="${form.lastname}" class="form-control" id="lastname">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="inputPassword" class="col-sm-4 control-label">Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="password" class="form-control" id="inputPassword">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="inputPassword1" class="col-sm-4 control-label">Confirm Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="confirm" class="form-control" id="inputPassword1">
   						</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" name="action" value="Create" class="btn btn-primary">Confirm</button>
      						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      						<button type="submit" class="btn btn-default">Reset</button>
    					</div>
  					</div>
  					<c:forEach var="error" items="${errors}">   
			   		 <div id="errormsg"> ${error} </div>
					</c:forEach>
				</form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>