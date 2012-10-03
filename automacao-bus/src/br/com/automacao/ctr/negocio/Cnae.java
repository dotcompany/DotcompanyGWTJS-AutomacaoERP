package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.CnaeTO;
import br.com.dotcompany.exception.NegocioException;

public interface Cnae {
	
	public List<CnaeTO> listAllCnae() throws NegocioException;
	
}