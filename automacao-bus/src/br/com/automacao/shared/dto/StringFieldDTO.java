package br.com.automacao.shared.dto;

import br.com.automacao.shared.type.CampoType;

@SuppressWarnings("serial")
public class StringFieldDTO extends FieldDTO {

	public StringFieldDTO(String nome, Integer ordem, boolean requerido) {
		super(nome, ordem, requerido);
	}
	
	@Override
	public CampoType getTipo(){
		return CampoType.STRING;
	}
	
	@Override
	public String getDescricao(){
		return CampoType.STRING.desc();
	}
}