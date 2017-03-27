package br.com.topicos.relatorio.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.topicos.relatorio.domain.Filial;

public class FilialDAOTest {

	@Test
	public void listarDesc() {

		List<Filial> filial = new ArrayList<>();
		FilialDAO filialDAO = new FilialDAO();
		try {
			filial = filialDAO.listaDesc("Efetuado");

			for (Filial retorno : filial) {
				System.out.println(
						"Retorno: " + retorno.getTipo() + " - " + retorno.getNomeLoja() + " - " + retorno.getSoma());
			}
		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}
	}
}
