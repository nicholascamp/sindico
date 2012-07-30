<%@include file="/WEB-INF/tags/taglib_includes.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript" src="/sindico/javascript/actions.js"></script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div>
		<tiles:insertAttribute name="header" />
		<div>
			<sec:authorize ifAnyGranted="ROLE_USUARIO, ROLE_FORNECEDOR">
				<tiles:insertAttribute name="navigation" />
			</sec:authorize>
			<hr noshade="noshade" size="1" width="100%">
			<sec:authorize ifNotGranted="ROLE_USUARIO, ROLE_FORNECEDOR">
				<h3>Faça Login</h3>

				<form name="f" action="<c:url value='/j_spring_security_check'/>"
					method="POST">
					<table>
						<tr>
							<td>Usuário:</td>
							<td><input type='text' name='j_username'
								value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' /></td>
						</tr>
						<tr>
							<td>Senha:</td>
							<td><input type='password' name='j_password'></td>
						</tr>
						<tr>
							<td><input type="checkbox"
								name="_spring_security_remember_me"></td>
							<td>Salvar usuário</td>
						</tr>

						<tr>
							<td colspan='2'><input name="submit" type="submit"></td>
						</tr>
					</table>
				</form>
				</br>
				</br>
				<h3>
					Ou <a href="<c:url value='/cadastro'/>">Cadastre-se</a>
				</h3>
				</br>
				</br>
				</br>
			</sec:authorize>
		</div>

		<div>
			<tiles:insertAttribute name="body" />
		</div>

		<hr noshade="noshade" size="1" width="100%">
		<sec:authorize ifAnyGranted="ROLE_USUARIO, ROLE_FORNECEDOR">
			<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
		</sec:authorize>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>