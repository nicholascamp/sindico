<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>Sindico.com</title>
</head>

<body>
	<form:form commandName="predio" method="put" action="atualizarPredio">
	Nome: <br />
		<form:input path="nome" />
		<br />
		<br />
	CNPJ: <br />
		<form:input path="cnpj" />
		<br />
		<br />
	ENDERECO: <br />
		<form:input path="endereco" title="Rua" />
		<br />
		<form:input path="bairro" title="Bairro"/>
		<br />
		<form:input path="cidade" />
		<br />
		<form:select path="estado">
			<form:options items="${estados}" />
		</form:select>
		<br />
		<form:input path="numero" />
		<br />
		<form:input path="cep" />
		<br />
		<br />
	Qtdade Aptos: <br />
		<form:input path="numeroApartamentos" />
		<br />
		<br />
	Tipo: <br />
		<form:select path="tipo">
			<form:options items="${tipos}" />
		</form:select>
		<br />
		<br />
	Gerente: <br />
		<form:select path="gerente">
			<form:options items="${gerentes}" />
		</form:select>
		<br />
		<br />
	Recebe cotação ?: <br />
		<form:checkbox path="gerenteRecebeCotacao"/>
		<br />
		<br />
		<input type="submit" value="Atualizar Predio" />
	</form:form>
	
	<a href="/sindico/predios.html">Cancelar</a>

</body>
</html>