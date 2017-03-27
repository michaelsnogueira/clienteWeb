package br.com.topicos.relatorio.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Loja extends GenericDomain {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHora;

	@Column(nullable = false)
	private Character nomeLoja;

	@Column(nullable = false, length = 15)
	private String tipo;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((nomeLoja == null) ? 0 : nomeLoja.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (nomeLoja == null) {
			if (other.nomeLoja != null)
				return false;
		} else if (!nomeLoja.equals(other.nomeLoja))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loja [dataHora=" + dataHora + ", nomeLoja=" + nomeLoja + ", tipo=" + tipo + ", valor=" + valor + "]";
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Character getLoja() {
		return nomeLoja;
	}

	public void setLoja(Character nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
