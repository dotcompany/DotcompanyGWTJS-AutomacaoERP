package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.ServicoColaboradorTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Título:</b> AgCidadeAtuacaoTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 25/08/2011, 09:52:25
 */
@SuppressWarnings("serial")
@ServerCalledCommand(ServicoColaboradorTO.class)
public class ServicoColaboradorMirror extends Mirror {
	
	private Long 							id;
	
	private ColaboradorMirror						colaborador;
	
	
	public ServicoColaboradorMirror(Long id) {
		this.id = id;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ColaboradorMirror getColaborador() {
		return colaborador;
	}
	public void setColaborador(ColaboradorMirror colaborador) {
		this.colaborador = colaborador;
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
