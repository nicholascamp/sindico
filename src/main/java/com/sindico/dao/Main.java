package com.sindico.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sindico.entity.Categoria;
import com.sindico.entity.Endereco;
import com.sindico.entity.Predio;
import com.sindico.entity.Subcategoria;
import com.sindico.entity.Usuario;
import com.sindico.enums.TipoUsuario;
import com.sindico.factory.CategoriaFactory;
import com.sindico.factory.PredioFactory;
import com.sindico.factory.SubcategoriaFactory;
import com.sindico.factory.UsuarioFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = UsuarioFactory.criaUsuario("Thiago", "Castro Ferreira", "thicas", 
				"11 2967-2420", "11 8561-6083", "", "", new Date(), new Date(), 
				"thiago.castro.ferreira@gmail.com", true, TipoUsuario.SINDICO, null);
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Vila Maria Alta");
		endereco.setCep("02129-170");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setEndereco("Rua Prefeito Molton Improta");
		endereco.setComplemento("casa");
		endereco.setNumero(99);
		Predio predio = PredioFactory.criaPredio(null, "3951.1111.0000.00-52", 
				new Date(), endereco, "Edifício Don Velasquez", 68, 's', null, false);
		
		Categoria categoria = CategoriaFactory.criaCategoria("Elevadores", null);
		
		Subcategoria subcategoria = SubcategoriaFactory.criSubcategoria("Elevadores de Plástico", categoria, null, null);
		
		Collection<Subcategoria> sub = new ArrayList<Subcategoria>();
		sub.add(subcategoria);
		categoria.setSubcategorias(sub);
		
		Configuration cfg = new Configuration().configure( "hibernate.cfg.xml" );
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(usuario);
		session.save(predio);
		session.save(categoria);
		session.save(subcategoria);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();

	}

}