<h1>CATEGORIAS</h1>
<div></div>
<div>
	<table style="margin: 10px;">
		<tr>
			<th>Nome</th>
			<th>Consultar</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<c:if test="${! empty categorias}">
			<c:forEach items="${categorias }" var="categoria">
				<tr>
					<td>${categoria.nome }</td>
					<td><c:url value="/categoria/mostra" var="Consultar">
							<c:param name="id" value="${categoria.codigo}" />
						</c:url> <a href="${Consultar}" title="Consulta Categoria">Consultar</a></td>
					<td><c:url value="/categoria/edita" var="Editar">
							<c:param name="id" value="${categoria.codigo}" />
						</c:url> <a href="${Editar}" title="Editar Categoria">Editar</a></td>
					<td><c:url value="/categoria/deleta" var="Deletar">
							<c:param name="id" value="${categoria.codigo}" />
						</c:url> <a href="${Deletar}" title="Deletar Categoria">Deletar</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:if test="${empty categorias}">
		<p>Nenhuma categoria encontrada</p>
	</c:if>
</div>
<div>
	<a href="/sindico/categoria/cria" title="Criar Categoria">Nova
		Categoria</a>
</div>
