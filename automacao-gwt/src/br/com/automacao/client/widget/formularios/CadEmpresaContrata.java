package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotDateField;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.util.Combo;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadEmpresaContrata extends IForm<EmpresaMirror> {
	
	private TabItem 					tabItemContrata = new TabItem("Dados da Contrata\u00E7\u00E3o (DotCompany)");
	private FormPanel 					formContrata = new FormPanel();
	private FieldSet 					fsetContrata = new FieldSet();
	private DotDateField 				dfAdesao = new DotDateField("pt");
	private DotTextField<String>		tfVlrAdesao = new DotTextField<String>();
	private ComboBox<Combo> 			cbMensalidade = new ComboBox<Combo>();
	private ComboBox<Combo> 			cbVendedor = new ComboBox<Combo>();
	private TextArea 					taObs = new TextArea();
	private ComboBox<Combo> 			cbTipoContrata = new ComboBox<Combo>();
	
	public CadEmpresaContrata(){
		super(null);
	}
	
	public CadEmpresaContrata(DotFormulario formulario){
		super(formulario);
		
		tabItemContrata.setLayout(new FitLayout());
		
//		formContrata.setHeaderVisible(false);
//		formContrata.setFrame(true);
//		formContrata.setHeading("New FormPanel");
//		formContrata.setCollapsible(true);
//		formContrata.setLayout(new AbsoluteLayout());
//		
//		fsetContrata.setLayout(new AbsoluteLayout());
//		
//		fsetContrata.add(dfAdesao, new AbsoluteData(0, 16));
//		dfAdesao.setSize("116px", "22px");
//		
//		Text txtNewText_3 = new Text("Ades\u00E3o do Sistema");
//		fsetContrata.add(txtNewText_3, new AbsoluteData(0, -1));
//		
//		
//		fsetContrata.add(tfVlrAdesao, new AbsoluteData(0, 60));
//		tfVlrAdesao.setSize("116px", "22px");
//		
//		Text txtSalrio = new Text("Valor da Ades\u00E3o.");
//		fsetContrata.add(txtSalrio, new AbsoluteData(0, 44));
//		txtSalrio.setSize("116px", "13px");
//		
//		fsetContrata.add(cbMensalidade, new AbsoluteData(122, 60));
//		
//		Text txtTipoDeSalrio = new Text("Tipo de Mensalidade");
//		AbsoluteData ad_txtTipoDeSalrio = new AbsoluteData(122, 44);
//		ad_txtTipoDeSalrio.setAnchorSpec("-580");
//		fsetContrata.add(txtTipoDeSalrio, ad_txtTipoDeSalrio);
//		txtTipoDeSalrio.setHeight("13px");
//		
//		fsetContrata.add(cbVendedor, new AbsoluteData(278, 60));
//		cbVendedor.setSize("150px", "22px");
//		
//		Text txtTipoDeComisso = new Text("Vendedor");
//		fsetContrata.add(txtTipoDeComisso, new AbsoluteData(278, 44));
//		txtTipoDeComisso.setSize("129px", "13px");
//		
//		Text txtTipoDeContratao = new Text("Tipo de Contrata\u00E7\u00E3o");
//		fsetContrata.add(txtTipoDeContratao, new AbsoluteData(122, 0));
//		txtTipoDeContratao.setSize("129px", "13px");
//		
//		fsetContrata.add(cbTipoContrata, new AbsoluteData(122, 16));
//		cbTipoContrata.setSize("272px", "22px");
//		ComboBoxUtils.createComboBox(cbTipoContrata, ContratacaoType.class);
//		
//		fsetContrata.add(taObs, new AbsoluteData(0, 106));
//		taObs.setSize("709px", "85px");
//		taObs.setFieldLabel("New TextArea");
//		
//		Text txtObs = new Text("OBS.");
//		fsetContrata.add(txtObs, new AbsoluteData(0, 88));
//		txtObs.setSize("46px", "13px");
//		formContrata.add(fsetContrata, new AbsoluteData(6, 6));
//		fsetContrata.setSize("731px", "230px");
//		fsetContrata.setHeading("Informa\u00E7\u00F5es da Contrata\u00E7\u00E3o.");
//		fsetContrata.setCollapsible(true);
//		tabItemContrata.add(formContrata);
	}

	@Override
	public void clear() {
		super.doClear(formContrata.getFields());
//		dfAdesao.clear();
//		tfVlrAdesao.clear();
//		cbMensalidade.clear();
//		cbVendedor.clear();
//		taObs.clear();
//		cbTipoContrata.clear();
	}

	@Override
	public void fillDTO(EmpresaMirror dto) {
		
	}

	@Override
	public TabItem getItem() {
		return tabItemContrata;
	}

	@Override
	public void loadFields(EmpresaMirror dto) {
		
	}
}