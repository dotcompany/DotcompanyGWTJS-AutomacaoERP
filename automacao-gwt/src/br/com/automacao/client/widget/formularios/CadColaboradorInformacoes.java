package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotDateField;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.type.AguaType;
import br.com.automacao.shared.type.ConstrucaoType;
import br.com.automacao.shared.type.EstadoCivilType;
import br.com.automacao.shared.type.MoradiaType;
import br.com.automacao.shared.type.ResideType;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ComboBoxUtils;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadColaboradorInformacoes extends IForm<ColaboradorMirror>{
	
	private TabItem tabItemInfoParticular = new TabItem("Informa\u00E7\u00E3o Particular ");
	private FormPanel formInfoParticular = new FormPanel();
	
	/* Filia��o */
	FieldSet fsetFiliacao = new FieldSet();
	private DotTextField<String> tfMae = new DotTextField<String>();
	private DotTextField<String> tfMaeContato = new DotTextField<String>();
	private DotTextField<String> tfPai = new DotTextField<String>();
	private DotTextField<String> tfContatoPai = new DotTextField<String>();
	
	/* Informa��o do C�njuge */
	private FieldSet fsetConjunge = new FieldSet();
	private ComboBoxUtils<Combo> cbCjgEstCivil = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfCjgNome = new DotTextField<String>();
	private DotTextField<String> tfCjgCpf = new DotTextField<String>("###.###.###-##");
	private DotTextField<String> tfCjgRg = new DotTextField<String>();
	private DotDateField dtCjgNascimento = new DotDateField("pt");
	private DotTextField<String> tfCjgFone = new DotTextField<String>();

	/* Informa��o Sobre Dependent1es */
	FieldSet fsetInfoDependentes = new FieldSet();
	private DotTextField<String> tfTotalFilhos = new DotTextField<String>();
	private DotTextField<String> tfDependentesIRRF = new DotTextField<String>();

	/* Situa��o Habitacional */
	FieldSet fsetHabitacao = new FieldSet();
	private ComboBoxUtils<Combo> cbMoradiaType = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbContrucaoType = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbResideTipo = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbAgua = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfAnimais = new DotTextField<String>();

	public CadColaboradorInformacoes(){
		super(null);
	}
	
	public CadColaboradorInformacoes(DotFormulario formulario) {
		super(formulario);
		
		tabItemInfoParticular.setLayout(new FitLayout());
		
		formInfoParticular.setFrame(true);
		formInfoParticular.setHeaderVisible(false);
		formInfoParticular.setCollapsible(true);
		formInfoParticular.setLayout(new AbsoluteLayout());
		
		fsetFiliacao.setLayout(new AbsoluteLayout());
		fsetFiliacao.setSize("731px", "110px");
		fsetFiliacao.setHeading("Filia\u00E7\u00E3o.");
		fsetFiliacao.setCollapsible(false);

		tfMae.buildInput(fsetFiliacao, "Nome da M\u00E3e", 0, 13, "350", "22", 1);
		tfMae.focus();
		tfPai.buildInput(fsetFiliacao, "Nome do Pai", 0, 56, "350", "22", 3);
		tfMaeContato.buildInput(fsetFiliacao, "Contato", 356, 13, "314", "22", 2);
		tfContatoPai.buildInput(fsetFiliacao, "Contato", 356, 56, "350", "22", 4);
		formInfoParticular.add(fsetFiliacao, new AbsoluteData(0, 0));

		fsetConjunge.setLayout(new AbsoluteLayout());
		formInfoParticular.add(fsetConjunge, new AbsoluteData(0, 112));
		fsetConjunge.setSize("731px", "110px");
		fsetConjunge.setHeading("Informa\u00E7\u00E3o do C\u00F4njuge.");
		fsetConjunge.setCollapsible(true);

		cbCjgEstCivil.buildInput(fsetConjunge, "Estado Civil", 0, 13, "129", "22", EstadoCivilType.class, 5);
		tfCjgNome.buildInput(fsetConjunge, "Nome do C\u00F4njuge", 135, 13, "326", "22", 6);
		tfCjgFone.onlyNumber();
		tfCjgCpf.buildInput(fsetConjunge, "CPF", 467, 13, "129", "22", 7);
		tfCjgRg.buildInput(fsetConjunge, "RG", 602, 13, "112", "22", 8);
		dtCjgNascimento.buildInput(fsetConjunge, "Data Nascimento", 0, 56, "129", "22", 9);
		tfCjgFone.buildInput(fsetConjunge, "Contato", 135, 56, "289", "22", 10);
		tfCjgCpf.onlyNumber();
		
		fsetHabitacao.setLayout(new AbsoluteLayout());
		fsetHabitacao.setSize("731px", "115px");
		fsetHabitacao.setHeading("Situa\u00E7\u00E3o Habitacional");
		fsetHabitacao.setCollapsible(true);

		cbMoradiaType.buildInput(fsetHabitacao, "Tipo de Moradia", 0, 15, "163", "22", MoradiaType.class, 11);
		cbContrucaoType.buildInput(fsetHabitacao, "Tipo de Constru\u00E7\u00E3o", 169, 15, "163", "22", ConstrucaoType.class, 12);
		cbResideTipo.buildInput(fsetHabitacao, "Moradia", 338, 15, "163", "22", ResideType.class, 13);
		cbAgua.buildInput(fsetHabitacao, "\u00C1gua", 507, 15, "163", "22", AguaType.class, 14);
		tfAnimais.buildInput(fsetHabitacao, "Possuem animais de estima\u00E7\u00E3o? Quais?", 0, 61, "332", "22", 15);
		formInfoParticular.add(fsetHabitacao, new AbsoluteData(0, 226));
		
		fsetInfoDependentes.setLayout(new AbsoluteLayout());
		tfTotalFilhos.onlyNumber();
		tfTotalFilhos.buildInput(fsetInfoDependentes, "N\u00BA de Filhos", 0, 15, "61", "22", 16);
		tfDependentesIRRF.buildInput(fsetInfoDependentes, "Dependentes P/ IPRF", 67, 15, "103", "22", 17);

		formInfoParticular.add(fsetInfoDependentes, new AbsoluteData(0, 344));
		fsetInfoDependentes.setSize("731px", "110px");
		fsetInfoDependentes.setHeading("Informa\u00E7\u00E3o Sobre Dependentes.");
		fsetInfoDependentes.setCollapsible(true);
		tabItemInfoParticular.add(formInfoParticular);
	}

	@Override
	public void clear() {
		super.doClear(formInfoParticular.getFields());
		/* Filia��o */
//		tfMae.clear();
//		tfMaeContato.clear();
//		tfPai.clear();
//		tfContatoPai.clear();
		
		/* Informa��o do C�njuge */
//		cbCjgEstCivil.clear();
//		tfCjgNome.clear();
//		tfCjgCpf.clear();
//		tfCjgRg.clear();
//		dtCjgNascimento.clear();
//		tfCjgFone.clear();

		/* Informa��o Sobre Dependent1es */
//		tfTotalFilhos.clear();
//		tfDependentesIRRF.clear();

		/* Situa��o Habitacional */
//		cbMoradiaType.clear();
//		cbContrucaoType.clear();
//		cbResideTipo.clear();
//		cbAgua.clear();
//		tfAnimais.clear();
	}

	@Override
	public void fillDTO(ColaboradorMirror mirrorTarget) {
		/* Filia��o */
		mirrorTarget.setMae(tfMae.getValue());
		mirrorTarget.setFoneMae(tfMaeContato.getValue());
		mirrorTarget.setPai(tfPai.getValue());
		mirrorTarget.setFonePai(tfContatoPai.getValue());
		
		/* Informa��o do C�njuge */
		if (fieldOk(cbCjgEstCivil)) {
			mirrorTarget.setTipoEstCivilConjuge((EstadoCivilType) cbCjgEstCivil.getValue().getItem());
		}
		mirrorTarget.setNomeConjuge(tfCjgNome.getValue());
		mirrorTarget.setCpfConjuge(tfCjgCpf.getValue());
		mirrorTarget.setRgConjuge(tfCjgRg.getValue());
		mirrorTarget.setDtNascConjuge(dtCjgNascimento.getValue());
		mirrorTarget.setFoneConjuge(tfCjgFone.getValue());

		/* Informa��o Sobre Dependent1es */
		if (fieldOk(tfTotalFilhos)) {
			mirrorTarget.setNumFilho(Integer.valueOf(tfTotalFilhos.getValue()));
		}
		if (fieldOk(tfDependentesIRRF)) {
			mirrorTarget.setNumDepIrrf(Integer.valueOf(tfDependentesIRRF.getValue()));
		}
		
		/* Situa��o Habitacional */
		if (fieldOk(cbMoradiaType)) {
			mirrorTarget.setTipoMoradia((MoradiaType) cbMoradiaType.getValue().getItem());
		}
		if (fieldOk(cbContrucaoType)) {
			mirrorTarget.setTipoConstrucao((ConstrucaoType) cbContrucaoType.getValue().getItem());
		}
		if (fieldOk(cbResideTipo)) {
			mirrorTarget.setTipoReside((ResideType) cbResideTipo.getValue().getItem());
		}
		if (fieldOk(cbAgua)) {
			mirrorTarget.setTipoAgua((AguaType) cbAgua.getValue().getItem());
		}
		mirrorTarget.setAnimais(tfAnimais.getValue());
	}

	@Override
	public TabItem getItem() {
		return tabItemInfoParticular;
	}

	@Override
	public void loadFields(ColaboradorMirror m) {
		/* Filia��o */
		tfMae.setValue(m.getMae());
		tfMaeContato.setValue(m.getFoneMae());
		tfPai.setValue(m.getPai());
		tfContatoPai.setValue(m.getFonePai());
		
		/* Informa��o do C�njuge */
		if (m.getTipoEstCivilConjuge() != null) {
			cbCjgEstCivil.setValue(new Combo(m.getTipoEstCivilConjuge().getNome(), m.getTipoEstCivilConjuge()));
		}
		tfCjgNome.setValue(m.getNomeConjuge());
		tfCjgCpf.setValue(m.getCpfConjuge());
		tfCjgRg.setValue(m.getRgConjuge());
		dtCjgNascimento.setValue(m.getDtNascConjuge());
		tfCjgFone.setValue(m.getFoneConjuge());

		/* Informa��o Sobre Dependent1es */
		tfTotalFilhos.setValue(String.valueOf(m.getNumFilho()));
		tfDependentesIRRF.setValue(String.valueOf(m.getNumDepIrrf()));

		/* Situa��o Habitacional */
		if (m.getTipoMoradia() != null) {
			cbMoradiaType.setValue(new Combo(m.getTipoMoradia().getNome(), m.getTipoMoradia()));
		}
		if (m.getTipoConstrucao() != null) {
			cbContrucaoType.setValue(new Combo(m.getTipoConstrucao().getNome(), m.getTipoConstrucao()));
		}
		if (m.getTipoReside() != null) {
			cbResideTipo.setValue(new Combo(m.getTipoReside().getNome(), m.getTipoReside()));
		}
		if (m.getTipoAgua() != null) {
			cbAgua.setValue(new Combo(m.getTipoAgua().getNome(), m.getTipoAgua()));
		}
		tfAnimais.setValue(m.getAnimais());
	}
}