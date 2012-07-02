<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form commandName="resposta" method="POST">
	<table>
		<tr>
			<td>Cotação:</td>
			<td>
				<input type="hidden" name="cotacao" value="${resposta.cotacao.id }" />
				<label>${resposta.cotacao.id }</label>
			</td>
		</tr>
		<tr>
			<td>Fornecedor:</td>
			<td>
				<input type="hidden" name="fornecedor" value="${resposta.fornecedor.id }" />
				${resposta.fornecedor.nome }
			</td>
		</tr>
		<tr>
			<td>Valor:</td>
			<td><form:input path="valor"/></td>
		</tr>
		<tr>
			<td>Condição:</td>
			<td><form:input path="condicao"/></td>
		</tr>
		<tr>
			<td>Garantia:</td>
			<td><form:input path="garantia"/></td>
		</tr>
		<tr>
			<td>Prazo:</td>
			<td><form:input path="prazo"/></td>
		</tr>
		<tr>
			<td>Primeira Parcela para:</td>
			<td><form:input path="parcelaPara" /></td>
		</tr>
		<tr>
			<td>Descrição Proposta:</td>
			<td><form:textarea path="primeiraResposta"/></td>
		</tr>
		<tr>
			<td>Arquivo Foto:</td>
			<td>FAZER</td>
		</tr>
	</table>
</form:form>