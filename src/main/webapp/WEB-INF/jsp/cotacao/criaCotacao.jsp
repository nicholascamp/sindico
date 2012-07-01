<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<form:form action="/sindico/carregaFornecedores" commandName="cotacao" method="GET">
		<legend>Subcategorias</legend> 
		<form:select path="subcategoria">
			<form:options items="${subcategorias }" itemLabel="title" itemValue="id" />			
		</form:select>
		<form:button value="Selecionar">Selecionar</form:button>		
	</form:form>
	<br />
	<div>
		<form:form commandName="cotacao" action="/sindico/criaCotacao" method="POST">
			<table>
				<tr>
					<td>Subcategoria:</td>
					<td>
						<c:if test="${ !empty cotacao.subcategoria }">
							<input type="hidden" name="subcategoria" value="${cotacao.subcategoria.id }" />
							<label>${cotacao.subcategoria.title }</label>
						</c:if>
						<c:if test="${ empty cotacao.subcategoria }">
							Selecione uma Subcategoria.
						</c:if>
					</td>
				</tr>
				<tr>
					<td>
						Fornecedores:						
					</td>
					<td>
						<c:if test="${ empty fornecedores }">
							Nenhum fornecedor encontrado para a Subcategoria selecionada.
						</c:if>
						<c:if test="${ !empty fornecedores }">
							<form:select path="fornecedores" multiple="true" size="10">
								<form:options items="${fornecedores }" itemLabel="nome" itemValue="id" />
							</form:select>
						</c:if>						
					</td>
				</tr>
				<tr>
					<td colspan="2">Descrição:</td>				
				</tr>
				<tr>
					<td colspan="2"><form:textarea path="titulo"/></td>
				</tr>
				<tr>
					<td colspan="2"><form:button value="Criar">Criar</form:button> </td>
				</tr>
			</table>	
		</form:form>
	</div>
		