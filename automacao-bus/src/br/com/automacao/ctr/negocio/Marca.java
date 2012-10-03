package br.com.automacao.ctr.negocio;


import br.com.automacao.ctr.entidade.MarcaTO;
import br.com.dotcompany.exception.NegocioException;

public interface Marca {
	
	public void incluir(MarcaTO marca) throws NegocioException;
	public void alterar(MarcaTO marca) throws NegocioException;
	public MarcaTO buscar(MarcaTO marca) throws NegocioException;
	public void excluir(MarcaTO marca) throws NegocioException;
	public MarcaTO pegar(MarcaTO marca) throws NegocioException;
	
}
