package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Administradora;
import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.Subcategoria;
import com.sindico.entity.Usuario;
import com.sindico.enums.Status;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Cotacao objects.
 */
public class CotacaoFactory {

	/**
	 * Cria cotacao.
	 * 
	 * @param data
	 *            the data
	 * @param subcategoria
	 *            the subcategoria
	 * @param status
	 *            the status
	 * @param aprovada
	 *            the aprovada
	 * @param usuario
	 *            the usuario
	 * @param administradora
	 *            the administradora
	 * @param gerente
	 *            the gerente
	 * @param fornecedores
	 *            the fornecedores
	 * @param fornecedorVencedor
	 *            the fornecedor vencedor
	 * @return the cotacao
	 */
	public static Cotacao criaCotacao(final Date data,
			final Subcategoria subcategoria, final Status status,
			final boolean aprovada, final Usuario usuario,
			final Administradora administradora,
			final GerenteAdministradora gerente,
			final Collection<Fornecedor> fornecedores,
			final Fornecedor fornecedorVencedor) {
		Cotacao cotacao = new Cotacao();
		cotacao.setData(data);
		cotacao.setSubcategoria(subcategoria);
		cotacao.setStatus(status);
		cotacao.setAprovada(aprovada);
		cotacao.setUsuario(usuario);
		cotacao.setAdministradora(administradora);
		cotacao.setGerenteAdmin(gerente);
		cotacao.setFornecedores(fornecedores);
		cotacao.setFornecedorVencedor(fornecedorVencedor);
		return cotacao;
	}

}
