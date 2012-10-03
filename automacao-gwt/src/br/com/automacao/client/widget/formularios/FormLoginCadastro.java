package br.com.automacao.client.widget.formularios;
//package br.com.automacao.web.client.widget.formularios;
//
//import br.com.automacao.web.client.command.LoginLoadResponse;
//import br.com.automacao.web.client.command.LoginSaveClient;
//import br.com.automacao.web.client.command.LoginSeekClient;
//import br.com.automacao.web.client.command.Response;
//import br.com.automacao.web.client.dialog.MsgDialog;
//import br.com.automacao.web.client.mirror.LoginDTO;
//import br.com.automacao.web.client.widget.DotcompanyFormulario;
//import br.com.automacao.web.client.widget.DotcompanyWindow;
//
//import com.extjs.gxt.ui.client.event.BaseEvent;
//import com.extjs.gxt.ui.client.event.ComponentEvent;
//import com.extjs.gxt.ui.client.event.Events;
//import com.extjs.gxt.ui.client.event.Listener;
//import com.extjs.gxt.ui.client.widget.TabItem;
//import com.extjs.gxt.ui.client.widget.TabPanel;
//import com.extjs.gxt.ui.client.widget.Text;
//import com.extjs.gxt.ui.client.widget.form.FormPanel;
//import com.extjs.gxt.ui.client.widget.form.TextField;
//import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
//import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//
//public class FormLoginCadastro extends DotcompanyFormulario {
//
//	private LoginDTO loginDTO = new LoginDTO();
//	private TabPanel tabPanel = new TabPanel();
//	private TabItem tbtmNewTabitem = new TabItem("Informa\u00E7\u00E3o Geral");
//	private FormPanel frmpnlNewFormpanel = new FormPanel();
//	private TextField<String> tfNome = new TextField<String>();
//	private TextField<String> tfEmail = new TextField<String>();
//	private TextField<String> tfLogin = new TextField<String>();
//	private TextField<String> tfSenha = new TextField<String>();
//	private TextField<String> tfFone = new TextField<String>();
//
//	@SuppressWarnings("unchecked")
//	public FormLoginCadastro(DotcompanyWindow window) {
//		super(window);
//		super.initialize(this);
//		super.setHeader("Cadastro");
//
//		tbtmNewTabitem.setLayout(new AbsoluteLayout());
//		this.frmpnlNewFormpanel.setHeading("TESTE");
//		this.frmpnlNewFormpanel.setFrame(true);
//		// frmpnlNewFormpanel.setHeaderVisible(false);
//		this.frmpnlNewFormpanel.setHeading("New FormPanel");
//		this.frmpnlNewFormpanel.setLayout(new AbsoluteLayout());
//
//		Text txtNome = new Text("Nome");
//		this.frmpnlNewFormpanel.add(txtNome, new AbsoluteData(6, 10));
//		txtNome.setSize("204px", "13px");
//
//		final Text tNomeAviso = new Text();
//		this.frmpnlNewFormpanel.add(tNomeAviso, new AbsoluteData(300, 30));
//
//		this.tfNome.setFieldLabel("Nome");
//		this.tfNome.addListener(Events.OnBlur, new Listener() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				try {
//					loginDTO.setNome(tfNome.getValue());
//
//					getService().execute(new LoginSeekClient(loginDTO),
//							new AsyncCallback<LoginLoadResponse>() {
//								@Override
//								public void onFailure(Throwable caught) {
//									MsgDialog
//											.error("O cadastrado nao pode ser realizado ...");
//								}
//
//								@Override
//								public void onSuccess(LoginLoadResponse result) {
//									if (!result.getLogin().getNome().equals("")
//											|| result.getLogin().getNome() != null) {
//										tNomeAviso.setText(result.getLogin()
//												.getNome());
//									}
//								}
//							});
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//		this.frmpnlNewFormpanel.add(this.tfNome, new AbsoluteData(6, 30));
//		this.tfNome.setSize("233px", "24px");
//
//		Text txtEmail = new Text("E-mail");
//		frmpnlNewFormpanel.add(txtEmail, new AbsoluteData(6, 50));
//		txtEmail.setSize("204px", "13px");
//
//		final Text tEmailAviso = new Text();
//		this.frmpnlNewFormpanel.add(tEmailAviso, new AbsoluteData(300, 70));
//
//		this.tfEmail.setFieldLabel("E-mail");
//		this.tfEmail.addListener(Events.OnBlur, new Listener() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				try {
//					loginDTO.setEmail(tfEmail.getValue());
//
//					getService().execute(new LoginSeekClient(loginDTO),
//							new AsyncCallback<LoginLoadResponse>() {
//								@Override
//								public void onFailure(Throwable caught) {
//									MsgDialog
//											.error("O cadastrado nao pode ser realizado ...");
//								}
//
//								@Override
//								public void onSuccess(LoginLoadResponse result) {
//									if (!result.getLogin().getEmail()
//											.equals("")
//											|| result.getLogin().getEmail() != null) {
//										tEmailAviso.setText(result.getLogin()
//												.getEmail());
//									}
//								}
//							});
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//		this.frmpnlNewFormpanel.add(this.tfEmail, new AbsoluteData(6, 70));
//		this.tfEmail.setSize("233px", "24px");
//
//		Text txtLogin = new Text("Login");
//		frmpnlNewFormpanel.add(txtLogin, new AbsoluteData(6, 90));
//		txtLogin.setSize("204px", "13px");
//
//		final Text tLoginAviso = new Text();
//		this.frmpnlNewFormpanel.add(tLoginAviso, new AbsoluteData(300, 110));
//
//		this.tfLogin.setFieldLabel("Login");
//		this.tfLogin.addListener(Events.OnBlur, new Listener() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				try {
//					loginDTO.setLogin(tfLogin.getValue());
//
//					getService().execute(new LoginSeekClient(loginDTO),
//							new AsyncCallback<LoginLoadResponse>() {
//								@Override
//								public void onFailure(Throwable caught) {
//									MsgDialog
//											.error("O cadastrado nao pode ser realizado ...");
//								}
//
//								@Override
//								public void onSuccess(LoginLoadResponse result) {
//									if (!result.getLogin().getLogin()
//											.equals("")
//											|| result.getLogin().getLogin() != null) {
//										tLoginAviso.setText(result.getLogin()
//												.getLogin());
//									}
//								}
//							});
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//		this.frmpnlNewFormpanel.add(this.tfLogin, new AbsoluteData(6, 110));
//		this.tfLogin.setSize("233px", "24px");
//
//		Text txtSenha = new Text("Senha");
//		frmpnlNewFormpanel.add(txtSenha, new AbsoluteData(6, 130));
//		txtSenha.setSize("204px", "13px");
//
//		this.tfSenha.setFieldLabel("Senha");
//		this.tfSenha.setPassword(true);
//		this.tfSenha.setMinLength(6);
//		this.frmpnlNewFormpanel.add(this.tfSenha, new AbsoluteData(6, 150));
//		this.tfSenha.setSize("233px", "24px");
//
//		Text txtFone = new Text("Telefone");
//		frmpnlNewFormpanel.add(txtFone, new AbsoluteData(6, 170));
//		txtFone.setSize("204px", "13px");
//
//		this.tfFone.setFieldLabel("Telefone");
//		this.frmpnlNewFormpanel.add(this.tfFone, new AbsoluteData(6, 190));
//		this.tfFone.setSize("233px", "24px");
//
//		tbtmNewTabitem.add(frmpnlNewFormpanel, new AbsoluteData(0, 0));
//		frmpnlNewFormpanel.setSize("678px", "521px");
//		tabPanel.add(tbtmNewTabitem);
//		tbtmNewTabitem.setSize("600", "406px");
//
//		addExtensionItem(tabPanel);
//		buildActionsButtons(this);
//		setSizeMain("650", "550");
//		// cntntpnlNewContentpanel.setHeading("New ContentPanel");
//	}
//
//	@Override
//	protected void onLoad() {
////		java.util.List<Stock> lst = new ArrayList<Stock>();
////		ListStore<RamoDeAtividadeDoSistemaDTO> store = new ListStore<RamoDeAtividadeDoSistemaDTO>();
//		// store.add(lst);
//		// cmbRamoDaAtividade.setStore(store);
//		// cmbFormaDeAqusicaoDoSistema.setStore(store);
//		// combo.setTriggerAction(TriggerAction.ALL);
//	}
//
//	@Override
//	public void onCancel(ComponentEvent ce) {
//		
//	}
//
//	@Override
//	public void onClear(ComponentEvent ce) {
//		
//	}
//
//	@Override
//	public void onDuplicateSaveItem(ComponentEvent ce) {
//		
//	}
//
//	@Override
//	public void onIncluir(ComponentEvent ce) {
//		
//	}
//
//	@Override
//	public void onNewSaveItem(ComponentEvent ce) {
//		
//	}
//
//	@Override
//	public void onRem(ComponentEvent ce) {
//		
//	}
//
//	@Override
//	public void onSave(ComponentEvent ce) {
//		try {
//			loginDTO.setNome(tfNome.getValue());
//			loginDTO.setEmail(tfEmail.getValue());
//			loginDTO.setLogin(tfLogin.getValue());
//			loginDTO.setSenha(tfSenha.getValue());
//			loginDTO.setTelefone(tfFone.getValue());
//
//			getService().execute(new LoginSaveClient(loginDTO),
//					new AsyncCallback<Response>() {
//						@Override
//						public void onFailure(Throwable caught) {
//							MsgDialog
//									.error("O cadastrado nao pode ser realizado ...");
//						}
//
//						@Override
//						public void onSuccess(Response result) {
//							MsgDialog.info("Sucesso",
//									"Login cadastrado com sucesso");
//						}
//					});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}