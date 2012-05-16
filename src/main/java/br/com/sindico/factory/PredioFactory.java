package br.com.sindico.factory;

import java.util.Date;

import br.com.sindico.entity.Endereco;
import br.com.sindico.entity.GerenteAdministradora;
import br.com.sindico.entity.Predio;

public class PredioFactory {
	
	public static Predio criaPredio(String arquivoFoto, String cnpj, Date dataCadastro, Endereco endereco,
			String nome, int numeroApartamentos, char tipo, GerenteAdministradora gerente, boolean gerenteRecebeCotacao
			){
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
