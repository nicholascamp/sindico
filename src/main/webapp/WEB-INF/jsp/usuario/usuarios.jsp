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
		<form:form action="/sindico/usuario/lista/nome" method="GET"
			commandName="usuario">
				Buscar Por Nome: <form:input path="nome" />
			<input type="submit" value="Buscar Usuarios" />
		</form:form>
		<br>
		<form:form action="/sindico/usuario/lista/email" method="GET"
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
				<th>Deletar</th>
			</tr>
			<c:if test="${! empty usuarios}">
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td><c:url value="/usuario/mostra" var="Consultar">
								<c:param name="id" value="${usuario.id}" />
							</c:url> <a href="${Consultar}" title="Consulta Usuario">Consultar</a>
						</td>
						<td><c:url value="/usuario/edita" var="Editar">
								<c:param name="id" value="${usuario.id}" />
							</c:url> <a href="${Editar}" title="Editar Fornecedor">Editar</a></td>
						<td><c:url value="/usuario/deleta" var="Deletar">
								<c:param name="id" value="${usuario.id}" />
							</c:url> <a href="javascript:deleteEntity('${Deletar }');"
							title="Deletar Fornecedor">Deletar</a></td>
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