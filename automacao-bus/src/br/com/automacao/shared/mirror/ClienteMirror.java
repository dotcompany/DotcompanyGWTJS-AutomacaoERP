package br.com.automacao.shared.mirror;

import java.io.Serializable;
import java.util.Set;

import br.com.automacao.ctr.entidade.ClienteTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


import br.com.automacao.shared.type.SexoType;

@SuppressWarnings("serial")
@ServerCalledCommand(ClienteTO.class)
public class ClienteMirror extends Mirror {
	
	private Long id;
	
	private String primeiroNome;
	
	private String sobrenome;

	private String descricao;
	
	private SexoType sexo;
	
	private String cpf;
	
	private EmpresaMirror empresa;
	
	
	private Set<EnderecoMirror> listaEndereco;
	
	private Set<CaminhoImagemMirror> listaImagens;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public SexoType getSexo() {
		return sexo;
	}
	public void setSexo(SexoType sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
	}
	public Set<EnderecoMirror> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(Set<EnderecoMirror> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	public Set<CaminhoImagemMirror> getListaImagens() {
		return listaImagens;
	}
	public void setListaImagens(Set<CaminhoImagemMirror> listaImagens) {
		this.listaImagens = listaImagens;
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
		return this.getPrimeiroNome();
	}
}
