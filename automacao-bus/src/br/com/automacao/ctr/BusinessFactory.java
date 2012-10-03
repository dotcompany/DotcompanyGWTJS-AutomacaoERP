package br.com.automacao.ctr;

import br.com.automacao.ctr.negocio.Cliente;
import br.com.automacao.ctr.negocio.Cnae;
import br.com.automacao.ctr.negocio.Colaborador;
import br.com.automacao.ctr.negocio.Contato;
import br.com.automacao.ctr.negocio.Empresa;
import br.com.automacao.ctr.negocio.FormDinamico;
import br.com.automacao.ctr.negocio.Fornecedor;
import br.com.automacao.ctr.negocio.Funcao;
import br.com.automacao.ctr.negocio.Grid;
import br.com.automacao.ctr.negocio.Marca;
import br.com.automacao.ctr.negocio.Modelos;
import br.com.automacao.ctr.negocio.Modulo;
import br.com.automacao.ctr.negocio.impl.ClienteBO;
import br.com.automacao.ctr.negocio.impl.CnaeBO;
import br.com.automacao.ctr.negocio.impl.ColaboradorBO;
import br.com.automacao.ctr.negocio.impl.EmpresaBO;
import br.com.automacao.ctr.negocio.impl.FormDinamicoBO;
import br.com.automacao.ctr.negocio.impl.FuncaoBO;
import br.com.automacao.ctr.negocio.impl.GridBO;
import br.com.automacao.ctr.negocio.impl.MarcaBO;
import br.com.automacao.ctr.negocio.impl.ModelosBO;
import br.com.automacao.ctr.negocio.impl.ModuloBO;
import br.com.dotcompany.context.SpringCtxHolder;
import br.com.dotcompany.hibernate.Generics;
import br.com.dotcompany.hibernate.GenericsBO;



public class BusinessFactory extends SpringCtxHolder {
	private BusinessFactory() {}

	private static BusinessFactory INSTANCE = null;
	private static Generics generics;
	private static Colaborador colaborador;
	private static Empresa empresa;
	private static Grid grid;
	private static Cliente cliente;
	private static FormDinamico formDinamico;
	private static Cnae cnae;
	private static Funcao funcao;
	private static Modulo modulo; 
	private static Marca marca; 
	private static Modelos modelos; 
	private static Contato contato;
	private static Fornecedor fornecedor;
	


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

	public Cliente getCliente() {
		if(cliente == null) {cliente = super.getBean(ClienteBO.class);}
		return cliente;
	}

	public FormDinamico getFormDinamico() {
		if(formDinamico == null){formDinamico = super.getBean(FormDinamicoBO.class);}
		return formDinamico;
	}
	public Funcao getFuncao() {
		if(funcao == null){funcao = super.getBean(FuncaoBO.class);}
		return funcao;
	}

	public Empresa getEmpresa() {
		if(empresa == null){empresa = super.getBean(EmpresaBO.class);}
		return empresa;
	}
	
	public Cnae getCnae() {
		if(cnae == null){cnae = super.getBean(CnaeBO.class);}
		return cnae;
	}

	public Modulo getModulo() {
		if(modulo == null){modulo = super.getBean(ModuloBO.class);}
		return modulo;
	}
	public Colaborador getColaborador() {
		if (colaborador == null) {colaborador = super.getBean(ColaboradorBO.class);}
		return colaborador;
	}
	public Marca getMarca() {
		if(marca == null){marca = super.getBean(MarcaBO.class);}
		return marca;
	}

	public Modelos getModelos() {
		if(modelos == null){modelos = super.getBean(ModelosBO.class);}
		return modelos;
	}

}