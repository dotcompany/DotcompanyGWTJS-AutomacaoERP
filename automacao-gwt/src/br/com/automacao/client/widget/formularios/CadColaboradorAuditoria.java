package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.ColaboradorMirror;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadColaboradorAuditoria extends IForm<ColaboradorMirror>{
	
	private TabItem tabItemAuditorio = new TabItem("Auditoria do cadastro");
	private FormPanel formAuditoria = new FormPanel();
	
	protected CadColaboradorAuditoria(){
		super(null);
	}
	
	public CadColaboradorAuditoria(DotFormulario formulario) {
		super(formulario);
		
		tabItemAuditorio.setLayout(new FitLayout());
		formAuditoria.setHeaderVisible(false);
		formAuditoria.setFrame(true);
		formAuditoria.setHeading("New FormPanel");
		formAuditoria.setCollapsible(true);
		tabItemAuditorio.add(formAuditoria);
	}

	public FormPanel getFormAuditoria() {
		return formAuditoria;
	}
	public void setFormAuditoria(FormPanel formAuditoria) {
		this.formAuditoria = formAuditoria;
	}
	public TabItem getTabItemAuditorio() {
		return tabItemAuditorio;
	}
	public void setTabItemAuditorio(TabItem tabItemAuditorio) {
		this.tabItemAuditorio = tabItemAuditorio;
	}

	@Override
	public void clear() {
		super.doClear(formAuditoria.getFields());
	}

	@Override
	public void fillDTO(ColaboradorMirror dto) {
		
	}

	@Override
	public TabItem getItem() {
		return getTabItemAuditorio();
	}

	@Override
	public void loadFields(ColaboradorMirror dto) {
		
	}
}