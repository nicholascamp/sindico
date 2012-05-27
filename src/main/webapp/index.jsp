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
		<div>
			<h1>Usuário</h1>
			<a href="/sindico/adicionaUsuario.jsp" title="Adicionar Usuário">Criar Usuário</a>
			<a href="/sindico/procuraUsuario.jsp" id="ProcurarUsuario" class="button" title="Procurar Usuário">Pesquisar Usuário</a>
		</div>
		
		<div>
			<h1>Categoria</h1>
			<a href="/sindico/adicionaCategoria.jsp" title="Adicionar Categoria">Criar Categoria</a>
			<a href="/sindico/editaCategoria.jsp" title="Edita Categoria">Editar Categoria</a>
			<a href="/sindico/procuraCategoria.jsp" title="Procura Categoria">Pesquisar Categoria</a>
		</div>
		
		<div>
			<h1>Prédio</h1>
			<a href="/sindico/adicionaPredio.jsp" title="Adicionar Prédio">Criar Prédio</a>	
			<a href="/sindico/procuraPredio.jsp" title="Procurar Prédio">Pesquisar Prédio</a>	
		</div>
			
	</body>
</html>
