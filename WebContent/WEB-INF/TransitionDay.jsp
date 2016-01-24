<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-head.jsp" />
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
  				<li role="presentation"><a href="Date.do">Transition Day</a></li>
  				<li role="presentation"><a href="EmployeeLogout.do">Log Out</a></li>
  			</c:otherwise>
  			</c:choose>
  			
  			</ul>
  			</div>
  			
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<br>
				<br>
				<div class="header"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Transition Day</div>
				<br>
				<br>
				<form class="form-horizontal" action="Date.do" method="POST">
  					<div class="form-group">
    					<label for="date" class="col-sm-4 control-label">Choose Date of Transition Day</label>
   						 <div class="col-sm-8">
      						<input type="Date" name="pricedate" value="" class="form-control" id="date" placeholder="mm/dd/yyyy">
   						</div>
  					</div>
  					
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" name="action" value="Transit" class="btn btn-primary">Confirm Date</button>
      						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      						<button type="reset"  class="btn btn-default">Reset</button>
    					</div>
  					</div>
  					<div class="form-group">
  						<div class="col-sm-4"></div>
  						<div class="col-sm-8">
  							<c:forEach var="error" items="${errors}">   
			   		 			<font color="red"><div id="errormsg"> ${error} </div></font> 	
							</c:forEach>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
		</div>
<jsp:include page="template-bottom.jsp" />