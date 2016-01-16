<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template-head.jsp" />
    
<jsp:include page="template-navbar.jsp" />

		<div id="mainPanel">
			<form action="login.do" method="POST">
				<div id="welcome">
						<span id="welcome-text">User Login</span>								
				</div>
				<div>
			    	<table class="centertable">
			    		<tr> <td colspan="2"> <hr /> </td> </tr>
				        <tr>
				            <td style="font-size: large">Username:</td>
				            <td>
				                <input type="text" name="username" value="${form.username}" class="form-input"/>
				            </td>
				        </tr>
				        <tr>
				            <td style="font-size: large">Password:</td>
				            <td><input type="password" name="password" class="form-input"/></td>
				        </tr>
				        <tr>
				            <td colspan="2" style="text-align: center;">
				                <input type="submit" name="action" value="Login" class="btn" />
				            </td>
				        </tr>
				        <tr> <td colspan="2"> <hr /> </td> </tr>
				        <tr>
				            <td colspan="2" style="text-align: center;">
				                <a href= "create.do">Forget Username or Password?</a>
				            </td>
				        </tr>    
			        </table>
			    </div>  
			   
				<c:forEach var="error" items="${errors}">   
			   		 <div id="errormsg"> ${error} </div>
				</c:forEach>

			</form>
		</div>
<jsp:include page="template-bottom.jsp" />