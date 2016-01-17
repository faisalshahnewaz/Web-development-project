<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template-head.jsp" />
    
<jsp:include page="template-navbar.jsp" />
 
		<div id="mainPanel">
			<form action="ChangeEmployeePassword.do" method="POST">
				<div id="welcome">
						<span id="welcome-text">Change Employee Password</span>								
				</div>
				<div>
			    	<table class="centertable">
			    		<tr> <td colspan="2"> <hr /> </td> </tr>
				        <tr>
				            <td style="font-size: large">User name:</td>
				            <td>
				                <input type="text" name="username" value="" class="form-input"/>
				            </td>
				        </tr>
				        <tr>
				            <td style="font-size: large">Old Password:</td>
				            <td>
				                <input type="password" name="oldPassword" value="" class="form-input"/>
				            </td>
				        </tr>
				        <tr>
				            <td style="font-size: large">New Password:</td>
				            <td><input type="password" name="newPassword" value="" class="form-input"/></td>
				        </tr>
				        <tr>
				            <td colspan="2" style="text-align: center;">
				                <input type="submit" name="action" value="Change" class="btn" />
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