<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Cria Gerente</h3>
<form:form commandName="gerente" method="POST" action="/sindico/criaGerente">
	<table style="margin: 10px;">
		<tr>
			<td><strong>Nome:</strong></td>
			<td><form:input path="nome" /></td>
		</tr>
		<tr>
			<td><strong>Email:</strong></td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td><strong>Telefone:</strong></td>
			<td><form:input path="telefone"/></td>
		</tr>
		<tr>
			<td>Celular:</td>
			<td><form:input path="celular"/></td>
		</tr>
		<tr>
			<td><strong>Senha</strong></td>
			<td><form:password path="senha"/></td>
		</tr>
		<tr>
			<td><strong>Recebe email de Marketing?</strong></td>
			<td>
				<form:select path="recebeEmailMkt">
					<form:option value="true">Recebe</form:option>
					<form:option value="false">Não Recebe</form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><strong>Administradora:</strong></td>
			<td>
				<form:select path="administradora">
					<form:options items="${administradoras }" itemLabel="nome" itemValue="id" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td><strong>Prédios:</strong></td>
			<td>
				<form:checkboxes items="${predios }" path="predios" itemLabel="nome" itemValue="id" />
			</td>
		</tr>
		<tr>
			<td><form:button value="Criar">Criar</form:button> </td>
		</tr>
	</table>
</form:form>

<div>
	<a href="/sindico/listaGerentes" title="Lista Gerentes">Listar Gerentes</a>
</div>