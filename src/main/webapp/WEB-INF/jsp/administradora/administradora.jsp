<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	</head>
	<body>
		<h1>Administradora ${administradora.nome }</h1>
		<table>
			<tr>
				<td>CNPJ:</td>
				<td>${administradora.cnpj } </td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td>${administradora.telefone }</td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td>${administradora.celular }</td>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan="2">Endereço:</td>
			</tr>
			<tr>
				<td>Rua:</td>
				<td>${administradora.endereco }</td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td>${administradora.bairro }</td>
			</tr>
			<tr>
				<td>Número:</td>
				<td>${administradora.numero }</td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td>${administradora.cep }</td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td>${administradora.cidade}</td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td>${administradora.estado }</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Telefone</td>
				<td>Celular</td>
			</tr>
			<c:forEach items="${administradora.gerentes }" var="gerente">
				<tr>
					<td>${gerente.nome }</td>
					<td>${gerente.email }</td>
					<td>${gerente.telefone }</td>
					<td>${gerente.celular }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<c:url value='/listaAdministradoras' />" title="Listar Administradora">Listar Administradoras</a>
	</body>
</html>