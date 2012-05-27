<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" ></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	
		<title>Sindico.com</title>
	</head>
	<body>
		<h1>Usuário ${param.nome}</h1>
		<table>
			<thead>
				<tr>
					<th>Telefone</th>
					<th>Celular</th>
					<th>Data de Cadastro</th>
					<th>Data de Nascimento</th>
					<th>Email</th>
					<th>Recebe Cotação?</th>
					<th>Tipo de Usuário</th>
					<th>Cotações</th>
				</tr>				
			</thead>
			<tr>
				<td>${param.telefone}</td>
				<td>${param.celular}</td>
				<td>${param.dataCadastro}</td>
				<td>${param.dataNascimento}</td>
				<td>${param.email}</td>
				<td>
					<c:if test="${param.recebeCotacao == true }">
						Recebe Cotação
					</c:if>
					<c:if test="${param.recebeCotacao == false }">
						Não recebe cotação
					</c:if>
				</td>	
				<td>${param.tipo }</td>	
				<td>
					<a href="/" title="Cotações do Usuário">Cotações</a>
				</td>		
			</tr>
		</table>
	</body>
</html>