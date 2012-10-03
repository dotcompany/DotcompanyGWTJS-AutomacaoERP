package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.type.SangueType;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ComboBoxUtils;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadColaboradorInfoMedica extends IForm<ColaboradorMirror> {
	
	private TabItem tabItemInfoMedica = new TabItem("Informa\u00E7\u00F5es M\u00E9dicas");
	private FormPanel formInfoMedica = new FormPanel();
	private ComboBoxUtils<Combo> cbSangueType = new ComboBoxUtils<Combo>();
	private TextArea taInfoRelevante = new TextArea();
	
	public CadColaboradorInfoMedica(){
		super(null);
	}
	
	public CadColaboradorInfoMedica(DotFormulario formulario) {
		super(formulario);
		
		tabItemInfoMedica.setLayout(new FitLayout());

		formInfoMedica.setHeaderVisible(false);
		formInfoMedica.setFrame(true);
		formInfoMedica.setHeading("New FormPanel");
		formInfoMedica.setCollapsible(true);
		formInfoMedica.setLayout(new AbsoluteLayout());

		cbSangueType.buildInput(formInfoMedica, "Tipo de Sangue", 6, 25, "80", "22", SangueType.class, 1);
		cbSangueType.focus();
		
		formInfoMedica.add(taInfoRelevante, new AbsoluteData(6, 76));
		taInfoRelevante.setSize("735px", "405px");

		Text txtInformaesRelevantes = new Text("Informa\u00E7\u00F5es Relevantes");
		formInfoMedica.add(txtInformaesRelevantes, new AbsoluteData(6, 59));
		txtInformaesRelevantes.setSize("208px", "13px");
		txtInformaesRelevantes.setTabIndex(2);
		tabItemInfoMedica.add(formInfoMedica, new AbsoluteData(0, 0));
		formInfoMedica.setSize("759px", "600px");
		tabItemInfoMedica.setHeight("483px");
	}

	@Override
	public void clear() {
		super.doClear(formInfoMedica.getFields());
	}

	@Override
	public void fillDTO(ColaboradorMirror mirrorTarget) {
		if (fieldOk(cbSangueType)) {
			mirrorTarget.setTipoSangue((SangueType) cbSangueType.getValue().getItem());
		}
		mirrorTarget.setMedInfoRelevante(taInfoRelevante.getValue());
	}

	@Override
	public TabItem getItem() {
		return tabItemInfoMedica;
	}

	@Override
	public void loadFields(ColaboradorMirror mirrorTarget) {
		if (mirrorTarget.getTipoSangue() != null) {
			cbSangueType.setValue(new Combo(mirrorTarget.getTipoSangue().getNome(), mirrorTarget.getTipoSangue()));
		}
		taInfoRelevante.setValue(mirrorTarget.getMedInfoRelevante());
	}
}