package br.com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import br.com.sindico.entity.Administradora;
import br.com.sindico.entity.Cotacao;
import br.com.sindico.entity.Endereco;
import br.com.sindico.entity.GerenteAdministradora;

public class AdministradoraFactory {
	
	public static Administradora criaAdministradora(Date dataCadastro, String cnpj, Collection<Endereco> enderecos,
			String telefone, String celular, String fax, String telefoneComercial, Collection<GerenteAdministradora> gerentes,
			Collection<Cotacao> cotacoes){
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
