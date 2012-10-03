package br.com.dotcompany.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.to.TransferObject;
import br.com.dotcompany.util.BancoUtil;
import br.com.dotcompany.util.ReflectionUtil;

@Repository
public class GenericsPO extends AbstractHibernatePO {
	
	public void initialize(Object t) throws DaoException {
		getDao().initialize(t);
	}
	
	public <T extends TransferObject> void incluir(T t) throws DaoException {
		getDao().salvar(t);
	}
	
	public void incluir(Class<?> clazz, List<Object> lista) throws DaoException {
		for(Object obj : lista)
			getDao().salvar(clazz, obj);
	}
	
	public <T extends TransferObject> void alterar(T t) throws DaoException {
		getDao().atualizar(t);
	}
	
	public <T extends TransferObject> void excluir(T t) throws DaoException {
		getDao().remove(t);
	}
	
	public <T extends TransferObject> T buscar(T t) throws DaoException {
		return getDao().buscar(t);
	}
	
	public <T extends TransferObject> T pegar(T t) throws DaoException {
		return getDao().pegar(t);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends TransferObject> List<T> listarPrimitivos(Class<?> clazz) throws DaoException {
		List<String> lista = ReflectionUtil.getFieldsNonCollections(clazz);
		int size = lista.size();
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		for(String field : lista){
			sb.append(field);
			if(--size > 0){
				sb.append(", ");
			}
		}
		sb.append(" from "+clazz.getName());
		return getDao().queryProjection(sb.toString()).list();
	}
	
	public <T extends TransferObject> List<T> listarLike(Class<?> clazz, String[] idColumns, String[] like) throws NegocioException {
		String hql =  BancoUtil.createFieldsHqlLike(" from "+clazz.getName(), idColumns, like, "or");
		return getDao().listarLike(clazz, hql);
	}
	
	public <T extends TransferObject> void evict(T t) throws DaoException {
		getDao().retirarObjetoSessao(t);
	}
	
	public Integer count(Class<?> clazz) throws DaoException {
		String hql  = "select count(CT.id) from " + clazz.getName() + " CT ";
		return getDao().queryCount(hql);		
	}
	
	public void runSql(String sql) throws DaoException {
		getDao().runSql(sql);		
	}
	
	public Long ultimoId(Class<?> clazz) throws DaoException {
		String hql = "select max(CL.id) from "+clazz.getName()+" CL";
		return Long.valueOf(getDao().queryCount(hql));
	}
}