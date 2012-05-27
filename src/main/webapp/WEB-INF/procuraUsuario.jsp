<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Sindico.com</title>
	</head>
	<body>
		<form action="/UsuarioController" method="get">
			<table>
				<tr>
					<td>Pesquisar Usuário </td>
					<td><input type="text" name="pesquisa" /> </td>
				</tr>
				<tr>
					<td>Pesquisar por</td>
					<td>
						<select name="pesquisarPor" >
							<option value="N">Nome</option>
							<option value="E">Email</option>
							<option value="P">Predio</option>
						</select>
					</td>
					<td>
						<input type="submit" value="Pesquisar" />
					</td>
				</tr>
			</table>
		</form>
	
	</body>
</html>