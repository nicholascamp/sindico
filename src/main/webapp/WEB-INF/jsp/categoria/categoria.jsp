<h3>Categoria ${categoria.nome}</h3>
<table style="margin: 10px;">
	<tr>
		<td>Subcategorias:</td>
		<td><form:label items="${categoria.subcategorias }"
				path="subcategorias" itemLabel="title" itemValue="id" /></td>
	</tr>
</table>
<div>
	<a href="/sindico/listaCategorias" title="Lista Categorias">Listar
		Categorias</a>
</div>
