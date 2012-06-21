<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>Predio ${predio.nome}</h1>
		<table style="margin: 10px;">
			<tr>
				<td>Data de cadastro:</td>
				<td>${predio.dataCadastro }</td>
			</tr>
			<tr>
				<td>Qtdade Aptos:</td>
				<td>${predio.numeroApartamentos }</td>
			</tr>
			<tr>
				<td>Tipo:</td>
				<td>${predio.tipo }</td>
			</tr>
			<tr>
				<td>Gerente:</td>
				<td>${predio.gerente }</td>
			</tr>
			<tr>
				<td>Gerente recebe cotação?:</td>
				<td>${predio.gerenteRecebeCotacao }</td>
			</tr>
			<tr>
				<td>CNPJ:</td>
				<td>${predio.cnpj }</td>
			</tr>
			<tr>
				<td>Foto:</td>
				<td>Incluir tag de foto</td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td>${predio.endereco }</td>
			</tr>
			<tr>
				<td>Numero:</td>
				<td>${predio.numero }</td>
			</tr>
			<tr>
				<td>CEP:</td>
				<td>${predio.cep }</td>
			</tr>
			<tr>
				<td>Bairro:</td>
				<td>${predio.bairro }</td>
			</tr>
			<tr>
				<td>Cidade:</td>
				<td>${predio.cidade }</td>
			</tr>
			<tr>
				<td>Estado:</td>
				<td>${predio.estado }</td>
			</tr>
		</table>
		<div>
			<a href="/sindico/predio/lista" title="Lista Predios">Listar Predios</a>
		</div>