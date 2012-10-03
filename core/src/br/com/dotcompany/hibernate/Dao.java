package br.com.dotcompany.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.ResultTransformer;

import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.to.TransferObject;

/**
 * Interface de acesso ao dao, ela contem funcionalidades basicas de acesso ao banco.
 * 
 * @author sergio
 *
 */
public interface Dao {
	
	public void runSql(String sql) throws DaoException;
	public boolean salvar(TransferObject entidade);
	public boolean existe(TransferObject entidade);
	public boolean remove(TransferObject entidade);
	public boolean atualizar(TransferObject entidade);
	public TransferObject consultarObjeto(Class<?> clazz, Serializable id);
	public TransferObject consultarObjeto(String hql);
	public  <T extends TransferObject> List <T> consultarLista(Class<?> clazz, String hql);
	public void retirarObjetoSessao(Object value);
	public <T extends TransferObject> List <T> listaDemanda(Class<?> clazz, String hql, int startPage, int maxResults);
	public <T extends TransferObject> List <T> consultarLista(String hql);
	public  <T extends TransferObject> List <T> listarLike(Class<?> clazz, String hql);
	public <T extends TransferObject> Collection<T> consultarObjetos(Class<?> tipoDaClasse);
	public boolean salvar(Class<?> clazz, Object obj);
	public Query query(String hql) throws DaoException;
	public int queryCount(String hql) throws DaoException;
	public <T extends TransferObject> T queryUnique(String hql) throws DaoException;
	public boolean queryExists(String hql) throws DaoException;
	public Query queryProjection(String hql) throws DaoException;
	public Query queryProjection(String hql, String forClazz) throws DaoException;
	public Query queryProjection(String hql, ResultTransformer rt) throws DaoException;
	public <T extends TransferObject> T buscar(T t) throws DaoException;
	public <T extends TransferObject> T pegar(T t) throws DaoException;
	public void initialize(Object to);
	
}