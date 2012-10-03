package br.com.dotcompany.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.to.TransferObject;

@Service
public class GenericsBO implements Generics {

	@Autowired
	private GenericsPO persistence;

	@Override
	public void initialize(Object t) throws NegocioException {
		persistence.initialize(t);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <T extends TransferObject> void incluir(T t) throws NegocioException {
		persistence.incluir(t);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void incluir(Class<?> clazz, List<Object> lista)
			throws NegocioException {
		persistence.incluir(clazz, lista);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <T extends TransferObject> void alterar(T t) throws NegocioException {
		persistence.alterar(t);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <T extends TransferObject> void excluir(T t) throws NegocioException {
		persistence.excluir(t);
	}

	@Override
	public <T extends TransferObject> T buscar(T t) throws NegocioException {
		return persistence.buscar(t);
	}

	@Override
	public <T extends TransferObject> T pegar(T t) throws NegocioException {
		return persistence.pegar(t);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public <T extends TransferObject> List<T> listarPrimitivos(Class<?> clazz)
			throws NegocioException {
		return persistence.listarPrimitivos(clazz);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public <T extends TransferObject> List<T> listarLike(Class<?> clazz,
			String[] idColumns, String[] like) throws NegocioException {
		return persistence.listarLike(clazz, idColumns, like);
	}

	@Override
	public <T extends TransferObject> void evict(T t) throws NegocioException {
		persistence.evict(t);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Integer count(Class<?> clazz) throws NegocioException {
		return persistence.count(clazz);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void runSql(String sql) throws NegocioException {
		persistence.runSql(sql);
	}

	@Override
	public Long ultimoId(Class<?> clazz) throws NegocioException {
		return persistence.ultimoId(clazz);
	}
}