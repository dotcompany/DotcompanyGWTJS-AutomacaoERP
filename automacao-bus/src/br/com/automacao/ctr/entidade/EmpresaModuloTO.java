package br.com.automacao.ctr.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dotcompany.to.TransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "empresamodulo")
public class EmpresaModuloTO extends TransferObject {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false, referencedColumnName="id")
	private EmpresaTO empresa;

	@ManyToOne
	@JoinColumn(name="id_modulo", nullable=false, referencedColumnName="id")
	private ModuloTO modulo;
	
	public EmpresaModuloTO() {}
	
	public EmpresaModuloTO(Long id) {
		this.id = id;
	}
	
	public EmpresaModuloTO(EmpresaTO empresa, ModuloTO modulo) {
        this.empresa = empresa;
        this.modulo = modulo;
	}
	
	public EmpresaModuloTO(Long id, EmpresaTO empresa, ModuloTO modulo) {
		this.id = id;
        this.empresa = empresa;
        this.modulo = modulo;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public EmpresaTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}
	public ModuloTO getModulo() {
		return modulo;
	}
	public void setModulo(ModuloTO modulo) {
		this.modulo = modulo;
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
		return this.id.toString();
	}
}