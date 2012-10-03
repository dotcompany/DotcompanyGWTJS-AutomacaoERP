package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.entidade.ModelosTO;
import br.com.automacao.ctr.entidade.ServicoColaboradorTO;
import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;


@Repository
public class ModelosPO extends AbstractHibernatePO{

	@SuppressWarnings("unchecked")
	public List<ModelosTO> listCombo(EmpresaTO empresa) throws DaoException {
		String hql  = "";
			   hql += " select distinct C.id, C.nome from " + ServicoColaboradorTO.class.getName() + " CS";
			   hql += " join CS.modelos 		M";
			   hql += " join C.empresa 				E";
			   hql += " where 1 =1 ";
			   hql += " and E.id =" + empresa.getId();
			   hql += " order by C.nome ASC";
		return getDao().queryProjection(hql,"modelos").list();
	}
	
	public void excluir(ModelosTO modelos) throws DaoException {
		getDao().remove(modelos);
	}
}

