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
  				<li role="presentation" class="active"><a href="ViewCustomerAccount.do">Manage Customer Account</a></li>
  				<!-- <li role="presentation"><a href="#">View Customer Transaction History</a></li>
  				<li role="presentation"><a href="DepositCheck.do">Deposit Check</a></li> -->
  				<li role="presentation"><a href="CreateFund.do">Create Fund</a></li>
  				<li role="presentation"><a href="Date.do">Transition Day</a></li>
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
					<div class="header"><h3>View Fund Information</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				
			<table width="100%" class="favoritetable table-bordered table-hover">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<tr class="title">
				<td>Fund Ticker</td>
				<td>Fund Name</td>
				<td>Shares</td>
				<td>Shares to Sell</td>
				<td>Operation</td>
			</tr>
				<c:forEach var="fund" items="${fundInfo}">
           		<tr>
        			<td>
        				<span style="text-align:center">
        					<input type="hidden" name="fundid" value=${ fund.fundid }>
        					${ fund.ticker }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:center">
        					${ fund.fundname } 
        				</span>
                    </td>
                    <td>
        				<span style="text-align:center">
        					${ fund.share }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:center">
        					<input type="text" name="shareSell" value="" />
        				</span>
                    </td>
                    <td>
        				<form action="SellFund.do" method="POST">
                			<input type="hidden" name="sellFund" value="${ customer.cid }" />
                			<input type="submit" name="button" value="Sell" />
           				</form>
                    </td>
   				</tr>
   				
			</c:forEach>
			
			</table>
				
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
