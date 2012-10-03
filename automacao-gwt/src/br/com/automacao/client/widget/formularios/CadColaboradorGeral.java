package br.com.automacao.client.widget.formularios;

import java.util.ArrayList;
import java.util.HashSet;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.widget.DotDateField;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.dto.CepDTO;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.mirror.EnderecoMirror;
import br.com.automacao.shared.type.EstadosBrType;
import br.com.automacao.shared.type.SexoType;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ComboBoxUtils;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Image;

public class CadColaboradorGeral extends IForm<ColaboradorMirror>{
	
	private TabItem tabItemGeral = new TabItem("Geral");
	private FormPanel formGeral = new FormPanel();
	private FieldSet fsetInfoImportante = new FieldSet();
	private FieldSet fsetDocPessoais = new FieldSet();
	private FieldSet fsetEndereco = new FieldSet();

	/* Informa��es Importante */
	private DotTextField<String> tfCodigo = new DotTextField<String>();
	private DotDateField dfCadastro = new DotDateField("pt");
	private DotTextField<String> tfMatricula = new DotTextField<String>();
	private DotTextField<String> tfNome = new DotTextField<String>();
	private CheckBox chkAtivo = new CheckBox();
	private CheckBox chkAtivarComoUsuario = new CheckBox();
	private Image imgColab = new Image();
	
	/* Documentos Pessoais */
	private ComboBoxUtils<Combo> cbSexo = new ComboBoxUtils<Combo>();
	private DotDateField dfNascimento = new DotDateField("pt");
	private DotTextField<String> tfCpf = new DotTextField<String>("###.###.###-##");
	private DotTextField<String> tfRg = new DotTextField<String>();
	private DotTextField<String> tfRgEmissor = new DotTextField<String>();
	private DotDateField dfEmissao = new DotDateField("pt");
	private DotTextField<String> tfTitulo = new DotTextField<String>("#########/##");
	private DotTextField<String> tfCtps = new DotTextField<String>();
	private DotTextField<String> tfSerie = new DotTextField<String>();
	private DotTextField<String> tfPis = new DotTextField<String>();
	private DotDateField dfEmissaoCt = new DotDateField("pt");
	private DotTextField<String> tfReservista = new DotTextField<String>();
	private DotTextField<String> tfHabilitacao = new DotTextField<String>();
	
	/* Endere�o */
	private Hidden idEndereco = new Hidden();
	private DotTextField<String> tfCep = new DotTextField<String>("#####-###");
	private DotTextField<String> tfEndereco = new DotTextField<String>();
	private DotTextField<String> tfQuadra = new DotTextField<String>();
	private DotTextField<String> tfLote = new DotTextField<String>();
	private DotTextField<String> tfNumero = new DotTextField<String>();
	private DotTextField<String> tfComplemento = new DotTextField<String>();
	private DotTextField<String> tfBairro = new DotTextField<String>();
	private DotTextField<String> tfCidade = new DotTextField<String>();
	private ComboBoxUtils<Combo> cbUf = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfPais = new DotTextField<String>();
	private DotTextField<String> tfReferencia = new DotTextField<String>();
	
	/* Contato */
	private SimpleComboBox<String> cbContato = new SimpleComboBox<String>();
	
	public CadColaboradorGeral(){
		super(null);
	}

