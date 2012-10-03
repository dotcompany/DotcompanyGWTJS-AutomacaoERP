package br.com.dotcompany.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Classe base que tem acesso a session do hibernate. Essa classe foi mapeada no
 * applicationContext.xml.
 * 
 * @author sergio
 * 
 */

public class PSHibernateDaoSupport extends HibernateDaoSupport {

	/**
	 * Disponibiliza o uso de criteria
	 * 
	 * @param clazz
	 * @return
	 */
	protected final Criteria createCriteria(Class<?> clazz) {
		return getSessionFactory().getCurrentSession().createCriteria(clazz);
	}

	/**
	 * Disponibiliza o uso da hql
	 * 
	 * @param hql
	 * @return
	 */
	protected final Query createQuery(String hql) {
		return getSessionFactory().getCurrentSession().createQuery(hql);
	}
}