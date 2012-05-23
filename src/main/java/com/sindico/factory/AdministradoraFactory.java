package com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import com.sindico.entity.Administradora;
import com.sindico.entity.Endereco;
import com.sindico.entity.GerenteAdministradora;

public class AdministradoraFactory {

	public static Administradora criaAdministradora(final Date dataCadastro, final String cnpj,
			final Collection<Endereco> enderecos, final String telefone, final String celular, 
			final Collection<GerenteAdministradora> gerentes) {
		Administradora admin = new Administradora();
		admin.setDataCadastro(dataCadastro);
		admin.setCnpj(cnpj);
		admin.setEnderecos(enderecos);
		admin.setTelefone(telefone);
		admin.setCelular(celular);
		admin.setGerentes(gerentes);
		return admin;

	}

}
