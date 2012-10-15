package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.to.TransferObject;

public interface Grid {

	public <T extends TransferObject> List<T> busca(Class<T> clazz, List<String> idColumns) throws NegocioException;
	public int countFilterAll(Class<?> clazz, String value, String[] nomeColunas, String[] tipoColunas) throws NegocioException;
	public int countFilterLike(Class<?> clazz, String[] like) throws NegocioException;
	
	public List<EmpresaTO> buscarTodos(Class<?> clazz, Integer start, Integer maxResults, String[] idColumns) throws NegocioException;
	public List<EmpresaTO> buscarFilter(Class<?> clazz, Integer start, Integer maxResults, String[] idColumns, String[] like) throws NegocioException;
	public List<EmpresaTO> buscarFilterAll(Class<?> clazz, Integer start, Integer maxResults, String value, String[] nomeColunas, String[] tipoColunas) throws NegocioException;
}