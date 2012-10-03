package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.UsuarioTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


@SuppressWarnings("serial")
@ServerCalledCommand(UsuarioTO.class)
public class UsuarioMirror extends Mirror {

	private Long id;
	
	private String username;
	
	private String senha;
	
	private EmpresaMirror empresa;
	
	public UsuarioMirror() { }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return this.getUsername();
	}

	public Serializable getKey() {
		return getId();
	}
}
