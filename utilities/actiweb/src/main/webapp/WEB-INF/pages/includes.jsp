<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,java.util.concurrent.Future, 
			java.io.File,
			java.util.List,
			java.util.ArrayList,
			java.util.Date,
			java.util.Calendar,
			java.util.List,
			com.actiweb.entities.Employee,
			com.actiweb.entities.Department,
			com.actiweb.entities.Location,
			com.actiweb.entities.Country,
			com.actiweb.entities.Region"%>
<%@page errorPage="/WEB-INF/pages/error.jsp"%>
<%--@page session="false"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tld/tab.tld"%>

<!DOCTYPE html>
<html>

<%
	long serverTime = System.currentTimeMillis();
%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${appTitle}</title>
<script>
	var contextPath = "${pageContext.servletContext.contextPath}";
</script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.11.4.custom/external/jquery/jquery.js?v=<%=serverTime%>"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.11.4.custom/jquery-ui.js?v=<%=serverTime%>"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/organization.js?v=<%=serverTime%>"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js?v=<%=serverTime%>"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.11.4.custom/jquery-ui.css?v=<%=serverTime%>" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/styles.css?v=<%=serverTime%>" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/menu.css?v=<%=serverTime%>" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css?v=<%=serverTime%>" />  
</head>