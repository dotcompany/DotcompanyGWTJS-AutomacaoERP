package br.com.automacao.ctr.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.automacao.shared.type.AguaType;
import br.com.automacao.shared.type.ComissaoType;
import br.com.automacao.shared.type.ConstrucaoType;
import br.com.automacao.shared.type.ContratacaoType;
import br.com.automacao.shared.type.EstadoCivilType;
import br.com.automacao.shared.type.LancaComissaoType;
import br.com.automacao.shared.type.MoradiaType;
import br.com.automacao.shared.type.PagComissaoType;
import br.com.automacao.shared.type.ResideType;
import br.com.automacao.shared.type.SalarioType;
import br.com.automacao.shared.type.SangueType;
import br.com.automacao.shared.type.SexoType;
import br.com.dotcompany.to.TransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "colaborador")
public class ColaboradorTO extends TransferObject {
	
	// ------------------------------------------------------- (Geral) Informações importante
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Version
	@Column(name="data_cadastro", nullable=false, insertable=true, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Column(name="matricula", length=45)
	private String matricula;
	
	@Column(name="nome", length=45, nullable=false)
	private String nome;
	
	@Column(name="ativo")
	private Boolean ativo;
	
	@Column(name="is_usuario")
	private boolean usuarioSistema;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=EmpresaTO.class)
	@JoinColumn(name="id_empresa")
	private EmpresaTO empresa;
	
	// ------------------------------------------------------- (Geral) Documentos Pessoais
	@Column(name="tipo_receita")
	@Enumerated(value = EnumType.STRING)
	private SexoType sexo;
	
	@Column(name="data_nascimento")
	private Date dtNasc;
	
	@Column(name="cpf", length=14)
	private String cpf;
	
	@Column(name="rg", length=20)
	private String rg;
	
	@Column(name="rg_org_emissor", length=45)
	private String rgEmissor;
	
	@Column(name="rg_dt_emissao")
	private Date dtEmissaoRg;
	
	@Column(name="titulo_eleitoral")
	private String titEleitoral;
	
	@Column(name="ctps")
	private String ctps;
	
	@Column(name="ctps_serie")
	private String ctpsSerie;
	
	@Column(name="pis_pasep")
	private String pisPasep;
	
	@Column(name="ct_dt_emissao")
	private Date dtEmissaoCt;
	
	@Column(name="resevista")
	private String resevista;
	
	@Column(name="cnh")
	private String cnh;
	
