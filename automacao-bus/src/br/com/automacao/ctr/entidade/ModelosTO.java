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
@Table(name = "modelos")
public class ModelosTO extends TransferObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="nome", length=45, nullable=false)
	private String nome;
	
	@Column(name="qtddiasdegarantia", length=45)
	private String qtddiasdegarantia;
	
	@Column(name="termosdagarantia", length=255, nullable=false)
	private String termosdagarantia;
	
	@Column(name="marca", length=2555, nullable=false)
	private String marca;



	public ModelosTO() { }
	public ModelosTO(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getQtddiasdegarantia() {
		return qtddiasdegarantia;
	}
	public void setQtddiasdegarantia(String qtddiasdegarantia) {
		this.qtddiasdegarantia = qtddiasdegarantia;
	}
	
	public String getTermosdagarantia() {
		return termosdagarantia;
	}
	public void setTermosdagarantia(String termosdagarantia) {
		this.termosdagarantia = termosdagarantia;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
		return this.getNome();
	}
}