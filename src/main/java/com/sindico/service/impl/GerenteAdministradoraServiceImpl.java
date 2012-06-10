/**
 * 
 */
package com.sindico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindico.dao.GerenteAdministradoraDAO;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.service.GerenteAdministradoraService;

/**
 * The Class GerenteAdministradoraServiceImpl.
 * 
 * @author Lucas
 */
@Service("gerenteAdministradoraService")
public class GerenteAdministradoraServiceImpl implements
		GerenteAdministradoraService {

	@Autowired
	GerenteAdministradoraDAO	gerenteAdministradoraDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sindico.service.GerenteAdministradoraService#listaGerentes()
	 */
	@Override
	public List<GerenteAdministradora> listGerentes() {
		return gerenteAdministradoraDAO.getLista();
	}

	@Override
	public GerenteAdministradora getGerente(Long id) {
		return gerenteAdministradoraDAO.getGerenteAdministradora(id);
	}

	@Override
	public GerenteAdministradora createGerente(GerenteAdministradora gerente) {
		return gerenteAdministradoraDAO.criaGerenteAdministradora(gerente);
	}

	@Override
	public GerenteAdministradora updateGerente(GerenteAdministradora gerente) {
		return gerenteAdministradoraDAO.atualizaGerenteAdministradora(gerente);
	}

	@Override
	public boolean removeGerente(Long id) {
		return gerenteAdministradoraDAO.removeGerenteAdministradora(id);
	}

}
