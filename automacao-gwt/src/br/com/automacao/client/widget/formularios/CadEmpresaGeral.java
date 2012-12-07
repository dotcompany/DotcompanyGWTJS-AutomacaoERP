package br.com.automacao.client.widget.formularios;

import java.util.ArrayList;
import java.util.HashSet;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.widget.DotDateField;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotListeners;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.client.widget.grid.GridSimples;
import br.com.automacao.client.widget.grid.proxy.DotProxy;
import br.com.automacao.client.widget.grid.proxy.DotRpcProxy;
import br.com.automacao.shared.dto.CepDTO;
import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.mirror.EnderecoMirror;
import br.com.automacao.shared.model.EmpresaModel;
import br.com.automacao.shared.type.ChegouType;
import br.com.automacao.shared.type.ContatoType;
import br.com.automacao.shared.type.EmitirNfType;
import br.com.automacao.shared.type.EmpresaType;
import br.com.automacao.shared.type.EstadosBrType;
import br.com.automacao.shared.type.PessoaType;
import br.com.automacao.shared.type.RamoType;
import br.com.automacao.shared.type.ReceitaType;
import br.com.automacao.shared.type.RegimeType;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ComboBoxUtils;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Image;

public class CadEmpresaGeral extends IForm<EmpresaMirror> {

	
	private TabItem tabItemGeral = new TabItem("Geral");
	private FormPanel formGeral = new FormPanel();
	private FieldSet fsetInformacoes = new FieldSet();

	

	// GERAL
	private FieldSet fsetGeral = new FieldSet();
	private Text textCodigo = new Text("C\u00F3digo");
	private DotTextField<String> tfCodigo = new DotTextField<String>();
	private DotDateField dfCadastro = new DotDateField("pt");
	private ComboBoxUtils<Combo> cbTipoEmpresa = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbConheceu = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbRamo = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbEmitirNF = new ComboBoxUtils<Combo>();

	// INFORMA��ES
	private TabPanel tabPanelInfo = new TabPanel();

	// INFORMA��ES -> GERAL
	private TabItem tabItemInfoGeral = new TabItem("Geral");
	private FormPanel formInfoGeral = new FormPanel();
	private DotTextField<String> tfRazaoSocial = new DotTextField<String>();
	private DotTextField<String> tfCpfCnpj = new DotTextField<String>();
	private ComboBoxUtils<Combo> cbPessoa = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfInscEstad = new DotTextField<String>();
	private DotTextField<String> tfInscMunic = new DotTextField<String>();
	private DotTextField<String> tfFantasia = new DotTextField<String>();
	private DotTextField<String> tfNomeContato = new DotTextField<String>();
	private Image imgFoto = new Image();

	// INFORMA��ES -> NFe
	private TabItem tabItemInfoComp = new TabItem("Informa\u00E7\u00F5es Complementares NFe");
	private FormPanel formInfoComp = new FormPanel();
	private ComboBoxUtils<Combo> cbCodRegimeTrib = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbTipoRegime = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfPis = new DotTextField<String>();
	private DotTextField<String> tfConfins = new DotTextField<String>();
	private DotTextField<String> tfSuframa = new DotTextField<String>();
	private DotTextField<String> tfInscEstadST = new DotTextField<String>();

