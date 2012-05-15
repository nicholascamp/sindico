package br.com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import br.com.sindico.entity.Administradora;
import br.com.sindico.entity.Cotacao;
import br.com.sindico.entity.GerenteAdministradora;
import br.com.sindico.entity.Predio;

public class GerenteAdministradoraFactory {
	
	public static GerenteAdministradora criGerenteAdministradora(Administradora admin, Collection<Predio> predios, Date dataCadastro, 
			String nome, String sobrenome, String email, String telefone, String celular, String fax,
			String telefoneComercial, Collection<Boolean> recebeCotacaoPredios, boolean recebeEmailMkt, String senha,
			Collection<Cotacao> cotacoes){
		GerenteAdministradora gerente = new GerenteAdministradora();
		gerente.setAdministradora(admin);
		gerente.setPredios(predios);
		gerente.setDataCadastro(dataCadastro);
		gerente.setNome(nome);
		gerente.setSobrenome(sobrenome);
		gerente.setEmail(email);
		gerente.setTelefone(telefone);
		gerente.setCelular(celular);
		gerente.setFax(fax);
		gerente.setTelefoneComercial(telefoneComercial);
		gerente.setRecebeCotacaoPredios(recebeCotacaoPredios);
		gerente.setRecebeEmailMkt(recebeEmailMkt);
		gerente.setSenha(senha);
		gerente.setCotacoes(cotacoes);
		return gerente;
	}

}