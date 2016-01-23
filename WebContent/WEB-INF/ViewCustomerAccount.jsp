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
  				<li role="presentation"><a href="#">Transition Day</a></li>
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
					<div class="header"><h3>View Customer Account</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				
			<form class="navbar-form navbar-left" role="search" action="ViewCustomerAccountSearch.do" method="POST">  			
  			<div class="form-group">
   			 <input type="text" class="form-control" placeholder="Search by User Name" name = "username">
  			</div>
  			<button type="submit" class="btn btn-default">Submit</button>
			</form>
			
			<table width="100%" class="favoritetable table-bordered table-hover table-responsive">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<col width="12.5%">
			<tr class="title">
				<td>Username</td>
				<td>Name</td>
				<td>Address</td>
				<td>Cash</td>
				<td>Fund Info</td>
				<td>Reset Password</td>
				<td>Deposit Check</td>
				<td>Transaction History</td>
			</tr>
				
				<c:set var="count" value="0" />
				<c:forEach var="customer" items="${customerList}">
				<c:set var="count" value="${ count+1 }" />

           		<tr class>
 
        			<td>
        				<span style="text-align:left" >
        					${ customer.username }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left;">
        					${ customer.firstname } ${ customer.lastname }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					${ customer.addrline1 } ${ customer.addrline2 } ${ customer.city } ${ customer.state }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					${ customer.cash }
        				</span>
                    </td>
                    <td>
        				<form action="CustomerSellFund.do" method="POST">
                			<input type="hidden" name="customerSellFund" value="${ customer.cid }" />
                			<input type="submit" name="button" value="Reset" />
           				</form>
                    </td>
                    <td>
			            <form action="ChangeCustomerPassword.do" method="POST">
                			<input type="hidden" name="resetpwdusername" value="${ customer.username }" />
                			<input type="submit" name="button" value="Reset" />
           				</form>
        			</td>
                    <td>
        				<form action="DepositCheck.do" method="POST">
                			<input type="hidden" name="depositcheckcid" value="${ customer.cid }" />
                			<input type="submit" name="button" value="Deposit" />
           				</form>
                    </td>
                    <td>
        				<form action="ViewTransactionHistory.do" method="POST">
                			<input type="hidden" name="viewtransactionhistorycid" value="${ customer.cid }" />
                			<input type="submit" name="button" value="View" />
           				</form>
                    </td>
   				</tr>
   				
			</c:forEach>
			
			<c:forEach var="error" items="${errors}">   
			<div id="errormsg"> ${error} </div>
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
