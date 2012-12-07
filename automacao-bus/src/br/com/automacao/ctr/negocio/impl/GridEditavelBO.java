package br.com.automacao.ctr.negocio.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.GridEditavel;
import br.com.automacao.ctr.persistencia.GridEditavelPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.to.TransferObject;

/**
 * Classe de implementação dos serviços do GridEditavel.
 * 
 * @author sergio
 *
 */
@Service
public class GridEditavelBO implements GridEditavel{

	// Spring injeta a classe GridEditavelPO  
	@Autowired
	private GridEditavelPO persistencia;
	
	@Override
	public int countFilterAll(Class<?> clazz, String value, String[] nomeColunas, String[] tipoColunas) throws NegocioException {
		return persistencia.countFilterAll(clazz, value, nomeColunas, tipoColunas);
	}
	
	@Override
	public int countFilterLike(Class<?> clazz, String[] like) throws NegocioException {
		return persistencia.countFilterLike(clazz, like);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends TransferObject> List<T> busca(Class<T> clazz, List<String> idColumns) throws NegocioException {
		return persistencia.busca(clazz, idColumns);
	}

	/**
	 * Busca todos os clientes de forma paginada e projetada.
	 * @param start - onde começa a paginação
	 * @param maxResults - máximo de clientes que será trazidos na demanda
	 * @param idColumns - colunas que serão projetadas. A regra é que os nomes da colunas seja o mesmo definido como nome de atributo da classe.
	 * @return - lista de clientes buscado projetada e paginada.
	 */
	@Override
	public List<EmpresaTO> buscarTodos(Class<?> clazz, Integer start, Integer maxResults, String[] idColumns) throws NegocioException {
		return persistencia.buscarTodos(clazz, start, maxResults, Arrays.asList(idColumns));
	}

	/**
	 * Busca todos clientes de forma paginada e projetada de acordo com o filtro.
	 * @param start - onde começa a paginação
	 * @param maxResults - máximo de clientes que será trazidos na demanda
	 * @param idColumns - colunas que serão projetadas. A regra é que os nomes da colunas seja o mesmo definido como nome de atributo da classe.
	 * @param field - Nome do campo que sera filtrado
	 * @param type - Tipo do filtro
	 * @param value - Valor para a pesquisa
	 */
	@Override
	public List<EmpresaTO> buscarFilter(Class<?> clazz, Integer start, Integer maxResults, String[] idColumns, String[] like) throws NegocioException {
		return persistencia.buscarFilter(clazz, start, maxResults, idColumns, like);
	}

	@Override
	public List<EmpresaTO> buscarFilterAll(Class<?> clazz, Integer start, Integer maxResults, String value, String[] nomeColunas, String[] tipoColunas) throws NegocioException {
		return persistencia.buscarFilterAll(clazz, start, maxResults, value, nomeColunas, tipoColunas);
	}
}