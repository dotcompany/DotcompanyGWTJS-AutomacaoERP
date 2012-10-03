package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.dialog.LoginDialog;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.UsuarioMirror;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;

public class LoginCadastroWindow extends DotWindow {

	// LoginDTO loginDTO = new LoginDTO();

	@SuppressWarnings("unchecked")
	public LoginCadastroWindow(String header) {
		super(header);
		setSize("530px", "403px");
		setClosable(false);
		setInitialWidth(530);
		setMinWidth(300);
		setMinHeight(400);
		setHeading("Login");
		setLayout(new AbsoluteLayout());

		FieldSet fldstLogin = new FieldSet();
		fldstLogin.setLayout(new AbsoluteLayout());

		final Text tNomeAviso = new Text();
		fldstLogin.add(tNomeAviso, new AbsoluteData(244, 20));
		tNomeAviso.setSize("233px", "24px");

		final Text tLoginAviso = new Text();
		fldstLogin.add(tLoginAviso, new AbsoluteData(244, 77));
		tLoginAviso.setSize("233px", "24px");

		final Text tEmailAviso = new Text();
		fldstLogin.add(tEmailAviso, new AbsoluteData(244, 137));
		tEmailAviso.setText("");
		tEmailAviso.setSize("233px", "24px");

		Text txtNome = new Text("Nome");
		fldstLogin.add(txtNome, new AbsoluteData(0, 0));
		txtNome.setSize("233px", "14px");

		final TextField<String> tfNome = new TextField<String>();
		fldstLogin.add(tfNome, new AbsoluteData(0, 20));

		tfNome.setFieldLabel("Nome");
		tfNome.addListener(Events.OnBlur, new Listener() {
			@Override
			public void handleEvent(BaseEvent be) {
				try {
					final UsuarioMirror loginDTO = new UsuarioMirror();

					String s = (tfNome.getValue() == null ? new String("")
							: tfNome.getValue());

					if (!s.equals("")) {
						loginDTO.setUsername(tfNome.getValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		tfNome.setAllowBlank(false);
		tfNome.setSize("233px", "24px");

		Text txtLogin = new Text("Login");
		fldstLogin.add(txtLogin, new AbsoluteData(0, 57));
		txtLogin.setSize("233px", "14px");
		final TextField<String> tfLogin = new TextField<String>();
		fldstLogin.add(tfLogin, new AbsoluteData(0, 77));

		tfLogin.setFieldLabel("Login");
		tfLogin.addListener(Events.OnBlur, new Listener() {
			@Override
			public void handleEvent(BaseEvent be) {
				try {
					final UsuarioMirror loginDTO = new UsuarioMirror();

					String s = (tfLogin.getValue() == null ? new String("")
							: tfLogin.getValue());

					if (!s.equals("")) {
						loginDTO.setUsername(tfLogin.getValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		tfLogin.setAllowBlank(false);
		tfLogin.setSize("233px", "24px");

		Text txtEmail = new Text("E-mail");
		fldstLogin.add(txtEmail, new AbsoluteData(0, 117));
		txtEmail.setSize("233px", "14px");
		final TextField<String> tfEmail = new TextField<String>();
		fldstLogin.add(tfEmail, new AbsoluteData(0, 137));

		tfEmail.setFieldLabel("E-mail");
		tfEmail.addListener(Events.OnBlur, new Listener() {
			@Override
			public void handleEvent(BaseEvent be) {
				try {
					/*final UsuarioMirror loginDTO = new UsuarioMirror();
					String s = (tfEmail.getValue() == null ? new String("") : tfEmail.getValue());*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		tfEmail.setAllowBlank(false);
		tfEmail.setSize("233px", "24px");

		Text txtSenha = new Text("Senha");
		fldstLogin.add(txtSenha, new AbsoluteData(0, 175));
		txtSenha.setSize("233px", "14px");
		final TextField<String> tfSenha = new TextField<String>();
		fldstLogin.add(tfSenha, new AbsoluteData(0, 195));

		tfSenha.setFieldLabel("Senha");
		tfSenha.setPassword(true);
		tfSenha.setMinLength(6);
		tfSenha.setAllowBlank(false);
		tfSenha.setSize("233px", "24px");

		Text txtFone = new Text("Telefone");
		fldstLogin.add(txtFone, new AbsoluteData(0, 230));
		txtFone.setSize("233px", "14px");
		final TextField<String> tfFone = new TextField<String>();
		fldstLogin.add(tfFone, new AbsoluteData(0, 250));

		tfFone.setFieldLabel("Telefone");
		tfFone.setSize("233px", "24px");

		Button btnLimpar = new Button("Fechar");
		fldstLogin.add(btnLimpar, new AbsoluteData(382, 291));
		btnLimpar.setSize("46px", "22px");

		Button btnSalvar = new Button("Salvar");
		fldstLogin.add(btnSalvar, new AbsoluteData(434, 291));
		btnSalvar.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				try {
					final UsuarioMirror loginDTO = new UsuarioMirror();
					loginDTO.setUsername(tfLogin.getValue());
					loginDTO.setSenha(tfSenha.getValue());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnLimpar.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				hide();
				LoginDialog dialog = new LoginDialog();
				dialog.show();
			}
		});

		add(fldstLogin, new AbsoluteData(6, 6));
		fldstLogin.setSize("503px", "350px");
		fldstLogin.setHeading("Cadastro ...");
	}

	@Override
	public void cancel() {
		
	}
}