package br.com.automacao.ctr.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.automacao.shared.type.EnderecoType;
import br.com.automacao.shared.type.EstadosBrType;
import br.com.dotcompany.to.TransferObject;

/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Título:</b> EnderecoTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> Wesley JR
 * <b>Criação:</b> 25/08/2011, 09:49:58
 */
@SuppressWarnings("serial")
@Entity
@Table(name="endereco")
public class EnderecoTO extends TransferObject {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=true)
	private Long id;
	
	@Column(name="cep", length=13)
	private String cep;

	@Column(name="logradouro", nullable=true, length=255)
	private String logradouro;

	@Column(name="quadra", length=20)
	private String quadra;
	
	@Column(name="lote", length=20)
	private String lote;
	
	@Column(name="numero", length=20)
	private String numero;
	
	@Column(name="complemento", length=70)
	private String complemento;
	
	@Column(name="bairro", nullable=true, length=100)
	private String bairro;
	
	@Column(name="cidade", nullable=true, length=100)
	private String cidade;
	
	@Column(name="tipo")
	@Enumerated(value = EnumType.STRING)
	private EnderecoType tipo; 
	
	@Column(name="uf", nullable=true, length=30)
	@Enumerated(value = EnumType.STRING)
	private EstadosBrType uf;
	
	@Column(name="pais", nullable=true, length=50)
	private String pais;
	
	@Column(name="ponto_referencia", length=100)
	private String pontoReferencia;

	
	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName="id")
	private EmpresaTO empresa;
	
	
	public EnderecoTO() { }
	
	public EnderecoTO(Long id) {
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

	public EmpresaTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaTO empresa) {
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
		return this.getLogradouro();
	}
}
