<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sindico"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<h1>CRIA CATEGORIA</h1>
		<form:form commandName="categoria" method="POST" action="/sindico/criaCategoria">
			<table>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" size="100" />
					</td>
				</tr>
				<tr>
					<td><form:button value="Criar">Criar</form:button>
					</td>
				</tr>
			</table>
		</form:form>
