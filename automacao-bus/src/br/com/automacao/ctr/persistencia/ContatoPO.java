package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.ContatoTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.entidade.ServicoContatoTO;
import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class ContatoPO extends AbstractHibernatePO{

	@SuppressWarnings("unchecked")
	public List<ContatoTO> listCombo(EmpresaTO empresa) throws DaoException {
		String hql  = "";
			   hql += " select distinct C.id, C.nome from " + ServicoContatoTO.class.getName() + " CS";
			   hql += " join CS.contato 		C";
			   hql += " join C.empresa 				E";
			   hql += " where 1 = 1";
			   hql += " and E.id =" + empresa.getId();
			   hql += " order by C.nome ASC";
		return getDao().queryProjection(hql,"contato").list();
	}
	public void excluir(ContatoTO contato) throws DaoException {
		getDao().remove(contato);
	}
}