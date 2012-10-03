package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.ParametroTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>T�tulo:</b> ParametroTO.java <br>
 * <b>Descri��o:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Cria��o:</b> 25/08/2011, 12:00:19
 */
@SuppressWarnings("serial")
@ServerCalledCommand(ParametroTO.class)
public class ParametroMirror extends Mirror {

	private Long 					id;

	private boolean enviarMailCliente;
	
	private boolean enviarSmsCliente;
	
	private boolean enviarMailEmpresa;
	
	private boolean enviarSmsEmpresa;

	private EmpresaMirror empresa;
	
	public ParametroMirror( ) {}
	
	public ParametroMirror(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public EmpresaMirror getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
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
