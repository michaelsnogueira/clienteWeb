package br.com.topicos.relatorio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.topicos.relatorio.domain.Filial;
import br.com.topicos.relatorio.util.HibernateUtil;

public class FilialDAO extends GenericDAO<Filial> {

	@SuppressWarnings("unchecked")
	public List<Filial> listaDesc(String tipo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Filial.class);
			consulta.add(Restrictions.eq("tipo", tipo));
			consulta.addOrder(Order.desc("soma"));
			List<Filial> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Filial> listaAsc(String tipo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Filial.class);
			consulta.add(Restrictions.eq("tipo", tipo));
			consulta.addOrder(Order.asc("soma"));
			List<Filial> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
