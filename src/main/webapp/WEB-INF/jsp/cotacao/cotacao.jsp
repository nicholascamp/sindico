<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<c:if test="${ ! empty msg }">
			<div>
				<p>${msg }</p>
			</div>
		</c:if>
		
		<h1>Cotação ${cotacao.id}</h1>
		<table style="margin: 10px;">		
			<tr>
				<td>Status:</td>
				<td>${cotacao.status }</td>
			</tr>
			<tr>
				<td>Impropria:</td>
				<td>${cotacao.impropria }</td>
			</tr>
			<tr>
				<td>Subcategoria:</td>
				<td>${cotacao.subcategoria }</td>
			</tr>
			<tr>
				<td>Usuário:</td>
				<c:if test="${! empty cotacao.usuario }">
					<td>${cotacao.usuario.nome }</td>
				</c:if>
				<c:if test="${empty cotacao.usuario }">
					<td>Sem usuário</td>
				</c:if>
			</tr>
			<tr>
				<td>Gerente Administradora:</td>
				<c:if test="${! empty cotacao.gerenteAdmin }">
					<td>${cotacao.gerenteAdmin }</td>
				</c:if>
				<c:if test="${empty cotacao.gerenteAdmin }">
					<td>Sem gerente</td>
				</c:if>				
			</tr>	
			<tr>
				<td>Fornecedores Concorrentes:</td>
				<c:if test="${empty cotacao.fornecedores }">
					<td>Nenhum fornecedor encontrado.</td>
				</c:if>
				<c:if test="${! empty cotacao.fornecedores }">
					<td>
						<c:forEach items="${cotacao.fornecedores }" var="fornecedor">
							${fornecedor.nome }, &nbsp;
						</c:forEach>
					</td>
				</c:if>
			</tr>	
			<tr>
				<td>Fornecedor Vencedor da Cotação:</td>
				<c:if test="${ empty cotacao.fornecedorVencedor }">
					<td>Sem fornecedor vencedor.</td>
				</c:if>
				<c:if test="${ ! empty cotacao.fornecedorVencedor }">
					<td>${cotacao.fornecedorVencedor.nome }</td>
				</c:if>				
			</tr>
			<tr>
				<td>Descrição:</td>
				<td>${cotacao.titulo }</td>
			</tr>
		</table>
		<br />
		<div>
			<h3>Negociações Abertas:</h3>
			<table>
				<thead>
					<tr>
						<th>Fornecedor</th>
						<th>Valor</th>
						<th>Condição</th>
						<th>Garantia</th>
						<th>Prazo</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${respostas }" var="resposta">
					<tr>
						<td>${resposta.fornecedor.nome }</td>
						<td>R$ ${resposta.valor }</td>
						<td>${resposta.condicao }</td>
						<td>${resposta.garantia } ano(s)</td>
						<td>${resposta.prazo }</td>
						<td>
							<c:url value="/criaRespostaCotacaoResposta" var="Criar">
								<c:param name="idCotacao" value="${cotacao.id }" />
								<c:param name="idFornecedor" value="${resposta.fornecedor.id }"></c:param>
							</c:url>
							<a href="${Criar }">Ver Negociação</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<c:url value="/listaRespostaCotacaoPorCotacao" var="Respostas">
				<c:param name="cotacaoId" value="${cotacao.id }" />
			</c:url>
			<a href="${Respostas }">Listar Respostas da Cotação</a>
			<c:url value="/criaRespostaCotacao" var="Resposta">
				<c:param name="id" value="${cotacao.id }" />
			</c:url>
			<a href="${Resposta }" title="Dar Orçamento">Abrir Negociação</a>
			<a href="<c:url value='/listaCotacoes' />" title="Lista Cotações">Listar Cotações</a>
		</div>