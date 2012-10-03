package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.ColaboradorMirror;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadColaboradorCurriculo extends IForm<ColaboradorMirror>{

	private TabItem tabItemCurriculo = new TabItem("Curriculo");
	private FormPanel formCurriculo = new FormPanel();
	private FieldSet fsetInfoCurriculo = new FieldSet();
	
	private Button btnAnexar = new Button("Anexar curriculo.");
	
	private TextArea taCvObjetivo = new TextArea();
	private TextArea taCvFormacao = new TextArea();
	private TextArea taCvExProfissinal = new TextArea();
	private TextArea taCvAtividade = new TextArea();
	private TextArea taCvInfo = new TextArea();
	
	public CadColaboradorCurriculo(){
		super(null);
	}

	public CadColaboradorCurriculo(DotFormulario formulario) {
		super(formulario);
		tabItemCurriculo.setLayout(new FitLayout());

		formCurriculo.setFrame(true);
		formCurriculo.setHeaderVisible(false);
		formCurriculo.setCollapsible(true);
		formCurriculo.setLayout(new AbsoluteLayout());
		
		fsetInfoCurriculo.setLayout(new AbsoluteLayout());
		
		fsetInfoCurriculo.add(btnAnexar, new AbsoluteData(0, 0));
		
		Text txtNewText_4 = new Text("OBJETIVO");
		fsetInfoCurriculo.add(txtNewText_4, new AbsoluteData(0, 41));
		
		Text txtFormao = new Text("FORMA\u00C7\u00C3O");
		fsetInfoCurriculo.add(txtFormao, new AbsoluteData(0, 96));
		txtFormao.setSize("49px", "13px");
		
		Text txtExperinciaProfissional = new Text("EXPERI\u00CANCIA PROFISSIONAL");
		AbsoluteData ad_txtExperinciaProfissional = new AbsoluteData(0, 178);
		ad_txtExperinciaProfissional.setAnchorSpec("-275");
		fsetInfoCurriculo.add(txtExperinciaProfissional, ad_txtExperinciaProfissional);
		txtExperinciaProfissional.setHeight("13px");
		
		Text txtQualificaesEAtividades = new Text("QUALIFICA\u00C7\u00D5ES E ATIVIDADES PROFISSIONAIS");
		AbsoluteData ad_txtQualificaesEAtividades = new AbsoluteData(0, 279);
		ad_txtQualificaesEAtividades.setAnchorSpec("-310");
		fsetInfoCurriculo.add(txtQualificaesEAtividades, ad_txtQualificaesEAtividades);
		txtQualificaesEAtividades.setHeight("13px");
		
		Text txtInformaesAdicionais = new Text("INFORMA\u00C7\u00D5ES ADICIONAIS");
		fsetInfoCurriculo.add(txtInformaesAdicionais, new AbsoluteData(0, 374));
		txtInformaesAdicionais.setSize("395px", "13px");
		
		fsetInfoCurriculo.add(taCvObjetivo, new AbsoluteData(0, 56));
		taCvObjetivo.setSize("650px", "29px");
		taCvObjetivo.focus();

		fsetInfoCurriculo.add(taCvFormacao, new AbsoluteData(0, 111));
		taCvFormacao.setSize("650px", "54px");
		
		fsetInfoCurriculo.add(taCvExProfissinal, new AbsoluteData(0, 194));
		taCvExProfissinal.setSize("650px", "71px");
		
		fsetInfoCurriculo.add(taCvAtividade, new AbsoluteData(0, 295));
		taCvAtividade.setSize("650px", "67px");
		
		fsetInfoCurriculo.add(taCvInfo, new AbsoluteData(0, 390));
		taCvInfo.setSize("650px", "71px");
		
		formCurriculo.add(fsetInfoCurriculo);
		fsetInfoCurriculo.setHeading("Informa\u00E7\u00F5es Curriculares.");
		fsetInfoCurriculo.setCollapsible(true);
		fsetInfoCurriculo.setSize("750", "520");
		tabItemCurriculo.add(formCurriculo);
	}


	@Override
	public void clear() {
		super.doClear(formCurriculo.getFields());
	}

	@Override
	public void fillDTO(ColaboradorMirror mirrorTarget) {
		mirrorTarget.setCvObjetivo(taCvObjetivo.getValue());
		mirrorTarget.setCvFormacao(taCvFormacao.getValue());
		mirrorTarget.setCvExProfissinal(taCvExProfissinal.getValue());
		mirrorTarget.setCvAtividade(taCvAtividade.getValue());
		mirrorTarget.setCvInfo(taCvInfo.getValue());
	}

	@Override
	public TabItem getItem() {
		return tabItemCurriculo;
	}

	@Override
	public void loadFields(ColaboradorMirror mirrorTarget) {
		taCvObjetivo.setValue(mirrorTarget.getCvObjetivo());
		taCvFormacao.setValue(mirrorTarget.getCvFormacao());
		taCvExProfissinal.setValue(mirrorTarget.getCvExProfissinal());
		taCvAtividade.setValue(mirrorTarget.getCvAtividade());
		taCvInfo.setValue(mirrorTarget.getCvInfo());		
	}
}