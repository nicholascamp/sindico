<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>Subcategoria ${subcategoria.title}</h1>
		<table style="margin: 10px;">
			<tr>
				<td>Categoria:</td>
				<td>${subcategoria.categoria.nome }</td>
			</tr>
		</table>
		<div>
			<a href="<c:url value='/listaSubcategorias'/>" title="Lista Subcategorias">Listar Subcategorias</a>
		</div>