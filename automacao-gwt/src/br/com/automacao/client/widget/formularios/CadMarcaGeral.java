package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.MarcaMirror;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;

public class CadMarcaGeral extends IForm<MarcaMirror>{
	

	private TabPanel 				tabPanel = new TabPanel();
	private TabItem 				tabItemGeral = new TabItem("Marca");
	private Label 					lblNome = new Label("Nome:");
	private Label 					lblDescrio = new Label("Descri\u00E7\u00E3o:");
	private DotTextField<String>	tfNome = new DotTextField<String>();
	private TextArea 				taDescricao = new TextArea();
	
	public CadMarcaGeral(){
		super(null);
	}
	

	public CadMarcaGeral(DotFormulario formulario) {
		super(formulario);

		
		tabPanel.setSize("343px", "268px");

		tabItemGeral.setSize("343px", "268px");
		tabItemGeral.setLayout(new AbsoluteLayout());

		tabItemGeral.add(lblNome, new AbsoluteData(6, 10));
		
		tabItemGeral.add(lblDescrio, new AbsoluteData(6, 55));
		tabItemGeral.add(tfNome, new AbsoluteData(6, 30));
		tfNome.setSize("329px", "22px");
				
		tabItemGeral.add(taDescricao, new AbsoluteData(6, 79));
		taDescricao.setSize("329px", "106px");

	}

	@Override
	public void clear() {
		tfNome.clear();
		taDescricao.clear();
	}
	
	@Override
	public void fillDTO(MarcaMirror mirrorTarget) {
		
		mirrorTarget.setDescricao(taDescricao.getValue());
		mirrorTarget.setNome(tfNome.getValue());
	}
	
	@Override
	public TabItem getItem() {
		return tabItemGeral;
	}

	
	
	@Override
	public void loadFields(MarcaMirror mm) {
	
		tfNome.setValue(mm.getNome());
		taDescricao.setValue(mm.getDescricao());
		
	}
}
