package br.com.automacao.client.widget;

import br.com.automacao.shared.type.PessoaType;
import br.com.automacao.shared.util.Combo;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;

@SuppressWarnings("unchecked")
public class DotListeners {

	public final static void maskCpfOrCnpj(final ComboBox<Combo> combo, final DotTextField tf){
		combo.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if(combo.getValue() != null && combo.getValue().getItem().equals(PessoaType.PF)){
					tf.clear();
					tf.setReadOnly(false);
					tf.setMask("###.###.###-##");
				}else if(combo.getValue() != null && combo.getValue().getItem().equals(PessoaType.PJ)){
					tf.clear();
					tf.setReadOnly(false);
					tf.setMask("###.###.#####-##");
				}
			}
		});
	}
	
	public final static void somenteNumero(final TextField tf){
		tf.addListener(Events.KeyUp, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if(tf != null && tf.getValue() != null){
					int size = tf.getValue().toString().length();
					String value = tf.getValue().toString().substring(size-1);
					if(isNotNumeric(value)){
						tf.setValue(tf.getValue().toString().substring(0, size-1));
					}
				}
			}
		});
	}
	
	public final static boolean isNotNumeric(String value){ 
		return (!value.contains("9") && !value.contains("8") && !value.contains("7") && !value.contains("6") && !value.contains("5") 
					&& !value.contains("4") && !value.contains("3") && !value.contains("2") && !value.contains("1") && !value.contains("0"));
	}
}