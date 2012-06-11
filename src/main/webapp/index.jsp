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
		<script type="text/javascript" src="/sindico/javascript/actions.js"></script>
		
		<title>Sindico.com</title>
	</head>
	<body>	
		<h1>Index</h1>
		<a href="/sindico/predio/lista.html">Gerenciar Prédios</a>	<br/>
		<a href="/sindico/categoria/lista.html">Gerenciar Categorias</a> <br/>
		<a href="/sindico/subcategoria/lista.html">Gerenciar Subcategorias</a> <br />
		<a href="/sindico/fornecedor/lista.html">Gerenciar Fornecedores</a> <br/>
		<a href="/sindico/administradora/lista.html">Gerenciar Administradoras</a> <br/>
		<a href="/sindico/usuario/lista.html">Gerenciar Usuarios</a> <br/>
		
		<br/><br/><br/>
		<a href="javascript:logout();">Logout</a>
	</body>
</html>