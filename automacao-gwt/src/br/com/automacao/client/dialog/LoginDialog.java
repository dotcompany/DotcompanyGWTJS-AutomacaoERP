package br.com.automacao.client.dialog;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.client.widget.formularios.LoginCadastroWindow;
import br.com.automacao.shared.mirror.UsuarioMirror;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class LoginDialog extends Dialog {

	private UsuarioMirror usuarioDTO;
	private TextField<String> login = new TextField<String>();
	private TextField<String> password = new TextField<String>();
	private Button submit = new Button("Logar");
	private Button cancel = new Button("Cancelar");
	private Button btRegistrar = new Button("Registrar");

	public LoginDialog() {

	}

	@Override
	public void show() {
		init();
		super.show();
	}

	private void init() {
		FormLayout layout = new FormLayout();
		layout.setLabelWidth(90);
		layout.setDefaultWidth(155);
		setLayout(layout);
		getElement().getStyle().setProperty("position", "relative");
		setButtonAlign(HorizontalAlignment.LEFT);
		setButtons("");
		setHeading("DotCompany");
		setModal(true);
		setBodyBorder(true);
		setBodyStyle("padding: 8px;background: none");
		setWidth(300);
		setHeight(150);
		setResizable(false);

		initLogin();
		initPassword();
		initButton();
	}

	private void initButton() {
		submit.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				usuarioDTO = new UsuarioMirror();
				usuarioDTO.setUsername(login.getValue());
				usuarioDTO.setSenha(password.getValue());
				
//				DesktopApp.getService().putInSession(DesktopApp.USUARIO, usuarioDTO, new AsyncCallback<Void>() {
//					@Override
//					public void onFailure(Throwable caught) {System.out.println("Falha");}
//					@Override
//					public void onSuccess(Void result) {System.out.println("Usuário na sessão.");}
//				});
				
				DesktopApp desktop = new DesktopApp();
				desktop.initizalize();
				closeDialog();
//				Dotcompany_gwt.getService().execute(new LoginLoadClient(loginDTO),
//					new AsyncCallback<LoginLoadResponse>() {
//						@Override
//						public void onFailure(Throwable caught) {
//							MsgDialog.message("ERRO: "
//									+ caught.getMessage());
//						}
//
//						@Override
//						public void onSuccess(LoginLoadResponse result) {
//							if (result.getLogin() == null) {
//								MsgDialog.error("Usuario inexistente.");
//							} else {
//								closeDialog();
//								MsgDialog.message("Bem-vindo "
//										+ result.getLogin().getLogin());
//								Dotcompany_gwt desktop = new Dotcompany_gwt();
//								desktop.initizalize();
//							}
//						}
//				});
			}
		});

		addButton(submit);

		cancel.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				System.out.println("aki");
			}
		});

		addButton(cancel);

		btRegistrar.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				closeDialog();
				// FormLoginCadastro f = new FormLoginCadastro();
				// f.show();
				LoginCadastroWindow w = new LoginCadastroWindow("Login");
				w.show();
			}
		});

		addButton(btRegistrar);
	}

	private void closeDialog() {
		hide();
	}

	// private void initLogon(){/*-{
	// function onLoad() {
	// var content = document.getElementById('content');
	// // Create the HTML for out text area
	// content.innerHTML = '<div><i>(Scroll down)</i> ' +
	// 'You can click the buttons on the onscreen ' +
	// 'keyboard to type Russian. You can also type Russian '+
	// 'with your keyboard. When you need to type English, ' +
	// 'please click the [-] button to minimize the keyboard.' +
	// '</div><textarea id="t1" cols="100" rows="5"></textarea>';
	//	
	// var kbd = new google.elements.keyboard.Keyboard(
	// [google.elements.keyboard.LayoutCode.RUSSIAN],
	// ['t1']);
	// }
	// }-*/
	// }

	private void initLogin() {
		login.setAllowBlank(false);
		login.setFieldLabel("Login");
		add(login);
		setFocusWidget(login);
	}

	private void initPassword() {
		password.setAllowBlank(false);
		password.setPassword(true);
		password.setFieldLabel("Senha");
		add(password);
	}

	@Override
	protected void createButtons() {
		//		
		// submit.addSelectionListener(new SelectionListener<ButtonEvent>() {
		// @Override
		// public void componentSelected(ButtonEvent ce) {
		//				
		// }
		// });
		// addButton(submit);
	}

}