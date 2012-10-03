package br.com.automacao.client.dialog;
//package br.com.automacao.web.client.dialog;
//
//import br.com.automacao.web.client.widget.DotcompanyWindow;
//import br.com.automacao.web.shared.DotReqFactory;
//import br.com.automacao.web.shared.TesteProxy;
//import br.com.automacao.web.shared.TesteRequest;
//
//import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
//import com.extjs.gxt.ui.client.event.ButtonEvent;
//import com.extjs.gxt.ui.client.event.SelectionListener;
//import com.extjs.gxt.ui.client.widget.button.Button;
//import com.extjs.gxt.ui.client.widget.form.TextField;
//import com.extjs.gxt.ui.client.widget.layout.FormLayout;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.event.shared.EventBus;
//import com.google.gwt.event.shared.SimpleEventBus;
//import com.google.web.bindery.requestfactory.shared.Receiver;
//
//public class TesteDialog extends DotcompanyWindow {
//	
//	private static final EventBus eventBus = new SimpleEventBus();
//	private static final DotReqFactory reqFactory = GWT.create(DotReqFactory.class);
//	private TesteProxy testeProxy;
//	private TesteRequest testeRequest;
//
//	private TextField<String> login = new TextField<String>();
//	private TextField<String> password = new TextField<String>();
//	private Button submit = new Button("Logar");
//	private Button cancel = new Button("Cancelar");
//	private Button btRegistrar = new Button("Registrar");
//
//	public TesteDialog() {
//		reqFactory.initialize(eventBus);
//		init();
//	}
//
//
//	private void init() {
//		FormLayout layout = new FormLayout();
//		layout.setLabelWidth(90);
//		layout.setDefaultWidth(155);
//		setLayout(layout);
//		getElement().getStyle().setProperty("position", "relative");
//		setButtonAlign(HorizontalAlignment.LEFT);
////		setButtons("");
//		setHeading("DotCompany");
//		setModal(true);
//		setBodyBorder(true);
//		setBodyStyle("padding: 8px;background: none");
//		setWidth(300);
//		setHeight(150);
//		setResizable(false);
//
//		initLogin();
//		initPassword();
//		initButton();
//	}
//
//	private void initButton() {
//		submit.addSelectionListener(new SelectionListener<ButtonEvent>() {
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				
//			}
//		});
//
//		addButton(submit);
//
//		cancel.addSelectionListener(new SelectionListener<ButtonEvent>() {
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				System.out.println("aki");
//			}
//		});
//
//		addButton(cancel);
//
//		btRegistrar.addSelectionListener(new SelectionListener<ButtonEvent>() {
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				
//				testeRequest = reqFactory.testeRequest();
//				testeProxy = testeRequest.create(TesteProxy.class);
//				testeProxy.setUsername("sergio");
//				testeProxy.setSenha("123456");
//				
//				testeRequest.getAll().fire(new Receiver<TesteProxy>() {
//					@Override
//					public void onSuccess(TesteProxy response) {
//						System.out.println("sucesso");
//					}
//				});
//				
//				closeDialog();
//				// FormLoginCadastro f = new FormLoginCadastro();
//				// f.show();
////				LoginCadastroWindow w = new LoginCadastroWindow();
////				w.show();
//			}
//		});
//
//		addButton(btRegistrar);
//	}
//
//	private void closeDialog() {
//		hide();
//	}
//
//	// private void initLogon(){/*-{
//	// function onLoad() {
//	// var content = document.getElementById('content');
//	// // Create the HTML for out text area
//	// content.innerHTML = '<div><i>(Scroll down)</i> ' +
//	// 'You can click the buttons on the onscreen ' +
//	// 'keyboard to type Russian. You can also type Russian '+
//	// 'with your keyboard. When you need to type English, ' +
//	// 'please click the [-] button to minimize the keyboard.' +
//	// '</div><textarea id="t1" cols="100" rows="5"></textarea>';
//	//	
//	// var kbd = new google.elements.keyboard.Keyboard(
//	// [google.elements.keyboard.LayoutCode.RUSSIAN],
//	// ['t1']);
//	// }
//	// }-*/
//	// }
//
//	private void initLogin() {
//		login.setAllowBlank(false);
//		login.setFieldLabel("Login");
//		add(login);
//		setFocusWidget(login);
//	}
//
//	private void initPassword() {
//		password.setAllowBlank(false);
//		password.setPassword(true);
//		password.setFieldLabel("Senha");
//		add(password);
//	}
//
//	@Override
//	public void cancel() {
//		
//		
//	}
//
////	@Override
////	protected void createButtons() {
////		//		
////		// submit.addSelectionListener(new SelectionListener<ButtonEvent>() {
////		// @Override
////		// public void componentSelected(ButtonEvent ce) {
////		//				
////		// }
////		// });
////		// addButton(submit);
////	}
//
//}