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
		<h1>Pesquisar Usuário</h1>
		<form action="/UsuarioController" method="get">
			<table>
				<tr>
					<td>Pesquisar </td>
					<td><input type="text" name="pesquisa" /> </td>
				</tr>
				<tr>
					<td>Pesquisar por</td>
					<td>
						<select name="pesquisarPor" >
							<option value="N">Nome</option>
							<option value="E">Email</option>
							<option value="P">Prédio</option>
						</select>
					</td>
					<td>
						<input type="hidden" name="ProcuraUsuario">
						<input type="submit" value="Pesquisar" />
					</td>
				</tr>
			</table>
		</form>
	
	</body>
</html>