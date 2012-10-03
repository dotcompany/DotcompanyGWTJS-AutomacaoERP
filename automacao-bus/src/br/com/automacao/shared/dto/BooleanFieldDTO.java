package br.com.automacao.shared.dto;

import br.com.automacao.shared.type.CampoType;

@SuppressWarnings("serial")
public class BooleanFieldDTO extends FieldDTO {

	public BooleanFieldDTO(String nome, Integer ordem, Boolean requerido) {
		super(nome, ordem, requerido);
	}
	
	@Override
	public CampoType getTipo(){
		return CampoType.BOOLEAN;
	}
	
	@Override
	public String getDescricao(){
		return CampoType.BOOLEAN.desc();
	}
}