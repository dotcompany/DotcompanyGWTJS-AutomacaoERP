package br.com.automacao.shared.dto;

import br.com.automacao.ctr.entidade.ParametroTO;
import br.com.automacao.shared.util.Mirror;
import br.com.dotcompany.core.ServerCalledCommand;


/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Titulo:</b> ParametroTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 25/08/2011, 12:00:19
 */
@SuppressWarnings("serial")
@ServerCalledCommand(ParametroTO.class)
public class ParametroDTO extends Mirror {

	private Integer 					id;

	private boolean enviarMailCliente;
	
	private boolean enviarSmsCliente;
	
	private boolean enviarMailEmpresa;
	
	private boolean enviarSmsEmpresa;
	
	public ParametroDTO( ) {}
	
	public ParametroDTO(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isEnviarMailCliente() {
		return enviarMailCliente;
	}
	public void setEnviarMailCliente(boolean enviarMailCliente) {
		this.enviarMailCliente = enviarMailCliente;
	}
	public boolean isEnviarSmsCliente() {
		return enviarSmsCliente;
	}
	public void setEnviarSmsCliente(boolean enviarSmsCliente) {
		this.enviarSmsCliente = enviarSmsCliente;
	}
	public boolean isEnviarMailEmpresa() {
		return enviarMailEmpresa;
	}
	public void setEnviarMailEmpresa(boolean enviarMailEmpresa) {
		this.enviarMailEmpresa = enviarMailEmpresa;
	}
	public boolean isEnviarSmsEmpresa() {
		return enviarSmsEmpresa;
	}
	public void setEnviarSmsEmpresa(boolean enviarSmsEmpresa) {
		this.enviarSmsEmpresa = enviarSmsEmpresa;
	}
}