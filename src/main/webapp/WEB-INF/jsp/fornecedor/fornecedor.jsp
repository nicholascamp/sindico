<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	
		<title>Sindico.com</title>
	</head>
	<body>
		<h1>Fornecedor ${fornecedor.nome}</h1>
		<table style="margin: 10px;">
			<tr>
				<td>Título:</td>
				<td>${fornecedor.title }</td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td>${fornecedor.nome }</td>
			</tr>
			<tr>
				<td>Nome Principal:</td>
				<td>${fornecedor.nomePrincipal }</td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td>${fornecedor.descricao }</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${fornecedor.email }</td>
			</tr>
			<tr>
				<td>Slogan:</td>
				<td>${fornecedor.slogan }</td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td>${fornecedor.telefone }</td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td>${fornecedor.celular }</td>
			</tr>
			<tr>
				<td>CNPJ:</td>
				<td>${fornecedor.cnpj }</td>
			</tr>
			<tr>
				<td>logo ?:</td>
				<td>${fornecedor.logo }</td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td>${fornecedor.endereco }</td>
			</tr>
			<tr>
				<td>Numero:</td>
				<td>${fornecedor.numero }</td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td>${fornecedor.cep }</td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td>${fornecedor.bairro }</td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td>${fornecedor.cidade }</td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td>${fornecedor.estado }</td>
			</tr>
			<tr>
				<td>Subcategorias:</td>
				<td>
					<c:forEach items="${fornecedor.subcategorias }" var="subcategoria">
						${subcategoria.title },
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Estrelas:</td>
				<td>${fornecedor.estrelas }</td>
			</tr>
			<tr>
				<td>Anunciante:</td>
				<td>
					<c:if test="${fornecedor.anunciante == true }">
						<input type="checkbox" disabled="disabled" checked />
					</c:if>
					<c:if test="${fornecedor.anunciante == false }">
						<input type="checkbox" disabled="disabled" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Aprovado:</td>
				<td>
					<c:if test="${fornecedor.aprovado == true }">
						<input type="checkbox" disabled="disabled" checked />
					</c:if>
					<c:if test="${fornecedor.aprovado == false }">
						<input type="checkbox" disabled="disabled" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Recebe Cotação:</td>
				<td>
					<c:if test="${fornecedor.recebeCotacaoEmail == true }">
						<input type="checkbox" disabled="disabled" checked />
					</c:if>
					<c:if test="${fornecedor.recebeCotacaoEmail == false }">
						<input type="checkbox" disabled="disabled" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Recebe News:</td>
				<td>
					<c:if test="${fornecedor.recebeNewsEmail == true }">
						<input type="checkbox" disabled="disabled" checked />
					</c:if>
					<c:if test="${fornecedor.recebeNewsEmail == false }">
						<input type="checkbox" disabled="disabled" />
					</c:if>				
				</td>
			</tr>
		</table>
		<div>
			<a href="<c:url value="listaFornecedores" />" title="Lista Fornecedores">Listar Fornecedores</a>
		</div>
	</body>
</html>