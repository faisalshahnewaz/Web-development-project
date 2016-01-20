<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Carnegie Financial Services</title>
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
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>