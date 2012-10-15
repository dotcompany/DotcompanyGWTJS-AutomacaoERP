package br.com.automacao.ctr.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.hibernate.AbstractHibernatePO;
import br.com.dotcompany.util.BancoUtil;

@Repository
public class GridPO extends AbstractHibernatePO{

	public int countFilterAll(Class<?> clazz, String value,	String[] nomeColunas, String[] tipoColunas) {
		return getDao().queryCount(BancoUtil.createCountHqlFilterAll(" from "+clazz.getName(), nomeColunas, tipoColunas, value));
	}

	public int countFilterLike(Class<?> clazz, String[] like) {
		return getDao().queryCount(BancoUtil.createCountHqlLike(" from "+clazz.getName(), like));
	}

	@SuppressWarnings("unchecked")
	public List busca(Class<?> clazz, List<String> idColumns) {
		StringBuffer hql = new StringBuffer();
		hql.append(BancoUtil.createFieldsHql(" from "+clazz.getName(), idColumns));
		return getDao().consultarLista(clazz, hql.toString());
	}

	public List<EmpresaTO> buscarTodos(Class<?> clazz, Integer start, Integer maxResults, List<String> idColumns) {
		String hql = BancoUtil.createFieldsHql(" from "+clazz.getName(), idColumns);
		return getDao().listaDemanda(EmpresaTO.class, hql, start, maxResults);
	}

	public List<EmpresaTO> buscarFilter(Class<?> clazz, Integer start, Integer maxResults, String[] idColumns, String[] like) {
		String hql =  BancoUtil.createFieldsHqlLike(" from "+clazz.getName(), idColumns, like);
		return getDao().listaDemanda(EmpresaTO.class, hql, start, maxResults);
	}

	public List<EmpresaTO> buscarFilterAll(Class<?> clazz, Integer start, Integer maxResults, String value, String[] nomeColunas, String[] tipoColunas) {
		String hql = BancoUtil.createFieldsHqlFilterAll(" from "+clazz.getName(), value, nomeColunas, tipoColunas);
		return getDao().listaDemanda(EmpresaTO.class, hql, start, maxResults);
	}
}