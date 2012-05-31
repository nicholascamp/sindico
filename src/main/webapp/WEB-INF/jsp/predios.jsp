<%@ include file="/WEB-INF/tags/taglib_includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sindico.com</title>
</head>
<body>
	<form:form action="buscarPredioPorNome" method="GET" commandName="predio">
		Buscar Por Nome: <form:input path="nome" />
		<input type="submit" value="Buscar Predios" />
	</form:form>
	<form:form action="buscarPredioPorEndereco" method="GET" commandName="predio">
		Buscar Por Endere�o: <form:input path="endereco" />
		<input type="submit" value="Buscar Predios" />
	</form:form>
	<a href="/sindico/predios.html">Visualizar todos os Pr�dios</a>
	<center>
		<table style="border-collapse: collapse;" width="500" border="1"
			bordercolor="#006699">
			<tbody>
				<tr bgcolor="lightblue">
					<th>Nome</th>
					<th>CNPJ</th>
					<th>Endere�o</th>
					<th>Nro de Aptos</th>
					<th>Tipo</th>
					<th>Gerente</th>
					<th>Recebe Cota��o ?</th>
					<th></th>
				</tr>
				<c:if test="${! empty predios}">
					<c:forEach var="predio" items="${predios}">
						<tr>
							<td><c:out value="${predio.nome}"></c:out></td>
							<td><c:out value="${predio.cnpj}"></c:out></td>
							<td><c:out value="${predio.endereco}"></c:out></td>
							<td><c:out value="${predio.numeroApartamentos}"></c:out></td>
							<td><c:out value="${predio.tipo}"></c:out></td>
							<td><c:if test="${!empty predio.gerente} }">
									<c:out value="${predio.gerente.nome}" />
								</c:if> <c:if test="${empty predio.gerente} }">
									<c:out value="N�o Possui Gerente" />
								</c:if></td>
							<td><c:out value="${predio.gerenteRecebeCotacao}"></c:out></td>
							<td><a href="atualizarPredio.html?id=${predio.id}">Editar</a>
								<a href="removerPredio?id=${predio.id}">Deletar</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty predios}">
					<tr>
						<td colspan="7" align="center">Nenhum pr�dio encontrado</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<a href="criaPredio.html">Novo Pr�dio</a>
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