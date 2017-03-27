package br.com.topicos.relatorio.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.topicos.relatorio.dao.FilialDAO;
import br.com.topicos.relatorio.dao.LojaDAO;
import br.com.topicos.relatorio.domain.Filial;
import br.com.topicos.relatorio.domain.Loja;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LojaBean implements Serializable {
	private Loja loja;
	private String listaTipos;
	private List<String> tipos;
	private String retorno;
	private Filial filial;
	private List<Filial> filiaisDesc;
	private List<Filial> filiaisAsc;

	public void novo() {
		loja = new Loja();
		filial = new Filial();
		loja.setValor(new BigDecimal("00.00"));
		filial.setSoma(new BigDecimal("00.00"));
		
	}

	@PostConstruct
	public void listarTipo() {
		try {
			novo();
			LojaDAO lojaDAO = new LojaDAO();
			tipos = lojaDAO.listaTipo();
			Messages.addGlobalInfo("Tipos listados com sucesso");
			for(String retorno : tipos) {
				System.out.println(retorno);
			}
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Ocorreu erro ao tentar listar os Tipos");
		}
	}
	
	public void localizar(ActionEvent evento) {

		//novo();
		
		System.out.println("TESTEssssssssss: ");

		retorno = (String) evento.getComponent().getAttributes().get("localizaEvento");

		System.out.println("Achou: " + retorno);

		FilialDAO filialDAO = new FilialDAO();

		try {

			filiaisDesc = filialDAO.listaDesc(retorno);
			filiaisAsc = filialDAO.listaAsc(retorno);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar a filial");
			erro.printStackTrace();
		}

	}
	
	public String getRetorno() {
		return retorno;
	}
	
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
	public List<Filial> getFiliaisAsc() {
		return filiaisAsc;
	}
	
	public void setFiliaisAsc(List<Filial> filiaisAsc) {
		this.filiaisAsc = filiaisAsc;
	}
	
	public List<Filial> getFiliaisDesc() {
		return filiaisDesc;
	}
	
	public void setFiliaisDesc(List<Filial> filiaisDesc) {
		this.filiaisDesc = filiaisDesc;
	}
	
	public Filial getFilial() {
		return filial;
	}
	
	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String getListaTipos() {
		return listaTipos;
	}

	public void setListaTipos(String listaTipos) {
		this.listaTipos = listaTipos;
	}
	
	public List<String> getTipos() {
		return tipos;
	}
	
	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}
}
