package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.FornecedorTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.exception.NegocioException;

public interface Fornecedor {

	public void incluir(FornecedorTO fornecedor) throws NegocioException;
	public void alterar(FornecedorTO fornecedor) throws NegocioException;
	public FornecedorTO buscar(FornecedorTO fornecedor) throws NegocioException;
	public void excluir(FornecedorTO fornecedor) throws NegocioException;
	public FornecedorTO pegar(FornecedorTO fornecedor) throws NegocioException;
	public List<FornecedorTO> listCombo(EmpresaTO empresa) throws NegocioException;
}