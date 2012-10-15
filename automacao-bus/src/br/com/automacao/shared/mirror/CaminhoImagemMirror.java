package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.CaminhoImagemTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


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
@ServerCalledCommand(CaminhoImagemTO.class)
public class CaminhoImagemMirror extends Mirror {

	private Long id;
	
	private String realPath;
	
	private EmpresaMirror empresa;
	
	

	
	public CaminhoImagemMirror() { }
	
	
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
	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
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
		return this.getRealPath();
	}
}
