package br.com.automacao.ctr.negocio;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.exception.NegocioException;

public interface Empresa {
	
	public void incluir(EmpresaTO empresa) throws NegocioException;
	public void alterar(EmpresaTO empresa) throws NegocioException;
	public void excluir(EmpresaTO empresa) throws NegocioException;
	public void pegar(EmpresaTO empresa) throws NegocioException;
	public void buscar(EmpresaTO empresa) throws NegocioException;
	public EmpresaTO buscarPorCnpjCpf(String cnpjCpf);
	
}
