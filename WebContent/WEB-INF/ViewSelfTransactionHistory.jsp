<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	  				<li role="presentation" class="active"><a href="ViewAccount.do">Manage Account</a></li>
	  				<li role="presentation"><a href="BuyFund.do">Buy Fund</a></li>
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
				
			<table width="100%" class="favoritetable table-bordered table-hover table-responsive">
			<col width="16.67%">
			<col width="16.67%">
			<col width="16.67%">
			<col width="16.67%">
			<col width="16.67%">
			<col width="16.67%">
			<tr class="title">
				<td><b>Number</b></td>
				<td><b>Type</b></td>
				<td><b>Fund Name</b></td>
				<td><b>Transaction Date</b></td>
				<td><b>Shares</b></td>
				<td><b>Amount</b></td>
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
        					${ transaction.fundname }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					${ transaction.executedate }
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					<fmt:formatNumber pattern="#,##0.000" value="${transaction.shares/1000}" maxFractionDigits="3"/>
        				</span>
                    </td>
                    <td>
        				<span style="text-align:left">
        					<fmt:formatNumber pattern="#,##0.00" value="${transaction.amount/100}" maxFractionDigits="2"/>
        				</span>
                    </td>
   				</tr>
   				
			</c:forEach>
			
			</table>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
		</div>
<jsp:include page="template-bottom.jsp" />
