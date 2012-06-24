<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<h1>FORNECEDORES</h1>
	<div>
		<br>
		<form:form action="/sindico/listaFornecedoresPorNome" method="GET"
			commandName="fornecedor">
				Buscar Por Nome: <form:input path="nome" />
			<input type="submit" value="Buscar Fornecedores" />
		</form:form>
		<br>
		<form:form action="/sindico/listaFornecedoresPorEndereco" method="GET"
			commandName="fornecedor">
				Buscar Por Endereco: <form:input path="endereco" />
			<input type="submit" value="Buscar Fornecedores" />
		</form:form>
		<br>
		<form:form action="/sindico/listaFornecedoresPorEmail" method="GET"
			commandName="fornecedor">
				Buscar Por Email: <form:input path="email" />
			<input type="submit" value="Buscar Fornecedores" />
		</form:form>
		<br>
		<form:form action="/sindico/listaFornecedoresPorCNPJ" method="GET"
			commandName="fornecedor">
				Buscar Por CNPJ: <form:input path="cnpj" />
			<input type="submit" value="Buscar Fornecedores" />
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
			<c:if test="${! empty fornecedores}">
				<c:forEach items="${fornecedores }" var="fornecedor">
					<tr>
						<td>${fornecedor.nome }</td>
						<td><c:url value="/mostraFornecedor" var="Consultar">
								<c:param name="id" value="${fornecedor.id}" />
							</c:url> <a href="${Consultar}" title="Consulta Fornecedor">Consultar</a>
						</td>
						<td><c:url value="/editaFornecedor" var="Editar">
								<c:param name="id" value="${fornecedor.id}" />
							</c:url> <a href="${Editar}" title="Editar Fornecedor">Editar</a></td>
						<td><c:url value="/deletaFornecedor" var="Deletar">
								<c:param name="id" value="${fornecedor.id}" />
							</c:url> <a href="javascript:deleteEntity('${Deletar }');"
							title="Deletar Fornecedor">Deletar</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${empty fornecedores}">
			<p>Nenhum fornecedor encontrado</p>
		</c:if>
	</div>
	<div>
		<a href="<c:url value="/criaFornecedor" />" title="Criar fornecedor">Novo
			Fornecedor</a>
	</div>