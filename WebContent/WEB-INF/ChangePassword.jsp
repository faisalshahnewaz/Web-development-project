<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>CFS for Customer</title>
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
  				<li role="presentation"><a href="CustomerLogin.do">Login</a></li>
 				<li role="presentation" class="active"><a href="ChangePassword.do">Change Password</a></li>
  				<li role="presentation"><a href="view_portfolio.html">View Portfolio</a></li>
  				<li role="presentation"><a href="BuyFund.do">Buy Fund</a></li>
  				<li role="presentation"><a href="sell_fund.html">Sell Fund</a></li>
  				<li role="presentation"><a href="transaction_history">Transaction History</a></li>
  				<li role="presentation"><a href="research.html">Research Fund</a></li>
  				<li role="presentation"><a href="request_check.html">Request Check</a></li>
  				<li role="presentation"><a href="EmployeeLogout.do">Log Out</a></li>
  			</div>
			</ul>
			
			<div class="col-md-1"></div>
      <div class="col-md-5">
        <br>
        <br>
        <div class="header"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Change Password</div>
        <br>
        <br>
        <br>
        <form class="form-horizontal" action="ChangePassword.do" method="POST">
            <div class="form-group">
              <label for="username" class="col-sm-4 control-label">User Name</label>
               <div class="col-sm-8">
                  <input type="text" name="username" class="form-control" id="username" placeholder="User Name">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword" class="col-sm-4 control-label">Old Password</label>
               <div class="col-sm-8">
                  <input type="password" name="oldPassword" class="form-control" id="inputPassword" placeholder="Password">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword1" class="col-sm-4 control-label">New Password</label>
               <div class="col-sm-8">
                  <input type="password" name="newPassword" class="form-control" id="inputPassword1" placeholder="Password">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword2" class="col-sm-4 control-label">Confirm Password</label>
               <div class="col-sm-8">
                  <input type="password" name="confirmPassword" class="form-control" id="inputPassword2" placeholder="Password">
              </div>
            </div>
            <br>
            
            <div class="form-group">
              <div class="col-sm-offset-4 col-sm-8">
                  <button type="submit" name="action" value="Change" class="btn btn-primary">Change Password</button>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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