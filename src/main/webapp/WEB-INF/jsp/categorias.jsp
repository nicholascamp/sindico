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
		<h1>CATEGORIAS</h1>
		<div>
		
		</div>
		<div>
			<table>
				<tr>
					<th>Nome</th>
					<th>Subcategorias</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:if test="${! empty categorias}">
					<c:forEach items="${categorias }" var="categoria">
						<tr>
							<td>${categoria.nome }</td>
							<!-- <td>
								<c:url value="/sindico/categoria/subcategorias" var="Subcategorias">
									<c:param name="codigo" value="${categoria.codigo}" />
								</c:url>
								<c:out value="Subcategorias" />
							</td>
							<td>
								<c:url value="/sindico/categoria/edita.html"  var="Editar">
									<c:param name="codigo" value="${categoria.codigo}" />
								</c:url>
								<c:out value="Editar" />
							</td>
							<td>
								<c:url value="/sindico/categoria/deleta.html" var="Deletar">
									<c:param name="codigo" value="${categoria.codigo}" />
								</c:url>
								<c:out value="Deletar" />
							</td> -->
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty categorias}">
					<tr>
						<td align="center">Nenhuma categoria encontrada</td>
					</tr>
				</c:if>
			</table>
		</div>
	</body>
</html>