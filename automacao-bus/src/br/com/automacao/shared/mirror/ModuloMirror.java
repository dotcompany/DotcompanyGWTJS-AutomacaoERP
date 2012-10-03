package br.com.automacao.shared.mirror;

import java.io.Serializable;
import java.util.List;

import br.com.automacao.ctr.entidade.ModuloTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;



/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Título:</b> ModuloTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 25/08/2011, 12:27:19
 */
@SuppressWarnings("serial")
@ServerCalledCommand(ModuloTO.class)
public class ModuloMirror extends Mirror {
		
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private List<EmpresaModuloMirror> listaModulo;
	
	public ModuloMirror() {}
	
	public ModuloMirror(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<EmpresaModuloMirror> getListaModulo() {
		return listaModulo;
	}
	public void setListaModulo(List<EmpresaModuloMirror> listaModulo) {
		this.listaModulo = listaModulo;
	}

	public Serializable getKey() {
		return getId();
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return this.getNome();
	}
}
