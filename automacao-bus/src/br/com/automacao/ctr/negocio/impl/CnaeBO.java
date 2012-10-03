package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automacao.ctr.entidade.CnaeTO;
import br.com.automacao.ctr.negocio.Cnae;
import br.com.automacao.ctr.persistencia.CnaePO;
import br.com.dotcompany.exception.NegocioException;

@Service
public class CnaeBO implements Cnae {

	@Autowired
	private CnaePO persistencia;
	
//	@Autowired
//	private Generics generic;

	@Override
	public List<CnaeTO> listAllCnae() throws NegocioException {
		return persistencia.listAllCnae();
	}
}