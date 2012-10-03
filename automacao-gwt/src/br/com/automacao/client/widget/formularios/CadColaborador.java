package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.util.DotConstants;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CadColaborador extends DotFormulario {
	
	private ColaboradorMirror colaborador;

	public CadColaborador(DotWindow window) {
		super(window, "Cadastro Cliente");
		super.initialize(this, new CadColaboradorGeral(this),
				new CadColaboradorInformacoes(this),
				new CadColaboradorFinanceiro(this),
				new CadColaboradorCurriculo(this),
				new CadColaboradorInfoMedica(this)/*,
				new CadColaboradorDocImg(this),
				new CadColaboradorAuditoria(this)*/
		);
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
		colaborador = new ColaboradorMirror();
		syncNew(colaborador);
	}

	@Override
	public void onSave(ComponentEvent ce) {
		colaborador = new ColaboradorMirror();
		sync(colaborador);
		getServiceColab().saveUpdate(colaborador, new AsyncCallback<Void>() {
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
		this.colaborador = (ColaboradorMirror) mirror;
		getServiceColab().excluir(colaborador, new AsyncCallback<Void>() {
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
		DesktopApp.getServiceColab().buscar((ColaboradorMirror)mirror, new AsyncCallback<ColaboradorMirror>() {
			@Override
			public void onSuccess(ColaboradorMirror result) {
				colaborador = result;
				sync(ActionType.EDIT, colaborador);
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