	// ENDERE�O
	private FieldSet fsetEndereco = new FieldSet();
	private DotTextField<String> tfCep = new DotTextField<String>("#####-###");
	private DotTextField<String> tfEndereco = new DotTextField<String>();
	private DotTextField<String> tfQuadra = new DotTextField<String>();
	private DotTextField<String> tfLote = new DotTextField<String>();
	private DotTextField<String> tfNumero = new DotTextField<String>();
	private DotTextField<String> tfComplemento = new DotTextField<String>();
	private DotTextField<String> tfBairro = new DotTextField<String>();
	private DotTextField<String> tfCidade = new DotTextField<String>();
	private DotTextField<String> tfPais = new DotTextField<String>();
	private ComboBoxUtils<Combo> cbUF = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfReferencia = new DotTextField<String>();
	private ComboBoxUtils<Combo> cbContato = new ComboBoxUtils<Combo>();
	private Hidden idEndereco = new Hidden();
	// private DotTextField<String> tfIbgeMunic = new DotTextField<String>();
	// private DotTextField<String> tfIbgeUF = new DotTextField<String>();
    //GRID
	private FieldSet fsetGrid = new FieldSet();
	private GridSimples<EmpresaModel, EmpresaMirror> gridEmp;
	
	

	public CadEmpresaGeral() {
		super(null);
	}

	public CadEmpresaGeral(DotFormulario formulario) {
		super(formulario);

		FileColumn fc = new FileColumn("8877yhg", EmpresaMirror.class.getName());
		EmpresaModel em = new EmpresaModel(fc);
		final DotProxy proxyEmpresa = new DotRpcProxy<EmpresaModel>(fc, em);
		gridEmp = new GridSimples<EmpresaModel, EmpresaMirror>(proxyEmpresa, fc,formulario,730,150);
		tabItemGeral.setLayout(new FitLayout());

		formGeral.setFrame(true);
		formGeral.setHeaderVisible(false);
		formGeral.setHeading("New FormPanel");
		formGeral.setCollapsible(false);
		formGeral.setLayout(new AbsoluteLayout());

		buildFieldSetInformacoes();
		buildFieldSetGeral();
		buildFieldSetEndereco();
		buildFieldSetGrid();

		buildImage();
		changeTab();
		selectItemGrid();
	}

