package com.sindico.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sindico.entity.Administradora;

public interface AdministradoraService {
	
	@Transactional
	List<Administradora> listAdministradoras();
	
	@Transactional
	Administradora getAdministradora(Long id);
	
	@Transactional
	Administradora createAdministradora(Administradora administradora);
	
	@Transactional
	Administradora updateAdministradora(Administradora administradora);
	
	@Transactional
	boolean removeAdministradora(Long id);
}
