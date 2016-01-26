<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-head.jsp" />
		<!-- <div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<img src="mutual_funds.jpg" alt="mutual fund" style="width:650px;height:500px;"/>
			</div>
			<div class="col-md-1"></div>
		</div> -->
		<div id="ad-carousel" class="carousel slide" data-ride="carousel">
		    <ol class="carousel-indicators">
		        <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
		        <li data-target="#ad-carousel" data-slide-to="1"></li>
		        <li data-target="#ad-carousel" data-slide-to="2"></li>
		    </ol>
   		 <div class="carousel-inner">
		        <div class="item active">
		            <img src="mutualfundssign1.jpeg" alt="1 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <h1>Give Your Money a Chance to Grow</h1>
		
		                    <p>Investing in mutual funds offers benefits you won't get from trading individual stocks and bonds on your own.</p>
		                </div>
		            </div>
		        </div>
		        <div class="item">
		            <img src="WallStreetSign1.jpeg" alt="2 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <h1>A Strategic Way to Build Your Portfolio</h1>
		
		                    <p>Whether you're looking to diversify or simply add to your portfolio, you can do so on your term at Carnegie Financial Services.</p>
		                </div>
		            </div>
		        </div>
		        <div class="item">
		            <img src="headquarter1.jpeg" alt="3 slide">
		
		            <div class="container">
		                <div class="carousel-caption">
		                    <h1>Convenience and Professional Management</h1>
		
		                    <p>You can buy and sell mutual fund shares online or by phone and set up automatic investments and withdrawals.</p>
		                </div>
		            </div>
		        </div>
		    </div>
		    <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
		            class="glyphicon glyphicon-chevron-left"></span></a>
		    <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
		            class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-3">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='EmployeeLogin.do'">Login as Employee</button>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-3">
				<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='CustomerLogin.do'">Login as Customer</button>
			</div>
			<div class="col-md-2"></div>
		</div>
<jsp:include page="template-bottom.jsp" />