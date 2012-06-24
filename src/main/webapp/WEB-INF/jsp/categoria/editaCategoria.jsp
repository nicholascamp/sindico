<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>EDITA CATEGORIA</h1>
<form:form commandName="categoria" method="POST" action="/sindico/categoria/editaCategoria">
	<input type="hidden" name="id" value="${categoria.id }" />
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome" value="${categoria.nome }" />
			</td>
		</tr>
		<tr>
				<td>Subcategorias:</td>
				<td><form:label items="${categoria.subcategorias }"
						path="subcategorias" itemLabel="title" itemValue="id" /></td>
			</tr>
		<tr>
			<td><form:button value="Editar">Editar</form:button></td>
		</tr>
	</table>
</form:form>