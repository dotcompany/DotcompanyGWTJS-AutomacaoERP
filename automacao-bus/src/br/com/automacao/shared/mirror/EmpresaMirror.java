package br.com.automacao.shared.mirror;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import br.com.automacao.ctr.entidade.EmpresaTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


import br.com.automacao.shared.type.ChegouType;
import br.com.automacao.shared.type.EmitirNfType;
import br.com.automacao.shared.type.EmpresaType;
import br.com.automacao.shared.type.PessoaType;
import br.com.automacao.shared.type.RamoType;
import br.com.automacao.shared.type.ReceitaType;
import br.com.automacao.shared.type.RegimeType;

@SuppressWarnings("serial")
@ServerCalledCommand(EmpresaTO.class)
public class EmpresaMirror extends Mirror {

	private Long id;
	
	private EmpresaMirror empresa;
	
	private EmpresaMirror filial;
	
	private String nomeFantasia;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private String inscEstadual;

	private String inscEstadualST;

	private String inscMunicipal;
	
	private String suframa;
	
	private String homePage;
	
	private String urlAmigavel;

	private Double aliquotaPis;
	
	private Double aliquotaIcms;
	
	private Double aliquotaCofins;

	private Date dataCadastro;
	
	private EmpresaType tipo;
	
	private PessoaType tipoPessoa;

	private ChegouType comoChegou;
	
	private RamoType tipoRamo;
	
	private EmitirNfType tipoEmitirNota;
	
	private ReceitaType tipoReceita;
	
	private RegimeType tipoRegime;
	
		
	private CnaeMirror cnae;
		
	
	private Set<EnderecoMirror> listaEndereco;
	
	private List<EmpresaModuloMirror> listaModulo;
	
	
	
	
	private Set<CaminhoImagemMirror> listaImagen;
	
	private Set<FuncaoMirror> listaFuncao;
	

	
	/*private Set<EmpresaMirror> listaFilial;*/
	
	
	public EmpresaMirror() { }
	
	public EmpresaMirror(Long id) { 
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
	public Set<EnderecoMirror> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(Set<EnderecoMirror> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	public List<EmpresaModuloMirror> getListaModulo() {
		return listaModulo;
	}
	public void setListaModulo(List<EmpresaModuloMirror> listaModulo) {
		this.listaModulo = listaModulo;
	}
	public CnaeMirror getCnae() {
		return cnae;
	}
	public void setCnae(CnaeMirror cnae) {
		this.cnae = cnae;
	}
	public Set<CaminhoImagemMirror> getListaImagen() {
		return listaImagen;
	}
	public void setListaImagen(Set<CaminhoImagemMirror> listaImagen) {
		this.listaImagen = listaImagen;
	}
	public Set<FuncaoMirror> getListaFuncao() {
		return listaFuncao;
	}
	public void setListaFuncao(Set<FuncaoMirror> listaFuncao) {
		this.listaFuncao = listaFuncao;
	}

	public EmpresaMirror getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
	}

	public EmpresaMirror getFilial() {
		return filial;
	}

	public void setFilial(EmpresaMirror filial) {
		this.filial = filial;
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
		return this.getNomeFantasia();
	}
}