	// ------------------------------------------------------- (Geral) Endereço
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="colaborador")
	private Set<EnderecoTO> listaEndereco;
	
	
	// ------------------------------------------------------- (Dados da Contratação) Informações da Contratação
	@Column(name="dt_adminssao")
	private Date dtAdmissao;
	
	@Column(name="dt_exame_medico")
	private Date dtExMedico;
	
	@ManyToOne
	@JoinColumn(name="id_funcao", referencedColumnName="id")
	private FuncaoTO funcao;	
	
	@Column(name="cbo")
	private String cbo;
	
	@Column(name="horas")
	private Integer horas;
	
	@OneToOne(targetEntity=CnaeTO.class, fetch=FetchType.LAZY)
	@JoinColumn(name="id_cnae")
	private CnaeTO cnae;

	@Column(name="tipo_contato")
	@Enumerated(value = EnumType.STRING)
	private ContratacaoType tipoContrato;
	
	@Column(name="ctr_obs")
	private String ctrObs;
	
	// ------------------------------------------------------- (Dados da Contratação) Informações da Demissão
	@Column(name="dt_demissao")
	private Date dtDemissao;
	
	@Column(name="dt_afastamento")
	private Date dtAfastamento;
	
	@Column(name="demissao_obs")
	private String demissaoObs;
	
	// ------------------------------------------------------- (Informações Particular) Filiação
	@Column(name="mae", length=45)
	private String mae;
	
	@Column(name="fone_mae", length=20)
	private String foneMae;
	
	@Column(name="pai", length=45)
	private String pai;
	
	@Column(name="fone_pai", length=20)
	private String fonePai;
	
	// ------------------------------------------------------- (Informações Particular) Informação do Cônjuge
	@Column(name="tipo_est_civil_conjuge", length=45)
	@Enumerated(value = EnumType.STRING)
	private EstadoCivilType tipoEstCivilConjuge;
	
	@Column(name="nome_conjuge", length=45)
	private String nomeConjuge;
	
	@Column(name="cpf_conjuge", length=14)
	private String cpfConjuge;
	
	@Column(name="rg_conjuge", length=20)
	private String rgConjuge;
	
	@Column(name="dt_nasc_conjuge")
	private Date dtNascConjuge;
	
	@Column(name="fone_conjuge", length=20)
	private String foneConjuge;
	
	// ------------------------------------------------------- (Informações Particular) Informação Sobre Dependentes
	@Column(name="num_filhos")
	private int numFilho;
	
	@Column(name="num_dep_irrf")
	private int numDepIrrf;
	
	// ------------------------------------------------------- (Informações Particular) Situação Habitacional
	@Column(name="tipo_reside")
	@Enumerated(value = EnumType.STRING)
	private ResideType tipoReside;
	
	@Column(name="tipo_construcao")
	@Enumerated(value = EnumType.STRING)
	private ConstrucaoType tipoConstrucao;
	
	@Column(name="tipo_moradia")
	@Enumerated(value = EnumType.STRING)
	private MoradiaType tipoMoradia;
	
	@Column(name="tipo_agua")
	@Enumerated(value = EnumType.STRING)
	private AguaType tipoAgua;
		
	@Column(name="animais")
	private String animais;
	
	// ------------------------------------------------------- (Informação Financeira)
	@Column(name="salario")
	private Double salario;
	
	@Column(name="tipo_salario")
	@Enumerated(value = EnumType.STRING)
	private SalarioType tipoSalario;
	
	@Column(name="tipo_comissao")
	@Enumerated(value = EnumType.STRING)
	private ComissaoType tipoComissao;
	
	@Column(name="comissao")
	private Double comissao;
	
	@Column(name="tipo_pg_comissao")
	@Enumerated(value = EnumType.STRING)
	private PagComissaoType tipoPgComissao;
	
	@Column(name="tipo_lc_comissao")
	@Enumerated(value = EnumType.STRING)
	private LancaComissaoType tipoLcComissao;
	
	// ------------------------------------------------------- (Curriculo) Informações Curriculares
	@Lob @Column(name="cv_objetivo")
	private String cvObjetivo;
	
	@Lob @Column(name="cv_formacao")
	private String cvFormacao;
	
	@Lob @Column(name="cv_ex_profissinal")
	private String cvExProfissinal;
	
	@Lob @Column(name="cv_atividade")
	private String cvAtividade;
	
	@Lob @Column(name="cv_info")
	private String cvInfo;
	
	// ------------------------------------------------------- (Informações Médicas)
	@Column(name="tipo_sangue")
	@Enumerated(value = EnumType.STRING)
	private SangueType TipoSangue;
	
	@Lob @Column(name="med_info_relevante")
	private String medInfoRelevante;
	
	// ------------------------------------------------------- (Documentos e Imagens)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="colaborador")
	private Set<CaminhoImagemTO> listaImagens;
	// ------------------------------------------------------- (Auditoria do Cadastro)
	

	public ColaboradorTO() { }
	public ColaboradorTO(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isUsuarioSistema() {
		return usuarioSistema;
	}
	public void setUsuarioSistema(boolean usuarioSistema) {
		this.usuarioSistema = usuarioSistema;
	}
	public EmpresaTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}
	public SexoType getSexo() {
		return sexo;
	}
	public void setSexo(SexoType sexo) {
		this.sexo = sexo;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getRgEmissor() {
		return rgEmissor;
	}
	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}
	public Date getDtEmissaoRg() {
		return dtEmissaoRg;
	}
	public void setDtEmissaoRg(Date dtEmissaoRg) {
		this.dtEmissaoRg = dtEmissaoRg;
	}
	public String getTitEleitoral() {
		return titEleitoral;
	}
	public void setTitEleitoral(String titEleitoral) {
		this.titEleitoral = titEleitoral;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public String getCtpsSerie() {
		return ctpsSerie;
	}
	public void setCtpsSerie(String ctpsSerie) {
		this.ctpsSerie = ctpsSerie;
	}
	public String getPisPasep() {
		return pisPasep;
	}
	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}
	public Date getDtEmissaoCt() {
		return dtEmissaoCt;
	}
	public void setDtEmissaoCt(Date dtEmissaoCt) {
		this.dtEmissaoCt = dtEmissaoCt;
	}
	public String getResevista() {
		return resevista;
	}
	public void setResevista(String resevista) {
		this.resevista = resevista;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public Set<EnderecoTO> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(Set<EnderecoTO> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	public Date getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	public Date getDtExMedico() {
		return dtExMedico;
	}
	public void setDtExMedico(Date dtExMedico) {
		this.dtExMedico = dtExMedico;
	}
	public FuncaoTO getFuncao() {
		return funcao;
	}
	public void setFuncao(FuncaoTO funcao) {
		this.funcao = funcao;
	}
	public String getCbo() {
		return cbo;
	}
	public void setCbo(String cbo) {
		this.cbo = cbo;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public CnaeTO getCnae() {
		return cnae;
	}
	public void setCnae(CnaeTO cnae) {
		this.cnae = cnae;
	}
	public ContratacaoType getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(ContratacaoType tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getCtrObs() {
		return ctrObs;
	}
	public void setCtrObs(String ctrObs) {
		this.ctrObs = ctrObs;
	}
	public Date getDtDemissao() {
		return dtDemissao;
	}
	public void setDtDemissao(Date dtDemissao) {
		this.dtDemissao = dtDemissao;
	}
	public Date getDtAfastamento() {
		return dtAfastamento;
	}
	public void setDtAfastamento(Date dtAfastamento) {
		this.dtAfastamento = dtAfastamento;
	}
	public String getDemissaoObs() {
		return demissaoObs;
	}
	public void setDemissaoObs(String demissaoObs) {
		this.demissaoObs = demissaoObs;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getFoneMae() {
		return foneMae;
	}
	public void setFoneMae(String foneMae) {
		this.foneMae = foneMae;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getFonePai() {
		return fonePai;
	}
	public void setFonePai(String fonePai) {
		this.fonePai = fonePai;
	}
	public EstadoCivilType getTipoEstCivilConjuge() {
		return tipoEstCivilConjuge;
	}
	public void setTipoEstCivilConjuge(EstadoCivilType tipoEstCivilConjuge) {
		this.tipoEstCivilConjuge = tipoEstCivilConjuge;
	}
	public String getNomeConjuge() {
		return nomeConjuge;
	}
	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}
	public String getCpfConjuge() {
		return cpfConjuge;
	}
	public void setCpfConjuge(String cpfConjuge) {
		this.cpfConjuge = cpfConjuge;
	}
	public String getRgConjuge() {
		return rgConjuge;
	}
	public void setRgConjuge(String rgConjuge) {
		this.rgConjuge = rgConjuge;
	}
	public Date getDtNascConjuge() {
		return dtNascConjuge;
	}
	public void setDtNascConjuge(Date dtNascConjuge) {
		this.dtNascConjuge = dtNascConjuge;
	}
	public String getFoneConjuge() {
		return foneConjuge;
	}
	public void setFoneConjuge(String foneConjuge) {
		this.foneConjuge = foneConjuge;
	}
	public int getNumFilho() {
		return numFilho;
	}
	public void setNumFilho(int numFilho) {
		this.numFilho = numFilho;
	}
	public int getNumDepIrrf() {
		return numDepIrrf;
	}
	public void setNumDepIrrf(int numDepIrrf) {
		this.numDepIrrf = numDepIrrf;
	}
	public ResideType getTipoReside() {
		return tipoReside;
	}
	public void setTipoReside(ResideType tipoReside) {
		this.tipoReside = tipoReside;
	}
	public ConstrucaoType getTipoConstrucao() {
		return tipoConstrucao;
	}
	public void setTipoConstrucao(ConstrucaoType tipoConstrucao) {
		this.tipoConstrucao = tipoConstrucao;
	}
	public MoradiaType getTipoMoradia() {
		return tipoMoradia;
	}
	public void setTipoMoradia(MoradiaType tipoMoradia) {
		this.tipoMoradia = tipoMoradia;
	}
	public AguaType getTipoAgua() {
		return tipoAgua;
	}
	public void setTipoAgua(AguaType tipoAgua) {
		this.tipoAgua = tipoAgua;
	}
	public String getAnimais() {
		return animais;
	}
	public void setAnimais(String animais) {
		this.animais = animais;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public SalarioType getTipoSalario() {
		return tipoSalario;
	}
	public void setTipoSalario(SalarioType tipoSalario) {
		this.tipoSalario = tipoSalario;
	}
	public ComissaoType getTipoComissao() {
		return tipoComissao;
	}
	public void setTipoComissao(ComissaoType tipoComissao) {
		this.tipoComissao = tipoComissao;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	public PagComissaoType getTipoPgComissao() {
		return tipoPgComissao;
	}
	public void setTipoPgComissao(PagComissaoType tipoPgComissao) {
		this.tipoPgComissao = tipoPgComissao;
	}
	public LancaComissaoType getTipoLcComissao() {
		return tipoLcComissao;
	}
	public void setTipoLcComissao(LancaComissaoType tipoLcComissao) {
		this.tipoLcComissao = tipoLcComissao;
	}
	public String getCvObjetivo() {
		return cvObjetivo;
	}
	public void setCvObjetivo(String cvObjetivo) {
		this.cvObjetivo = cvObjetivo;
	}
	public String getCvFormacao() {
		return cvFormacao;
	}
	public void setCvFormacao(String cvFormacao) {
		this.cvFormacao = cvFormacao;
	}
	public String getCvExProfissinal() {
		return cvExProfissinal;
	}
	public void setCvExProfissinal(String cvExProfissinal) {
		this.cvExProfissinal = cvExProfissinal;
	}
	public String getCvAtividade() {
		return cvAtividade;
	}
	public void setCvAtividade(String cvAtividade) {
		this.cvAtividade = cvAtividade;
	}
	public String getCvInfo() {
		return cvInfo;
	}
	public void setCvInfo(String cvInfo) {
		this.cvInfo = cvInfo;
	}
	public SangueType getTipoSangue() {
		return TipoSangue;
	}
	public void setTipoSangue(SangueType tipoSangue) {
		TipoSangue = tipoSangue;
	}
	public String getMedInfoRelevante() {
		return medInfoRelevante;
	}
	public void setMedInfoRelevante(String medInfoRelevante) {
		this.medInfoRelevante = medInfoRelevante;
	}
	public Set<CaminhoImagemTO> getListaImagens() {
		return listaImagens;
	}
	public void setListaImagens(Set<CaminhoImagemTO> listaImagens) {
		this.listaImagens = listaImagens;
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