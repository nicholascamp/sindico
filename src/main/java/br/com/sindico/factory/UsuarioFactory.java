package br.com.sindico.factory;

import java.util.Collection;
import java.util.Date;

import br.com.sindico.entity.Cotacao;
import br.com.sindico.entity.Usuario;

public class UsuarioFactory {
	public static Usuario criaUsuario(String nome, String sobrenome, String senha, String telefone, String celular,
			String fax, String telefoneComercial, Date dataCadastro, Date dataNascimento, String email,
			boolean recebeCotacao, char tipo, Collection<Cotacao> cotacoes){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		usuario.setCelular(celular);
		usuario.setFax(fax);
		usuario.setTelefoneComercial(telefoneComercial);
		usuario.setDataCadastro(dataCadastro);
		usuario.setDataNascimento(dataNascimento);
		usuario.setEmail(email);
		usuario.setRecebeCotacao(recebeCotacao);
		usuario.setTipo(tipo);
		usuario.setCotacoes(cotacoes);
		return usuario;		
	}

}
