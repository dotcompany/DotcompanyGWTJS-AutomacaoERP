package br.com.automacao.client.widget;

import java.util.List;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.model.DotModel;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ListModelPropertyEditor;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("unused")
public class DotAutoComplete<M extends DotModel> {

	private final Class<?> clazz;
	private ComboBox<DotModel> combo;
	private final ListStore<DotModel> list = new ListStore<DotModel>();
	private final DotModel dotModel;
	
	public DotAutoComplete(Class<?> clazz, DotModel dotModel) {
		this.clazz = clazz;
		this.dotModel = dotModel;
		buildCombo();
	}

	@SuppressWarnings("unchecked")
	private void onLoadAutocomplete(String value) {
		String[] like = new String[]{"nome", "string", value, "id", "integer", value};
		DesktopApp.getServiceGenerics().listar(clazz.getName(), new String[]{"id", "nome"}, like, new AsyncCallback<List>() {
			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(List result) {
				int cont = 0;
				for (; cont < result.size(); cont++) {
					Mirror cm = (Mirror) result.get(cont);
					dotModel.convert(result);
				}
				list.add(dotModel.getListModel());
			}
		});
	}

	private void buildCombo() {
		combo = new ComboBox<DotModel>();
		combo.setWidth(300);  
		combo.setStore(list);
		combo.setDisplayField(dotModel.getSecond());  
		combo.setTypeAhead(true);  
		combo.setTriggerAction(TriggerAction.ALL);
		combo.setTemplate(getTemplate());
		
		combo.setPropertyEditor(new ListModelPropertyEditor<DotModel>() {
			@Override
			public String getStringValue(DotModel value) {
				return value.get(dotModel.getFirst())+" - "+value.get(dotModel.getSecond());
			}
			
			@Override
			public DotModel convertStringValue(String value) {
				System.out.println(value);
				return null;
			}
		});
		
		KeyListener listener = new KeyListener(){
			@Override
			public void componentKeyUp(ComponentEvent event) {
				if(event.getKeyCode() != KeyCodes.KEY_DOWN && event.getKeyCode() != KeyCodes.KEY_LEFT && 
						event.getKeyCode() != KeyCodes.KEY_RIGHT && event.getKeyCode() != KeyCodes.KEY_UP){
					String value = combo.getRawValue();
					System.out.println(value);
					if(value != null && value.length() >= 1){
						combo.getStore().removeAll();
						list.removeAll();
						onLoadAutocomplete(value);
					}else if(value != null && value.length() == 0){
						combo.getStore().removeAll();
						list.removeAll();
					}
				}
			}
		};
		combo.addKeyListener(listener);
	}

	private native String getTemplate() /*-{ 
	    return  [ 
			    '<tpl for=".">', 
			    	'<div class="x-combo-list-item" qtip="{slogan}" qtitle="State Slogan"><img width="16px" height="11px" src="../../{id}.png"/>{id} - {nome}</div>', 
			    '</tpl>' ].join(""); 
  	}-*/;  

	private native String getFlagTemplate(String base) /*-{
		return [
				'<tpl for=".">',
					'<div class="x-combo-list-item"><img width="16px" height="11px" src="' + base + 'samples/images/icons/fam/flags/{[values.abbr]}.png"> {[values.name]}</div>',
				'</tpl>' ].join("");
		}-*/;
	
	public Widget getWidget(){
		return combo;
	}
	
	public String getValue(){
		return combo.getRawValue();
	}
}