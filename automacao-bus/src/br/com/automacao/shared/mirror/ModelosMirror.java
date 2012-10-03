package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.ModelosTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


@SuppressWarnings("serial")
@ServerCalledCommand(ModelosTO.class)
public class ModelosMirror extends Mirror {
	
	private Long id;
	
	private String nome;
	
	private String qtddiasdegarantia;
	
	private String termosdagarantia;
	
	private String marca;



	public ModelosMirror() { }
	public ModelosMirror(Long id) {
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
