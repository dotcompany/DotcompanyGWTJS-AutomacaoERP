package br.com.automacao.ctr.negocio;

import java.util.List;

import br.com.automacao.ctr.entidade.ColaboradorTO;
import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.exception.NegocioException;

public interface Colaborador {

	public void incluir(ColaboradorTO colaborador) throws NegocioException;
	public void alterar(ColaboradorTO colaborador) throws NegocioException;
	public ColaboradorTO buscar(ColaboradorTO colaborador) throws NegocioException;
	public void excluir(ColaboradorTO colaborador) throws NegocioException;
	public ColaboradorTO pegar(ColaboradorTO colaborador) throws NegocioException;
	public List<ColaboradorTO> listCombo(EmpresaTO empresa) throws NegocioException;
	
}