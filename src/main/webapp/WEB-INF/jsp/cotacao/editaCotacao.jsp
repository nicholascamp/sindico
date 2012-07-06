<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form commandName="cotacao" action="/sindico/editaCotacao"
	method="POST">
	<input type="hidden" name="id" value="${cotacao.id }" />
	<c:if test="${ !empty cotacao.gerenteAdmin }">
		<input type="hidden" name="gerenteAdmin" value="${cotacao.gerenteAdmin.id }" />
	</c:if>	
	<table>
		<tr>
			<td>Usuário:</td>
			<td>
				<input type="hidden" name="usuario" value="${cotacao.usuario.id }" />
				<label>${cotacao.usuario.nome } </label>
			</td>
		</tr>
		<tr>
			<td>Subcategoria:</td>
			<td>
				<input type="hidden" name="subcategoria" value="${cotacao.subcategoria.id }" />
				<label>${cotacao.subcategoria.title }</label>
			</td>
		</tr>
		<tr>
			<td>Fornecedores:</td>
			<td>
				<form:select path="fornecedores" multiple="true" size="10" enabled="false">
					<form:options items="${cotacao.fornecedores }" itemLabel="nome" itemValue="id" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>
				<input type="hidden" name="status" value="${ cotacao.status }" />
				<label>${cotacao.status }</label>
			</td>
		</tr>
		<tr>
			<td colspan="2">Descrição:</td>
		</tr>
		<tr>
			<td colspan="2"><form:textarea path="titulo"
					value="${cotacao.titulo }" /></td>
		</tr>
		<tr>
			<td>Imprópria:</td>
			<td><form:checkbox path="impropria"
					value="${cotacao.impropria }" /></td>
		</tr>
		<tr>
			<td colspan="2"><form:button value="Editar">Editar</form:button></td>
		</tr>
	</table>
</form:form>
