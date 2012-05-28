package com.sindico.action.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sindico.action.Logica;
import com.sindico.dao.UsuarioDAO;
import com.sindico.entity.Usuario;
import com.sindico.enums.TipoUsuario;
import com.sindico.factory.UsuarioFactory;

/**
 * Servlet implementation class AdicionaContato
 */
@Repository
public class AdicionaUsuario extends HttpServlet implements Logica {
	private static final long	serialVersionUID	= 1L;

	@Autowired
	private UsuarioDAO			usuarioDAO;

	@Override
	public void executa(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		// Seta variável telefone
		String telefone = getTelefone(request);

		// Seta variável celular
		String celular = getCelular(request);

		Date dataNascimento = new SimpleDateFormat("dd/mm/yyyy").parse(request
				.getParameter("dataNascimento"));

		Usuario usuario = UsuarioFactory.criaUsuario(
				request.getParameter("nome"), request.getParameter("senha"),
				telefone, celular, new Date(), dataNascimento,
				request.getParameter("email"),
				getRecebeCotacao(request.getParameter("recebeCotacao")),
				getTipo(request.getParameter("tipoUsuario")), null);

		if(usuario != null){
			usuarioDAO.criaUsuario(usuario);
			
			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("mostra-usuario");
			rd.forward(request, response);
		}	
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
