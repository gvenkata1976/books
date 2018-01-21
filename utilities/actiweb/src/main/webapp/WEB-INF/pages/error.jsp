<%@ page isErrorPage="true"%> 
<%@ include file="/WEB-INF/pages/includes.jsp"%> 
<body>
	<br /> 
	<%@ include file="/WEB-INF/pages/header.jsp"%>
	<div class="ui-widget">
		<h2>Error Page</h2>
		<%
			String message = "";
			if(exception!=null){
				//message = ExceptionUtils.getStackTrace(exception);
				message = exception.getMessage();
				exception.printStackTrace(); 
			}
		%>
		<div class="ui-state-error">
			<table width="100%" border="1">
				<tr valign="top">
					<td width="10%"><b>Error:</b></td>
					<td>${pageContext.exception}</td>
				</tr>
				<tr valign="top">
					<td><b>URI:</b></td>
					<td>${pageContext.errorData.requestURI}</td>
				</tr>
				<tr valign="top">
					<td><b>Status code:</b></td>
					<td>${pageContext.errorData.statusCode}</td>
				</tr>
				<tr valign="top">
					<td><b>Stack trace:</b></td>
					<td><c:forEach var="trace"
							items="${pageContext.exception.stackTrace}">
							<p>${trace}</p>
							<br/><p><%=message %></p>
						</c:forEach></td>
				</tr>
			</table>
		</div>
		<br/> 
		<br/> <a href="${pageContext.servletContext.contextPath}/">Home
			Page</a>
	</div>
</body>
</html>