package br.com.topicos.relatorio.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import br.com.topicos.relatorio.domain.Loja;
import br.com.topicos.relatorio.util.HibernateUtil;

public class LojaDAO extends GenericDAO<Loja> {

	@SuppressWarnings("unchecked")
	public List<String> listaTipo() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Loja.class);
			consulta.setProjection(Projections.distinct(Projections.property("tipo")));
			List<String> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Loja> listarDesc(String tipo) {

		System.out.println("Tipo: " + tipo);
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Loja> resultado = new ArrayList<>();
		try {
			Criteria consulta = sessao.createCriteria(Loja.class);
//			consulta.setResultTransformer(Transformers.aliasToBean(Loja.class));
			resultado = consulta.setProjection(Projections.projectionList().add(Projections.property("codigo"))
					.add(Projections.property("dataHora")).add(Projections.groupProperty("nomeLoja"))
					.add(Projections.property("tipo")).add(Projections.sum("valor")))
					.add(Property.forName("tipo").eq(tipo)).list();

//			resultado = consulta.list();
//			
//			resultado = (List<Loja>) consulta.setProjection(Projections.property("codigo"))
//					.setProjection(Projections.property("dataHora"))
//					.add((Criterion) Projections.groupProperty("nomeLoja")).setProjection(Projections.property("tipo"))
//					.add((Criterion) Projections.sum("valor")).add(Property.forName("tipo").eq(tipo)).list();
		} catch (RuntimeException erro) {
			throw erro;
		}
		return resultado;
	}

}
