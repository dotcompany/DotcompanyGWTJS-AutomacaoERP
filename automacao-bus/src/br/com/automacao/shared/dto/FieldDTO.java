package br.com.automacao.shared.dto;

import br.com.automacao.shared.type.CampoType;
import br.com.automacao.shared.util.Mirror;

import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("serial")
public abstract class FieldDTO extends Mirror implements IsSerializable{

	private String nome;
	
	private Integer ordem;
	
	private boolean requerido;
	
	public FieldDTO() {}
	
	public FieldDTO(String nome, Integer ordem, boolean requerido) {
		this.nome = nome;
		this.ordem = ordem;
		this.requerido = requerido;
	}

	public abstract CampoType getTipo();
	
	public abstract String getDescricao();
	
	public String getNome() {
		return nome;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public boolean getRequerido() {
		return requerido;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
}