package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Cotacao;
import com.sindico.entity.Endereco;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.Subcategoria;

/**
 * A factory for creating Fornecedor objects.
 */
public class FornecedorFactory {

	/**
	 * Cria fornecedor.
	 * 
	 * @param dataCadastro
	 *            the data cadastro
	 * @param nome
	 *            the nome
	 * @param nomePrincipal
	 *            the nome principal
	 * @param logo
	 *            the logo
	 * @param enderecos
	 *            the enderecos
	 * @param cnpj
	 *            the cnpj
	 * @param subcategorias
	 *            the subcategorias
	 * @param estrelas
	 *            the estrelas
	 * @param anunciante
	 *            the anunciante
	 * @param aprovado
	 *            the aprovado
	 * @param telefone
	 *            the telefone
	 * @param telefoneComercial
	 *            the telefone comercial
	 * @param celular
	 *            the celular
	 * @param fax
	 *            the fax
	 * @param slogan
	 *            the slogan
	 * @param descricao
	 *            the descricao
	 * @param title
	 *            the title
	 * @param email
	 *            the email
	 * @param recebeCotacaoEmail1
	 *            the recebe cotacao email1
	 * @param recebeNewsEmail1
	 *            the recebe news email1
	 * @param recebeCotacaoEmail2
	 *            the recebe cotacao email2
	 * @param recebeNewsEmail2
	 *            the recebe news email2
	 * @param recebeCotacaoEmail3
	 *            the recebe cotacao email3
	 * @param recebeNewsEmail3
	 *            the recebe news email3
	 * @param cotacoes
	 *            the cotacoes
	 * @param cotacaoVencedoras
	 *            the cotacao vencedoras
	 * @return the fornecedor
	 */
	public static Fornecedor criaFornecedor(final Date dataCadastro, final String nome, final String nomePrincipal,
			final String logo, final Collection<Endereco> enderecos, final String cnpj,
			final Collection<Subcategoria> subcategorias, final int estrelas, final boolean anunciante,
			final boolean aprovado, final String telefone, final String telefoneComercial, final String celular,
			final String fax, final String slogan, final String descricao, final String title,
			final Collection<String> email, final boolean recebeCotacaoEmail1, final boolean recebeNewsEmail1,
			final boolean recebeCotacaoEmail2, final boolean recebeNewsEmail2, final boolean recebeCotacaoEmail3,
			final boolean recebeNewsEmail3, final Collection<Cotacao> cotacoes,
			final Collection<Cotacao> cotacaoVencedoras) {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setDataCadastro(dataCadastro);
		fornecedor.setNome(nome);
		fornecedor.setNomePrincipal(nomePrincipal);
		fornecedor.setLogo(logo);
		fornecedor.setEnderecos(enderecos);
		fornecedor.setCnpj(cnpj);
		fornecedor.setSubcategorias(subcategorias);
		fornecedor.setEstrelas(estrelas);
		fornecedor.setAnunciante(anunciante);
		fornecedor.setAprovado(aprovado);
		fornecedor.setTelefone(telefone);
		fornecedor.setTelefoneComercial(telefoneComercial);
		fornecedor.setCelular(celular);
		fornecedor.setFax(fax);
		fornecedor.setSlogan(slogan);
		fornecedor.setDescricao(descricao);
		fornecedor.setTitle(title);
		fornecedor.setEmail(email);
		fornecedor.setRecebeCotacaoEmail1(recebeCotacaoEmail1);
		fornecedor.setRecebeCotacaoEmail2(recebeCotacaoEmail2);
		fornecedor.setRecebeCotacaoEmail3(recebeCotacaoEmail3);
		fornecedor.setRecebeNewsEmail1(recebeNewsEmail1);
		fornecedor.setRecebeNewsEmail2(recebeNewsEmail2);
		fornecedor.setRecebeNewsEmail3(recebeNewsEmail3);
		fornecedor.setCotacoes(cotacoes);
		fornecedor.setCotacoesVencedoras(cotacaoVencedoras);
		return fornecedor;
	}
}