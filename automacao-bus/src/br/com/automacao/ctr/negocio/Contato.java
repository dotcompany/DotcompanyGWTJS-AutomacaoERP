package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.ContatoTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.exception.NegocioException;

public interface Contato {

	public void incluir(ContatoTO contato) throws NegocioException;
	public void alterar(ContatoTO contato) throws NegocioException;
	public ContatoTO buscar(ContatoTO contato) throws NegocioException;
	public void excluir(ContatoTO contato) throws NegocioException;
	public ContatoTO pegar(ContatoTO contato) throws NegocioException;
	public List<ContatoTO> listCombo(EmpresaTO empresa) throws NegocioException;
}