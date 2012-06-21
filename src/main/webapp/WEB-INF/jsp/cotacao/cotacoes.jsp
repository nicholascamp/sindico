<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>COTAÇÕES</h1>
		<div>
			<table style="margin: 10px;">
				<tr>
					<th>Código</th>
					<th>Consultar</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:if test="${! empty cotacoes}">
					<c:forEach items="${cotacoes }" var="cotacao">
						<tr>
							<td>${cotacao.codigo }</td>
							<td>
								<c:url value="/mostraCotacao" var="Consultar">
									<c:param name="id" value="${cotacao.codigo}" />
								</c:url>
								<a href="${Consultar}" title="Consulta Cotação">Consultar</a>
							</td>
							<td>
								<c:url value="/editaCotacao"  var="Editar">
									<c:param name="id" value="${cotacao.codigo}" />
								</c:url>
								<a href="${Editar}" title="Editar Cotação">Editar</a>
							</td>
							<td>
								<c:url value="/deletaCotacao" var="Deletar" >
									<c:param name="id" value="${cotacao.codigo}" />
								</c:url>
								<a id="delete" href="javascript:deleteEntity('${Deletar }');" title="Deletar Cotação">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<c:if test="${empty cotacoes}">
				<p>Nenhuma cotação encontrada</p>
			</c:if>
		</div>
		<div>
			<a href="<c:url value='/criaCotacao' />" title="Criar Cotação">Nova Cotação</a>
		</div>