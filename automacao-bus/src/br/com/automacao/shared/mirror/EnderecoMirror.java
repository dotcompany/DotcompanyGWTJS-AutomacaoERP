package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.EnderecoTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;

import br.com.automacao.shared.type.EnderecoType;
import br.com.automacao.shared.type.EstadosBrType;

/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Título:</b> EnderecoTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 25/08/2011, 09:49:58
 */
@SuppressWarnings("serial")
@ServerCalledCommand(EnderecoTO.class)
public class EnderecoMirror extends Mirror {
		
	private Long id;
	
	private String cep;

	private String logradouro;

	private String quadra;
	
	private String lote;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private EnderecoType tipo; 
	
	private EstadosBrType uf;
	
	private String pais;
	
	private String pontoReferencia;
	
	private EmpresaMirror empresa;
	
	public EnderecoMirror() { }
	
	public EnderecoMirror(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public EstadosBrType getUf() {
		return uf;
	}
	public void setUf(EstadosBrType uf) {
		this.uf = uf;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getQuadra() {
		return quadra;
	}
	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
	}
	public EnderecoType getTipo() {
		return tipo;
	}
	public void setTipo(EnderecoType tipo) {
		this.tipo = tipo;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
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
		return this.getLogradouro();
	}
}
