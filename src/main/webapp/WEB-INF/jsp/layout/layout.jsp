<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript" src="/sindico/javascript/actions.js"></script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div>
		<tiles:insertAttribute name="header" />
		<div>
			<tiles:insertAttribute name="navigation" />
			<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
		</div>

		<div>
			<tiles:insertAttribute name="body" />
		</div>

		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>