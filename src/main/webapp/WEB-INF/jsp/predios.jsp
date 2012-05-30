<%@ include file="/WEB-INF/tags/taglib_includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sindico.com</title>
</head>
<body>
	<center>
		<table style="border-collapse: collapse;" width="500" border="1"
			bordercolor="#006699">
			<tbody>
				<tr bgcolor="lightblue">
					<th>Nome</th>
					<th>CNPJ</th>
					<th>Endereço</th>
					<th>Nro de Aptos</th>
					<th>Tipo</th>
					<th>Gerente</th>
					<th>Recebe Cotação ?</th>
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
									<c:out value="${predio.gerente.nome}"/>
								</c:if> <c:if test="${empty predio.gerente} }">
									<c:out value="Não Possui Gerente"/>
								</c:if></td>
							<td><c:out value="${predio.gerenteRecebeCotacao}"></c:out></td>
							<td><a href="atualizarPredio.html?id=${predio.id}">Editar</a>
								<a
								href="deletarPredio.html?id=${predio.id}">Deletar</a>

							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty predios}">
					<tr>
						<td colspan="7" align="center">Nenhum prédio encontrado</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<a href="criaPredio.html">Novo Prédio</a>
	</center>

</body>
</html>