package br.com.automacao.client.widget;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.service.EmpresaServiceAsync;
import br.com.automacao.client.service.GridServiceAsync;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.form.FormPanel;

public abstract class DotContentPanel extends FormPanel {
	
	private DotWindow window;
	
	public DotContentPanel(DotWindow window, String header) {
		this.window = window;
	}
	
	@Override
	protected void initState() {
		super.setScrollMode(Scroll.AUTO);
		super.setHeaderVisible(false);
		super.initState();
	}
	
	public void show(){
		window.show();
	}
	
	public void toFront() {
		window.toFront();
	}
	
	protected static GridServiceAsync getGridService() {
		return DesktopApp.getServiceGrid();
	}
	protected static EmpresaServiceAsync getServiceEmp() {
		return DesktopApp.getServiceEmpresa();
	}
	
	protected void onCancel(){
		window.cancel();
	}
}