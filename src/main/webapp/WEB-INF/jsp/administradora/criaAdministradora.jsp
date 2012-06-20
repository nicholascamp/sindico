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
	<form:form commandName="administradora" action="/sindico/criaAdministradora" method="POST">
		<table>
			<tr>
				<td>Nome:</td>
				<td><form:input path="nome"/></td>
			</tr>
			<tr>
				<td>CNPJ:</td>
				<td><form:input path="cnpj"/></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><form:input path="telefone"/></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><form:input path="celular"/></td>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan="2">Endereço:</td>
			</tr>
			<tr>
				<td>Rua:</td>
				<td><form:input path="endereco"/> </td>
			</tr>
			<tr>
				<td>Número:</td>
				<td><form:input path="numero"/> </td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td><form:input path="cep"/> </td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td><form:input path="bairro"/> </td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td><form:input path="cidade"/> </td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><form:input path="estado"/> </td>
			</tr>
			<tr>
				<td colspan="2"><form:button value="Criar">Criar</form:button> </td>
			</tr>
		</table>
	</form:form>	
</body>
</html>