	public CadColaboradorGeral(DotFormulario formulario) {
		super(formulario);

		tabItemGeral.setLayout(new FitLayout());
		
		formGeral.setFrame(true);
		formGeral.setHeaderVisible(false);
		formGeral.setHeading("New FormPanel");
		formGeral.setCollapsible(true);
		formGeral.setLayout(new AbsoluteLayout());

		//---------------------------------------------------------------------- Informa��es Importante
		fsetDocPessoais.setLayout(new AbsoluteLayout());
		formGeral.add(fsetDocPessoais, new AbsoluteData(6, 142));
		fsetDocPessoais.setSize("731px", "160px");
		fsetDocPessoais.setHeading("Documentos Pessoais.");
		fsetDocPessoais.setCollapsible(false);
				
		tfCodigo.buildInput(fsetInfoImportante, "C\u00F3digo", 0, 12, "100px", "22px", 1);
		tfCodigo.onlyNumber();

		dfCadastro.buildInput(fsetInfoImportante, "Data Cadastro", 106, 12, "110px", "22px", 2);
		dfCadastro.focus();
		tfMatricula.buildInput(fsetInfoImportante, "Matricula", 223, 12, "119px", "22px", 3);
		tfMatricula.onlyNumber();
		tfNome.buildInput(fsetInfoImportante, "Nome", 0, 56, "395px", "22px", 4);
		
		chkAtivo.setBoxLabel("Ativo");
		chkAtivo.setHideLabel(true);
		chkAtivo.setSize("55px", "22px");
		chkAtivo.setValue(true);
		chkAtivo.setTabIndex(5);
		fsetInfoImportante.add(chkAtivo, new AbsoluteData(0, 82));
		
		chkAtivarComoUsuario.setBoxLabel("Usu\u00E1rio do Sistema");
		chkAtivarComoUsuario.setHideLabel(true);
		chkAtivarComoUsuario.setSize("203px", "20px");
		chkAtivarComoUsuario.setTabIndex(6);
		fsetInfoImportante.add(chkAtivarComoUsuario, new AbsoluteData(61, 82));
		
		fsetInfoImportante.add(imgColab, new AbsoluteData(590, -12));
		imgColab.setSize("119px", "116px");
		
		//---------------------------------------------------------------------- Documentos Pessoais
		fsetInfoImportante.setLayout(new AbsoluteLayout());
		formGeral.add(fsetInfoImportante, new AbsoluteData(6, 6));
		fsetInfoImportante.setSize("731px", "130px");
		fsetInfoImportante.setHeading("Informa\u00E7\u00F5es importante.");
		fsetInfoImportante.setCollapsible(true);		
				
		cbSexo.buildInput(fsetDocPessoais, "Sexo", 0, 12, "82px", "22px", SexoType.class, 6);
		
		dfNascimento.buildInput(fsetDocPessoais, "Data de Nascimento", 131, 12, "110", "22", 7);
		
		tfCpf.buildInput(fsetDocPessoais, "CPF", 0, 56, "122px", "22px", 8);
		tfCpf.onlyNumber();
		tfRg.buildInput(fsetDocPessoais, "RG:", 128, 56, "92px", "22px", 9);
		tfRgEmissor.buildInput(fsetDocPessoais, "RG. Emissor", 226, 56, "80px", "22px", 10);
		
		dfNascimento.buildInput(fsetDocPessoais, "Data de Nascimento", 313, 56, "110", "22", 11);
		
		tfTitulo.buildInput(fsetDocPessoais, "Titulo de Eleitor", 430, 56, "122px", "22px", 12);
		tfCtps.buildInput(fsetDocPessoais, "CTPS", 0, 99, "80px", "22px", 13);
		tfCtps.onlyNumber();
		tfSerie.buildInput(fsetDocPessoais, "S\u00E9rie", 86, 99, "92px", "22px", 14);
		tfSerie.onlyNumber();
		tfPis.buildInput(fsetDocPessoais, "Pis/Pasep", 184, 99, "122px", "22px", 15);
		tfPis.onlyNumber();
		
		dfEmissaoCt.buildInput(fsetDocPessoais, "Data Emiss\u00E3o CT", 313, 99, "110", "22", 16);
		
		tfReservista.buildInput(fsetDocPessoais, "Certificado Reservista", 429, 99, "122px", "22px", 17);
		tfReservista.onlyNumber();
		tfHabilitacao.buildInput(fsetDocPessoais, "Habilita&ccedil;&atilde;o", 557, 99, "122px", "22px", 18);
		
		//---------------------------------------------------------------------- Endere�o
		fsetEndereco.setLayout(new AbsoluteLayout());
		formGeral.add(fsetEndereco, new AbsoluteData(6, 308));
		fsetEndereco.setSize("731px", "155");
		fsetEndereco.setHeading("Endere\u00E7o.");
		fsetEndereco.setCollapsible(true);
		
		tfCep.buildInput(fsetEndereco, "Cep", 0, 13, "82px", "22px", 19);
		tfCep.onlyNumber();
		tfCep.addListener(Events.Blur, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				DesktopApp.getServiceGenerics().loadCep(tfCep.getValueWithoutMask(), new AsyncCallback<CepDTO>() {
					@Override
					public void onSuccess(CepDTO result) {
						tfEndereco.setValue(result.getLogradouro());
						tfBairro.setValue(result.getBairro());
						tfCidade.setValue(result.getCidade());
						cbUf.itnComboEnum(EstadosBrType.class, result.getUf());
					}
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			}
		});		
		tfEndereco.buildInput(fsetEndereco, "Endere\u00E7o", 88, 12, "336px", "22px", 20);
		tfQuadra.buildInput(fsetEndereco, "Qd.", 430, 12, "46px", "22px", 21);
		tfLote.buildInput(fsetEndereco, "Lote", 482, 12, "46px", "22px", 22);	
		tfNumero.buildInput(fsetEndereco, "Numero", 534, 12, "46px", "22px", 23);
		tfComplemento.buildInput(fsetEndereco, "Complemento", 0, 56, "273px", "22px", 24);
		tfBairro.buildInput(fsetEndereco, "Bairro", 282, 56, "142px", "22px", 25);	
		tfCidade.buildInput(fsetEndereco, "Cidade", 430, 56, "150px", "22px", 26);
		cbUf.buildInput(fsetEndereco, "UF", 586, 56, "46px", "22px", EstadosBrType.class, 27);
		tfPais.buildInput(fsetEndereco, "Pa&iacute;s", 640, 56, "68px", "22px", 28);
		tfReferencia.buildInput(fsetEndereco, "Ponto de Refer\u00EAncia", 0, 99, "424px", "22px", 29);
		
		//---------------------------------------------------------------------- Contato
		Text txtContato_2 = new Text("Contato");
		fsetEndereco.add(txtContato_2, new AbsoluteData(430, 84));
		txtContato_2.setSize("181px", "13px");
		fsetEndereco.add(cbContato, new AbsoluteData(430, 99));
		cbContato.setSize("279px", "22px");
		cbContato.setTabIndex(30);
		
		tabItemGeral.add(formGeral);
	}

