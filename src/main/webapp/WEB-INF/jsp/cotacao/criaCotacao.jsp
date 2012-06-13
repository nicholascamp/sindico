<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

	<title>Sindico.com</title>
</head>
<body>
	<form:form commandName="cotacao" action="cria" method="POST">
		<table>
			<tr>
				<td>Subcategoria:</td>
				<td>
					<form:select path="subcategoria">
						<form:options items="${subcategorias }" itemLabel="title" itemValue="codigo" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">Descrição:</td>				
			</tr>
			<tr>
				<td colspan="2"><form:textarea path="titulo"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:button value="Criar">Criar</form:button> </td>
			</tr>
		</table>	
	</form:form>	
</body>
</html>