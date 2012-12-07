package br.com.automacao.client;

import br.com.automacao.client.service.CnaeService;
import br.com.automacao.client.service.CnaeServiceAsync;
import br.com.automacao.client.service.EmpresaService;
import br.com.automacao.client.service.EmpresaServiceAsync;
import br.com.automacao.client.service.FuncaoService;
import br.com.automacao.client.service.FuncaoServiceAsync;
import br.com.automacao.client.service.GenericsService;
import br.com.automacao.client.service.GenericsServiceAsync;
import br.com.automacao.client.service.GridEditavelService;
import br.com.automacao.client.service.GridEditavelServiceAsync;
import br.com.automacao.client.service.GridService;
import br.com.automacao.client.service.GridServiceAsync;
import br.com.automacao.client.service.ModuloService;
import br.com.automacao.client.service.ModuloServiceAsync;
import br.com.automacao.client.service.SessaoService;
import br.com.automacao.client.service.SessaoServiceAsync;

import com.google.gwt.core.client.GWT;

public abstract class ActionServer {

	private static final GridServiceAsync SERVICE_GRID = GWT
			.create(GridService.class);
	private static final GenericsServiceAsync SERVICE_GENERICS = GWT
			.create(GenericsService.class);
	private static final CnaeServiceAsync SERVICE_CNAE = GWT
			.create(CnaeService.class);
	private static final FuncaoServiceAsync SERVICE_FUNCAO = GWT
			.create(FuncaoService.class);
	private static final ModuloServiceAsync SERVICE_MODULO = GWT
			.create(ModuloService.class);
	private static final SessaoServiceAsync SERVICE_SESSAO = GWT
			.create(SessaoService.class);
	private static final EmpresaServiceAsync SERVICE_EMPRESA = GWT
			.create(EmpresaService.class);
	private static final GridEditavelServiceAsync SERVICE_GRIDEDITAVEL = GWT
			.create(GridEditavelService.class);
	
	public static EmpresaServiceAsync getServiceEmpresa() {
		return SERVICE_EMPRESA;
	}

	public static GridServiceAsync getServiceGrid() {
		return SERVICE_GRID;
	}
	public static GridEditavelServiceAsync getServiceGridEditavel() {
		return SERVICE_GRIDEDITAVEL;
	}

	public static GenericsServiceAsync getServiceGenerics() {
		return SERVICE_GENERICS;
	}

	public static CnaeServiceAsync getServiceCnae() {
		return SERVICE_CNAE;
	}


	public static FuncaoServiceAsync getServiceFuncao() {
		return SERVICE_FUNCAO;
	}

	public static ModuloServiceAsync getServiceModulo() {
		return SERVICE_MODULO;
	}

	public static SessaoServiceAsync getServiceSessao() {
		return SERVICE_SESSAO;
	}
}