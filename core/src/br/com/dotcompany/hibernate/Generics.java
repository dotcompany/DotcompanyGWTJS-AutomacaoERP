package br.com.dotcompany.hibernate;

import java.util.List;

import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.to.TransferObject;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.hibernate <br>
 * <b>Título:</b> Generics.java <br>
 * <b>Descrição:</b> <br>
 * 
 * <b>Autor:</b> DotCompany <b>Criação:</b> 26/08/2011, 10:35:19
 */
public interface Generics {

	public <T extends TransferObject> void incluir(T t) throws NegocioException;

	public void incluir(Class<?> clazz, List<Object> lista)
			throws NegocioException;

	public <T extends TransferObject> void alterar(T t) throws NegocioException;

	public <T extends TransferObject> void excluir(T t) throws NegocioException;

	public <T extends TransferObject> T buscar(T t) throws NegocioException;

	public <T extends TransferObject> T pegar(T t) throws NegocioException;

	public <T extends TransferObject> List<T> listarPrimitivos(Class<?> clazz)
			throws NegocioException;

	public <T extends TransferObject> void evict(T t) throws NegocioException;

	public Integer count(Class<?> clazz) throws NegocioException;

	public void runSql(String sql) throws NegocioException;

	public Long ultimoId(Class<?> clazz) throws NegocioException;

	public <T extends TransferObject> List<T> listarLike(Class<?> clazz,
			String[] idColumns, String[] like) throws NegocioException;

	public void initialize(Object t) throws NegocioException;

}