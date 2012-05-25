<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sindico.com</title>
	</head>
	
	<body>
		<form action="UsuarioController" method="post">
			Nome: <input type="text" name="nome" />
			Senha: <input type="password" name="senha" />
			Telefone: <input type="text" name="ddd" size="2" /> <input type="text" name="telefone" />
			Celular: <input type="text" name="dddc" size="2" /> <input type="text" name="celular" />
			Email: <input type="text" name="email" />
			Data de Nascimento: <!-- implementar -->
			<input type="radio" name="tipoUsuario" value="S" /> Sindico 
			<input type="radio" name="tipoUsuario" value="C" /> Conselheiro
			<input type="radio" name="tipoUsuario" value="M" /> Morador 
			<input type="radio" name="tipoUsuario" value="Z" /> Zelador 
			<input type="hidden" name="logica" />
			Deseja receber cotações por email? <input type="checkbox" name="recebeCotacao" value="true" checked />
			<input type="submit" name="button" value="Criar" />
		</form>
	
	</body>
</html>