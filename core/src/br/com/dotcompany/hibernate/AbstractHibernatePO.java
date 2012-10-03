package br.com.dotcompany.hibernate;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * Possui acesso ao Dao de servi�o basico, classes PO dever�o extender
 * 
 * @author sergio
 *
 */
public class AbstractHibernatePO extends PSHibernateDaoSupport {

	public final static String UNCHECKED = "unchecked"; 
	
	@Autowired
	private Dao dao;

	protected Dao getDao() {
		return dao;
	}

	protected void setDao(Dao dao) {
		this.dao = dao;
	}
}