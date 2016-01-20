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
  				<li role="presentation"><a href="createEmployee.do">Create Employee Account</a></li>
  				<li role="presentation"><a href="CreateCustomer.do">Create Customer Account</a></li>
  				<li role="presentation"><a href="ChangeCustomerPassword.do">Reset Customer Password</a></li>
  				<li role="presentation"><a href="#">View Customer Account</a></li>
  				<li role="presentation"><a href="#">View Customer Transaction History</a></li>
  				<li role="presentation" class="active"><a href="DepositCheck.do">Deposit Check</a></li>
  				<li role="presentation"><a href="CreateFund.do">Create Fund</a></li>
  				<li role="presentation"><a href="#">Transition Day</a></li>
  				<li role="presentation"><a href="#">Log Out</a></li>
  			</div>
			</ul>
			
			<div class="col-md-6">
				<br>
				<br>
				<br>
				<div class="col-sm-1"></div>
				<div class="col-sm-11">
					<div class="header"><h3>Deposit Check</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<form class="form-horizontal" action="DepositCheck.do" method="POST">
					<div class="form-group">
    					<label for="checknumber" class="col-sm-4 control-label">Check Number</label>
    					<div class="col-sm-8">
      						<input type="text" name="checknumber" class="form-control" id="checknumber">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="depositamount" class="col-sm-4 control-label">Deposit Amount</label>
    					<div class="col-sm-8">
      						<input type="text" name="depositamount" class="form-control" id="depositamount">
    					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" class="btn btn-primary">Confirm</button>
      						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      						<button type="submit" class="btn btn-default">Cancel</button>
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