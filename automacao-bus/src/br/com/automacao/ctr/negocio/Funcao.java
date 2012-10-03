package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.FuncaoTO;
import br.com.dotcompany.exception.NegocioException;

public interface Funcao {
	
	public List<FuncaoTO> listAllFuncao() throws NegocioException;
	
}