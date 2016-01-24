<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-head.jsp" />
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-2">

		<ul class="nav nav-pills nav-stacked">

			<c:choose>
				<c:when test="${customer == null}">
					<li role="presentation" class="active"><a
						href="CustomerLogin.do">Login</a></li>
				</c:when>
				<c:otherwise>
					<!-- <li role="presentation"><a href="ChangePassword.do">Change Password</a></li> -->
					<li role="presentation" class="active"><a
						href="ViewAccount.do">Manage Account</a></li>
					<li role="presentation"><a href="BuyFund.do">Buy Fund</a></li>
					<!-- <li role="presentation"><a href="ViewSelfTransactionHistory.do">Transaction History</a></li> -->
					<li role="presentation"><a href="ResearchFund.do">Research
							Fund</a></li>
					<!-- <li role="presentation"><a href="RequestCheck.do">Request Check</a></li> -->
					<li role="presentation"><a href="CustomerLogout.do">Log
							Out</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<div class="col-md-6">
		<br> <br>
		<div class="col-sm-1"></div>
		<div class="col-sm-11">
			<div class="header">
				<h3>Manage Account
			</div>
			<h5>Note: The last trading date was ${Date }</h5>
			<table width="100%"
				class="table table-bordered table-hover table-responsive">
				<%-- 				<col width="10%"> --%>
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<col width="12.5%">
				<tr class="title">
					<!-- 				<td>Number</td> -->
					<td>Username</td>
					<td>Name</td>
					<td>Address</td>
					<td>Cash</td>
					<td>Fund Info</td>
					<td>Change Password</td>
					<td>Request Check</td>
					<td>Transaction History</td>
				</tr>
				<tr>
					<td><span style="text-align: left"> ${ customer.username }
					</span></td>
					<td><span style="text-align: left"> ${ customer.firstname }
							${ customer.lastname } </span></td>
					<td><span style="text-align: left"> ${ customer.addrline1 }
							${ customer.addrline2 } ${ customer.city } ${ customer.state } </span></td>
					<td><span style="text-align: left"> ${ customer.cash }
					</span></td>
					<td>
						<form action="FundInfo.do" method="POST">
							<input type="hidden" name="sellFund" value="${ customer.cid }" />
							<input type="submit" name="action" value="View" />
						</form>
					</td>
					<td>
						<form action="ChangePassword.do" method="POST">
							<input type="hidden" name="changepwdusername"
								value="${ customer.username }" /> <input type="submit"
								name="button" value="Change" />
						</form>
					</td>
					<td>
						<form action="RequestCheck.do" method="POST">
							<input type="hidden" name="requestcheckcid"
								value="${ customer.cid }" /> <input type="submit" name="button"
								value="Request" />
						</form>
					</td>
					<td>
						<form action="ViewSelfTransactionHistory.do" method="POST">
							<input type="hidden" name="viewselftransactionhistorycid"
								value="${ customer.cid }" /> <input type="submit" name="button"
								value="View" />
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="col-md-2"></div>
	<div class="col-md-1"></div>
</div>
<jsp:include page="template-bottom.jsp" />