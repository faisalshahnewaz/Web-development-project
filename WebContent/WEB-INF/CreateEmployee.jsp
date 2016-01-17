<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template-head.jsp" />
    
<jsp:include page="template-navbar.jsp" />
    
		<div id="mainPanel">
			<form action="createEmployee.do" method="POST">
				<div id="welcome">
						<span id="welcome-text">Create Employee</span>								
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
				            <td style="font-size: large">First Name:</td>
				            <td><input type="text" name="firstname" value="${form.firstname}" class="form-input"/></td>
				        </tr>
				        <tr>
				            <td style="font-size: large">Last Name:</td>
				            <td><input type="text" name="lastname" value="${form.lastname}" class="form-input"/></td>
				        </tr>
				        <tr>
				            <td style="font-size: large">Password:</td>
				            <td><input type="password" name="password" class="form-input"/></td>
				        </tr>
				        <tr>
				            <td style="font-size: large">Confirm Password:</td>
				            <td><input type="password" name="confirm" class="form-input"/></td>
				        </tr>
				        <tr>
				            <td colspan="2" style="text-align: center;">
				                <input type="submit" name="action" value="Create" class="btn" />
				            </td>
				        </tr>
				        <tr> <td colspan="2"> <hr /> </td> </tr>
			        </table>
			    </div>  
			   
				<c:forEach var="error" items="${errors}">   
			   		 <div id="errormsg"> ${error} </div>
				</c:forEach>

			</form>
		</div>

<jsp:include page="template-bottom.jsp" />