<%@include file="/WEB-INF/tags/taglib_includes.jsp"%>
<!doctype html>
<!-- .container-topo -->
<div class="container-topo">
	<header class="container">
		<div class="cf">
			<h1 class="logo"><a href="" class="hide-text">Sindico.com</a></h1>

			<p class="acesse-sua-conta-destaque">Ol�, acesse <a href="">sua conta</a> ou <a href="" class="bt-padrao">cadastre-se</a></p>

			<p class="acesse-sua-conta">Acesse <a href="">sua conta</a> ou <a href="">cadastre-se</a></p>

			<!-- .menu-redes-sociais -->
			<div class="menu-redes-sociais">
				<nav>
					<a href="">Home</a><a href="">Blog do sindico</a>
				</nav>

				<!-- .redes-sociais -->
				<div class="redes-sociais">
					<a href="" class="linkedin hide-text" title="LinkedIn">LinkedIn</a>
					<a href="" class="twitter hide-text" title="Twitter">Twitter</a>
					<a href="" class="facebook hide-text" title="Facebook">Facebook</a>
				</div>
				<!-- </ .redes-sociais -->
			</div>
			<!-- </ .menu-redes-sociais -->
		</div>

		<!-- .categorias-busca -->
		<div class="categorias-busca cf">
			<!-- .menu-categorias -->
			<ul class="menu-categorias">
				<li>
					<a href="<c:url value="/listaCategorias" />">Categorias</a>

					<!-- .submenu-categorias -->
					<ul class="submenu-categorias">
						<!--TODO: JSTL -->
						<!--<c:forEach items="${categorias }" var="categoria">
							<li>
								<c:url value="/mostraCategoria" var="Consultar">
									<c:param name="id" value="${categoria.id}" />
								</c:url>
								<a href="${Consultar }" >${categoria.nome }</a>
							</li>
						</c:forEach> -->
						<li><a href="">Administra��o</a></li>

						<li>
							<a href="">�gua</a>

							<!-- // submenu nv2 -->
							<ul>
								<li><a href="">Administra��o</a></li>
								<li><a href="">�gua</a></li>
								<li><a href="">Certifica��o Digital</a></li>
								<li><a href="">Combate a Inc�ndio</a></li>
								<li class="destaque-submenu"><img src="http://placehold.it/76x76"><strong>LorLorem</strong> ipsumem ipsum dolor sit amet, consectetur adipiscing elit</li>
							</ul>
							<!-- </ // submenu nv2 -->
						</li>

						<li><a href="">Certifica��o Digital</a></li>
						<li><a href="">Combate a Inc�ndio</a></li>
						<li><a href="">El�trica</a></li>
						<li><a href="">Funcion�rio</a></li>
						<li><a href="">Garagem</a></li>
						<li><a href="">G�s</a></li>
						<li><a href="">Jardins</a></li>
						<li><a href="">Lazer</a></li>
						<li><a href="">Limpeza</a></li>
						<li><a href="">Manuten��o</a></li>
					</ul>
					<!-- </ </ .submenu-categorias -->
				</li>
			</ul>
			<!-- </ .menu-categorias -->

			<form action="">
				<a href="" class="bt-categoria">Categoria</a>
				<input type="search" placeholder="Fa�a sua busca">
				<input type="image" src="/sindico/img/bt-busca.png" alt="buscar">
			</form>
		</div>
		<!-- </ .categorias-busca -->
	</header>
</div>