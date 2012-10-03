package br.com.automacao.client.widget;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.service.ClienteServiceAsync;
import br.com.automacao.client.service.ColaboradorServiceAsync;
import br.com.automacao.client.service.EmpresaServiceAsync;
import br.com.automacao.client.service.GenericsServiceAsync;
import br.com.automacao.client.service.GridServiceAsync;
import br.com.automacao.client.service.MarcaServiceAsync;
import br.com.automacao.client.service.ModelosServiceAsync;

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

	protected static ClienteServiceAsync getServiceCliente() {
		return DesktopApp.getServiceCliente();
	}

	protected static GenericsServiceAsync getServiceGenerics() {
		return DesktopApp.getServiceGenerics();
	}

	protected static ColaboradorServiceAsync getServiceColab() {
		return DesktopApp.getServiceColab();
	}

	protected static MarcaServiceAsync getServiceMarca() {
		return DesktopApp.getServiceMarca(); 
	} 
	protected static ModelosServiceAsync getServiceModelos() {
		return DesktopApp.getServiceModelos(); 
	} 
	
	protected static EmpresaServiceAsync getServiceEmp() {
		return DesktopApp.getServiceEmpresa();
	}
	

	protected void onCancel(){
		window.cancel();
	}
}