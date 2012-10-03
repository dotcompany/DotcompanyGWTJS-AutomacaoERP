package br.com.automacao.ctr.negocio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.Empresa;
import br.com.automacao.ctr.persistencia.EmpresaPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class EmpresaBO implements Empresa {

	@Autowired
	private Generics generics;

	@Autowired
	private EmpresaPO persistencia;
	
	@Override
//	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void incluir(EmpresaTO empresa) throws NegocioException {
		generics.incluir(empresa);
	}
	
	@Override
//	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void alterar(EmpresaTO empresa) throws NegocioException {
		generics.alterar(empresa);
	}

	@Override
//	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void excluir(EmpresaTO empresa) throws NegocioException {
		generics.excluir(empresa);
	}
	
	@Override
	public void pegar(EmpresaTO empresa) throws NegocioException {
		generics.pegar(empresa);
	}
	
	@Override
	public void buscar(EmpresaTO empresa) throws NegocioException {
		generics.buscar(empresa);
	}

	@Override
	public EmpresaTO buscarPorCnpjCpf(String cnpjCpf) {
		return persistencia.buscarPorCnpjCpf(cnpjCpf);
	}
}