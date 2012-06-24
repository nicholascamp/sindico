<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<h3>GERENTE</h3>
	<div>
		<table style="margin: 10px;">
			<tr>
				<th>Nome</th>
				<th>Consultar</th>
				<th>Editar</th>
				<th>Deletar</th>
			</tr>
			<c:if test="${! empty gerentes}">
				<c:forEach items="${gerentes }" var="gerente">
					<tr>
						<td>${gerente.nome }</td>
						<td><c:url value="/mostraGerente" var="Consultar">
								<c:param name="id" value="${gerente.codigo}" />
							</c:url> <a href="${Consultar}" title="Consulta Gerente">Consultar</a>
						</td>
						<td><c:url value="/editaGerente" var="Editar">
								<c:param name="id" value="${gerente.codigo}" />
							</c:url> <a href="${Editar}" title="Editar Gerente">Editar</a></td>
						<td><c:url value="/deletaGerente" var="Deletar">
								<c:param name="id" value="${gerente.codigo}" />
							</c:url> <a href="javascript:deleteEntity('${Deletar }');"
							title="Deletar Gerente">Deletar</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${empty gerentes}">
			<p>Nenhum gerente encontrado</p>
		</c:if>
	</div>
	<div>
		<a href="<c:url value="/criaGerente" />" title="Criar gerente">Novo
			gerente</a>
	</div>