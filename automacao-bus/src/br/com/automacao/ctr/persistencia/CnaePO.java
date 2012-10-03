package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.CnaeTO;
import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class CnaePO extends AbstractHibernatePO{

	@SuppressWarnings("unchecked")
	public List<CnaeTO> listAllCnae() throws DaoException {
		String hql  = "";
			   hql += " select distinct C.id, C.nome from " + CnaeTO.class.getName() + " C";
			   hql += " order by C.nome ASC";
		return getDao().queryProjection(hql).list();
	}
}