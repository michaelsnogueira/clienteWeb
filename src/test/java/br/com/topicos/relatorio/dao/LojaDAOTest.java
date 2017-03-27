package br.com.topicos.relatorio.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topicos.relatorio.domain.Loja;

public class LojaDAOTest {
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {
		Loja loja = new Loja();

		loja.setDataHora(new Date(2017 - 1900, 02, 11, 16, 58));
		loja.setLoja('M');
		loja.setTipo("Teste");
		loja.setValor(new BigDecimal("20.00"));

		LojaDAO lojaDAO = new LojaDAO();

		try {
			lojaDAO.salvar(loja);
			System.out.println("Loja salva com sucesso");
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar salvar a loja " + erro.getMessage());
		}
	}

	@Test
	public void listarDesc() {
		LojaDAO lojaDAO = new LojaDAO();
		try {
			List<Loja> resultado = lojaDAO.listarDesc("Efetuado");
			System.out.println("REtorno list: " + resultado.size());

		System.out.println("Tipo: " + resultado.get(1).getTipo());
			for (Loja loja : resultado) {

				System.out.println("retorno: " + loja.getTipo());
			}
		} catch (RuntimeException erro) {
//			erro.printStackTrace();
			System.out.println("Erro ao tentar listar em forma decrescente a loja " + erro.getMessage());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		LojaDAO lojaDAO = new LojaDAO();
		Loja loja = lojaDAO.buscar(57L);

		System.out.println(loja.getTipo());

	}

	@Test
	@Ignore
	public void excluir() {
		LojaDAO lojaDAO = new LojaDAO();
		Loja loja = lojaDAO.buscar(63589l);

		try {
			lojaDAO.excluir(loja);
			System.out.println("Excluido com sucesso");
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar excluir a loja " + erro.getMessage());
		}
	}

	@Test
	@Ignore
	public void editar() {
		LojaDAO lojaDAO = new LojaDAO();

		Loja loja = lojaDAO.buscar(63590L);

		try {
			loja.setTipo("Teste2");
			lojaDAO.editar(loja);
			System.out.println("Registro alterado com sucesso");
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar editar a loja " + erro.getMessage());
		}
	}

	@Test
	@Ignore
	public void merge() {
		LojaDAO lojaDAO = new LojaDAO();
		Loja loja = lojaDAO.buscar(63590L);
		loja.setTipo("TEste3");
		lojaDAO.merge(loja);
	}

	@Test
	@Ignore
	public void listaTipo() {
		LojaDAO lojaDAO = new LojaDAO();
		try {
			List<String> resultado = lojaDAO.listaTipo();

			for (String loja : resultado) {
				System.out.println("Loja: " + loja);
			}
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar listar o distinct da loja: " + erro.getMessage());
		}

	}
}
