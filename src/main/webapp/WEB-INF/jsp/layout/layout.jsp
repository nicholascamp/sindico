<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
		<script type="text/javascript" src="/sindico/javascript/actions.js"></script>
		
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		
	</head>
	<body>
		<table border="1" style="border-collapse: collapse;" cellpadding="2" cellspacing="2" align="center" width="800">    
			<tbody>
				<tr>
	        		<td height="30" colspan="2"><tiles:insertAttribute name="header" /></td>
	   		 	</tr>
	    		<tr>
	        		<td width="150" height="450" valign="top">
	  					<tiles:insertAttribute name="navigation" />
	  				</td>
	        		<td valign="top" width="650">
	        			<tiles:insertAttribute name="body" />
	        		</td>
	        	</tr>
	        	<tr>
	        		<td height="30" colspan="2">
	        			<tiles:insertAttribute name="footer" />
	        		 </td>
	    		</tr>
			</tbody>
		</table>
	</body>
</html>