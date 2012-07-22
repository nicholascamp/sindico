<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${ ! empty respostas }">
	<table>
		<tr>
			<th>Valor</th>
			<th>Condição</th>
			<th>Garantia</th>
			<th>Prazo</th>
			<th>Primeira Parcela para</th>
			<th>Data</th>
			<th>Descrição Proposta</th>
		</tr>
		<c:forEach items="${respostas }" var="resposta">
			<tr>
				<td>${resposta.valor }</td>
				<td>${resposta.condicao }</td>
				<td>${resposta.garantia } ano(s)</td>
				<td>${resposta.prazo }</td>
				<td>${resposta.parcelaPara } dia(s)</td>
				<td>${resposta.data }</td>
				<td>${resposta.resposta }</td>				
			</tr>
		</c:forEach>
	</table>	
</c:if>
<br  />
<form:form action="/sindico/encerraCotacao" commandName="resposta" method="POST">
	<input type="hidden" name="idRespostaCotacao" value="${respostaUltima.id }" />
	<form:button>Encerrar Cotação</form:button>
</form:form>
<form:form action="/sindico/deletaCotacao" commandName="resposta" method="GET">
	<input type="hidden" name="id" value="${resposta.cotacao.id }" />
	<form:button>Destruir Cotação</form:button>
</form:form>
<br />
<h3>Responder:</h3>
<form:form action="/sindico/criaRespostaCotacao" commandName="resposta" method="POST">
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
			<td><form:textarea path="resposta"/></td>
		</tr>
		<tr>
			<td>Arquivo Foto:</td>
			<td>FAZER</td>
		</tr>		
	</table>
	<form:button>Criar</form:button>
</form:form>