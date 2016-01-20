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
 				<li role="presentation"><a href="ChangeCustomerPassword.do">Change Password</a></li>
  				<li role="presentation"><a href="view_portfolio.html">View Portfolio</a></li>
  				<li role="presentation" class="active"><a href="BuyFund.do">Buy Fund</a></li>
  				<li role="presentation"><a href="sell_fund.html">Sell Fund</a></li>
  				<li role="presentation"><a href="transaction_history">Transaction History</a></li>
  				<li role="presentation"><a href="research.html">Research Fund</a></li>
  				<li role="presentation"><a href="request_check.html">Request Check</a></li>
  				<li role="presentation"><a href="index.html">Log Out</a></li>
  			</div>
			</ul>
			
			<div class="col-md-5">
				<br>
				<br>
				<div class="col-sm-1"></div>
        <div class="col-sm-11">
					<div class="header"><h3>Fund Purchase</div>
        </div>
				<br>
				<br>
				<br>
        <br>
				
				<form class="form-horizontal" action="BuyFund.do" method="POST">
  					<div class="form-group">
    					<label for="symbol" class="col-sm-4 control-label">Fund Symbol</label>
    					<div class="col-sm-8">
      						<input type="text" name="fundsymbol" class="form-control" id="symbol" placeholder="fund symbol">
    					</div>
  					</div>
  					<div class="form-group">
              <label for="amount" class="col-sm-4 control-label">Dollar Amount</label>
               <div class="col-sm-8">
                  <input type="text" name="money" class="form-control" id="amount" placeholder="dollar amount">
              </div>
            </div>
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" name="action" value="BuyFund" class="btn btn-primary">Confirm Purchase</button>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="submit" class="btn btn-default">Cancel</button>
    					</div>
  					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-1"></div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>