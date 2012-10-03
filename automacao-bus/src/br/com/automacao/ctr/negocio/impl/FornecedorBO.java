package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.ctr.entidade.FornecedorTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.negocio.Fornecedor;
import br.com.automacao.ctr.persistencia.FornecedorPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class FornecedorBO implements Fornecedor {

	@Autowired
	private FornecedorPO persistencia;
	
	@Autowired
	private Generics generic;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void incluir(FornecedorTO t) throws NegocioException {
		generic.incluir(t);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void alterar(FornecedorTO fornecedor) throws NegocioException {
		generic.alterar(fornecedor);
	}
	
	@Override
	public FornecedorTO buscar(FornecedorTO fornecedor) throws NegocioException {
		return generic.buscar(fornecedor);
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void excluir(FornecedorTO fornecedor) throws NegocioException {
		persistencia.excluir(fornecedor);
	}
	
	@Override
	public FornecedorTO pegar(FornecedorTO fornecedor) throws NegocioException {
		return generic.pegar(fornecedor);
	}
	
	@Override
	public List<FornecedorTO> listCombo(EmpresaTO empresa) throws NegocioException {
		return persistencia.listCombo(empresa);
	}
}