<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>Cotacao ${cotacao.codigo}</h1>
		<table style="margin: 10px;">
			<tr>
				<td>Data:</td>
				<td>${cotacao.data }</td>
			</tr>
			<tr>
				<td>Subcategoria:</td>
				<td>${cotacao.subcategoria.nome }</td>
			</tr>
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
				<td>${cotacao.usuario.nome }</td>
			</tr>	
			<tr>
				<td>Gerente Administradora:</td>
				<td>${cotacao.gerenteAdmin }</td>
			</tr>	
			<tr>
				<td>Fornecedores Concorrentes:</td>
				<td>
					<table>
						<c:if test="${empty cotacao.forcecedores }">
							<tr>
								<td>Nenhum fornecedor encontrado.</td>
							</tr>
						</c:if>
						<c:if test="${! empty cotacao.forcecedores }">
							<c:forEach items="${cotacao.fornecedores } var="fornecedor">
								<tr>
									<td>Nome:</td>
									<td>${fornecedor.nome }</td>
								</tr>
							</c:forEach>
						</c:if>
						
					</table>
				</td>
			</tr>	
			<tr>
				<td>Fornecedor Vencedor da Cotação:</td>
				<td>${cotacao.fornecedorVencedor.nome }</td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td>${cotacao.titulo }</td>
			</tr>
		</table>
		<div>
			<a href="<c:url value='/listaCotacoes' />" title="Lista Cotações">Listar Cotações</a>
		</div>