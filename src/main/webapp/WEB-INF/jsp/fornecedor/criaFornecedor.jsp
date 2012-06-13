<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js">
</script>
<script type="text/javascript" src="/sindico/javascript/actions.js">
</script>


<title>Sindico.com</title>
</head>
<body>
	<h1>CRIA FORNECEDOR</h1>
	<form:form id="fornecedor" commandName="fornecedor" method="POST" action="cria">
		<table>
			<tr>
				<td>Título:</td>
				<td><form:input path="title" size="100" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><form:input path="nome" size="100" /></td>
			</tr>
			<tr>
				<td>Nome Principal:</td>
				<td><form:input path="nomePrincipal" size="100" /></td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td><form:textarea path="descricao" size="100" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" size="100" /></td>
			</tr>
			<tr>
				<td>Slogan:</td>
				<td><form:input path="slogan" size="100" /></td>
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
				<td>CNPJ:</td>
				<td><form:input path="cnpj" size="100" /></td>
			</tr>
			<tr>
				<td>logo ?:</td>
				<td><form:input path="logo" size="100" /></td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td><form:input id="cep" path="cep" size="8"
						onblur="javascript:makeGetRequest(09607030);" /></td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td><form:input id="endereco" path="endereco" size="100" /></td>
			</tr>
			<tr>
				<td>Numero:</td>
				<td><form:input path="numero" size="100" /></td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td><form:input id="bairro" path="bairro" size="100" /></td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td><form:input id="cidade" path="cidade" size="100" /></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><form:select path="estado" id="uf">
						<form:options items="${estados}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Subcategorias:</td>
				<td><form:checkboxes items="${subcategoriasFornecedor }"
						path="subcategorias" itemLabel="title" itemValue="codigo" /></td>
			</tr>
			<tr>
				<td>Estrelas:</td>
			</tr>
			<tr>
				<td><form:radiobutton path="estrelas" value="1" label="1" /></td>
			</tr>
			<tr>
				<td><form:radiobutton path="estrelas" value="2" label="2" /></td>
			</tr>
			<tr>
				<td><form:radiobutton path="estrelas" value="3" label="3" /></td>
			</tr>
			<tr>
				<td><form:radiobutton path="estrelas" value="4" label="4" /></td>
			</tr>
			<tr>
				<td><form:radiobutton path="estrelas" value="5" label="5" /></td>
			</tr>
			<tr>
				<td>Anunciante:</td>
				<td><form:checkbox path="anunciante" /></td>
			</tr>
			<tr>
				<td>Aprovado:</td>
				<td><form:checkbox path="aprovado" /></td>
			</tr>
			<tr>
				<td>Recebe Cotacao:</td>
				<td><form:checkbox path="recebeCotacaoEmail" /></td>
			</tr>
			<tr>
				<td>Recebe News:</td>
				<td><form:checkbox path="recebeNewsEmail" /></td>
			</tr>
			<tr>
				<td><form:button value="Criar">Criar</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>