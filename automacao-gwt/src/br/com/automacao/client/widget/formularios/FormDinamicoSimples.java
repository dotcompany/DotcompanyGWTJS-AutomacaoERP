package br.com.automacao.client.widget.formularios;

import java.util.ArrayList;
import java.util.List;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.dto.TextFieldDTO;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FormDinamicoSimples extends DotFormulario{

	private DotTextField<Object>[] fields ;
	
	private String nameClasse;
	
	private FormPanel form;
	
	private int cont = 0;

	private List<String> listaNome;
	
	public FormDinamicoSimples(DotWindow window, String nameClasse) {
		super(window, "Cadastro");
		super.initialize(this);
		window.setLayout(new FitLayout());
		form = new FormPanel();
		form.setHeaderVisible(false);
		form.setBorders(false);
		addExtensionItem(form);
		this.nameClasse = nameClasse;
		onLoadForm();
	}
	
	protected void onLoadForm() {
		DesktopApp.getServiceGenerics().loadForm(nameClasse, new AsyncCallback<List<TextFieldDTO>>() {
			@Override
			public void onFailure(Throwable caught) {}

			@Override
			public void onSuccess(List<TextFieldDTO> result) {
				getDuplicateSaveItem().disable();
				getNewSaveItem().disable();
				addPanel(result);
			}
		});
	}
	
	private void addPanel(List<TextFieldDTO> lista){
		init(lista);
		form.layout();
	}
	
	@SuppressWarnings("unchecked")
	private void init(List<TextFieldDTO> textFieldsDTO) {
		listaNome = new ArrayList<String>();
		int nomeSize = textFieldsDTO.size();
//		if(nomeSize != labels.length){
//			Lan�ar exception
//		}
			
		fields = new DotTextField[nomeSize];
		buildTextFields(textFieldsDTO);
		
		form.setSize(748, 380);
		setSize(750, 400);
	}

	private void buildTextFields(List<TextFieldDTO> textFieldsDTO) {
		for(TextFieldDTO textFieldDTO : textFieldsDTO){
			listaNome.add(textFieldDTO.getNome());
			fields[cont] = new DotTextField<Object>();
			fields[cont].setFieldLabel(textFieldDTO.getLabel());
			fields[cont].setAllowBlank(false);
			form.add(fields[cont++]);
		}
	}
	
	private void clearTexts() {
		for(TextField<Object> field : fields){
			field.setValue(null);
		}
	}

	@Override
	public void onCancel(ComponentEvent ce) {
		clear();
		super.onCancel();
	}

	@Override
	public void onClear(ComponentEvent ce) {
		clearTexts();
	}

	@Override
	public void onDuplicateSaveItem(ComponentEvent ce) {}

	@Override
	public void onNew(ComponentEvent ce) {
		clear();
	}

	@Override
	public void onNewSaveItem(ComponentEvent ce) {}

	@Override
	public void onSave(ComponentEvent ce) {
		List<Object> lista = new ArrayList<Object>();
		for(TextField<Object> field : fields){
			lista.add(field.getValue());
		}
		DesktopApp.getServiceGenerics().salvarForDinamico(nameClasse, listaNome, lista, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {}

			@Override
			public void onSuccess(Void result) {}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(Mirror dto, ButtonEvent ce, Loader loader) {
		
	}

	@Override
	public void edit(Mirror dto) {
		
		
	}
}