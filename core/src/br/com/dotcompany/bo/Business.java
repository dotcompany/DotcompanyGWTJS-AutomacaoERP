package br.com.dotcompany.bo;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.dotcompany.hibernate.Dao;

/**
 * Classe a ser extendida por todas classes de negocio do sistema pois com ela
 * se tem acesso as funcionalidades basicas em banco de dados.
 * 
 * @author sergio
 * 
 */
public abstract class Business {

	@Autowired
	private Dao dao;

	protected Dao getDao() {
		return dao;
	}

	protected void setDao(Dao dao) {
		this.dao = dao;
	}
}