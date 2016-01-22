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
			
			<c:choose>
			<c:when test="${employee == null}">  
  				<li role="presentation" class="active"><a href="EmployeeLogin.do">Login</a></li>
  			</c:when>
  			
  			<c:otherwise>
 				<li role="presentation"  class="active"><a href="ChangeEmployeePassword.do">Change Password</a></li>
  				<li role="presentation"><a href="createEmployee.do">Create Employee Account</a></li>
  				<li role="presentation"><a href="CreateCustomer.do">Create Customer Account</a></li>
  				<!-- <li role="presentation"><a href="ChangeCustomerPassword.do">Reset Customer Password</a></li> -->
  				<li role="presentation"><a href="ViewCustomerAccount.do">Manage Customer Account</a></li>
  				<!-- <li role="presentation"><a href="#">View Customer Transaction History</a></li>
  				<li role="presentation"><a href="DepositCheck.do">Deposit Check</a></li> -->
  				<li role="presentation"><a href="CreateFund.do">Create Fund</a></li>
  				<li role="presentation"><a href="#">Transition Day</a></li>
  				<li role="presentation"><a href="EmployeeLogout.do">Log Out</a></li>
  			</c:otherwise>
  			</c:choose>
  			
  			</ul>
  			</div>
  			
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<br>
				<br>
				<div class="header"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Change Password</div>
				<br>
				<br>
				<form class="form-horizontal" action="ChangeEmployeePassword.do" method="POST">
  					<div class="form-group">
    					<label for="inputOldPassword" class="col-sm-4 control-label">Old Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="oldPassword" value="" class="form-control" id="inputOldPassword" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="inputPassword" class="col-sm-4 control-label">New Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="newPassword" value="" class="form-control" id="inputPassword" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="inputPassword1" class="col-sm-4 control-label">Confirm Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="confirmPassword" value="" class="form-control" id="inputPassword1" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" class="btn btn-primary">Change Password</button>
      						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      						<button type="reset" name="action" value="Change" class="btn btn-default">Reset</button>
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