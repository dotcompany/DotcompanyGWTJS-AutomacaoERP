package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.ModuloTO;
import br.com.dotcompany.exception.NegocioException;

public interface Modulo {

	public void incluir(ModuloTO modulo) throws NegocioException;
	public void alterar(ModuloTO modulo) throws NegocioException;
	public ModuloTO buscar(ModuloTO modulo) throws NegocioException;
	public List<ModuloTO> buscarPorEmpresa(Integer idEmpresa) throws NegocioException;
	public void excluir(ModuloTO modulo) throws NegocioException;
	public ModuloTO pegar(ModuloTO modulo) throws NegocioException;
}