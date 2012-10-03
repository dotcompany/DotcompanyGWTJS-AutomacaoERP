package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.ctr.entidade.ContatoTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.Contato;
import br.com.automacao.ctr.persistencia.ContatoPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class ContatoBO implements Contato {

	@Autowired
	private ContatoPO persistencia;
	
	@Autowired
	private Generics generic;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void incluir(ContatoTO t) throws NegocioException {
		generic.incluir(t);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void alterar(ContatoTO contato) throws NegocioException {
		generic.alterar(contato);
	}
	
	@Override
	public ContatoTO buscar(ContatoTO contato) throws NegocioException {
		return generic.buscar(contato);
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void excluir(ContatoTO contato) throws NegocioException {
		persistencia.excluir(contato);
	}
	
	@Override
	public ContatoTO pegar(ContatoTO contato) throws NegocioException {
		return generic.pegar(contato);
	}
	
	@Override
	public List<ContatoTO> listCombo(EmpresaTO empresa) throws NegocioException {
		return persistencia.listCombo(empresa);
	}
}