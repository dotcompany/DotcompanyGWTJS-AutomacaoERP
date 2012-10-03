package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.entidade.FornecedorTO;
import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class FornecedorPO extends AbstractHibernatePO{

	@SuppressWarnings("unchecked")
	public List<FornecedorTO> listCombo(EmpresaTO empresa) throws DaoException {
		String hql  = "";
			   hql += " select distinct F.id, F.nome from " + FornecedorTO.class.getName() + " F";
			   hql += " join F.empresa 	E";
			   hql += " where 1 = 1";
			   hql += " and E.id =" + empresa.getId();
			   hql += " order by F.nome ASC";
		return getDao().queryProjection(hql,"fornecedor").list();
	}
	
	public void excluir(FornecedorTO fornecedor) throws DaoException {
		getDao().remove(fornecedor);
	}
}