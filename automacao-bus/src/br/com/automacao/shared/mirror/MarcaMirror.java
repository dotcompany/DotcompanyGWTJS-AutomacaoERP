package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.MarcaTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


@SuppressWarnings("serial")
@ServerCalledCommand(MarcaTO.class)
public class MarcaMirror extends Mirror {

	private Long id;
	
	private String nome;
	
	private String descricao;

	
	public MarcaMirror() {
		// TODO Auto-generated constructor stub
	}

	public MarcaMirror(Long id) {
		return;
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
