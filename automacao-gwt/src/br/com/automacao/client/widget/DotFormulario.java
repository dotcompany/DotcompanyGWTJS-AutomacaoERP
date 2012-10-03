package br.com.automacao.client.widget;

import java.util.HashMap;
import java.util.Map;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("unchecked")
public abstract class DotFormulario extends DotContentPanel implements ActionButtons{
	
	protected enum ActionType{
		SAVE, EDIT, REMOVE, NEW;
	}
	
	protected Map<String, IForm> 	form;
	protected IForm[] 				paramForm;
	protected TabPanel 				tabPanel = new TabPanel();
	private SplitButton 			btnSave;
	private Menu 					menuSave;
	private MenuItem 				newSaveItem;
	private MenuItem 				duplicateSaveItem;
	private Button 					btnNovo;
	private Button 					btnClear;
	private Button 					btnCancel;
	private Mirror 					mirror;
	protected String 				idItem;
	
	public DotFormulario(DotWindow window, String header) {
		super(window, header);
	}
	
	protected final void initialize(ActionButtons actions, IForm... paramForm){
		initButtons();
		createMenuToolBar();
		buildActionsButtons(actions);
		initializeTabPanel(paramForm);
	}

	private void initializeTabPanel(IForm... paramForm) {
		Integer cont = 0;
		this.form = new HashMap<String, IForm>();
		this.paramForm = paramForm;
		tabPanel = new TabPanel();
		tabPanel.setBorders(false);
		tabPanel.setLayoutData(new FormLayout());
		if (paramForm != null && paramForm.length > 0) {
			for (IForm value : paramForm) {
				String id = "item"+cont++; 
				TabItem item = value.getItem();
				if (item == null) {throw new NullPointerException(" O metodo "+value.getClass().getName()+".getItem() do formulario esta nulo ou nao foi definido.");}
				item.setId(id);
				tabPanel.add(item);
				this.form.put(id, value);
			}
		}

		tabPanel.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				tabPanel.getSelectedItem().getHeader().setStyleAttribute("backgroundColor", "yellow");
				idItem = tabPanel.getSelectedItem().getId();
			}
		});
	}
	
	private final void initButtons() {
		btnSave = new SplitButton(DesktopApp.CONST.salvar());
		menuSave = new Menu();
		newSaveItem = new MenuItem(DesktopApp.CONST.salvar_novo(), DesktopApp.IMG.img_save());
		duplicateSaveItem = new MenuItem(DesktopApp.CONST.salvar_duplicado(), DesktopApp.IMG.img_save());
		
		btnNovo = new Button(DesktopApp.CONST.novo(), DesktopApp.IMG.img_add());
		btnClear = new Button(DesktopApp.CONST.limpar(), DesktopApp.IMG.img_clear());
		btnCancel = new Button(DesktopApp.CONST.cancelar(), DesktopApp.IMG.img_cancel());

		btnSave.setIcon(DesktopApp.IMG.img_save());
		menuSave.add(newSaveItem);
		menuSave.add(duplicateSaveItem);
		btnSave.setMenu(menuSave);
	}

	private void createMenuToolBar(){
		final ToolBar toolBar = new ToolBar();
		toolBar.add(btnNovo);
		toolBar.add(btnSave);
		toolBar.add(btnCancel);
		toolBar.add(new SeparatorToolItem());
		toolBar.add(btnClear);
		setTopComponent(toolBar);
	}
	
	private void buildActionsButtons(ActionButtons actions) {
		getBtnSave().addSelectionListener(actions.actionSave());
		getBtnClear().addSelectionListener(actions.actionClear());
		getBtnNovo().addSelectionListener(actions.actionIncluir());
		getNewSaveItem().addSelectionListener(actions.actionSaveNew());
		getDuplicateSaveItem().addSelectionListener(actions.actionSaveDuplicate());
		getBtnCancel().addSelectionListener(actions.actionCancel());
	}

	protected void beforeChange() {
		getBtnSave().removeAllListeners();
		getBtnCancel().removeAllListeners();
		getBtnClear().removeAllListeners();
		getBtnNovo().removeAllListeners();
		getNewSaveItem().removeAllListeners();
		getDuplicateSaveItem().removeAllListeners();
	}
	
	protected void addExtensionItem(final Widget form){
		super.add(form/*, new FormData("90%")*/);
	}
	
	protected void setSizeMain(String width, String height){
		super.setSize(width, height);
	}

	public SplitButton getBtnSave() {
		return btnSave;
	}

	public MenuItem getNewSaveItem() {
		return newSaveItem;
	}

	public MenuItem getDuplicateSaveItem() {
		return duplicateSaveItem;
	}

	public Button getBtnNovo() {
		return btnNovo;
	}

	public Button getBtnClear() {
		return btnClear;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public Mirror getMirror() {
		return mirror;
	}

	public void setMirror(Mirror mirror) {
		this.mirror = mirror;
	}
	
	protected void sync(Mirror mirror){
		sync(ActionType.SAVE, mirror);
	}
	
	protected void syncClear(){
		sync(ActionType.REMOVE, null);
	}
	
	protected void syncNew(Mirror mirror){
		sync(ActionType.EDIT, mirror);
	}
	
	protected void sync(ActionType type, Mirror mirror){
		if (paramForm != null && paramForm.length > 0) {
			if(type == ActionType.EDIT){
				for (IForm value : paramForm) 
					value.loadFields(mirror);
				return;
			}
			if(type == ActionType.SAVE){
				for (IForm value : paramForm) 
					value.fillDTO(mirror);
				return;
			}
			for (IForm value : paramForm) 
				value.clear();
		}
	}
	
	@Override
	public final SelectionListener<ButtonEvent> actionCancel() {
		return new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onCancel(ce);
			}
		};
	}

	@Override
	public final SelectionListener<ButtonEvent> actionSave() {
		return new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onSave(ce);
			}
		};
	}


	@Override
	public final SelectionListener<ButtonEvent> actionClear() {
		return new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onClear(ce);
			}
		};
	}

	@Override
	public final SelectionListener<ButtonEvent> actionIncluir() {
		return new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onNew(ce);
			}
		};
	}

	@Override
	public final SelectionListener<MenuEvent> actionSaveDuplicate() {
		return new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent ce) {
				onDuplicateSaveItem(ce);
			}
		};
	}

	@Override
	public final SelectionListener<MenuEvent> actionSaveNew() {
		return new SelectionListener<MenuEvent>() {
			@Override
			public void componentSelected(MenuEvent ce) {
				onNewSaveItem(ce);
			}
		};
	}

	public abstract void onSave(ComponentEvent ce);
	public abstract void onClear(ComponentEvent ce);
	public abstract void onNew(ComponentEvent ce);
	public abstract void onNewSaveItem(ComponentEvent ce);
	public abstract void onCancel(ComponentEvent ce);
	public abstract void onDuplicateSaveItem(ComponentEvent ce);
	public abstract void remove(Mirror dto, ButtonEvent ce, Loader loader);
	public abstract void edit(Mirror dto);
}
