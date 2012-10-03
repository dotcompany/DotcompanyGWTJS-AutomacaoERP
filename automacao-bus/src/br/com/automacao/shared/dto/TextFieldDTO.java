package br.com.automacao.shared.dto;

import br.com.automacao.shared.util.Mirror;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TextFieldDTO extends Mirror implements IsSerializable{

	private static final long serialVersionUID = 1L;

	private String nome;

	private String label;
	
	public TextFieldDTO() {}

	public TextFieldDTO(String nome, String label) {
		super();
		this.nome = nome;
		this.label = label;
	}

	public String getNome() {
		return nome;
	}

	public String getLabel() {
		return label;
	}
}