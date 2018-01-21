<%@ include file="/WEB-INF/pages/includes.jsp"%>
<body> 
<%@ include file="/WEB-INF/pages/header.jsp"%>
<c:if test="${not empty msg}">
	<div class="fail"><c:out value="${msg}"/></div>
</c:if>
<div class="login">

<form:form method="post" commandName="user" action="${pageContext.servletContext.contextPath}/user/validate.htm">
<table class="login" >
<tr>
<th colspan=3>Login</th></tr>
<tr>
<td>User Name</td><td><form:input path="userName" /></td></tr><tr>
<td>Password </td><td><form:input path="password" /></td></tr><tr>
<td>&nbsp;</td><td><input type="submit" name="Submit" value="Submit">&nbsp;&nbsp;&nbsp;<a href="#">New User</a></td></tr>
</table>
</form:form></div>

</body>
</html>