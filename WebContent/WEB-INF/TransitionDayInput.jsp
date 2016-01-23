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
 				<li role="presentation"><a href="ChangeEmployeePassword.do">Change Password</a></li>
  				<li role="presentation"><a href="createEmployee.do">Create Employee Account</a></li>
  				<li role="presentation"><a href="CreateCustomer.do">Create Customer Account</a></li>
  				<!-- <li role="presentation"><a href="ChangeCustomerPassword.do">Reset Customer Password</a></li> -->
  				<li role="presentation"><a href="ViewCustomerAccount.do">Manage Customer Account</a></li>
  				<!-- <li role="presentation"><a href="#">View Customer Transaction History</a></li>
  				<li role="presentation"><a href="DepositCheck.do">Deposit Check</a></li> -->
  				<li role="presentation"><a href="CreateFund.do">Create Fund</a></li>
  				<li role="presentation" class="active"><a href="TransitionDay.do">Transition Day</a></li>
  				<li role="presentation"><a href="EmployeeLogout.do">Log Out</a></li>
  			</c:otherwise>
  			</c:choose>
  			
  			</ul>
  			</div>
			
			<div class="col-md-6">
				<br>
				<br>
				<br>
				<div class="col-sm-1"></div>
				<div class="col-sm-11">
					<div class="header"><h3>Transition Day Input</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<form class="form-horizontal" action="TransitionDay.do" method="POST">	
				<table width="100%" class="favoritetable">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<tr class="title">
						<td>Fund Id</td>
						<td>Fund Ticker</td>
						<td>Fund Name</td>
						<td>Price</td>
					</tr>
				
					<c:forEach var="fund" items="${fundList}">
           			<tr>
        				<td>
        					<span style="text-align:left">
        					 	<input type="hidden" name="fundid" value=${ fund.fundid }>	
        					</span>
                    	</td>
                    	<td>
        					<span style="text-align:left">
        						${ fund.ticker }
        					</span>
                    	</td>
                    	<td>
        					<span style="text-align:left">
        						${ fund.fundName }        				
        					</span>
                    	</td>
                    	<td>
        					<span style="text-align:left">
        						<input type="text" name="price" value="${ fund.price }" />
        					</span>
                    	</td>  
   					</tr>
					</c:forEach>
				</table>
  				<div class="form-group">
    				<div class="col-sm-offset-4 col-sm-8">
      					<button type="submit" class="btn btn-primary" name = "action" value="InputFund">Confirm Input Price</button>
      					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      					<button type="submit" class="btn btn-default">Cancel</button>
    				</div>
  				</div>
			</form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>