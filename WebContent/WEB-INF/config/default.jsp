<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.myprojects.web.dao.entity.ProjectSearch" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:set var="root" scope="session" value="${pageContext.request.contextPath}"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="project tracking blog" />
<meta name="description" content="This site is about tracking, recording and sharing project activity." />
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
<link href="${root}/static/css/project.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="${root}/static/images/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/static/images/favicon.ico" type="image/x-icon">
<script type="text/javascript" src="${root}/static/script/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${root}/static/script/myproject.js"></script>
<tiles:insertAttribute name="includes"></tiles:insertAttribute>
</head>

<%
	// Pass in a ProjectSearch object for the search bar from in the header
	request.setAttribute("projectSearch", new ProjectSearch());
%>

<body>

<div class="header">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>

<div class="content">
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>

<br />

<div id="footerbackgroundcolorfade">
<hr />

<div class="footer">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</div>

</body>
</html>
