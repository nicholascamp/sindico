<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>EDITA SUBCATEGORIA</h1>
		<form:form commandName="subcategoria" method="POST" action="/sindico/editaSubcategoria">
			<input type="hidden" name="codigo" value="${subcategoria.codigo}" />
			<table>
				<tr>
					<td>Nome: </td>
					<td><form:input path="title" value="${subcategoria.title }" size="50"/> </td>					
				</tr>
				<tr>
					<td>Categoria:</td>
					<td><form:select path="categoria">
						<form:options items="${categorias }" itemValue="codigo" itemLabel="nome"/>
					</form:select></td>
				</tr>
				<tr>
					<td>
						<form:button value="Editar">Editar</form:button>
					</td>
				</tr>
			</table>
		</form:form>