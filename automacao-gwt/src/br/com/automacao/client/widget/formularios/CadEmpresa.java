package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.util.DotConstants;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CadEmpresa extends DotFormulario {
	
	private EmpresaMirror empresa;
	
	public CadEmpresa(DotWindow window){
		super(window, "Cadastro Empresa");
		super.initialize(this, new CadEmpresaGeral(this), new CadEmpresaGestor(this), 
				new CadEmpresaModulo(this)/*, new CadEmpresaDetalhe(this)*//*, new CadEmpresaContrata(this),
				new CadEmpresaDocImage(this)*/);
		super.addExtensionItem(tabPanel);
		
		setLayout(new FitLayout());
		
		tabPanel.setTabScroll(true);
	}
	
	@Override
	public void onClear(ComponentEvent ce) {
		form.get(idItem).clear();
	}
	
	@Override
	public void onDuplicateSaveItem(ComponentEvent ce) {
		sync(empresa);
		getServiceEmp().saveUpdate(empresa, new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				MsgDialog.message(DotConstants.MSG_SUCESSO);
				empresa.setId(null);
				sync(ActionType.EDIT, empresa);
			}
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}
		});
	}

	@Override
	public void onNew(ComponentEvent ce) {
		empresa = new EmpresaMirror();
		syncNew(empresa);
	}

	@Override
	public void onNewSaveItem(ComponentEvent ce) {
		empresa = new EmpresaMirror();
		sync(empresa);
		getServiceEmp().saveUpdate(empresa, new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
 				MsgDialog.message(DotConstants.MSG_SUCESSO);
				syncClear();
			}
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}
		});
	}

	@Override
	public void onSave(ComponentEvent ce) {
		empresa = new EmpresaMirror();
		sync(empresa);
		getServiceEmp().saveUpdate(empresa, new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				getServiceEmp().buscarPorCnpjCpf(empresa.getCnpj(), new AsyncCallback<EmpresaMirror>() {
					@Override
					public void onFailure(Throwable caught) {
						MsgDialog.error(DotConstants.MSG_ERRO);
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(EmpresaMirror result) {
						empresa = result;
						sync(ActionType.EDIT, empresa);
					}
				});
				MsgDialog.message(DotConstants.MSG_SUCESSO);
			}
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(Mirror dto, ButtonEvent ce, final Loader loader) {
		this.empresa = (EmpresaMirror) dto;
		getServiceEmp().excluir(empresa, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(Void result) {
				loader.load();
			}
		});
		
	}

	@Override
	public void edit(final Mirror dto) {
		getServiceEmp().buscar((EmpresaMirror) dto, new AsyncCallback<EmpresaMirror>() {
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(EmpresaMirror result) {
				empresa = result;
				sync(ActionType.EDIT, empresa);
			}
		});
	}

	@Override
	public void onCancel(ComponentEvent ce) {
		syncClear();
		super.onCancel();
	}
}