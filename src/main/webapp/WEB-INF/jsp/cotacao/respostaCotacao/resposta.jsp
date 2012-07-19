<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>Resposta Cotação</h3>
<div>
	<table>
		<tr>
			<td>Cotação:</td>
			<td>${resposta.cotacao.id }</td>
		</tr>
		<c:if test="${ ! empty resposta.fornecedor }">
			<tr>
				<td>Fornecedor:</td>
				<td>${resposta.fornecedor.nome }</td>
			</tr>
		</c:if>
		<tr>
			<td>Prédio:</td>
			<td></td>
		</tr>		
		<tr>
			<td>Valor:</td>
			<td>${resposta.valor }</td>
		</tr>
		<tr>
			<td>Condição:</td>
			<td>${resposta.condicao }</td>
		</tr>
		<tr>
			<td>Garantia:</td>
			<td>${resposta.garantia } ano(s)</td>
		</tr>
		<tr>
			<td>Prazo:</td>
			<td>${resposta.prazo }</td>
		</tr>
		<tr>
			<td>Primeira Parcela para:</td>
			<td>${resposta.parcelaPara } dia(s)</td>
		</tr>
		<tr>
			<td>Arquivo Foto:</td>
			<td>FAZER</td>
		</tr>
	</table>
	
</div>