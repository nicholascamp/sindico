<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>Resposta Cotação</h3>
<form:form commandName="resposta" method="POST" action="/sindico/editaRespostaCotacao">>
	<input type="hidden" name="id" value="${resposta.id }" />
	<table>
		<tr>
			<td>Cotação:</td>
			<td>
				<input type="hidden" name="predio" value="${resposta.predio.id }">
				<c:if test="${ ! empty resposta.fornecedor }">
					<input type="hidden" name="fornecedor" value="${resposta.fornecedor.id }">
				</c:if>
				<input type="hidden" name="cotacao" value="${resposta.cotacao.id }" />
				<label>${resposta.cotacao.id }</label>
			</td>
		</tr>
		<tr>
			<td>Valor:</td>
			<td><form:input path="valor" value="${resposta.valor}"/></td>
		</tr>
		<tr>
			<td>Condição:</td>
			<td><form:input path="condicao" value="${resposta.condicao}"/></td>
		</tr>
		<tr>
			<td>Garantia:</td>
			<td><form:input path="garantia" value="${resposta.garantia}"/></td>
		</tr>
		<tr>
			<td>Prazo:</td>
			<td><form:input path="prazo" value="${resposta.prazo}"/></td>
		</tr>
		<tr>
			<td>Primeira Parcela para:</td>
			<td><form:input path="parcelaPara" value="${resposta.parcelaPara}" /></td>
		</tr>
		<tr>
			<td>Descrição Proposta:</td>
			<td><form:textarea path="resposta" value="${resposta.resposta}"/></td>
		</tr>
		<tr>
			<td>Arquivo Foto:</td>
			<td>FAZER</td>
		</tr>		
	</table>
	<form:button>Atualizar</form:button>
</form:form>