	private void changeTab() {
		tabPanelInfo.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if (tabPanelInfo.getSelectedItem().equals(tabItemInfoGeral)) {
					cbPessoa.setTabIndex(7);
					tfCpfCnpj.setTabIndex(8);
					tfInscEstad.setTabIndex(9);
					tfInscMunic.setTabIndex(10);
					tfRazaoSocial.setTabIndex(11);
					tfFantasia.setTabIndex(12);
					tfNomeContato.setTabIndex(13);
				} else {
					cbCodRegimeTrib.setTabIndex(7);
					cbTipoRegime.setTabIndex(8);
					tfPis.setTabIndex(9);
					tfConfins.setTabIndex(10);
					tfSuframa.setTabIndex(11);
					tfInscEstadST.setTabIndex(12);
				}
			}
		});
	}
	
	private void selectItemGrid() {
		formGeral.addListener(Events.OnChange, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				tfFantasia.setValue(gridEmp.getDto().toString());		
			}
		});
	}

	private void buildImage() {
		formGeral.add(imgFoto, new AbsoluteData(612, 10));
		imgFoto.setSize("125px", "152px");
		tabItemGeral.add(formGeral);
		tabItemGeral.setHeight("700px");
	}

	private void buildFieldSetGeral() {
		fsetGeral.setLayout(new AbsoluteLayout());
		fsetGeral.setCollapsible(false);

		fsetGeral.add(textCodigo, new AbsoluteData(0, -2));
		textCodigo.setSize("33px", "13px");

		fsetGeral.add(tfCodigo, new AbsoluteData(0, 14));
		tfCodigo.setSize("100px", "22px");
		tfCodigo.setTabIndex(1);

		dfCadastro.buildInput(fsetGeral, "Data Cadastro", 106, 13, "110px",
				"22px", 2);
		dfCadastro.focus();
		cbTipoEmpresa.buildInput(fsetGeral, "Tipo da Empresa", 222, 14,
				"173px", "22px", EmpresaType.class, 3);
		cbConheceu.buildInput(fsetGeral, "Como nos Conheceu", 1, 58, "216px",
				"22px", ChegouType.class, 4);
		cbRamo.buildInput(fsetGeral, "Ramo de Atividade da empresa", 222, 58,
				"173px", "22p", RamoType.class, 5);
		cbEmitirNF.buildInput(fsetGeral, "Usar\u00E1 o sistema p/ Emitir NFe",
				401, 58, "173px", "22px", EmitirNfType.class, 6);
		formGeral.add(fsetGeral, new AbsoluteData(6, 3));
		
		
		fsetGeral.setSize("600px", "158px");
		fsetGeral.setHeading("Geral.");
	}

	private void buildFieldSetInformacoes() {
		fsetInformacoes.setLayout(new FitLayout());
		fsetInformacoes.add(tabPanelInfo);
		fsetInformacoes.setCollapsible(false);
		tabItemInfoGeral.setLayout(new FitLayout());

		formInfoGeral.setFrame(true);
		formInfoGeral.setHeaderVisible(false);
		formInfoGeral.setHeading("New FormPanel");
		formInfoGeral.setLayout(new AbsoluteLayout());

		cbPessoa.buildInput(formInfoGeral, "Pessoa F.\\J.", 6, 13, "92px",
				"22px", PessoaType.class, 7);
		tfCpfCnpj.buildInput(formInfoGeral, "CPF\\CNPJ", 104, 13, "135px",
				"22px", 8);
		tfInscEstad.buildInput(formInfoGeral, "Inscri\u00E7\u00E3o Estadual",
				245, 13, "99px", "22px", 9);
		tfInscMunic.buildInput(formInfoGeral, "Inscri\u00E7\u00E3o Municipal",
				362, 13, "99px", "22px", 10);
		tfRazaoSocial.buildInput(formInfoGeral, "Nome\\Raz\u00E3o", 6, 57,
				"350px", "22px", 11);
		tfFantasia.buildInput(formInfoGeral, "Nome Fantasia", 362, 57, "333px",
				"22px", 12);
		tfNomeContato.buildInput(formInfoGeral, "Nome Contato", 6, 100,
				"350px", "22px", 13);
		DotListeners.maskCpfOrCnpj(cbPessoa, tfCpfCnpj);
        
		tabItemInfoGeral.add(formInfoGeral);
		tabPanelInfo.add(tabItemInfoGeral);
		tabItemInfoComp.setLayout(new FitLayout());

		formInfoComp.setHeaderVisible(false);
		formInfoComp.setFrame(true);
		formInfoComp.setHeading("New FormPanel");
		formInfoComp.setCollapsible(false);
		formInfoComp.setLayout(new AbsoluteLayout());

		cbCodRegimeTrib.buildInput(formInfoComp,
				"C\u00F3digo de Regime Tribut\u00E1rio - CRT", 6, 13, "285px",
				"22px", ReceitaType.class, 26);
		cbTipoRegime.buildInput(formInfoComp, "Tipo de Regime", 297, 13,
				"188px", "22px", RegimeType.class, 27);
		tfPis.buildInput(formInfoComp, "Aliq. PIS", 491, 13, "82px", "22px", 28);
		tfConfins.buildInput(formInfoComp, "Aliq. CONFINS", 579, 13, "82px",
				"22px", 29);
		tfSuframa
				.buildInput(formInfoComp, "SUFRAMA", 6, 57, "82px", "22px", 30);
		tfInscEstadST.buildInput(formInfoComp,
				"Inscri\u00E7\u00E3o Estadual ST", 94, 57, "105px", "22px", 31);

		tabItemInfoComp.add(formInfoComp);
		tabPanelInfo.add(tabItemInfoComp);
		formGeral.add(fsetInformacoes, new AbsoluteData(6, 161));
		fsetInformacoes.setSize("731px", "210px");
		fsetInformacoes.setHeading("Informa\u00E7\u00F5es Importantes");
	}

	private void buildFieldSetEndereco() {
		formGeral.add(fsetEndereco, new AbsoluteData(6, 367));
		tfCep.buildInput(fsetEndereco, "Cep", 0, 12, "82px", "22px", 14);
		tfEndereco.buildInput(fsetEndereco, "Endere\u00E7o", 88, 12, "336px",
				"22px", 15);
		tfQuadra.buildInput(fsetEndereco, "Quadra", 430, 12, "46px", "22px", 16);
		tfLote.buildInput(fsetEndereco, "Lote", 482, 12, "46px", "22px", 17);
		tfNumero.buildInput(fsetEndereco, "Nº", 534, 12, "46px", "22px", 18);
		tfComplemento.buildInput(fsetEndereco, "Complemento", 0, 56, "160px",
				"22px", 19);
		tfBairro.buildInput(fsetEndereco, "Bairro", 166, 56, "142px", "22px",
				20);
		tfCidade.buildInput(fsetEndereco, "Cidade", 314, 56, "150px", "22px",
				21);
		cbUF.buildInput(fsetEndereco, "UF", 470, 56, "46px", "22px",
				EstadosBrType.class, 22);
		tfPais.buildInput(fsetEndereco, "País", 522, 56, "68px", "22px", 23);
		tfReferencia.buildInput(fsetEndereco, "Ponto de Refer\u00EAncia", 0,
				99, "308px", "22px", 24);
		cbContato.buildInput(fsetEndereco,
				"Contatos (Telefones, Email, HomePage, Etc...)", 314, 99,
				"279px", "22px", ContatoType.class, 25);
		fsetEndereco.setSize("731px", "155");
		fsetEndereco.setHeading("Endere\u00E7o.");
		fsetEndereco.setCollapsible(false);
		fsetEndereco.setLayout(new AbsoluteLayout());

		tfCep.addListener(Events.Blur, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				DesktopApp.getServiceGenerics().loadCep(
						tfCep.getValueWithoutMask(),
						new AsyncCallback<CepDTO>() {
							@Override
							public void onSuccess(CepDTO result) {
								tfEndereco.setValue(result.getLogradouro());
								tfBairro.setValue(result.getBairro());
								tfCidade.setValue(result.getCidade());
								cbUF.itnComboEnum(EstadosBrType.class,
										result.getUf());
							}

							@Override
							public void onFailure(Throwable caught) {
							}
						});
			}
		});
	}
	private void buildFieldSetGrid() {
		fsetGrid.setLayout(new AbsoluteLayout());
		fsetGrid.setCollapsible(false);
		
		gridEmp.setAutoMin(122);
		gridEmp.setLayout(new AbsoluteLayout());
		gridEmp.setAutoHeight(true);
		gridEmp.setAutoWidth(true);
		
		fsetGrid.setSize("731px", "155px");
		fsetGrid.setHeading("Grid exemplo");
		fsetGrid.add(gridEmp);
		formGeral.add(fsetGrid,new AbsoluteData(6, 527));
	}

	@Override
	public void clear() {
		super.doClear(formGeral.getFields());
		super.doClear(formInfoComp.getFields());
		super.doClear(formInfoGeral.getFields());

		// Geral
		// tfCodigo.clear();
		// dfCadastro.clear();
		// cbConheceu.clear();
		// cbRamo.clear();
		// cbTipoEmpresa.clear();
		// cbEmitirNF.clear();

		// Informa��es Importantes -> Geral
		// tfRazaoSocial.clear();
		// tfFantasia.clear();
		// tfCpfCnpj.clear();
		// tfInscEstad.clear();
		// tfInscEstadST.clear();
		// tfCodigo.clear();

		// Informa��es Importantes -> Informa��es Complementares NFe
		// cbCodRegimeTrib.clear();
		// cbTipoRegime.clear();
		// tfPis.clear();
		// tfConfins.clear();

		// Endere�o
		// tfCep.clear();
		// tfEndereco.clear();
		// tfQuadra.clear();
		// tfLote.clear();
		// tfNumero.clear();
		// tfComplemento.clear();
		// tfBairro.clear();
		// tfCidade.clear();
		// cbUF.clear();
		// tfPais.clear();
		// tfReferencia.clear();
		// cbContato.clear();
		tabItemGeral.layout();
	}

	@Override
	public void fillDTO(EmpresaMirror mirrorTarget) {
		// Geral
		if (tfCodigo.getValue() != null) {
			mirrorTarget.setId(Long.valueOf(tfCodigo.getValue().toString()));
		}
		mirrorTarget.setDataCadastro(dfCadastro.getValue());
		mirrorTarget
				.setComoChegou((ChegouType) cbConheceu.getValue().getItem());
		mirrorTarget.setTipoRamo((RamoType) cbRamo.getValue().getItem());
		mirrorTarget.setTipo((EmpresaType) cbTipoEmpresa.getValue().getItem());
		mirrorTarget.setTipoEmitirNota(((EmitirNfType) cbEmitirNF.getValue()
				.getItem()));

		// Informa��es Importantes -> Geral
		mirrorTarget.setTipoPessoa((PessoaType) cbPessoa.getValue().getItem());
		mirrorTarget.setRazaoSocial(tfRazaoSocial.getValue());
		mirrorTarget.setNomeFantasia(tfFantasia.getValue());
		mirrorTarget.setCnpj(tfCpfCnpj.getValue());
		mirrorTarget.setInscEstadual(tfInscEstad.getValue());
		mirrorTarget.setInscEstadualST(tfInscEstadST.getValue());

		// Informa��es Importantes -> Informa��es Complementares NFe
		mirrorTarget.setTipoReceita((ReceitaType) cbCodRegimeTrib.getValue()
				.getItem());
		mirrorTarget.setTipoRegime((RegimeType) cbTipoRegime.getValue()
				.getItem());
		mirrorTarget.setAliquotaPis(Double.valueOf(tfPis.getValue()));
		mirrorTarget.setAliquotaCofins(Double.valueOf(tfConfins.getValue()));

		/* Endere�o */
		EnderecoMirror end = new EnderecoMirror();
		if (idEndereco.getValue() != null && !idEndereco.getValue().isEmpty()) {
			end.setId(Long.valueOf(idEndereco.getValue()));
		}
		end.setCep(tfCep.getValue());
		end.setLogradouro(tfEndereco.getValue());
		end.setQuadra(tfQuadra.getValue());
		end.setLote(tfLote.getValue());
		end.setNumero(tfNumero.getValue());
		end.setPais(tfPais.getValue());
		end.setComplemento(tfComplemento.getValue());
		end.setBairro(tfBairro.getValue());
		end.setCidade(tfCidade.getValue());
		if (cbUF.getValue() != null) {
			end.setUf((EstadosBrType) cbUF.getValue().getItem());
		}
		end.setPontoReferencia(tfReferencia.getValue());
		if (end.toString() != null) {
			end.setEmpresa(mirrorTarget);
			mirrorTarget.setListaEndereco(new HashSet<EnderecoMirror>());
			mirrorTarget.getListaEndereco().add(end);
		}
	}

	@Override
	public TabItem getItem() {
		return tabItemGeral;
	}

	@Override
	public void loadFields(EmpresaMirror dto) {
		// List<Field<?>> fields = new ArrayList<Field<?>>();
		// fields.addAll(formGeral.getFields());
		// fields.addAll(formInfoComp.getFields());
		// fields.addAll(formInfoGeral.getFields());

		// DesktopApp.getServiceGenerics().copyFields(fields, dto, this, new
		// AsyncCallback<Void>() {
		// @Override
		// public void onFailure(Throwable caught) {
		//
		// }
		//
		// @Override
		// public void onSuccess(Void result) {
		//
		// }
		// });

		// Geral
		if (dto.getId() == null) {
			textCodigo.setVisible(false);
			tfCodigo.setVisible(false);
			tfCodigo.clear();
		} else {
			textCodigo.setVisible(true);
			tfCodigo.setVisible(true);
			tfCodigo.setValue(dto.getId().toString());
		}
		tfCodigo.setReadOnly(true);
		dfCadastro.setValue(dto.getDataCadastro());

		if (dto.getComoChegou() != null)
			cbConheceu.setValue(new Combo(dto.getComoChegou().getNome(), dto
					.getComoChegou()));
		else
			cbConheceu.clear();

		if (dto.getTipoPessoa() != null)
			cbPessoa.setValue(new Combo(dto.getTipoPessoa().getNome(), dto
					.getTipoPessoa()));
		else
			cbPessoa.clear();

		if (dto.getTipoRamo() != null)
			cbRamo.setValue(new Combo(dto.getTipoRamo().getNome(), dto
					.getTipoRamo()));
		else
			cbRamo.clear();

		if (dto.getTipo() != null)
			cbTipoEmpresa.setValue(new Combo(dto.getTipo().getNome(), dto
					.getTipo()));
		else
			cbTipoEmpresa.clear();

		if (dto.getTipoEmitirNota() != null)
			cbEmitirNF.setValue(new Combo(dto.getTipoEmitirNota().getNome(),
					dto.getTipoEmitirNota()));
		else
			cbEmitirNF.clear();

		// Informa��es Importantes -> Geral
		tfRazaoSocial.setValue(dto.getRazaoSocial());
		tfFantasia.setValue(dto.getNomeFantasia());
		tfCpfCnpj.setValue(dto.getCnpj());
		tfInscEstad.setValue(dto.getInscEstadual());
		tfInscEstadST.setValue(dto.getInscEstadualST());

		// Informa��es Importantes -> Informa��es Complementares NFe
		if (dto.getTipoReceita() != null)
			cbCodRegimeTrib.setValue(new Combo(dto.getTipoReceita().getNome(),
					dto.getTipoReceita()));
		else
			cbCodRegimeTrib.clear();

		if (dto.getTipoRegime() != null)
			cbTipoRegime.setValue(new Combo(dto.getTipoRegime().getNome(), dto
					.getTipoRegime()));
		else
			cbTipoRegime.clear();

		tfPis.setValue(dto.getAliquotaPis() == null ? "" : dto.getAliquotaPis()
				.toString());
		tfConfins.setValue(dto.getAliquotaCofins() == null ? "" : dto
				.getAliquotaCofins().toString());

		/* Endere�o */
		if (dto.getListaEndereco() != null && !dto.getListaEndereco().isEmpty()) {
			EnderecoMirror end = (new ArrayList<EnderecoMirror>(
					dto.getListaEndereco())).get(0);
			idEndereco.setValue(String.valueOf(end.getId()));
			tfCep.setValue(end.getCep());
			tfEndereco.setValue(end.getLogradouro());
			tfQuadra.setValue(end.getQuadra());
			tfLote.setValue(end.getLote());
			tfNumero.setValue(end.getNumero());
			tfComplemento.setValue(end.getComplemento());
			tfBairro.setValue(end.getBairro());
			tfCidade.setValue(end.getCidade());

			if (end.getUf() != null)
				cbUF.setValue(new Combo(end.getUf().getNome(), end.getUf()));
			else
				cbUF.clear();

			tfPais.setValue(end.getPais());
			tfReferencia.setValue(end.getPontoReferencia());
		} else {
			tfCep.clear();
			tfEndereco.clear();
			tfQuadra.clear();
			tfLote.clear();
			tfNumero.clear();
			tfComplemento.clear();
			tfBairro.clear();
			tfCidade.clear();
			cbUF.clear();
			tfPais.clear();
			tfReferencia.clear();
			cbContato.clear();
		}
	}
	public void configColumns()
	{
	
		
	}
}