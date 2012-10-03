package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.ctr.entidade.ColaboradorTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.Colaborador;
import br.com.automacao.ctr.persistencia.ColaboradorPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class ColaboradorBO implements Colaborador {

	@Autowired
	private ColaboradorPO persistencia;
	
	@Autowired
	private Generics generic;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void incluir(ColaboradorTO t) throws NegocioException {
		generic.incluir(t);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void alterar(ColaboradorTO colaborador) throws NegocioException {
		generic.alterar(colaborador);
	}
	
	@Override
	public ColaboradorTO buscar(ColaboradorTO colaborador) throws NegocioException {
		return generic.buscar(colaborador);
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void excluir(ColaboradorTO colaborador) throws NegocioException {
		persistencia.excluir(colaborador);
	}
	
	@Override
	public ColaboradorTO pegar(ColaboradorTO colaborador) throws NegocioException {
		return generic.pegar(colaborador);
	}
	
	@Override
	public List<ColaboradorTO> listCombo(EmpresaTO empresa) throws NegocioException {
		return persistencia.listCombo(empresa);
	}
}