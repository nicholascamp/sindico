package com.sindico.dao;

import java.util.Date;

import com.sindico.entity.Usuario;
import com.sindico.enums.TipoUsuario;
import com.sindico.factory.UsuarioFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = UsuarioFactory.criaUsuario("Thiago Castro Ferreira", "0212345", "11 1111-1111", "11 8561-1111", 
				new Date(), new Date(), "thiago.castro.ferreira", true, TipoUsuario.MORADOR, null);

	}

}
