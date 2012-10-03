package br.com.automacao.shared.dto;

import br.com.automacao.shared.util.Mirror;

import com.google.gwt.user.client.rpc.IsSerializable;

public class FiltroDTO extends Mirror implements IsSerializable{

	private static final long serialVersionUID = 1L;

	private String nomeColuna;

	private String tipoColuna;
	
	public FiltroDTO() {}

	public FiltroDTO(String nomeColuna, String tipoColuna) {
		this.nomeColuna = nomeColuna;
		this.tipoColuna = tipoColuna;
	}

	public String getNomeColuna() {
		return nomeColuna;
	}

	public String getTipoColuna() {
		return tipoColuna;
	}
}