package br.com.dotcompany.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.to.TransferObject;

/**
 * Classe de acesso ao banco de dados.
 * Possui serviços basicos.
 * 
 * @author sergio
 *
 */
@Repository
public class DaoImpl extends PSHibernateDaoSupport implements Dao {

	@Override
	public  boolean salvar(
			TransferObject entidade) {
		try {
			this.getHibernateTemplate().save(entidade);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public void runSql(String sql) throws DaoException {
		getSession().createSQLQuery(sql).executeUpdate();
	}
	
	@Override
	public void initialize(Object to) {
		this.getHibernateTemplate().initialize(to);
	}
	
	@Override
	public  boolean salvar(Class<?> clazz, Object obj) {
		try {
			this.getHibernateTemplate().save(clazz.getName(), obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public  boolean atualizar(
			TransferObject entidade) {
		try {
			this.getHibernateTemplate().update(entidade);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public  boolean remove(
			TransferObject entidade) {
		try {
			this.getHibernateTemplate().delete(entidade);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public  boolean existe(
			TransferObject entidade) {
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("select count(TABELA.id) ");
			hql.append("from " + entidade.getClass().getName() + " TABELA");
			hql.append("where = " + entidade.getKey());

			Query query = super.createQuery(hql.toString());
			return query.uniqueResult() != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public  TransferObject consultarObjeto(
			Class<?> clazz, Serializable id) {
		try {
			return (TransferObject) this.getHibernateTemplate().load(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public  TransferObject consultarObjeto(
			String hql) {
		try {
			Query query = super.createQuery(hql);
			return (TransferObject) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void retirarObjetoSessao(Object value) {
		try {
			getHibernateTemplate().evict(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public  <T extends TransferObject> List <T> listaDemanda(Class<?> clazz, String hql, int startPage, int maxResults) {
		try {
			Query query = queryProjection(hql);
			query.setFirstResult(startPage);
			query.setMaxResults(maxResults);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public  <T extends TransferObject> List <T> consultarLista(String hql) {
		Query query = super.createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public  <T extends TransferObject> List <T> listarLike(Class<?> clazz, String hql) {
		Query query = super.createQuery(hql);
		query.setResultTransformer(new AliasToBeanResultTransformer(clazz));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public  <T extends TransferObject> List <T> consultarLista(Class<?> clazz, String hql) {
		Query query = super.createQuery(hql);
		query.setResultTransformer(new ExportDotcompanyResultTransformer(clazz));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public  <T extends TransferObject> Collection<T> consultarObjetos(
			Class<?> tipoDaClasse) {
		try {
			return super.createCriteria(tipoDaClasse).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Query query(String hql) throws DaoException {
		return createQuery(hql);
	}
	
	@Override
	public int queryCount(String hql) throws DaoException {
		Number n = (Number) this.query(hql).uniqueResult();
		return  n == null ? 0 : n.intValue();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends TransferObject> T queryUnique(String hql) throws DaoException {
		return (T) this.query(hql).setMaxResults(1).uniqueResult();
	}

	@Override
	public boolean queryExists(String hql) throws DaoException {
		return this.query(hql).setMaxResults(1).uniqueResult() != null;
	}
	
	@Override
	public Query queryProjection(String hql) throws DaoException {
		// hql COM alias para as projeções.
		if (hql.toLowerCase().contains(" as ")) {
			boolean distinct = hql.toLowerCase().contains("distinct");
			Class<?> clazz = HqlTransformer.clazzForHql(hql);
			return query(hql).setResultTransformer(new HqlTransformer(clazz, distinct, true));
		}
		// hql SEM alias para as projeções.
		return query(hql).setResultTransformer(new HqlTransformer(hql));
	}
	
	@Override
	public Query queryProjection(String hql, String forClazz) throws DaoException {
		return query(hql).setResultTransformer(new HqlTransformer(hql, forClazz));
	}
	
	@Override
	public Query queryProjection(String hql, ResultTransformer rt) throws DaoException {
		if (rt == null) {
			return queryProjection(hql);
		}
		return query(hql).setResultTransformer(rt);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends TransferObject> T buscar(T t) throws DaoException {
		return (T) getSession().get(((TransferObject)t).getClass(), ((TransferObject)t).getKey());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends TransferObject> T pegar(T t) throws DaoException {
		return (T) getSession().load(((TransferObject)t).getClass(), ((TransferObject)t).getKey());
	}
}