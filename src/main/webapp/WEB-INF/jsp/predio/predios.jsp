<%@ include file="/WEB-INF/tags/taglib_includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="/sindico/javascript/actions.js"></script>
<title>Sindico.com</title>
</head>
<body>

	<form:form action="/sindico/listaPrediosPorNome" method="GET"
		commandName="predio">
		Buscar Por Nome: <form:input path="nome" />
		<input type="submit" value="Buscar Predios" />
	</form:form>
	<form:form action="/sindico/listaPrediosPorEndereco"
		method="GET" commandName="predio">
		Buscar Por Endereço: <form:input path="endereco" />
		<input type="submit" value="Buscar Predios" />
	</form:form>
	<div>
		<table style="margin: 10px;">
			<tr>
				<th>Nome</th>
				<th>Consultar</th>
				<th>Editar</th>
				<th>Deletar</th>
			</tr>
			<c:if test="${! empty predios}">
				<c:forEach items="${predios }" var="predio">
					<tr>
						<td>${predio.nome }</td>
						<td><c:url value="/mostraPredio" var="Consultar">
								<c:param name="id" value="${predio.id}" />
							</c:url> <a href="${Consultar}" title="Consulta Predio">Consultar</a></td>
						<td><c:url value="/editaPredio" var="Editar">
								<c:param name="id" value="${predio.id}" />
							</c:url> <a href="${Editar}" title="Editar Categoria">Editar</a></td>
						<td><c:url value="/deletaPredio" var="Deletar">
								<c:param name="id" value="${predio.id}" />
							</c:url> <a href="javascript:deleteEntity('${Deletar }');"
							title="Deletar Prédio">Deletar</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${empty predios}">
			<p>Nenhum predio encontrado</p>
		</c:if>
	</div>
	<div>
		<a href="<c:url value="/criaPredio"/>" title="Criar Prédio">Novo
			Prédio</a>
	</div>

	<!-- 		<div class="paging"> -->
	<%-- 			<c:if test="${!predios.firstPage}"> --%>
	<!-- 				<a href="predios.html?page=previous"><b>&lt;&lt; Prev</b></a> -->
	<!--             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
	<%--           </c:if> --%>
	<%-- 			<c:if test="${!predios.lastPage}"> --%>
	<!-- 				<a href="predios.html?page=next"><b>Next &gt;&gt;</b></a> -->
	<%-- 			</c:if> --%>
	<!-- 		</div> -->

	</center>

</body>
</html>