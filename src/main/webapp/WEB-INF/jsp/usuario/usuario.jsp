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
	<h1>Usuario ${usuario.nome}</h1>
	<table style="margin: 10px;">
		<tr>
			<td>Email:</td>
			<td>${usuario.email }</td>
		</tr>
		<tr>
			<td>Telefone:</td>
			<td>${usuario.telefone }</td>
		</tr>
		<tr>
			<td>Celular:</td>
			<td>${usuario.celular }</td>
		</tr>
		<tr>
			<td>Data de Nascimento:</td>
			<td>${usuario.dataNascimento }</td>
		</tr>
		<tr>
			<td>Data de cadastro:</td>
			<td>${usuario.dataCadastro }</td>
		</tr>
		<tr>
			<td>Tipo:</td>
			<td>${usuario.tipo}</td>
		</tr>
		<tr>
			<td>Admin:</td>
			<td><c:if test="${usuario.admin == true }">
					<input type="checkbox" disabled="disabled" checked />
				</c:if> <c:if test="${usuario.admin == false }">
					<input type="checkbox" disabled="disabled" />
				</c:if></td>
		</tr>
		<tr>
			<td>Qtdade cotações:</td>
			<td>${usuario.qtdadeCotacoes}</td>
		</tr>
	</table>
	<div>
		<a href="<c:url value='/listaUsuarios' />" title="Lista Usuarios">Listar
			Usuarios</a>
	</div>
</body>
</html>