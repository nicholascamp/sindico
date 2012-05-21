package com.sindico.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="EMAIL_FORNECEDOR")
public class EmailFornecedor {
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name = "RECEBE_COTACAO_EMAIL")
	private boolean recebeCotacaoEmail;

	@Column(name = "RECEBE_NEWS_EMAIL")
	private boolean recebeNewsEmail;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRecebeCotacaoEmail() {
		return recebeCotacaoEmail;
	}

	public void setRecebeCotacaoEmail(boolean recebeCotacaoEmail) {
		this.recebeCotacaoEmail = recebeCotacaoEmail;
	}

	public boolean isRecebeNewsEmail() {
		return recebeNewsEmail;
	}

	public void setRecebeNewsEmail(boolean recebeNewsEmail) {
		this.recebeNewsEmail = recebeNewsEmail;
	}
	
	
}
