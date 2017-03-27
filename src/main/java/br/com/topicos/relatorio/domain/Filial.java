package br.com.topicos.relatorio.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Filial extends GenericDomain {

	@Column(nullable = false)
	private Character nomeLoja;

	@Column(nullable = false, length = 15)
	private String tipo;

	@Column(precision = 6, scale = 2)
	private BigDecimal soma;

	public Character getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(Character nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public BigDecimal getSoma() {
		return soma;
	}

	public void setSoma(BigDecimal soma) {
		this.soma = soma;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
