package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.ServicoContatoTO;
import br.com.automacao.shared.util.Mirror;
import br.com.dotcompany.core.ServerCalledCommand;


@SuppressWarnings("serial")
@ServerCalledCommand(ServicoContatoTO.class)
public class ServicoContatoMirror extends Mirror {
	
private Long id;
	
	public ServicoContatoMirror(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
