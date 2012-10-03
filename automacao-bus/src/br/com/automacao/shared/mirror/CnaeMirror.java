package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.CnaeTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


@SuppressWarnings("serial")
@ServerCalledCommand(CnaeTO.class)
public class CnaeMirror extends Mirror {
 
	private Long id;
	
	private String codigo;
	
	private String nome;

	public CnaeMirror() {}
	public CnaeMirror(Long id) {
		this.id = id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return this.id.toString();
	}
}
