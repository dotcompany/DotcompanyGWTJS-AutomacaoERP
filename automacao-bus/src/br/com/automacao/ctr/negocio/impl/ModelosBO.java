package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.entidade.ModelosTO;
import br.com.automacao.ctr.negocio.Modelos;
import br.com.automacao.ctr.persistencia.ModelosPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class ModelosBO implements Modelos {

	@Autowired
	private ModelosPO persistencia;
	@Autowired
	private Generics generic;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void incluir(ModelosTO t) throws NegocioException {
		generic.incluir(t);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void alterar(ModelosTO modelos) throws NegocioException {
		generic.alterar(modelos);
	}
	
	@Override
	public ModelosTO buscar(ModelosTO modelos) throws NegocioException {
		return generic.buscar(modelos);
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void excluir(ModelosTO modelos) throws NegocioException {
		persistencia.excluir(modelos);
	}
	
	@Override
	public ModelosTO pegar(ModelosTO modelos) throws NegocioException {
		return generic.pegar(modelos);
	}
	
	@Override
	public List<ModelosTO> listCombo(EmpresaTO empresa) throws NegocioException {
		return persistencia.listCombo(empresa);
	}

}