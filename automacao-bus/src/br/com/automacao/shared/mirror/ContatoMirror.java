package br.com.automacao.shared.mirror;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import br.com.automacao.ctr.entidade.ColaboradorTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


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


@ServerCalledCommand(ColaboradorTO.class)
public class ContatoMirror extends Mirror {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------- (Geral) Informações importante
	private Long id;
	
	private Date dataCadastro;
	
	private String matricula;
	
	private String nome;
	
	private Boolean ativo;
	
	private boolean usuarioSistema;
	
	private EmpresaMirror empresa;
	// ------------------------------------------------------- (Geral) Documentos Pessoais
	private SexoType sexo;
	
	private Date dtNasc;
	
	private String cpf;
	
	private String rg;
	
	private String rgEmissor;
	
	private Date dtEmissaoRg;
	
	private String titEleitoral;
	
	private String ctps;
	
	private String ctpsSerie;
	
	private String pisPasep;
	
	private Date dtEmissaoCt;
	
	private String resevista;
	
	private String cnh;
	
	// ------------------------------------------------------- (Geral) Endereço
	private Set<EnderecoMirror> listaEndereco;

	
	// ------------------------------------------------------- (Dados da Contratação) Informações da Contratação
	private Date dtAdmissao;
	
	private Date dtExMedico;
	
	private FuncaoMirror funcao;	
	
	private String cbo;
	
	private Integer horas;
	
	private CnaeMirror cnae;

	private ContratacaoType tipoContrato;
	
	private String ctrObs;
	
	// ------------------------------------------------------- (Dados da Contratação) Informações da Demissão
	private Date dtDemissao;
	
	private Date dtAfastamento;
	
	private String demissaoObs;
	
	// ------------------------------------------------------- (Informações Particular) Filiação
	private String mae;
	
	private String foneMae;
	
	private String pai;
	
	private String fonePai;
	
	// ------------------------------------------------------- (Informações Particular) Informação do Cônjuge
	private EstadoCivilType tipoEstCivilConjuge;
	
	private String nomeConjuge;
	
	private String cpfConjuge;
	
	private String rgConjuge;
	
	private Date dtNascConjuge;
	
	private String foneConjuge;
	
	// ------------------------------------------------------- (Informações Particular) Informação Sobre Dependentes
	private int numFilho;
	
	private int numDepIrrf;
	
	// ------------------------------------------------------- (Informações Particular) Situação Habitacional
	private ResideType tipoReside;
	
	private ConstrucaoType tipoConstrucao;
	
	private MoradiaType tipoMoradia;
	
	private AguaType tipoAgua;
		
	private String animais;
	
	// ------------------------------------------------------- (Informação Financeira)
	private Double salario;
	
	private SalarioType tipoSalario;
	
	private ComissaoType tipoComissao;
	
	private Double comissao;
	
	private PagComissaoType tipoPgComissao;
	
	private LancaComissaoType tipoLcComissao;
	
	// ------------------------------------------------------- (Curriculo) Informações Curriculares
	private String cvObjetivo;
	
	private String cvFormacao;
	
	private String cvExProfissinal;
	
	private String cvAtividade;
	
	private String cvInfo;
	
	// ------------------------------------------------------- (Informações Médicas)
	private SangueType TipoSangue;
	
	private String medInfoRelevante;
	
	// ------------------------------------------------------- (Documentos e Imagens)
	private Set<CaminhoImagemMirror> listaImagens;
	
	// ------------------------------------------------------- (Lista de Serviços)
	private Set<ServicoColaboradorMirror> listaServicoColaborador;

	// ------------------------------------------------------- (Auditoria do Cadastro)
	

	public ContatoMirror() { }
	public ContatoMirror(Long id) {
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
	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
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
	public Set<EnderecoMirror> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(Set<EnderecoMirror> listaEndereco) {
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
	public FuncaoMirror getFuncao() {
		return funcao;
	}
	public void setFuncao(FuncaoMirror funcao) {
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
	public CnaeMirror getCnae() {
		return cnae;
	}
	public void setCnae(CnaeMirror cnae) {
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
	public Set<CaminhoImagemMirror> getListaImagens() {
		return listaImagens;
	}
	public void setListaImagens(Set<CaminhoImagemMirror> listaImagens) {
		this.listaImagens = listaImagens;
	}
	public Set<ServicoColaboradorMirror> getListaServicoColaborador() {
		return listaServicoColaborador;
	}
	public void setListaServicoColaborador(
			Set<ServicoColaboradorMirror> listaServicoColaborador) {
		this.listaServicoColaborador = listaServicoColaborador;
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
