package br.com.automacao.ctr.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.dotcompany.to.TransferObject;

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
@Entity
@Table(name="parametro")
public class ParametroTO extends TransferObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long 					id;

	@Column(name="enviar_mail_cliente")
	private boolean enviarMailCliente;
	
	@Column(name="enviar_sms_cliente")
	private boolean enviarSmsCliente;
	
	@Column(name="enviar_mail_empresa")
	private boolean enviarMailEmpresa;
	
	@Column(name="enviar_sms_empresa")
	private boolean enviarSmsEmpresa;

	@OneToOne(cascade=CascadeType.ALL, targetEntity=EmpresaTO.class)
	@JoinColumn(name="id_empresa")
	private EmpresaTO empresa;
	
	public ParametroTO( ) {}
	
	public ParametroTO(Long id) {
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

	public EmpresaTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	@Override
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