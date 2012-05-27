<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="sindico" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>	
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" ></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	
		<title>Sindico.com</title>
	</head>
	
	<body>
		<form action="UsuarioController" method="post">
			Nome: <input type="text" name="nome" />
			Senha: <input type="password" name="senha" />
			Telefone: <input type="text" name="ddd" size="2" /> <input type="text" name="telefone" />
			Celular: <input type="text" name="dddc" size="2" /> <input type="text" name="celular" />
			Email: <input type="text" name="email" />
			Data de Nascimento: <sindico:campoData id="dataNascimento" />
			<input type="radio" name="tipoUsuario" value="S" /> Sindico 
			<input type="radio" name="tipoUsuario" value="C" /> Conselheiro
			<input type="radio" name="tipoUsuario" value="M" /> Morador 
			<input type="radio" name="tipoUsuario" value="Z" /> Zelador 
			<input type="hidden" name="AdicionaContato" />
			Deseja receber cotações por email? <input type="checkbox" name="recebeCotacao" value="true" checked />
			<input type="submit" name="button" value="Criar" />
		</form>
	
	</body>
</html>