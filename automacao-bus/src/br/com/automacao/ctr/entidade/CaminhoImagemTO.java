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

/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>T�tulo:</b> CaminhoImagensTO.java <br>
 * <b>Descri��o:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Cria��o:</b> 25/08/2011, 11:05:28
 */
@SuppressWarnings("serial")
@Entity
@Table(name="caminho_imagens")
public class CaminhoImagemTO extends TransferObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="real_path", nullable=false, length=500)
	private String realPath;
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false, referencedColumnName="id")
	private EmpresaTO empresa;
	

	public CaminhoImagemTO() { }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
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
		return this.getRealPath();
	}
}