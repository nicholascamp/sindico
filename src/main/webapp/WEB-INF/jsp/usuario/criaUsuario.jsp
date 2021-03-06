<%@include file="/WEB-INF/tags/taglib_includes.jsp"%>
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
	<h1>CRIA USUARIO</h1>
	
	<c:if test="${not empty param.login_error}">
      <font color="red">
        Your login attempt was not successful, try again.<br/><br/>
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
    
	<form:form commandName="usuario" method="POST" action="cadastro">
		<table>
			<tr>
				<td>Nome:</td>
				<td><form:input path="nome" size="100" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" size="100" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="100" /></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><form:input path="telefone" size="100" /></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><form:input path="celular" size="100" /></td>
			</tr>
			<tr>
				<td>Data Nascimento:</td>
				<td><form:input path="dataNascimento" size="100" /></td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td><form:input path="cep" size="8"/> </td>
			</tr>
			<tr>
				<td>Numero:</td>
				<td><form:input path="numero"/> </td>
			</tr>
			<tr>
				<td>Tipo:</td>
				<td><form:select path="tipo">
						<form:options items="${tipos}" path="tipo" size="100" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:button value="Criar">Criar</form:button></td>
			</tr>
		</table>
	</form:form>
</html>