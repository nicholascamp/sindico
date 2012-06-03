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

		<title>Sindico.com</title>
	</head>
	<body>
		<h1>SUBCATEGORIAS</h1>
		<div>
			
		</div>
		<div>
			<table style="margin: 10px;">
				<tr>
					<th>Título</th>
					<th>Categoria</th>
					<th>Consultar</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:if test="${! empty subcategorias}">
					<c:forEach items="${subcategorias }" var="subcategoria">
						<tr>
							<td>${subcategoria.title }</td>
							<td>${subcategoria.categoria.nome }</td>
							<td>
								<c:url value="/subcategoria/mostra" var="Consultar">
									<c:param name="id" value="${subcategoria.codigo}" />
								</c:url>
								<a href="${Consultar}" title="Consulta Subcategoria">Consultar</a>
							</td>
							<td>
								<c:url value="/subcategoria/edita"  var="Editar">
									<c:param name="id" value="${subcategoria.codigo}" />
								</c:url>
								<a href="${Editar}" title="Editar Subcategoria">Editar</a>
							</td>
							<td>
								<c:url value="/subcategoria/deleta" var="Deletar" >
									<c:param name="id" value="${subcategoria.codigo}" />
								</c:url>
								<a href="${Deletar}" title="Deletar Subcategoria">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<c:if test="${empty subcategorias}">
				<p>Nenhuma subcategoria encontrada</p>
			</c:if>
		</div>
		<div>
			<a href="/sindico/subcategoria/cria" title="Criar Categoria">Nova Subcategoria</a>
		</div>
	</body>
</html>