package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotAutoComplete;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.MarcaMirror;
import br.com.automacao.shared.mirror.ModelosMirror;
import br.com.automacao.shared.model.MarcaModel;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;

public class CadModelosGeral extends IForm<ModelosMirror>{
	
	private TabPanel tabPanel = new TabPanel();
	private TabItem tbtmModelo = new TabItem("Modelo");
	private Label lblMarca = new Label("Marca");
	private Label lblNome = new Label("Nome");
	private Label lblQtdDiasDe = new Label("QTD. Dias de Garantia");
	private Label lblTermosDaGarantia = new Label("Termos da Garantia");
	final DotAutoComplete<MarcaModel> cbMarca = new DotAutoComplete<MarcaModel>(MarcaMirror.class, new MarcaModel());
	
	private DotTextField<String> tfNome = new DotTextField<String>();
	private DotTextField<String> tfQtddiasdegarantia = new DotTextField<String>();
	private TextArea taTermosdaGarantia = new TextArea();
	

	public CadModelosGeral(){
		super(null);
	}

	public CadModelosGeral(DotFormulario formulario) {
		super(formulario);

		tbtmModelo.setLayout(new AbsoluteLayout());
		
		tbtmModelo.add(lblMarca, new AbsoluteData(121, 53));
		tbtmModelo.add(lblNome, new AbsoluteData(6, 6));
		tbtmModelo.add(lblQtdDiasDe, new AbsoluteData(6, 51));
		tbtmModelo.add(lblTermosDaGarantia, new AbsoluteData(6, 93));
		
		//cbMarca.setStore(new ListStore<Combo>());
		tbtmModelo.add(cbMarca.getWidget(),new AbsoluteData(119, 70));
		cbMarca.getWidget().setSize("168px", "22px");
		tbtmModelo.add(tfNome, new AbsoluteData(6, 25));
		tfNome.setSize("281px", "22px");
		tfNome.setFieldLabel("");
		
		tbtmModelo.add(tfQtddiasdegarantia, new AbsoluteData(6, 70));
		tfQtddiasdegarantia.setSize("107px", "22px");
		tfQtddiasdegarantia.setFieldLabel("");
		
		taTermosdaGarantia.setSize("281px", "60px");
		tabPanel.add(tbtmModelo);
		tabPanel.setSize("303px", "309px");
		tbtmModelo.add(taTermosdaGarantia, new AbsoluteData(8, 112));
		
	}

	@Override
	public void clear() {
		tfNome.clear();
		tfQtddiasdegarantia.clear();
		taTermosdaGarantia.clear();
	}
	
	@Override
	public void fillDTO(ModelosMirror mirrorTarget) {
		mirrorTarget.setNome(tfNome.getValue());
		mirrorTarget.setQtddiasdegarantia(tfQtddiasdegarantia.getValue());
		mirrorTarget.setTermosdagarantia(taTermosdaGarantia.getValue());
		mirrorTarget.setMarca(cbMarca.getValue().toString());
	}
	 
	@Override
	public TabItem getItem() {
		return tbtmModelo;
	}

	
	@Override
	public void loadFields(ModelosMirror m) {
			
		tfNome.setValue(m.getNome());
		tfQtddiasdegarantia.setValue(m.getQtddiasdegarantia());
		taTermosdaGarantia.setValue(m.getTermosdagarantia());
		/* Documentos Pessoais */
		if (m.getMarca() != null) {
		 //cbMarca.getValue().(new Combo(m.getMarca(), m.getMarca()));
		}
	
	}
}