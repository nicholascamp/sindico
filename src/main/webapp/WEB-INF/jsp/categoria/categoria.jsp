<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<h3>Categoria ${categoria.nome}</h3>

<p><strong>Subcategorias:</strong></p>
<table style="margin: 10px;">
	<c:forEach items="${categoria.subcategorias }" var="subcategoria">
		<tr>
			<td>${subcategoria.title }</td>
		</tr>
	</c:forEach>
</table>
<div>
	<a href="/sindico/listaCategorias" title="Lista Categorias">Listar
		Categorias</a>
</div>
