package com.sindico.action.usuario;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sindico.action.Logica;
import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;
import com.sindico.enums.TipoUsuario;
import com.sindico.factory.UsuarioFactory;

/**
 * Servlet implementation class AdicionaContato
 */
public class AdicionaUsuario extends HttpServlet implements Logica {
	private static final long	serialVersionUID	= 1L;

	@Autowired
	private UsuarioDAO			usuarioDAO;

	@SuppressWarnings("deprecation")
	@Override
	public void executa(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		// Seta variável telefone
		String telefone = getTelefone(request);

		// Seta variável celular
		String celular = getCelular(request);

		Usuario usuario = UsuarioFactory.criaUsuario(
				request.getParameter("nome"), request.getParameter("senha"),
				telefone, celular, new Date(),
				new Date(request.getParameter("dataNascimento")),
				request.getParameter("email"),
				getRecebeCotacao(request.getParameter("recebeCotacao")),
				getTipo(request.getParameter("tipoUsuario")), null);

		usuarioDAO.criaUsuario(usuario);
		
		RequestDispatcher rd = request.getRequestDispatcher("mostra-usuario");
		rd.forward(request, response);

	}

	private String getTelefone(final HttpServletRequest request) {
		StringBuilder telefone = new StringBuilder();
		telefone.append(request.getParameter("ddd"));
		telefone.append(" ");
		telefone.append(request.getParameter("telefone"));
		return telefone.toString();
	}

	private String getCelular(final HttpServletRequest request) {
		StringBuilder celular = new StringBuilder();
		celular.append(request.getParameter("dddc"));
		celular.append(" ");
		celular.append(request.getParameter("celular"));
		return celular.toString();
	}

	private boolean getRecebeCotacao(final String cotacao) {
		if (cotacao.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	private TipoUsuario getTipo(final String tipo) {

		if (tipo.equals("S")) {
			return TipoUsuario.SINDICO;
		} else if (tipo.equals("C")) {
			return TipoUsuario.CONSELHO;
		} else if (tipo.equals("M")) {
			return TipoUsuario.MORADOR;
		} else {
			return TipoUsuario.ZELADOR;
		}
	}

}
