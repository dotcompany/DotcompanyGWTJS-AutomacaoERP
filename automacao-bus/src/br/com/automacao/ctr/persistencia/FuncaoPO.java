package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.FuncaoTO;
import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.hibernate.AbstractHibernatePO;

@Repository
public class FuncaoPO extends AbstractHibernatePO{

	@SuppressWarnings("unchecked")
	public List<FuncaoTO> listAllFuncao() throws DaoException {
		String hql  = "";
			   hql += " select F.id, F.descricaoMenu from " + FuncaoTO.class.getName() + " F";
			   hql += " order by F.descricaoMenu asc";
		return getDao().queryProjection(hql).list();
	}
}