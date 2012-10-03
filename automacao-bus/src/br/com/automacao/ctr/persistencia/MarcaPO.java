package br.com.automacao.ctr.persistencia;


import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.MarcaTO;

import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class MarcaPO extends AbstractHibernatePO{

	
	
		public void excluir(MarcaTO marca) throws DaoException {
		getDao().remove(marca);
	}
}
