package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.mirror.UsuarioMirror;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadEmpresaGestor extends IForm<EmpresaMirror> {

	private TabItem 						tabItemGeral = new TabItem("Gestor");
	private FormPanel						formGestor = new FormPanel();
	private FieldSet 						fSet = new FieldSet();
	
	private DotTextField<String> 			tfNome = new DotTextField<String>();
	private DotTextField<String> 			tfUsuario = new DotTextField<String>();
	private DotTextField<String> 			tfSenha = new DotTextField<String>();
	private DotTextField<String> 			tfRepetirSenha = new DotTextField<String>();
	private DotTextField<String> 			tfEmail = new DotTextField<String>();
	private DotTextField<String>			tfRepetirEmail = new DotTextField<String>();

	public CadEmpresaGestor(){
		super(null);
	}
	
	public CadEmpresaGestor(DotFormulario formulario){
		super(formulario);
		
		tabItemGeral.setLayout(new FitLayout());
		formGestor.setFrame(true);
		formGestor.setHeaderVisible(false);
		formGestor.setCollapsible(true);
		formGestor.setLayout(new FitLayout());
		
		fSet.setLayout(new AbsoluteLayout());
		
		buildSenha();
		buildEmail();

		Text txtNewText = new Text("Nome:");
		fSet.add(txtNewText, new AbsoluteData(18, 28));
		
		Text txtUsurio = new Text("Usu\u00E1rio:");
		fSet.add(txtUsurio, new AbsoluteData(18, 85));
		
		fSet.add(tfNome, new AbsoluteData(18, 47));
		tfNome.setSize("624px", "22px");
		tfNome.setTabIndex(1);
		tfNome.focus();
		
		fSet.add(tfUsuario, new AbsoluteData(18, 104));
		tfUsuario.setSize("213px", "22px");
		tfUsuario.setTabIndex(2);;
		
		fSet.setSize(845, 200);
		formGestor.add(fSet, new AbsoluteData(6, 3));
		tabItemGeral.add(formGestor);
		formGestor.setWidth("856px");
	}

	private void buildEmail() {
		Text txtEmail = new Text("Email:");
		fSet.add(txtEmail, new AbsoluteData(18, 149));
		
		Text txtRepetirEmail = new Text("Repetir email:");
		fSet.add(txtRepetirEmail, new AbsoluteData(343, 149));
		
		fSet.add(tfEmail, new AbsoluteData(18, 168));
		tfEmail.setSize("308px", "22px");
		tfEmail.setTabIndex(5);
		tfEmail.setAllowBlank(false);
		
		fSet.add(tfRepetirEmail, new AbsoluteData(343, 168));
		tfRepetirEmail.setSize(299, 22);
		tfRepetirEmail.setTabIndex(6);
		tfRepetirEmail.setAllowBlank(false);
		tfRepetirEmail.addListener(Events.Blur, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if(tfEmail != null && !tfEmail.getValue().equals(tfRepetirEmail.getValue())){
					tfEmail.setValue("");
					tfRepetirEmail.setValue("");
					tfRepetirEmail.markInvalid("Senha não confere!");
				}
			}
		});
	}

	private void buildSenha() {
		Text txtSenha = new Text("Senha:");
		fSet.add(txtSenha, new AbsoluteData(253, 85));
		
		Text txtRepetirSenha = new Text("Repetir senha:");
		fSet.add(txtRepetirSenha, new AbsoluteData(470, 85));
		
		tfSenha.setPassword(true);
		tfSenha.setTabIndex(3);
		tfSenha.setAllowBlank(false);
		fSet.add(tfSenha, new AbsoluteData(253, 104));
		tfSenha.setSize("192px", "22px");
		
		tfRepetirSenha.setPassword(true);
		tfRepetirSenha.setTabIndex(4);
		tfRepetirSenha.setAllowBlank(false);
		fSet.add(tfRepetirSenha, new AbsoluteData(470, 104));
		tfRepetirSenha.setSize("172px", "22px");
		
		tfRepetirSenha.addListener(Events.Blur, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if(tfSenha != null && !tfSenha.getValue().equals(tfRepetirSenha.getValue())){
					tfSenha.setValue("");
					tfRepetirSenha.setValue("");
					tfRepetirSenha.markInvalid("Senha não confere!");
				}
			}
		});
	}

	@Override
	public void clear() {
		super.doClear(formGestor.getFields());
	}

	@Override
	public void fillDTO(EmpresaMirror dto) {
		validate(tfNome, tfUsuario);
		UsuarioMirror um = new UsuarioMirror();
		um.setUsername(tfUsuario.getValue());
		um.setSenha(tfSenha.getValue());
	}

	@Override
	public void loadFields(EmpresaMirror dto) {
			clear();	
	}

	@Override
	public TabItem getItem() {
		return tabItemGeral;
	}
}