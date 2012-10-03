package br.com.automacao.ctr.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.dotcompany.to.TransferObject;

/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Título:</b> ModuloTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 25/08/2011, 12:27:19
 */
@SuppressWarnings("serial")
@Entity
@Table(name="modulo")
public class ModuloTO extends TransferObject {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="descricao", length=300)
	private String descricao;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="modulo")
	private List<EmpresaModuloTO> listaModulo;
	
	public ModuloTO() {}
	
	public ModuloTO(Long id) {
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<EmpresaModuloTO> getListaModulo() {
		return listaModulo;
	}
	public void setListaModulo(List<EmpresaModuloTO> listaModulo) {
		this.listaModulo = listaModulo;
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