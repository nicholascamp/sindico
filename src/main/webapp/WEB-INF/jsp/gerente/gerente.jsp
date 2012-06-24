<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>Gerente ${gerente.nome}</h3>
<table style="margin: 10px;">
	<tr>
		<td><strong>Email:</strong></td>
		<td>${gerente.email }</td>
	</tr>
	<tr>
		<td><strong>Telefone:</strong></td>
		<td>${gerente.telefone }</td>
	</tr>
	<tr>
		<td>Celular:</td>
		<td>${gerente.celular }</td>
	</tr>
	<tr>
		<td><strong>Senha</strong></td>
		<td>${gerente.senha }</td>
	</tr>
	<tr>
		<td><strong>Recebe email de Marketing?</strong></td>
		<td>${gerente.recebeEmailMkt }</td>
	</tr>
	<tr>
		<td><strong>Data de Cadastro:</strong></td>
		<td></td>
	</tr>
	<tr>
		<td><strong>Administradora:</strong></td>
		<td>${gerente.administradora.nome }</td>
	</tr>
	<tr>
		<td><strong>Prédios:</strong></td>
		<td>
			<a href="#" title="Prédios">Prédios Administrados</a>
		</td>
	</tr>
</table>
<div>
	<a href="/sindico/listaGerentes" title="Lista Gerentes">Listar Gerentes</a>
</div>