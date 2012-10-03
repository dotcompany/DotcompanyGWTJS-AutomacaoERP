package br.com.automacao.ctr.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.dotcompany.to.TransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "cnae")
public class CnaeTO extends TransferObject {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="codigo", nullable=false)
	private String codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;

	public CnaeTO() {}
	public CnaeTO(Long id) {
		this.id = id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	@Override
	public String toString() {
		return this.id.toString();
	}
}