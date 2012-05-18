package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Administradora;
import com.sindico.entity.Cotacao;
import com.sindico.entity.Endereco;
import com.sindico.entity.GerenteAdministradora;

public class AdministradoraFactory {

	public static Administradora criaAdministradora(final Date dataCadastro, final String cnpj,
			final Collection<Endereco> enderecos, final String telefone, final String celular, final String fax,
			final String telefoneComercial, final Collection<GerenteAdministradora> gerentes,
			final Collection<Cotacao> cotacoes) {
		Administradora admin = new Administradora();
		admin.setDataCadastro(dataCadastro);
		admin.setCnpj(cnpj);
		admin.setEnderecos(enderecos);
		admin.setTelefone(telefone);
		admin.setTelefoneComercial(telefoneComercial);
		admin.setCelular(celular);
		admin.setFax(fax);
		admin.setGerentes(gerentes);
		admin.setCotacoes(cotacoes);
		return admin;

	}

}
