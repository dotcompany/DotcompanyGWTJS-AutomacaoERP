package br.com.automacao.shared.dto;

import br.com.automacao.shared.type.CampoType;

@SuppressWarnings("serial")
public class FloatFieldDTO extends FieldDTO {

	public FloatFieldDTO(String nome, Integer ordem, Boolean requerido) {
		super(nome, ordem, requerido);
	}
	
	@Override
	public CampoType getTipo(){
		return CampoType.FLOAT;
	}
	
	@Override
	public String getDescricao(){
		return CampoType.FLOAT.desc();
	}
}