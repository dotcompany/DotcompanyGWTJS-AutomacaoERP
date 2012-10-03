package br.com.automacao.client.widget.formularios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.client.widget.LeftToRightWidget;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.mirror.EmpresaModuloMirror;
import br.com.automacao.shared.mirror.ModuloMirror;
import br.com.automacao.shared.util.DotConstants;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Hidden;

public class CadEmpresaModulo extends IForm<EmpresaMirror> {
	
	private TabItem 						tabItemModulo = new TabItem("M\u00F3dulos do Sistema");
	private FormPanel 						formModulo = new FormPanel();
	private LeftToRightWidget<ModuloMirror> l2r = new LeftToRightWidget<ModuloMirror>("Desvinculados", "Vinculados");
	private Set<ModuloMirror>				modulosLeft = new HashSet<ModuloMirror>();
	private Set<ModuloMirror>				modulosRight = new HashSet<ModuloMirror>();
	private Hidden							idEmpresa = new Hidden();

	public CadEmpresaModulo(){
		super(null);
	}
	
	public CadEmpresaModulo(DotFormulario formulario){
		super(formulario);
		
		tabItemModulo.setLayout(new FitLayout());
		initializeDesign();
		load();
	}

	private void load() {
		modulosRight.clear();
		modulosLeft.clear();
		l2r.clearLeftColumns();
		l2r.clearRightColumns();
		if(idEmpresa != null && !idEmpresa.getValue().isEmpty())
			loadByEmpresa();
		else{
			loadAll();
		}
	}

	private void loadByEmpresa() {
		DesktopApp.getServiceModulo().buscarPorEmpresa(Integer.valueOf(idEmpresa.getValue()), new AsyncCallback<List<ModuloMirror>>() {
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(List<ModuloMirror> result) {
				for(ModuloMirror mm : result){
					modulosRight.add(mm);
					l2r.addRight(mm.getNome(), mm);
				}
				loadAll();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	private void loadAll() {
		DesktopApp.getServiceGenerics().listar(ModuloMirror.class.getName(), new AsyncCallback<List>() {
			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();	
			}
			@Override
			public void onSuccess(List result) {
				for(int i = 0; i < result.size(); i++){
					ModuloMirror mm = (ModuloMirror) result.get(i);
					if(!(l2r.rightExists(mm.getNome()) >= 0)){
						modulosLeft.add(mm);
						l2r.addLeft(mm.getNome(), mm);
					}
				}
			}
		});
	}

	private void initializeDesign() {
		formModulo = new FormPanel();
		formModulo.setFrame(true);
		formModulo.setHeaderVisible(true);
		formModulo.setSize(800, 650);
		
		formModulo.add(l2r);
		
		formModulo.setWidth(700);
		
		tabItemModulo.add(formModulo);
	}
	
	@Override
	public void clear() {
		load();
	}

	@Override
	public void fillDTO(EmpresaMirror dto) {
		List<ModuloMirror> lista = l2r.getSelectedRightValues();
		List<EmpresaModuloMirror> listaEM = new ArrayList<EmpresaModuloMirror>();
		EmpresaModuloMirror emm = null;
		for(ModuloMirror mm : lista){
			if(mm.getListaModulo() != null)
				emm = new EmpresaModuloMirror(mm.getListaModulo().iterator().next().getId(), dto, mm);
			else
				emm = new EmpresaModuloMirror(dto, mm);
			listaEM.add(emm);
		}
		dto.setListaModulo(listaEM);
		
		excludeModulos(dto);
	}

	private void excludeModulos(EmpresaMirror dto) {
		List<ModuloMirror> lExcludes = l2r.getSelectedLeftValues();
		List<EmpresaModuloMirror> lEMExcludes = new ArrayList<EmpresaModuloMirror>();
		for(ModuloMirror mm : lExcludes){
			if(mm.getListaModulo() != null && mm.getListaModulo().size() > 0){
				EmpresaModuloMirror emm = new EmpresaModuloMirror(mm.getListaModulo().iterator().next().getId(), dto, mm);
				lEMExcludes.add(emm);
			}
		}
		DesktopApp.getServiceModulo().excluir(lEMExcludes, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				MsgDialog.error(DotConstants.MSG_ERRO);
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Void result) {
				load();
			}
		});
	}

	@Override
	public TabItem getItem() {
		return tabItemModulo;
	}

	@Override
	public void loadFields(EmpresaMirror dto) {
		if(dto != null && dto.getId() != null){
			idEmpresa.setValue(dto.getId().toString());
		}else 
			idEmpresa.setValue("");
		load();
	}
}