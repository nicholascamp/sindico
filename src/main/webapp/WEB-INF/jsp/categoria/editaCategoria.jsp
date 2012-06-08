<h1>EDITA CATEGORIA</h1>
<form:form commandName="categoria" method="POST" action="edita">
	<input type="hidden" name="codigo" value="${categoria.codigo }" />
	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome" value="${categoria.nome }" />
			</td>
		</tr>
		<tr>
			<td>Subcategorias:</td>
			<td>INSERIR TRATAMENTO DE SUBCATEGORIAS</td>
		</tr>
		<tr>
			<td><form:button value="Editar">Editar</form:button></td>
		</tr>
	</table>
</form:form>
