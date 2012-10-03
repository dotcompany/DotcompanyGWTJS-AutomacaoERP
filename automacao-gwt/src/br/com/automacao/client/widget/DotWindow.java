package br.com.automacao.client.widget;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.service.ClienteServiceAsync;
import br.com.automacao.client.service.ColaboradorServiceAsync;
import br.com.automacao.client.service.GenericsServiceAsync;
import br.com.automacao.client.service.GridServiceAsync;
import br.com.automacao.shared.mirror.UsuarioMirror;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Window;

public abstract class DotWindow extends Window {
	
	private boolean isMaximizable = false;
	
	@SuppressWarnings("unused")
	private UsuarioMirror objSessao;
	
	public DotWindow(String header) {
		initHeader(header);
		this.getHeader().addListener(Events.OnDoubleClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				isMaximizable = !isMaximizable;
				if (isMaximizable){
					maximize();
				} else
					restore();
			}
		});
	}
	
	private void initHeader(String header) {
		this.setHeaderVisible(true);
		this.setHeading(header);
	}
	
	@Override
	protected void initState() {
		super.initState();
		setHeight(660);
		setScrollMode(Scroll.AUTO);
		setMaximizable(true);
		setClosable(true);
		setMinimizable(true);
		setDraggable(true);
	}

	@Override
	protected void afterShow() {
		super.afterShow();
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
	}
	
	
	
	public UsuarioMirror getUsuarioLogado() {
//		getService().getSession(DesktopApp.USUARIO, new AsyncCallback<UsuarioMirror>() {
//			@Override
//			public void onSuccess(UsuarioMirror result) {
//				objSessao = result;
//			}
//			@Override
//			public void onFailure(Throwable caught) {
//				
//			}
//		});
//		return (UsuarioMirror) objSessao;
		return null;
	}
	
	public abstract void cancel();

	protected static GridServiceAsync getServiceGrid() {
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
	
}