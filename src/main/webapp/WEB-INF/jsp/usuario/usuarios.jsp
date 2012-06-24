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
<script type="text/javascript" src="/sindico/javascript/actions.js"></script>

<title>Sindico.com</title>
</head>
<body>
	<h1>USUARIOS</h1>
	<div>
		<br>
		<form:form action="/sindico/listaUsuariosPorNome" method="GET"
			commandName="usuario">
				Buscar Por Nome: <form:input path="nome" />
			<input type="submit" value="Buscar Usuarios" />
		</form:form>
		<br>
		<form:form action="/sindico/listaUsuariosPorEmail" method="GET"
			commandName="usuario">
				Buscar Por Email: <form:input path="email" />
			<input type="submit" value="Buscar Usuarios" />
		</form:form>
		<br>
	</div>
	<div>
		<table style="margin: 10px;">
			<tr>
				<th>Nome</th>
				<th>Consultar</th>
				<th>Editar</th>
			</tr>
			<c:if test="${! empty usuarios}">
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td><c:url value="/mostraUsuario" var="Consultar">
								<c:param name="id" value="${usuario.id}" />
							</c:url> <a href="${Consultar}" title="Consulta Usuario">Consultar</a>
						</td>
						<td><c:url value="/usuario/admin" var="Admin" >
								<c:param name="id" value="${usuario.id}" />
								<c:param name="admin" value="${! usuario.admin}" />
							</c:url> <c:if test="${usuario.admin == false}">
							<a href="${Admin}"  title="Tornar Admin">Tornar Admin</a>
							</c:if>  <c:if test="${usuario.admin == true}">
							<a href="${Admin}" title="Retirar Admin">Retirar Admin</a>
							</c:if> </td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${empty usuarios}">
			<p>Nenhum usuario encontrado</p>
		</c:if>
	</div>
	<div>
		<a href="/sindico/cadastro" title="Criar usuario">Novo
			Usuario</a>
	</div>
</body>
</html>