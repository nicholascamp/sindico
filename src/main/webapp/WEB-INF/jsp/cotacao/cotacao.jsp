<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>Cotacao ${cotacao.codigo}</h1>
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
				<td>Usuário:</td>
				<c:if test="${! empty cotacao.usuarioSimples }">
					<td>${cotacao.usuario.nome }</td>
				</c:if>
				<c:if test="${empty cotacao.usuarioSimples }">
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
				<td>
					<c:if test="${empty cotacao.fornecedores }">
							<tr>
								<td>Nenhum fornecedor encontrado.</td>
							</tr>
						</c:if>
						<c:if test="${! empty cotacao.fornecedores }">
							<c:forEach items="${cotacao.fornecedores } var="fornecedor">
								<div>
									<label>Nome:</label> ${fornecedor.nome }								
								</div>
							</c:forEach>
						</c:if>
				</td>
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
		<div>
			<a href="<c:url value='/listaCotacoes' />" title="Lista Cotações">Listar Cotações</a>
		</div>