package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.util.Combo;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadEmpresaDetalhe extends IForm<EmpresaMirror> {
	
	private TabItem 					tabItemDetalhe = new TabItem("Detalhamento do Cadastro.");
	private FormPanel 					formDetalhe = new FormPanel();
	
	private DotTextField<Double> 		tfSalFixo = new DotTextField<Double>();
	private DotTextField<Double> 		tfComissao = new DotTextField<Double>();
	private ComboBox<Combo> 			cbTipoSal = new ComboBox<Combo>();
	private ComboBox<Combo> 			cbTipoComissao = new ComboBox<Combo>();
	private ComboBox<Combo> 			cbPagComissao = new ComboBox<Combo>();
	private ComboBox<Combo> 			cbNumConta = new ComboBox<Combo>();
	private ComboBox<Combo> 			cbPlanoContas = new ComboBox<Combo>();
	private ComboBox<Combo> 			cbLancadaComissao = new ComboBox<Combo>();

	public CadEmpresaDetalhe(){
		super(null);
	}
	
	
	public CadEmpresaDetalhe(DotFormulario formulario){
		super(formulario);
		
		tabItemDetalhe.setLayout(new FitLayout());
		
		formDetalhe.setHeaderVisible(false);
		formDetalhe.setFrame(true);
		formDetalhe.setHeading("New FormPanel");
		formDetalhe.setCollapsible(true);
		formDetalhe.setLayout(new AbsoluteLayout());
		
		tfSalFixo.setFieldLabel("New TextField");
		formDetalhe.add(tfSalFixo, new AbsoluteData(6, 22));
		tfSalFixo.setSize("116px", "22px");
		tfSalFixo.onlyNumber();
		
		Text txtSalrioFixo = new Text("Sal\u00E1rio fixo");
		AbsoluteData ad_txtSalrioFixo = new AbsoluteData(6, 6);
		ad_txtSalrioFixo.setAnchorSpec("-655");
		formDetalhe.add(txtSalrioFixo, ad_txtSalrioFixo);
		txtSalrioFixo.setHeight("13px");
		
		cbTipoSal.setFieldLabel("New SimpleComboBox");
		formDetalhe.add(cbTipoSal, new AbsoluteData(128, 22));
		cbTipoSal.setSize("150px", "22px");
		
		Text text_7 = new Text("Tipo de Sal\u00E1rio");
		formDetalhe.add(text_7, new AbsoluteData(128, 6));
		text_7.setSize("129px", "13px");
		
		cbTipoComissao.setFieldLabel("New SimpleComboBox");
		formDetalhe.add(cbTipoComissao, new AbsoluteData(284, 22));
		cbTipoComissao.setSize("150px", "22px");
		
		Text text_8 = new Text("Tipo de Comiss\u00E3o");
		formDetalhe.add(text_8, new AbsoluteData(284, 6));
		text_8.setSize("129px", "13px");
		
		tfComissao.setFieldLabel("New TextField");
		formDetalhe.add(tfComissao, new AbsoluteData(440, 22));
		tfComissao.setSize("57px", "22px");
		tfComissao.onlyNumber();
		
		Text text_9 = new Text("Comiss\u00E3o");
		formDetalhe.add(text_9, new AbsoluteData(440, 6));
		text_9.setSize("46px", "13px");
		
		formDetalhe.add(cbPagComissao, new AbsoluteData(6, 71));
		cbPagComissao.setSize("428px", "22px");
		cbPagComissao.setFieldLabel("New SimpleComboBox");
		
		cbNumConta.setFieldLabel("New SimpleComboBox");
		formDetalhe.add(cbNumConta, new AbsoluteData(6, 128));
		cbNumConta.setSize("276px", "22px");
		
		cbPlanoContas.setFieldLabel("New SimpleComboBox");
		formDetalhe.add(cbPlanoContas, new AbsoluteData(6, 192));
		cbPlanoContas.setSize("276px", "22px");
		
		cbLancadaComissao.setFieldLabel("New SimpleComboBox");
		formDetalhe.add(cbLancadaComissao, new AbsoluteData(440, 71));
		cbLancadaComissao.setSize("276px", "22px");
		
		Text txtOndeSerLanado = new Text("Onde ser\u00E1 lan\u00E7ado a comiss\u00E3o?");
		formDetalhe.add(txtOndeSerLanado, new AbsoluteData(440, 54));
		txtOndeSerLanado.setSize("276px", "13px");
		
		Text txtPagamentoDeComisso = new Text("Pagamento de comiss\u00E3o ser\u00E1 apartir de...");
		formDetalhe.add(txtPagamentoDeComisso, new AbsoluteData(6, 54));
		txtPagamentoDeComisso.setSize("428px", "13px");
		
		Text txtCretitarNaConta = new Text("Cretitar na Conta N\u00BA");
		formDetalhe.add(txtCretitarNaConta, new AbsoluteData(6, 109));
		txtCretitarNaConta.setSize("428px", "13px");
		
		Text txtPlanoDeContas = new Text("Plano de Contas (associado)");
		formDetalhe.add(txtPlanoDeContas, new AbsoluteData(6, 173));
		txtPlanoDeContas.setSize("428px", "13px");
		tabItemDetalhe.add(formDetalhe);
	}

	@Override
	public void clear() {
		super.doClear(formDetalhe.getFields());
	}

	@Override
	public void fillDTO(EmpresaMirror dto) {
		
	}

	@Override
	public TabItem getItem() {
		return tabItemDetalhe;
	}

	@Override
	public void loadFields(EmpresaMirror dto) {
		
	}
}