<%@include file="/WEB-INF/tags/taglib_includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<title>Sindico.com</title>
</head>

<body>
	<form:form commandName="usuario" method="post" action="criaUsuario">
	Nome: <br />
		<form:input path="nome" />
		<br />
		<br />
	Senha: <br />
		<form:password path="senha" />
		<br />
		<br />
	Email: <br />
		<form:input path="email" />
		<br />
		<br />
		<input type="submit" value="Cria Usuario" />
	</form:form>

</body>
</html>