package br.com.automacao.shared.mirror;

import java.io.Serializable;

import br.com.automacao.ctr.entidade.EmpresaModuloTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;


@SuppressWarnings("serial")
@ServerCalledCommand(EmpresaModuloTO.class)
public class EmpresaModuloMirror extends Mirror {
 
	private Long id;

	private EmpresaMirror empresa;

	private ModuloMirror modulo;
	
	public EmpresaModuloMirror() {}
	
	public EmpresaModuloMirror(Long id) {
		this.id = id;
	}
	
	public EmpresaModuloMirror(EmpresaMirror empresa, ModuloMirror modulo) {
        this.empresa = empresa;
        this.modulo = modulo;
	}
	
	public EmpresaModuloMirror(Long id, EmpresaMirror empresa, ModuloMirror modulo) {
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
	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
	}
	public ModuloMirror getModulo() {
		return modulo;
	}
	public void setModulo(ModuloMirror modulo) {
		this.modulo = modulo;
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
		return this.id.toString();
	}
}
