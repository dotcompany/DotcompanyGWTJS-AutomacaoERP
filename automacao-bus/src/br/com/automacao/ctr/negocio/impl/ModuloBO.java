package br.com.automacao.ctr.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automacao.ctr.entidade.ModuloTO;
import br.com.automacao.ctr.negocio.Modulo;
import br.com.automacao.ctr.persistencia.ModuloPO;
import br.com.dotcompany.exception.NegocioException;
import br.com.dotcompany.hibernate.Generics;

@Service
public class ModuloBO implements Modulo {

	@Autowired
	private ModuloPO persistencia;

	@Autowired
	private Generics generics;
	
	@Override
	public void alterar(ModuloTO modulo) throws NegocioException {
		generics.alterar(modulo);
	}

	@Override
	public ModuloTO buscar(ModuloTO modulo) throws NegocioException {
		return generics.buscar(modulo);
	}

	@Override
	public void excluir(ModuloTO modulo) throws NegocioException {
		generics.excluir(modulo);
	}

	@Override
	public void incluir(ModuloTO modulo) throws NegocioException {
		generics.incluir(modulo);
	}

	@Override
	public ModuloTO pegar(ModuloTO modulo) throws NegocioException {
		return generics.pegar(modulo);
	}

	@Override
	public List<ModuloTO> buscarPorEmpresa(Integer idEmpresa) throws NegocioException {
		return persistencia.buscarPorEmpresa(idEmpresa);
	}
}