package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.automacao.ctr.entidade.ModelosTO;
import br.com.dotcompany.exception.NegocioException;

public interface Modelos {

	public void incluir(ModelosTO modelos) throws NegocioException;
	public void alterar(ModelosTO modelos) throws NegocioException;
	public ModelosTO buscar(ModelosTO modelos) throws NegocioException;
	public void excluir(ModelosTO modelos) throws NegocioException;
	public ModelosTO pegar(ModelosTO modelos) throws NegocioException;
	public List<ModelosTO> listCombo(EmpresaTO empresa) throws NegocioException;
	 
}
