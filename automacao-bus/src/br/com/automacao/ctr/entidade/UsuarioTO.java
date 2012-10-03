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

@SuppressWarnings("serial")
@Entity
@Table(name="usuario")
public class UsuarioTO extends TransferObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="username", nullable=false, length=12)
	private String username;
	
	@Column(name="senha", nullable=false, length=12)
	private String senha;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=EmpresaTO.class)
	@JoinColumn(name="id_empresa")
	private EmpresaTO empresa;
	
	public UsuarioTO() { }
	
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
	public EmpresaTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaTO empresa) {
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

	@Override
	public Serializable getKey() {
		return getId();
	}
}