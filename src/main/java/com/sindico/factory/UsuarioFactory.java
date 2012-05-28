package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Usuario;
import com.sindico.enums.TipoUsuario;

/**
 * A factory for creating Usuario objects.
 */
public class UsuarioFactory {

	public static Usuario criaUsuario(final String nome, final String senha,
			final String telefone, final String celular,
			final Date dataCadastro, final Date dataNascimento,
			final String email, final boolean recebeCotacao,
			final TipoUsuario tipo, final Collection<Cotacao> cotacoes) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		usuario.setCelular(celular);
		usuario.setDataCadastro(dataCadastro);
		usuario.setDataNascimento(dataNascimento);
		usuario.setEmail(email);
		usuario.setRecebeCotacao(recebeCotacao);
		usuario.setTipo(tipo);
		usuario.setCotacoes(cotacoes);
		return usuario;
	}

}