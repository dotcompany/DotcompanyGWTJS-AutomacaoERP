package br.com.automacao.shared.mirror;

import java.io.Serializable;
import java.util.Set;

import br.com.automacao.ctr.entidade.FuncaoTO;
import br.com.dotcompany.core.ServerCalledCommand;
import br.com.automacao.shared.util.Mirror;



@SuppressWarnings("serial")
@ServerCalledCommand(FuncaoTO.class)
public class FuncaoMirror extends Mirror {
 
	private Long id;
	 
	private String descricaoMenu;
	 
	private String menuImg;
	 
	private String metodo;
	 
	private EmpresaMirror empresa;
	 
	private Set<ColaboradorMirror> listaColaborador;

	
	public FuncaoMirror() { }
	public FuncaoMirror(Long id) {
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
	public EmpresaMirror getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaMirror empresa) {
		this.empresa = empresa;
	}
	public Set<ColaboradorMirror> getListaColaborador() {
		return listaColaborador;
	}
	public void setListaColaborador(Set<ColaboradorMirror> listaColaborador) {
		this.listaColaborador = listaColaborador;
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
		return this.getDescricaoMenu();
	}	
}
