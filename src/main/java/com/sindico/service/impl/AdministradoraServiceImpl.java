package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.AdministradoraDAO;
import com.sindico.entity.Administradora;
import com.sindico.service.AdministradoraService;

@Service("administradoraService")
public class AdministradoraServiceImpl implements AdministradoraService {

	@Autowired
	AdministradoraDAO	dao;

	@Override
	public List<Administradora> listAdministradoras() {
		return dao.getLista();
	}

	@Override
	public Administradora getAdministradora(final Long id) {
		return dao.getAdministradora(id);
	}

	@Override
	public Administradora createAdministradora(
			final Administradora administradora) {
		return dao.criaAdministradora(administradora);
	}

	@Override
	public Administradora updateAdministradora(
			final Administradora administradora) {
		return dao.atualizaAdministradota(administradora);
	}

	@Override
	public boolean removeAdministradora(final Long id) {
		return dao.removeAdministradora(id);
	}

}
