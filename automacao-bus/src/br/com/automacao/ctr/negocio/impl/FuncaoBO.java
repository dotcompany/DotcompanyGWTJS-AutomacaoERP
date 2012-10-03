package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automacao.ctr.entidade.FuncaoTO;
import br.com.automacao.ctr.negocio.Funcao;
import br.com.automacao.ctr.persistencia.FuncaoPO;
import br.com.dotcompany.exception.NegocioException;

@Service
public class FuncaoBO implements Funcao {

	@Autowired
	private FuncaoPO persistencia;
	
//	@Autowired
//	private Generics generic;

	@Override
	public List<FuncaoTO> listAllFuncao() throws NegocioException {
		return persistencia.listAllFuncao();
	}

	
}