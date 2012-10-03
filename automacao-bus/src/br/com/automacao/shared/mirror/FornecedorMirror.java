package br.com.automacao.shared.mirror;

import java.io.Serializable;
import java.util.Date;

import br.com.automacao.ctr.entidade.ColaboradorTO;
import br.com.automacao.shared.util.Mirror;
import br.com.dotcompany.core.ServerCalledCommand;


@ServerCalledCommand(ColaboradorTO.class)
public class FornecedorMirror extends Mirror {
	
	private static final long serialVersionUID = 1L;
	private Long id;
    private String nome;
    private String cpfCnpj;
    private String rg;
    private String orgaoRg;
    private String inscricaoEstadal;
    private String inscricaoMunicipal;
    private Date desde;
    private String tipoPessoa;
    private String excluido;
    private Date dataCadastro;

	public FornecedorMirror() { }
	public FornecedorMirror(Long id) {
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
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoRg() {
		return orgaoRg;
	}
	public void setOrgaoRg(String orgaoRg) {
		this.orgaoRg = orgaoRg;
	}
	public String getInscricaoEstadal() {
		return inscricaoEstadal;
	}
	public void setInscricaoEstadal(String inscricaoEstadal) {
		this.inscricaoEstadal = inscricaoEstadal;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getExcluido() {
		return excluido;
	}
	public void setExcluido(String excluido) {
		this.excluido = excluido;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
