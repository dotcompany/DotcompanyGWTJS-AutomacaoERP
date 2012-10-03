package br.com.automacao.shared.dto;

import br.com.automacao.shared.type.CampoType;

@SuppressWarnings("serial")
public class DateFieldDTO extends FieldDTO {

	public DateFieldDTO(String nome, Integer ordem, Boolean requerido) {
		super(nome, ordem, requerido);
	}
	
	@Override
	public CampoType getTipo(){
		return CampoType.DATE;
	}
	
	@Override
	public String getDescricao(){
		return CampoType.DATE.desc();
	}
}