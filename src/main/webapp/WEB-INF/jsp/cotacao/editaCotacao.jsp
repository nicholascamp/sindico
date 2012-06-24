<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<form:form commandName="cotacao" action="/editaCotacao" method="POST">
		<table>
			<tr>
				<td>Subcategoria:</td>
				<td><form:checkboxes items="${subcategorias }" path="subcategoria"
				itemLabel="title" itemValue="id"/></td>
			</tr>
			<tr>
				<td colspan="2">Descrição:</td>				
			</tr>
			<tr>
				<td colspan="2"><form:textarea path="titulo" value="${cotacao.titulo }" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button value="Criar">Criar</form:button> </td>
			</tr>
		</table>	
	</form:form>	