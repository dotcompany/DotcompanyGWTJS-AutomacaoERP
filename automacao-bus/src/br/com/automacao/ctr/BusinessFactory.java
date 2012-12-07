package br.com.automacao.ctr;


import br.com.automacao.ctr.negocio.Cnae;
import br.com.automacao.ctr.negocio.Empresa;
import br.com.automacao.ctr.negocio.FormDinamico;
import br.com.automacao.ctr.negocio.Funcao;
import br.com.automacao.ctr.negocio.Grid;
import br.com.automacao.ctr.negocio.GridEditavel;
import br.com.automacao.ctr.negocio.Modulo;
import br.com.automacao.ctr.negocio.impl.CnaeBO;
import br.com.automacao.ctr.negocio.impl.EmpresaBO;
import br.com.automacao.ctr.negocio.impl.FormDinamicoBO;
import br.com.automacao.ctr.negocio.impl.FuncaoBO;
import br.com.automacao.ctr.negocio.impl.GridBO;
import br.com.automacao.ctr.negocio.impl.GridEditavelBO;
import br.com.automacao.ctr.negocio.impl.ModuloBO;
import br.com.dotcompany.context.SpringCtxHolder;
import br.com.dotcompany.hibernate.Generics;
import br.com.dotcompany.hibernate.GenericsBO;



public class BusinessFactory extends SpringCtxHolder {
	private BusinessFactory() {}

	private static BusinessFactory INSTANCE = null;
	private static Generics generics;
	private static Empresa empresa;
	private static Grid grid;
	private static FormDinamico formDinamico;
	private static Cnae cnae;
	private static Funcao funcao;
	private static Modulo modulo;
	private static GridEditavel grideditavel; 
	


	public static BusinessFactory getInstance() {
		if (INSTANCE == null){INSTANCE = new BusinessFactory();}
		return INSTANCE;
	}

	public Generics getGenerics() {
		if (generics == null) {generics = super.getBean(GenericsBO.class);}
		return generics;
	}

	public Grid getGrid() {
		if (grid == null) {grid = super.getBean(GridBO.class);}
		return grid;
	}
	public GridEditavel getGridEditavel() {
		if (grideditavel == null) {grideditavel = super.getBean(GridEditavelBO.class);}
		return grideditavel;
	}


	public FormDinamico getFormDinamico() {
		if(formDinamico == null){formDinamico = super.getBean(FormDinamicoBO.class);}
		return formDinamico;
	}
	public Funcao getFuncao() {
		if(funcao == null){funcao = super.getBean(FuncaoBO.class);}
		return funcao;
	}

	
	
	public Cnae getCnae() {
		if(cnae == null){cnae = super.getBean(CnaeBO.class);}
		return cnae;
	}

	public Modulo getModulo() {
		if(modulo == null){modulo = super.getBean(ModuloBO.class);}
		return modulo;
	}
	public Empresa getEmpresa() {
		if(empresa == null){empresa = super.getBean(EmpresaBO.class);}
		return empresa;
	}
}