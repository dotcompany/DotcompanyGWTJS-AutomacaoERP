package br.com.automacao.ctr.negocio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.ctr.entidade.MarcaTO;

import br.com.automacao.ctr.negocio.Marca;
import br.com.automacao.ctr.persistencia.MarcaPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class MarcaBO implements Marca {

	@Autowired
	private MarcaPO persistencia;
	
	@Autowired
	private Generics generic;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void incluir(MarcaTO t) throws NegocioException {
		generic.incluir(t);
	} 

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void alterar(MarcaTO marca) throws NegocioException {
		generic.alterar(marca);
	}
	
	@Override
	public MarcaTO buscar(MarcaTO marca) throws NegocioException {
		return generic.buscar(marca);
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void excluir(MarcaTO marca) throws NegocioException {
		persistencia.excluir(marca);
	}
	
	@Override
	public MarcaTO pegar(MarcaTO marca) throws NegocioException {
		return generic.pegar(marca);
	}


	
	
}
