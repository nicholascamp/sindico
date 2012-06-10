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
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<title>Sindico.com</title>
</head>
<body>
	<h1>CRIA FORNECEDOR</h1>
	<form:form commandName="fornecedor" method="POST" action="edita">
		<input type="hidden" name="codigo" value="${fornecedor.codigo }" />
		<table>
			<tr>
				<td>Título:</td>
				<td><form:input path="title" value="${fornecedor.title }" size="100" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><form:input path="nome" value="${fornecedor.nome }" size="100" /></td>
			</tr>
			<tr>
				<td>Nome Principal:</td>
				<td><form:input path="nomePrincipal" value="${fornecedor.nomePrincipal }" size="100" /></td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td><form:textarea path="descricao" value="${fornecedor.descricao }" size="100" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" value="${fornecedor.email }" size="100" /></td>
			</tr>
			<tr>
				<td>Slogan:</td>
				<td><form:input path="slogan" value="${fornecedor.slogan }" size="100" /></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><form:input path="telefone" value="${fornecedor.telefone }"  size="100" /></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><form:input path="celular" value="${fornecedor.celular }" size="100" /></td>
			</tr>
			<tr>
				<td>CNPJ:</td>
				<td><form:input path="cnpj" value="${fornecedor.cnpj }" size="100" /></td>
			</tr>
			<tr>
				<td>logo ?:</td>
				<td><form:input path="logo" value="${fornecedor.logo }" size="100" /></td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td><form:input path="endereco" value="${fornecedor.endereco }" size="100" /></td>
			</tr>
			<tr>
				<td>Numero:</td>
				<td><form:input path="numero" value="${fornecedor.numero }" size="100" /></td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td><form:input path="cep" value="${fornecedor.cep }" size="8" /></td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td><form:input path="bairro" value="${fornecedor.bairro }" size="100" /></td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td><form:input path="cidade" value="${fornecedor.cidade }" size="100" /></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td><form:select path="estado">
						<form:options items="${estados}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Subcategorias:</td>
				<td>
					<form:checkboxes items="${subcategoriasFornecedor }" path="subcategorias" itemLabel="title" itemValue="codigo" />
				</td>
			</tr>
			<tr>
				<td>Estrelas:</td>
			</tr>
			<tr>
				<td>
					<c:if test="${fornecedor.estrelas == 1 }">
						<form:radiobutton path="estrelas" value="1" label="1" checked />
					</c:if>
					<c:if test="${fornecedor.estrelas != 1 }">
						<form:radiobutton path="estrelas" value="1" label="1" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<c:if test="${fornecedor.estrelas == 2 }">
						<form:radiobutton path="estrelas" value="2" label="2" checked />
					</c:if>
					<c:if test="${fornecedor.estrelas != 2 }">
						<form:radiobutton path="estrelas" value="2" label="2" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<c:if test="${fornecedor.estrelas == 3 }">
						<form:radiobutton path="estrelas" value="3" label="3" checked />
					</c:if>
					<c:if test="${fornecedor.estrelas != 3 }">
						<form:radiobutton path="estrelas" value="3" label="3" />
					</c:if>
				</td>
			</tr>
			<tr>
				<c:if test="${fornecedor.estrelas == 4 }">
						<form:radiobutton path="estrelas" value="4" label="4" checked />
					</c:if>
					<c:if test="${fornecedor.estrelas != 4 }">
						<form:radiobutton path="estrelas" value="4" label="4" />
					</c:if>
			</tr>
			<tr>
				<c:if test="${fornecedor.estrelas == 5 }">
						<form:radiobutton path="estrelas" value="5" label="5" checked />
					</c:if>
					<c:if test="${fornecedor.estrelas != 5 }">
						<form:radiobutton path="estrelas" value="5" label="5" />
					</c:if>
			</tr>
			<tr>
				<td>Anunciante:</td>
				<td>
					<c:if test="${fornecedor.anunciante == true }">
						<form:checkbox path="anunciante" checked />
					</c:if>
					<c:if test="${fornecedor.anunciante == false }">
						<form:checkbox path="anunciante" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Aprovado:</td>
				<td>
					<c:if test="${fornecedor.aprovado == true }">
						<form:checkbox path="aprovado" checked/>
					</c:if>	
					<c:if test="${fornecedor.aprovado == false }">
						<form:checkbox path="aprovado"/>
					</c:if>				
				</td>
			</tr>
			<tr>
				<td>Recebe Cotacao:</td>
				<td>
					<c:if test="${fornecedor.recebeCotacaoEmail == true }">
						<form:checkbox path="recebeCotacaoEmail" checked />
					</c:if>
					<c:if test="${fornecedor.recebeCotacaoEmail == false }">
						<form:checkbox path="recebeCotacaoEmail" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Recebe News:</td>
				<td>
					<c:if test="${fornecedor.recebeNewsEmail == true }">
						<form:checkbox path="recebeNewsEmail" checked />
					</c:if>
					<c:if test="${fornecedor.recebeNewsEmail == false }">
						<form:checkbox path="recebeNewsEmail" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td><form:button value="Editar">Editar</form:button></td>
			</tr>
		</table>
	</form:form>
	
	<a href="/sindico/fornecedor/lista.html">Cancelar</a>
</body>
</html>