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
				<c:when test="${customer == null}">  
  					<li role="presentation" class="active"><a href="CustomerLogin.do">Login</a></li>
  				</c:when>
  				<c:otherwise>
	 				<!-- <li role="presentation"><a href="ChangePassword.do">Change Password</a></li> -->
	  				<li role="presentation" class="active"><a href="ViewAccount.do">Manage Account</a></li>
	  				<li role="presentation"><a href="BuyFund.do">Buy Fund</a></li>
	  				<li role="presentation"><a href="SellFund.do">Sell Fund</a></li>
	  				<!-- <li role="presentation"><a href="ViewSelfTransactionHistory.do">Transaction History</a></li> -->
	  				<li role="presentation"><a href="ResearchFund.do">Research Fund</a></li>
	  				<!-- <li role="presentation"><a href="RequestCheck.do">Request Check</a></li> -->
	  				<li role="presentation"><a href="CustomerLogout.do">Log Out</a></li>
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
					<div class="header"><h3>Transaction History</h3></div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				
			<table width="100%" class="favoritetable">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<tr class="title">
				<td>Number</td>
				<td>Type</td>
				<td>Fund Name</td>
				<td>Transaction Date</td>
				<td>Shares</td>
				<td>Amount</td>
				<td>Status</td>
			</tr>
				
				<c:set var="count" value="0" />
				<c:forEach var="transaction" items="${transactions}">
				<c:set var="count" value="${ count+1 }" />

           		<tr>
           			<td style="text-align:left"> ${ count } </td>
       				<td>
			            <span style="text-align:left">
        					${ transaction.transactiontype }
        				</span>
        			</td>
        			<td>
        				<span style="text-align:left">
        					<%-- Fund Name --%>
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					${ transaction.executedate }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					${ transaction.shares }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					${ transaction.amount / 1000.000}
        				</span>
                    </td>
   				</tr>
   				
			</c:forEach>
			
			</table>
				
				<!-- <form class="form-horizontal">
					<div class="form-group">
    					<label for="fundname" class="col-sm-4 control-label">Fund Name</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" id="fundname" name="fundName">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="ticker" class="col-sm-4 control-label">Ticker</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" id="ticker" name="ticker">
    					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" class="btn btn-primary" name = "action" value="CreateFund">Create</button>
      						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      						<button type="submit" class="btn btn-default">Cancel</button>
    					</div>
  					</div>
				</form> -->
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>