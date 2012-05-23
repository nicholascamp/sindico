package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Administradora;
import com.sindico.entity.Cotacao;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.Predio;

/**
 * A factory for creating GerenteAdministradora objects.
 */
public class GerenteAdministradoraFactory {

	/**
	 * Cri gerente administradora.
	 * 
	 * @param admin
	 *            the admin
	 * @param predios
	 *            the predios
	 * @param dataCadastro
	 *            the data cadastro
	 * @param nome
	 *            the nome
	 * @param sobrenome
	 *            the sobrenome
	 * @param email
	 *            the email
	 * @param telefone
	 *            the telefone
	 * @param celular
	 *            the celular
	 * @param fax
	 *            the fax
	 * @param telefoneComercial
	 *            the telefone comercial
	 * @param recebeCotacaoPredios
	 *            the recebe cotacao predios
	 * @param recebeEmailMkt
	 *            the recebe email mkt
	 * @param senha
	 *            the senha
	 * @param cotacoes
	 *            the cotacoes
	 * @return the gerente administradora
	 */
	public static GerenteAdministradora criaGerenteAdministradora(
			final Administradora admin, final Collection<Predio> predios,
			final Date dataCadastro, final String nome,
			final String email, final String telefone, final String celular,
			final boolean recebeEmailMkt, final String senha,
			final Collection<Cotacao> cotacoes) {
		GerenteAdministradora gerente = new GerenteAdministradora();
		gerente.setAdministradora(admin);
		gerente.setPredios(predios);
		gerente.setDataCadastro(dataCadastro);
		gerente.setNome(nome);
		gerente.setEmail(email);
		gerente.setTelefone(telefone);
		gerente.setCelular(celular);
		gerente.setRecebeEmailMkt(recebeEmailMkt);
		gerente.setSenha(senha);
		gerente.setCotacoes(cotacoes);
		return gerente;
	}

}