	@Override
	public void clear() {
		super.doClear(formGeral.getFields());
	}
	
	@Override
	public void fillDTO(ColaboradorMirror mirrorTarget) {
		/* Informa��es Importante */  
		if (fieldOk(tfCodigo)) {
			mirrorTarget.setId(Long.valueOf(tfCodigo.getValue().toString()));
		}
		mirrorTarget.setDataCadastro(dfCadastro.getValue());
		mirrorTarget.setMatricula(tfMatricula.getValue());
		mirrorTarget.setNome(tfNome.getValue());
		mirrorTarget.setAtivo(chkAtivo.getValue());
		mirrorTarget.setUsuarioSistema(chkAtivarComoUsuario.getValue());
		
		/* Documentos Pessoais */
		if (fieldOk(cbSexo)) {
			mirrorTarget.setSexo((SexoType) cbSexo.getValue().getItem());
		}
		mirrorTarget.setDtNasc(dfNascimento.getValue());
		mirrorTarget.setCpf(tfCpf.getValue());
		mirrorTarget.setRg(tfRg.getValue());
		mirrorTarget.setRgEmissor(tfRgEmissor.getValue());
		mirrorTarget.setDtEmissaoRg(dfEmissao.getValue());
		mirrorTarget.setTitEleitoral(tfTitulo.getValue());
		mirrorTarget.setCtps(tfCtps.getValue());
		mirrorTarget.setCtpsSerie(tfSerie.getValue());
		mirrorTarget.setPisPasep(tfPis.getValue());
		mirrorTarget.setDtEmissaoCt(dfEmissaoCt.getValue());
		mirrorTarget.setResevista(tfReservista.getValue());
		mirrorTarget.setCnh(tfHabilitacao.getValue());
		
		/* Endere�o */
		EnderecoMirror end = new EnderecoMirror();
		if (fieldOk(idEndereco)) {
			end.setId(Long.valueOf(idEndereco.getValue()));
		}
		end.setCep(tfCep.getValue());
		end.setLogradouro(tfEndereco.getValue());
		end.setQuadra(tfQuadra.getValue());
		end.setLote(tfLote.getValue());
		end.setNumero(tfNumero.getValue());
		end.setComplemento(tfComplemento.getValue());
		end.setBairro(tfBairro.getValue());
		end.setCidade(tfCidade.getValue());
		if (fieldOk(cbUf)) {
			end.setUf((EstadosBrType)cbUf.getValue().getItem());
		}
		end.setPais(tfPais.getValue());
		end.setPontoReferencia(tfReferencia.getValue());
		if (end.toString() != null) {
			end.setColaborador(mirrorTarget);
			mirrorTarget.setListaEndereco(new HashSet<EnderecoMirror>());
			mirrorTarget.getListaEndereco().add(end);
		}
		
		/* Contato */
		
	}
	
