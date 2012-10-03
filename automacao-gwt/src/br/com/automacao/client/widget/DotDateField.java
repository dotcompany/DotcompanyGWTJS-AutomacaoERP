package br.com.automacao.client.widget;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;

public class DotDateField extends DateField{
	
	private static String MASK_DATE;
	private static String language;
	private static String FORMAT_DATE;
	
	public DotDateField() {
		this(null);
	}

	public DotDateField(String _language) {
		language = _language;
		dateFormat();
		processing();
	}
	
	private final void dateFormat(){
		if (language!=null && language.equals("en")) {
			FORMAT_DATE = "yyyy/dd/MM";
			MASK_DATE = "####/##/##";
		} else {
			FORMAT_DATE = "dd/MM/yyyy";
			MASK_DATE = "##/##/####";
		}
		this.getPropertyEditor().setFormat(DateTimeFormat.getFormat(FORMAT_DATE));
	}

	private final void processing(){
		this.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyUp(ComponentEvent event) {
				String text = getRawValue();
				if(text != null && !text.isEmpty()){
					int length = text.length();
					int keyCode = event.getKeyCode();
					if (MASK_DATE.length() < length) {
						setRawValue(text.substring(0, MASK_DATE.length()));
						return;
					}
					if (DotListeners.isNotNumeric(text.substring(length-1))) {
						setRawValue(text.substring(0, length-1));
						return;
					}
					if (length >= MASK_DATE.length() &&  keyCode != KeyCodes.KEY_BACKSPACE && keyCode != KeyCodes.KEY_TAB ) {
						setRawValue(text.substring(0, length));
						return;
					} else if(keyCode != KeyCodes.KEY_BACKSPACE){
						int nextIndex = MASK_DATE.indexOf('#', length);
						String currentMask = "";
						if (nextIndex >= 0){
							if(length==nextIndex){
								if (length > 1) {
									String key = MASK_DATE.substring(length-1, length);
									if (!key.equals("#")) {
										String newValue = text.substring(0, length-1) + key + text.substring(length-1);
										setRawValue(newValue);
										return;
									}
								}
								currentMask = MASK_DATE.substring(length, nextIndex+1);
							} else {
								currentMask = MASK_DATE.substring(length, nextIndex);
							}
						}else{
							currentMask = MASK_DATE.substring(length);
						}
						
						if (!currentMask.equals("#")){
							setRawValue(text + currentMask);
						}
					}
				}
			}
		});
	}
	
	public final void buildInput(LayoutContainer fs, String label, int left, int top, Object _width, Object _height, int _tabIndex){
		Text txt = new Text(label);
		fs.add(txt, new AbsoluteData(left, top-16));
		fs.add(this, new AbsoluteData(left, top));
		this.setSize((String)_width, (String)_height);
		this.setName(txt.getText());
		this.setTabIndex(_tabIndex);
	}
}