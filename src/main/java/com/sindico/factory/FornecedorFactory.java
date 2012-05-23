package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Cotacao;
import com.sindico.entity.EmailFornecedor;
import com.sindico.entity.Endereco;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.Subcategoria;

/**
 * A factory for creating Fornecedor objects.
 */
public class FornecedorFactory {


	public static Fornecedor criaFornecedor(final Date dataCadastro, final String nome, final String nomePrincipal,
			final String logo, final Endereco endereco, final String cnpj,
			final Collection<Subcategoria> subcategorias, final int estrelas, final boolean anunciante,
			final boolean aprovado, final String telefone,  final String celular,
			final String slogan, final String descricao, final String title,
			final Collection<EmailFornecedor> email,  final Collection<Cotacao> cotacoes,
			final Collection<Cotacao> cotacaoVencedoras) {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setDataCadastro(dataCadastro);
		fornecedor.setNome(nome);
		fornecedor.setNomePrincipal(nomePrincipal);
		fornecedor.setLogo(logo);
		fornecedor.setEndereco(endereco);
		fornecedor.setCnpj(cnpj);
		fornecedor.setSubcategorias(subcategorias);
		fornecedor.setEstrelas(estrelas);
		fornecedor.setAnunciante(anunciante);
		fornecedor.setAprovado(aprovado);
		fornecedor.setTelefone(telefone);
		fornecedor.setCelular(celular);
		fornecedor.setSlogan(slogan);
		fornecedor.setDescricao(descricao);
		fornecedor.setTitle(title);
		fornecedor.setEmail(email);
		fornecedor.setCotacoes(cotacoes);
		fornecedor.setCotacoesVencedoras(cotacaoVencedoras);
		return fornecedor;
	}
}