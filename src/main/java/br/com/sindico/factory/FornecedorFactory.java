package br.com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import br.com.sindico.entity.Cotacao;
import br.com.sindico.entity.Endereco;
import br.com.sindico.entity.Fornecedor;
import br.com.sindico.entity.Subcategoria;

public class FornecedorFactory {
	
	public static Fornecedor criaFornecedor(Date dataCadastro, String nome, String nomePrincipal, String logo,
			Collection<Endereco> enderecos, String cnpj, Collection<Subcategoria> subcategorias, int estrelas,
			boolean anunciante, boolean aprovado, String telefone, String telefoneComercial, String celular,
			String fax, String slogan, String descricao, String title, Collection<String> email, boolean recebeCotacaoEmail1,
			boolean recebeNewsEmail1, boolean recebeCotacaoEmail2, boolean recebeNewsEmail2, boolean recebeCotacaoEmail3,
			boolean recebeNewsEmail3, Collection<Cotacao> cotacoes, Collection<Cotacao> cotacaoVencedoras){
		
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