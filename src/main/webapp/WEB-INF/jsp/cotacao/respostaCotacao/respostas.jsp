<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>Resposta Cotações ${cotacao.id }</h1>
<div>
	<table style="margin: 10px;">
		<tr>
			<th>Código</th>
			<th>Consultar</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<c:if test="${! empty respostas}">
			<c:forEach items="${respostas }" var="resposta">
				<tr>
					<td>${resposta.id }</td>
					<td><c:url value="/mostraRespostaCotacao" var="Consultar">
							<c:param name="id" value="${resposta.id}" />
						</c:url> <a href="${Consultar}" title="Consulta Resposta">Consultar</a></td>
					<td><c:url value="/editaRespostaCotacao" var="Editar">
							<c:param name="id" value="${resposta.id}" />
						</c:url> <a href="${Editar}" title="Editar Resposta">Editar</a></td>
					<td><c:url value="/deletaRespostaCotacao" var="Deletar">
							<c:param name="id" value="${cotacao.id}" />
						</c:url> <a id="delete" href="javascript:deleteEntity('${Deletar }');"
						title="Deletar Resposta">Deletar</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:if test="${empty respostas}">
		<p>Nenhuma resposta encontrada</p>
	</c:if>
</div>
<div>
	<c:url value="/criaRespostaCotacao" var="Resposta">
		<c:param name="id" value="${cotacao.id }" />
	</c:url>
	<a href="${Resposta }" title="Dar Orçamento">Responder</a>
</div>