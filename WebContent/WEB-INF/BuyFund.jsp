<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-head.jsp" />
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
	  				<li role="presentation"><a href="ViewAccount.do">Manage Account</a></li>
	  				<li role="presentation" class="active"><a href="BuyFund.do">Buy Fund</a></li>
	  				<!-- <li role="presentation"><a href="ViewSelfTransactionHistory.do">Transaction History</a></li> -->
	  				<li role="presentation"><a href="ResearchFund.do">Research Fund</a></li>
	  				<!-- <li role="presentation"><a href="RequestCheck.do">Request Check</a></li> -->
	  				<li role="presentation"><a href="CustomerLogout.do">Log Out</a></li>
	  			</c:otherwise>
  				</c:choose>
  			</ul>
  			</div>
			
			<div class="col-md-5">
				<br>
				<br>
				<div class="col-sm-1"></div>
        <div class="col-sm-11">
					<div class="header"><h3>Buy Fund</div>
        </div>
				<br>
				<br>
				<br>
        <br>
				
				<form class="form-horizontal" action="BuyFund.do" method="POST">
  					<div class="form-group">
    					<label for="symbol" class="col-sm-4 control-label">Fund Symbol</label>
    					<div class="col-sm-8">
      						<input type="text" name="fundsymbol" class="form-control" id="symbol" placeholder="Required">
    					</div>
  					</div>
  					<div class="form-group">
              <label for="amount" class="col-sm-4 control-label">Dollar Amount</label>
               <div class="col-sm-8">
                  <input type="text" name="money" class="form-control" id="amount" placeholder="Required">
              </div>
            </div>
  					<div class="form-group">
    					<div class="col-sm-offset-4 col-sm-8">
      						<button type="submit" name="action" value="BuyFund" class="btn btn-primary">Confirm Purchase</button>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="submit" class="btn btn-default">Cancel</button>
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
			<div class="col-md-3"></div>
			<div class="col-md-1"></div>
		</div>
<jsp:include page="template-bottom.jsp" />