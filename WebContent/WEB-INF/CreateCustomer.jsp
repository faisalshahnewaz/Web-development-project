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
 				<li role="presentation"><a href="ChangeEmployeePassword.do">Change Password</a></li>
  				<li role="presentation"><a href="createEmployee.do">Create Employee Account</a></li>
  				<li role="presentation" class="active"><a href="CreateCustomer.do">Create Customer Account</a></li>
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
			
			<div class="col-md-6">
				<div class="col-sm-1"></div>
				<div class="col-sm-11">
					<div class="header"><h3>Create Customer Account</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<form class="form-horizontal" action="CreateCustomer.do" method="POST">
					<div class="form-group">
    					<label for="username" class="col-sm-4 control-label">User Name</label>
    					<div class="col-sm-8">
      						<input type="text" name="username" class="form-control" id="username" placeholder="Required">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="firstname" class="col-sm-4 control-label">First Name</label>
    					<div class="col-sm-8">
      						<input type="text" name="firstname" class="form-control" id="firstname" placeholder="Required">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-4 control-label">Last Name</label>
    					<div class="col-sm-8">
      						<input type="text" name="lastname" class="form-control" id="lastname" placeholder="Required">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="inputPassword" class="col-sm-4 control-label">Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="password" class="form-control" id="inputPassword" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="inputPassword1" class="col-sm-4 control-label">Confirm Password</label>
   						 <div class="col-sm-8">
      						<input type="password" name="confirmpassword" class="form-control" id="inputPassword1" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="address1" class="col-sm-4 control-label">Address Line1</label>
   						 <div class="col-sm-8">
      						<input type="text" name="addrline1" class="form-control" id="address1" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="address2" class="col-sm-4 control-label">Address Line2</label>
   						 <div class="col-sm-8">
      						<input type="text" name="addrline2" class="form-control" id="address2" placeholder="Optional">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="city" class="col-sm-4 control-label">City</label>
   						 <div class="col-sm-8">
      						<input type="text" name="city" class="form-control" id="city" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="state" class="col-sm-4 control-label">State</label>
   						 <div class="col-sm-8">
      						<input type="text" class="form-control" id="state" name="state" placeholder="Required">
   						</div>
  					</div>
  					<div class="form-group">
    					<label for="cash" class="col-sm-4 control-label">Zip</label>
   						 <div class="col-sm-8">
      						<input type="text" class="form-control" name = "zip" id="zip" placeholder="Required">
   						</div>
  					</div>
  					
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" class="btn btn-primary">Confirm</button>
      						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      						<button type="reset" class="btn btn-default">Reset</button>
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