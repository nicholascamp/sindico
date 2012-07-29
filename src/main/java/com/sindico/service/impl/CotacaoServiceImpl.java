/**
 * 
 */
package com.sindico.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sindico.dao.CotacaoDAO;
import com.sindico.dao.RespostaCotacaoDAO;
import com.sindico.entity.Cotacao;
import com.sindico.entity.Fornecedor;
import com.sindico.entity.GerenteAdministradora;
import com.sindico.entity.Predio;
import com.sindico.entity.RespostaCotacao;
import com.sindico.entity.Usuario;
import com.sindico.service.CotacaoService;
import com.sindico.service.EmailService;
import com.sindico.service.GerenteAdministradoraService;
import com.sindico.service.UsuarioService;
import com.sindico.utils.StringUtils;



// TODO: Auto-generated Javadoc
/**
 * The Class CotacaoServiceImpl.
 * 
 * @author Lucas
 */
@Service("cotacaoService")
public class CotacaoServiceImpl implements CotacaoService {

	@Autowired
	CotacaoDAO						cotacaoDAO;

	@Autowired
	RespostaCotacaoDAO				respostaCotacaoDAO;

	@Autowired
	UsuarioService					usuarioService;

	@Autowired
	GerenteAdministradoraService	gerenteService;

	@Autowired
	EmailService					emailService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#listarPorFornecedor(java.lang.Long)
	 */
	@Override
	public List<Cotacao> listarPorFornecedor(final Long fornecedorId) {
		return cotacaoDAO.listarPorFornecedor(fornecedorId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#criarCotacao(com.sindico.entity.Cotacao
	 * )
	 */
	@Override
	public Cotacao criarCotacao(final Cotacao cotacao) {
		return cotacaoDAO.criaCotacao(cotacao);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#atualizarCotacao(com.sindico.entity
	 * .Cotacao)
	 */
	@Override
	public Cotacao atualizarCotacao(final Cotacao cotacao) {
		return cotacaoDAO.atualizaCotacao(cotacao);
	}

	@Override
	public List<Cotacao> listCotacoes() {
		// TODO Auto-generated method stub
		return cotacaoDAO.getLista();
	}

	@Override
	public List<Cotacao> listCotacoes(final Long usuarioId) {
		return cotacaoDAO.getLista(usuarioId);
	}

	@Override
	public List<Cotacao> listCotacoes(final Predio predio) {
		return cotacaoDAO.getLista(predio);
	}

	@Override
	public boolean removerCotacao(final Long id) {
		// TODO Auto-generated method stub
		Cotacao cotacao = cotacaoDAO.getCotacao(id);
		if (cotacao != null) {
			cotacaoDAO.removeCotacao(id);
			return true;
		}
		return false;
	}

	@Override
	public Cotacao getCotacao(final Long id) {
		Cotacao cotacao = cotacaoDAO.getCotacao(id);
		return cotacao;
	}

	@Override
	public RespostaCotacao getRespostaCotacao(final Long id) {
		return respostaCotacaoDAO.getRespostaCotacao(id);
	}

	@Override
	public List<RespostaCotacao> listRespostasCotacao() {
		List<RespostaCotacao> respostaCotacao = respostaCotacaoDAO.getLista();
		return preencheRespostaCotacao(respostaCotacao);
	}

	@Override
	public List<RespostaCotacao> listRespostasCotacao(final Long idCotacao,
			final Long idFornecedor) {
		// TODO Auto-generated method stub
		List<RespostaCotacao> respostaCotacao = respostaCotacaoDAO.getLista(
				idCotacao, idFornecedor);
		return respostaCotacao;
	}

	@Override
	public List<RespostaCotacao> listRespostasCotacao(final Long idCotacao) {
		List<RespostaCotacao> respostaCotacao = respostaCotacaoDAO
				.getLista(idCotacao);
		return preencheRespostaCotacao(respostaCotacao);
	}

	@Override
	public List<RespostaCotacao> listRespostasCotacaoHistorico(
			final Cotacao cotacao) {
		List<RespostaCotacao> respostaCotacao = new ArrayList<RespostaCotacao>();

		for (Fornecedor fornecedor : cotacao.getFornecedores()) {
			RespostaCotacao resposta = respostaCotacaoDAO.getRespostaCotacao(
					cotacao.getId(), fornecedor.getId());

			if (resposta != null) {
				respostaCotacao.add(resposta);
			}
		}
		return respostaCotacao;
	}

	@Override
	public boolean possuiNegociacaoAberta(long cotacaoId, long fornecedorId) {
		return (respostaCotacaoDAO.getRespostaCotacaoAberta(cotacaoId, fornecedorId) != null);

	}

	@Override
	public RespostaCotacao updateRespostaCotacao(
			final RespostaCotacao respostaCotacao) {
		return respostaCotacaoDAO.atualizaRespostaCotacao(respostaCotacao);
	}

	@Override
	public void removeRespostaCotacao(final Long id) {
		respostaCotacaoDAO.removeRespostaCotacao(id);
	}

	@Override
	public RespostaCotacao criaRespostaCotacao(
			final RespostaCotacao respostaCotacao) {
		return respostaCotacaoDAO.criaRespostaCotacao(respostaCotacao);
	}

	public List<RespostaCotacao> preencheRespostaCotacao(
			final List<RespostaCotacao> respostaCotacao) {
		List<RespostaCotacao> aux = new ArrayList<RespostaCotacao>();

		for (RespostaCotacao resposta : respostaCotacao) {
			if (verificaExistenciaFornecedor(aux, resposta)) {
				aux.add(resposta);
			}
		}
		return aux;
	}

	public boolean verificaExistenciaFornecedor(
			final List<RespostaCotacao> respostas,
			final RespostaCotacao resposta) {
		for (RespostaCotacao respostaAux : respostas) {
			if (respostaAux.getFornecedor().equals(resposta.getFornecedor())) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#adicionarGerente(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public void adicionarGerente(final String email, final Long cotacaoId)
			throws Exception {

		GerenteAdministradora gerente = gerenteService.getByEmail(email);
		if (gerente == null) {
			gerente = new GerenteAdministradora("Convidado",
					StringUtils.encodePassword("sindico", email), email);
			gerenteService.createGerente(gerente);
			emailService.emailCadastro("", email);
		}

		Cotacao cotacao = getCotacao(cotacaoId);
		cotacao.setGerenteAdmin(gerente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sindico.service.CotacaoService#adicionarUsuario(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public void adicionarUsuario(final String email, final Long cotacaoId)
			throws Exception {

		Usuario usuario = usuarioService.loadByUsername(email);
		if (usuario == null) {
			usuario = new Usuario("Convidado", StringUtils.encodePassword(
					"sindico", email), email);
			usuarioService.criaUsuario(usuario);
		}
		Cotacao cotacao = getCotacao(cotacaoId);
		cotacao.addUsuario(usuario);
		emailService.emailCadastro("", email);

	}
}