	@Override
	public TabItem getItem() {
		return tabItemGeral;
	}

	
	
	@Override
	public void loadFields(ColaboradorMirror m) {
		/* Informa��es Importante */  
		if(m.getId() == null){
			tfCodigo.setVisible(false);
			tfCodigo.setVisible(false);
			tfCodigo.clear();
		}else{
			tfCodigo.setVisible(true);
			tfCodigo.setVisible(true);
			tfCodigo.setValue(m.getId().toString());
		}
		tfCodigo.setReadOnly(true);
		dfCadastro.setValue(m.getDataCadastro());
		tfMatricula.setValue(m.getMatricula());
		tfNome.setValue(m.getNome());
		chkAtivo.setValue(m.getAtivo());
		chkAtivarComoUsuario.setValue(m.isUsuarioSistema());
		
		/* Documentos Pessoais */
		if (m.getSexo() != null) {
			cbSexo.setValue(new Combo(m.getSexo().getNome(), m.getSexo()));
		}
		dfNascimento.setValue(m.getDtNasc());
		tfCpf.setValue(m.getCpf());
		tfRg.setValue(m.getRg());
		tfRgEmissor.setValue(m.getRgEmissor());
		dfEmissao.setValue(m.getDtEmissaoRg());
		tfTitulo.setValue(m.getTitEleitoral());
		tfCtps.setValue(m.getCtps());
		tfSerie.setValue(m.getCtpsSerie());
		tfPis.setValue(m.getPisPasep());
		dfEmissaoCt.setValue(m.getDtEmissaoCt());
		tfReservista.setValue(m.getResevista());
		tfHabilitacao.setValue(m.getCnh());
		
		/* Endere�o */
		if (m.getListaEndereco() != null && !m.getListaEndereco().isEmpty()) {
			EnderecoMirror end = (new ArrayList<EnderecoMirror>(m.getListaEndereco())).get(0);
			idEndereco.setValue(String.valueOf(end.getId()));
			tfCep.setValue(end.getCep());
			tfEndereco.setValue(end.getLogradouro());
			tfQuadra.setValue(end.getQuadra());
			tfLote.setValue(end.getLote());
			tfNumero.setValue(end.getNumero());
			tfComplemento.setValue(end.getComplemento());
			tfBairro.setValue(end.getBairro());
			tfCidade.setValue(end.getCidade());
			cbUf.setValue(new Combo(end.getUf().getNome(), end.getUf()));
			tfPais.setValue(end.getPais());
			tfReferencia.setValue(end.getPontoReferencia());
		}else {
			tfCep.clear();
			tfEndereco.clear();
			tfQuadra.clear();
			tfLote.clear();
			tfNumero.clear();
			tfComplemento.clear();
			tfBairro.clear();
			tfCidade.clear();
			cbUf.clear();
			tfPais.clear();
			tfReferencia.clear();
			cbContato.clear();
		}
		
		/* Contato */
		
	}
}