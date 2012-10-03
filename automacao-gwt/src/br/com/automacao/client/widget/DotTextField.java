package br.com.automacao.client.widget;

import br.com.automacao.client.DesktopApp;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Timer;

public class DotTextField<D> extends TextField<D>{
	
	private String mask;
	private boolean isNumeric = false;
	private Boolean alterado = Boolean.FALSE;
	
	private Timer timer;
	
	public DotTextField() {
		this(null);
	}
	
	@SuppressWarnings("unchecked")
	public DotTextField(String mask){
		this.mask = mask; 
		if(mask != null){
			maskTextField(this);
		}
		TextField<D>.TextFieldMessages msg = new TextFieldMessages(); 
		msg.setBlankText(DesktopApp.CONST.text_field_permite_branco());
		setMessages(msg);
		
		addListener(Events.Focus, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				timer = new Timer() {
					@Override
					public void run() {
						if(alterado && isRendered()) {
							el().firstChild().setStyleAttribute("backgroundColor", "yellow");
							alterado = Boolean.FALSE; 
						} else if(isRendered()){
							el().firstChild().setStyleAttribute("backgroundColor", "white");
							alterado = Boolean.TRUE;
						}
					}
				};
				timer.scheduleRepeating(1000);
			}
		});
		
		addListener(Events.Blur, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				timer.cancel();
				el().firstChild().setStyleAttribute("backgroundColor", "white");
			}
		});
	}
	
	public final void onlyNumber(){
		if (mask == null || mask.isEmpty()) {
			DotListeners.somenteNumero(this);
		} else {
			isNumeric = Boolean.TRUE;
		}
	}

	public void setMask(String mask){
		this.mask = mask; 
		if(mask != null){
			maskTextField(this);
		}
	}
	
	@SuppressWarnings("unchecked")
	public final void maskTextField(final TextField tf) {
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void componentKeyUp(ComponentEvent event) {
				String text = (String)tf.getValue();
				if(text != null){
					int length = text.length();
					int keyCode = event.getKeyCode();
					if (mask.length() < length) {
						tf.setValue(text.substring(0, mask.length()));
						return;
					}
					if (isNumeric && DotListeners.isNotNumeric(text.substring(length-1))) {
						tf.setValue(text.substring(0, length-1));
						return;
					}
					if (length >= mask.length() &&  keyCode != KeyCodes.KEY_BACKSPACE && keyCode != KeyCodes.KEY_TAB ) {
						tf.setValue(text.substring(0, length));
						return;
					} else if(keyCode != KeyCodes.KEY_BACKSPACE){
						int nextIndex = mask.indexOf('#', length);
						String currentMask = "";
						if (nextIndex >= 0){
							if(length==nextIndex){
								if (length > 1) {
									String key = mask.substring(length-1, length);
									if (!key.equals("#")) {
										String newValue = text.substring(0, length-1) + key + text.substring(length-1);
										tf.setValue(newValue);
										return;
									}
								}
								currentMask = mask.substring(length, nextIndex+1);
							} else {
								currentMask = mask.substring(length, nextIndex);
							}
						}else{
							currentMask = mask.substring(length);
						}
						
						if (!currentMask.equals("#")){
							tf.setValue(text + currentMask);
						}
					}
				}
			}
		});
	}
	
	public String getValueWithoutMask(){
		String origtext = (String) this.getValue();
		String strip = "";
		try {
			for (int i = 0; i < origtext.length(); i++) {
				if (Character.isDigit(origtext.charAt(i)))
					strip = strip.concat(String.valueOf(origtext.charAt(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strip;
	}
	
	public void setReadOnly(){
		setReadOnly(true);
	}
	
	public void unsetReadOnly(){
		setReadOnly(false);
	}
	
	public final void buildInput(LayoutContainer fs, String label, int left, int top, Object _width, Object _height, int _tabIndex){
		Text txt = new Text(label);
		fs.add(txt, new AbsoluteData(left, top-16));
		fs.add(this, new AbsoluteData(left, top));
		this.setSize((String)_width, (String)_height);
		this.setName(txt.getText());
		this.setTabIndex(_tabIndex);
	}

	public void setValue(Long id) {
		// TODO Auto-generated method stub
		
	}
}