package br.com.automacao.shared.dto;

import br.com.automacao.shared.type.CampoType;

@SuppressWarnings("serial")
public class IntegerFieldDTO extends FieldDTO {

	public IntegerFieldDTO(String nome, Integer ordem, Boolean requerido) {
		super(nome, ordem, requerido);
	}
	
	@Override
	public CampoType getTipo(){
		return CampoType.INTEGER;
	}
	
	@Override
	public String getDescricao(){
		return CampoType.INTEGER.desc();
	}
}