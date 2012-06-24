<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form commandName="predio" method="PUT"
	action="/sindico/editaPredio">
	<table>
		<tr>
			<td>Nome:</td>
			<td><form:input path="nome" size="100" /></td>
		</tr>
		<tr>
			<td>CNPJ:</td>
			<td><form:input path="cnpj" size="100" /></td>
		</tr>
		<tr>
			<td>Endereço:</td>
			<td><form:input path="endereco" size="100" /></td>
		</tr>
		<tr>
			<td>Bairro:</td>
			<td><form:input path="bairro" size="100" /></td>
		</tr>
		<tr>
			<td>Cidade:</td>
			<td><form:input path="cidade" size="100" /></td>
		</tr>
		<tr>
			<td>Estado:</td>
			<td><form:select path="estado">
					<form:options items="${estados}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Numero:</td>
			<td><form:input path="numero" size="100" /></td>
		</tr>
		<tr>
			<td>CEP:</td>
			<td><form:input path="cep" size="100" /></td>
		</tr>
		<tr>
			<td>Nro. Aptos:</td>
			<td><form:input path="numeroApartamentos" size="100" /></td>
		</tr>
		<tr>
			<td>Tipo:</td>
			<td><form:select path="tipo">
					<form:options items="${tipos}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Gerente:</td>
			<td><form:select path="gerente">
					<form:options items="${gerentes}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Gerente recebe cotação?:</td>
			<td><form:checkbox path="gerenteRecebeCotacao" /></td>
		</tr>
	</table>
	<input type="submit" value="Atualizar Predio" />
</form:form>

<a href="<c:url value='/listaPredios' />">Cancelar</a>