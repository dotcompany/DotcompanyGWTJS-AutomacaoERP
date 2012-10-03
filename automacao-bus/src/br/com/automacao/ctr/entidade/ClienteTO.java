package br.com.automacao.ctr.entidade;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.automacao.shared.type.SexoType;
import br.com.dotcompany.to.TransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "cliente")
public class ClienteTO extends TransferObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="primeiro_nome", nullable=false, length=45)
	private String primeiroNome;
	
	@Column(name="sobrenome", nullable=false, length=45)
	private String sobrenome;

	@Column(name="descricao", length=300)
	private String descricao;
	
	@Column(name="sexo_tipo", nullable=false)
	@Enumerated(value = EnumType.STRING)
	private SexoType sexo;
	
	@Column(name="cpf", length=20)
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName="id")
	private EmpresaTO empresa;

	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
	private Set<EnderecoTO> listaEndereco;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
	private Set<CaminhoImagemTO> listaImagens;
	
	
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
	public EmpresaTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	public Set<EnderecoTO> getListaEndereco() {
		return listaEndereco;
	}
	public void setListaEndereco(Set<EnderecoTO> listaEndereco) {
		this.listaEndereco = listaEndereco;
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
		return this.getPrimeiroNome();
	}
}