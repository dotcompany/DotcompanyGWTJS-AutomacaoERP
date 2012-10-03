package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.ModelosMirror;
import br.com.automacao.shared.util.DotConstants;
import br.com.automacao.shared.util.Mirror;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class CadModelos extends DotFormulario {
	
	private ModelosMirror modelos;

	public CadModelos(DotWindow window) {
		super(window, "Cadastro de Modelos");
		super.initialize(this, new CadModelosGeral(this));
		setSize(830, 700);
		super.addExtensionItem(tabPanel);
		setLayout(new FitLayout());
		tabPanel.setTabScroll(true);
	}

	@Override
	public void onClear(ComponentEvent ce) {
		form.get(idItem).clear();
	}
	
	@Override
	public void onNew(ComponentEvent ce) {
		modelos = new ModelosMirror();
		syncNew(modelos);
	}

	@Override
	public void onSave(ComponentEvent ce) {
		modelos = new ModelosMirror();
		sync(modelos);
		getServiceModelos().saveUpdate(modelos, new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				MsgDialog.message(DotConstants.MSG_SUCESSO);
			}
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}
		});
	}
	
	@Override
	public void onDuplicateSaveItem(ComponentEvent ce) { }
	
	@Override
	public void onNewSaveItem(ComponentEvent ce) { }
	
	@SuppressWarnings("unchecked")
	@Override
	public void remove(Mirror mirror, ButtonEvent ce, final Loader loader) {
		this.modelos = (ModelosMirror) mirror;
		getServiceModelos().excluir(modelos, new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				MsgDialog.message(DotConstants.MSG_SUCESSO);
				loader.load();
			}
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}
		});
	}

	@Override
	public void edit(Mirror mirror) {
		DesktopApp.getServiceModelos().buscar((ModelosMirror)mirror, new AsyncCallback<ModelosMirror>() {
			@Override
			public void onSuccess(ModelosMirror result) {
				modelos = result;
				sync(ActionType.EDIT, modelos);
			}
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}
		});
	}
	
	@Override
	public void onCancel(ComponentEvent ce) {
		syncClear();
		super.onCancel();
	}
}