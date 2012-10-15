package br.com.automacao.ctr.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.automacao.shared.type.ChegouType;
import br.com.automacao.shared.type.EmitirNfType;
import br.com.automacao.shared.type.EmpresaType;
import br.com.automacao.shared.type.PessoaType;
import br.com.automacao.shared.type.RamoType;
import br.com.automacao.shared.type.ReceitaType;
import br.com.automacao.shared.type.RegimeType;
import br.com.dotcompany.to.TransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name="empresa", uniqueConstraints={@UniqueConstraint(columnNames={"url_amigavel","insc_Estadual","cnpj"})})
public class EmpresaTO extends TransferObject {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome_fantasia", length=50)
	private String nomeFantasia;
	
	@Column(name = "razao_social", length=155)
	private String razaoSocial;
	
	@Column(name="cnpj", nullable=false, length=50)
	private String cnpj;
	
	@Column(name="insc_estadual")
	private String inscEstadual;

	@Column(name="insc_estadual_st")
	private String inscEstadualST;

	@Column(name="insc_municipal")
	private String inscMunicipal;
	
	@Column(name="suframa")
	private String suframa;
	
	@Column(name="home_page", length=255)
	private String homePage;
	
	@Column(name="url_amigavel", length=50)
	private String urlAmigavel;

	@Column(name="aliquota_pis")
	private Double aliquotaPis;
	
	@Column(name="aliquota_icms")
	private Double aliquotaIcms;
	
	@Column(name="aliquota_cofins")
	private Double aliquotaCofins;

	@Version
	@Column(name="data_cadastro", nullable=false, insertable=true, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Column(name="tipo_empresa", nullable=false)
	@Enumerated(value = EnumType.STRING)	
	private EmpresaType tipo;
	
	@Column(name="tipo_pessoa", nullable=false)
	@Enumerated(value = EnumType.STRING)	
	private PessoaType tipoPessoa;

	@Column(name="como_chegou")
	@Enumerated(value = EnumType.STRING)
	private ChegouType comoChegou;
	
	@Column(name="tipo_ramo")
	@Enumerated(value = EnumType.STRING)
	private RamoType tipoRamo;
	
	@Column(name="tipo_emitir_nf")
	@Enumerated(value = EnumType.STRING)
	private EmitirNfType tipoEmitirNota;
	
	@Column(name="tipo_receita")
	@Enumerated(value = EnumType.STRING)
	private ReceitaType tipoReceita;
	
	@Column(name="tipo_regime")
	@Enumerated(value = EnumType.STRING)
	private RegimeType tipoRegime;
	
	
	@OneToOne(targetEntity=CnaeTO.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_cnae")
	private CnaeTO cnae;
		
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empresa")
	private Set<EnderecoTO> listaEndereco;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empresa")
	private List<EmpresaModuloTO> listaModulo;
	
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empresa")
	private Set<CaminhoImagemTO> listaImagen;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empresa")
	private Set<FuncaoTO> listaFuncao;
	
	
	/*private Set<EmpresaTO> listaFilial;*/
	
	
	public EmpresaTO() { }
	
	public EmpresaTO(Long id) { 
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EmpresaType getTipo() {
		return tipo;
	}
	public void setTipo(EmpresaType tipo) {
		this.tipo = tipo;
	}
	public ReceitaType getTipoReceita() {
		return tipoReceita;
	}
	public void setTipoReceita(ReceitaType tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	public RegimeType getTipoRegime() {
		return tipoRegime;
	}
	public void setTipoRegime(RegimeType tipoRegime) {
		this.tipoRegime = tipoRegime;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getInscEstadualST() {
		return inscEstadualST;
	}
	public void setInscEstadualST(String inscEstadualST) {
		this.inscEstadualST = inscEstadualST;
	}
	public String getInscMunicipal() {
		return inscMunicipal;
	}
	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getSuframa() {
		return suframa;
	}
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	public ChegouType getComoChegou() {
		return comoChegou;
	}
	public Double getAliquotaPis() {
		return aliquotaPis;
	}
	public void setAliquotaPis(Double aliquotaPis) {
		this.aliquotaPis = aliquotaPis;
	}
	public Double getAliquotaIcms() {
		return aliquotaIcms;
	}
	public void setAliquotaIcms(Double aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}
	public Double getAliquotaCofins() {
		return aliquotaCofins;
	}
	public void setAliquotaCofins(Double aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}
	public void setComoChegou(ChegouType comoChegou) {
		this.comoChegou = comoChegou;
	}
	public PessoaType getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(PessoaType tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public RamoType getTipoRamo() {
		return tipoRamo;
	}
	public void setTipoRamo(RamoType tipoRamo) {
		this.tipoRamo = tipoRamo;
	}
	public EmitirNfType getTipoEmitirNota() {
		return tipoEmitirNota;
	}
	public void setTipoEmitirNota(EmitirNfType tipoEmitirNota) {
		this.tipoEmitirNota = tipoEmitirNota;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getUrlAmigavel() {
		return urlAmigavel;
	}
	public void setUrlAmigavel(String urlAmigavel) {
		this.urlAmigavel = urlAmigavel;
	}

	public Set<EnderecoTO> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(Set<EnderecoTO> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	public List<EmpresaModuloTO> getListaModulo() {
		return listaModulo;
	}
	public void setListaModulo(List<EmpresaModuloTO> listaModulo) {
		this.listaModulo = listaModulo;
	}

	public CnaeTO getCnae() {
		return cnae;
	}
	public void setCnae(CnaeTO cnae) {
		this.cnae = cnae;
	}
	public Set<CaminhoImagemTO> getListaImagen() {
		return listaImagen;
	}
	public void setListaImagen(Set<CaminhoImagemTO> listaImagen) {
		this.listaImagen = listaImagen;
	}
	public Set<FuncaoTO> getListaFuncao() {
		return listaFuncao;
	}
	public void setListaFuncao(Set<FuncaoTO> listaFuncao) {
		this.listaFuncao = listaFuncao;
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
		return this.getNomeFantasia();
	}
}