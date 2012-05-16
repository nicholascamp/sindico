package com.sindico.factory;

import java.util.Date;

import com.sindico.entity.Endereco;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.Predio;

public class PredioFactory {

	public static Predio criaPredio(final String arquivoFoto, final String cnpj, final Date dataCadastro,
			final Endereco endereco, final String nome, final int numeroApartamentos, final char tipo,
			final GerenteAdministradora gerente, final boolean gerenteRecebeCotacao) {
		Predio predio = new Predio();
		predio.setArquivoFoto(arquivoFoto);
		predio.setCnpj(cnpj);
		predio.setDataCadastro(dataCadastro);
		predio.setEndereco(endereco);
		predio.setNome(nome);
		predio.setNumeroApartamentos(numeroApartamentos);
		predio.setTipo(tipo);
		predio.setGerente(gerente);
		predio.setGerenteRecebeCotacao(gerenteRecebeCotacao);
		return predio;
	}

}
