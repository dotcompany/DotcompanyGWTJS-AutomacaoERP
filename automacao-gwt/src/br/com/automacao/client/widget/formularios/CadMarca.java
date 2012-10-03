package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.MarcaMirror;
import br.com.automacao.shared.util.DotConstants;
import br.com.automacao.shared.util.Mirror;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class CadMarca extends DotFormulario{
	
	private MarcaMirror marca;

	public CadMarca(DotWindow window) {
		super(window, "Cadastro de Marca");
		super.initialize(this, new CadMarcaGeral(this)/*,
				new CadColaboradorUsuario(this),
				new CadColaboradorContrato(this),
				new CadColaboradorInformacoes(this),
				new CadColaboradorFinanceiro(this),
				new CadColaboradorCurriculo(this),
				new CadColaboradorInfoMedica(this),
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
		marca = new MarcaMirror();
		syncNew(marca);
	}

	
	@Override
	public void onSave(ComponentEvent ce) {
		marca = new MarcaMirror();
		sync(marca);
		getServiceMarca().saveUpdate(marca, new AsyncCallback<Void>() {
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
	
	
	@Override
	public void remove(Mirror mirror, ButtonEvent ce, final Loader loader) {
		this.marca = (MarcaMirror) mirror;
		getServiceMarca().excluir(marca, new AsyncCallback<Void>() {
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
		DesktopApp.getServiceMarca().buscar((MarcaMirror)mirror, new AsyncCallback<MarcaMirror>() {
			@Override
			public void onSuccess(MarcaMirror result) {
				marca = result;
				sync(ActionType.EDIT, marca);
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
