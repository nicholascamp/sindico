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

	/**
	 * Cria usuario.
	 * 
	 * @param nome
	 *            the nome
	 * @param sobrenome
	 *            the sobrenome
	 * @param senha
	 *            the senha
	 * @param telefone
	 *            the telefone
	 * @param celular
	 *            the celular
	 * @param fax
	 *            the fax
	 * @param telefoneComercial
	 *            the telefone comercial
	 * @param dataCadastro
	 *            the data cadastro
	 * @param dataNascimento
	 *            the data nascimento
	 * @param email
	 *            the email
	 * @param recebeCotacao
	 *            the recebe cotacao
	 * @param tipo
	 *            the tipo
	 * @param cotacoes
	 *            the cotacoes
	 * @return the usuario
	 */
	public static Usuario criaUsuario(final String nome,
			final String sobrenome, final String senha, final String telefone,
			final String celular, final String fax,
			final String telefoneComercial, final Date dataCadastro,
			final Date dataNascimento, final String email,
			final boolean recebeCotacao, final TipoUsuario tipo,
			final Collection<Cotacao> cotacoes) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		usuario.setCelular(celular);
		usuario.setFax(fax);
		usuario.setTelefoneComercial(telefoneComercial);
		usuario.setDataCadastro(dataCadastro);
		usuario.setDataNascimento(dataNascimento);
		usuario.setEmail(email);
		usuario.setRecebeCotacao(recebeCotacao);
		usuario.setTipo(tipo);
		usuario.setCotacoes(cotacoes);
		return usuario;
	}

}
