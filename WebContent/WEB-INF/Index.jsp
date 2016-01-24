<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-head.jsp" />
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<img src="mutual_funds.jpg" alt="mutual fund" style="width:650px;height:500px;"/>
			</div>
			<div class="col-md-1"></div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-2">
				<button type="button" class="btn btn-primary btn-lg btn-block" onclick="location.href='EmployeeLogin.do'">Login as Employee</button>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">
				<button type="button" class="btn btn-primary btn-lg btn-block" onclick="location.href='CustomerLogin.do'">Login as Customer</button>
			</div>
			<div class="col-md-6"></div>
		</div>
<jsp:include page="template-bottom.jsp" />