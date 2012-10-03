package br.com.automacao.shared.type;

import br.com.automacao.shared.dto.BooleanFieldDTO;
import br.com.automacao.shared.dto.DateFieldDTO;
import br.com.automacao.shared.dto.FieldDTO;
import br.com.automacao.shared.dto.FloatFieldDTO;
import br.com.automacao.shared.dto.IntegerFieldDTO;
import br.com.automacao.shared.dto.StringFieldDTO;

public enum CampoType {
	STRING()  { 
	    @Override public String desc(){ return "campo de texto simples.";}

		@Override
		public FieldDTO makeField(String nome, int ordem, boolean requerido) {
			return new StringFieldDTO(nome, ordem, requerido);
		}
	  },
	  INTEGER() { 
	    @Override public String desc(){ return "campo de valor inteiro.";}

		@Override
		public FieldDTO makeField(String nome, int ordem, boolean requerido) {
			return new IntegerFieldDTO(nome, ordem, requerido);
		}
	  },
	  FLOAT()   { 
	    @Override public String desc(){ return "campo de valor numérico (decimal).";}

		@Override
		public FieldDTO makeField(String nome, int ordem, boolean requerido) {
			return new FloatFieldDTO(nome, ordem, requerido);
		}
	  },
	  DATE()    { 
	    @Override public String desc(){ return "campo de valor data.";}

		@Override
		public FieldDTO makeField(String nome, int ordem, boolean requerido) {
			return new DateFieldDTO(nome, ordem, requerido);
		}
	  },
	  BOOLEAN() { 
	    @Override public String desc(){ return "campo de valor lógico (sim/não).";}

		@Override
		public FieldDTO makeField(String nome, int ordem, boolean requerido) {
			return new BooleanFieldDTO(nome, ordem, requerido);
		}
	  },
	  TEXT_AREA()   { 
	    @Override public String desc(){ return "campo de texto longo.";}

		@Override
		public FieldDTO makeField(String nome, int ordem, boolean requerido) {
			return null;
		}
	  };
	  public abstract String desc();
	  public abstract FieldDTO makeField(String nome, int ordem, boolean requerido);
	  
	  public String getNome(){
		switch (this) {
			case STRING: return "String";
			case INTEGER: return "Integer";
			case FLOAT: return "Float";
			case DATE: return "Data";
			case BOOLEAN: return "Boolean";
			default: return "Text Area";
		}
	  }
	 	
	@Override
	public String toString(){
		return getNome();
	}
};