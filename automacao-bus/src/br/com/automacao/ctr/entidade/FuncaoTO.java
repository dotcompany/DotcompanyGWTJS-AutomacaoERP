package br.com.automacao.ctr.entidade;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import br.com.dotcompany.to.TransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name="funcao")
public class FuncaoTO extends TransferObject {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	 
	@Column(name="descricao_menu", length=300)
	private String descricaoMenu;
	 
	@Column(name="imagem_menu")
	private String menuImg;
	 
	@Column(name="metodo")
	private String metodo;
	 
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false, referencedColumnName="id")
	private EmpresaTO empresa;
	

	
	public FuncaoTO() { }
	public FuncaoTO(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricaoMenu() {
		return descricaoMenu;
	}
	public void setDescricaoMenu(String descricaoMenu) {
		this.descricaoMenu = descricaoMenu;
	}
	public String getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public EmpresaTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
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
		return this.getDescricaoMenu();
	}	
}