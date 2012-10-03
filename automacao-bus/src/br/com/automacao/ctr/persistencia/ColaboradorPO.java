package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.ColaboradorTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.entidade.ServicoColaboradorTO;
import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class ColaboradorPO extends AbstractHibernatePO{

	@SuppressWarnings("unchecked")
	public List<ColaboradorTO> listCombo(EmpresaTO empresa) throws DaoException {
		String hql  = "";
			   hql += " select distinct C.id, C.nome from " + ServicoColaboradorTO.class.getName() + " CS";
			   hql += " join CS.colaborador 		C";
			   hql += " join C.empresa 				E";
			   hql += " where 1 = 1";
			   hql += " and E.id =" + empresa.getId();
			   hql += " order by C.nome ASC";
		return getDao().queryProjection(hql,"colaborador").list();
	}
	
	public void excluir(ColaboradorTO colaborador) throws DaoException {
		getDao().remove(colaborador);
	}
}