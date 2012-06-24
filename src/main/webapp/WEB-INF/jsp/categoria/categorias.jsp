<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>CATEGORIAS</h1>
<div>
	<table style="margin: 10px;">
		<tr>
			<th>Nome</th>
			<th>Consultar</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<c:if test="${! empty categorias}">
			<c:forEach items="${categorias }" var="categoria">
				<tr>
					<td>${categoria.nome }</td>
					<td><c:url value="/mostraCategoria" var="Consultar">
							<c:param name="id" value="${categoria.id}" />
						</c:url> <a href="${Consultar}" title="Consulta Categoria">Consultar</a></td>
					<td><c:url value="/editaCategoria" var="Editar">
							<c:param name="id" value="${categoria.id}" />
						</c:url> <a href="${Editar}" title="Editar Categoria">Editar</a></td>
					<td><c:url value="/deletaCategoria" var="Deletar">
							<c:param name="id" value="${categoria.id}" />
						</c:url> <a href="javascript:deleteEntity('${Deletar }');"
						title="Deletar Categoria">Deletar</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:if test="${empty categorias}">
		<p>Nenhuma categoria encontrada</p>
	</c:if>
</div>
<div>
	<a href="<c:url value="/criaCategoria"/>" title="Criar Categoria">Nova
		Categoria</a>
</div>