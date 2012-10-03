package br.com.automacao.client.widget.formulario.descriptor;

import br.com.automacao.client.widget.formulario.dinamico.CampoDescWidget;
import br.com.automacao.client.widget.formulario.dinamico.FieldChangeListener;
import br.com.automacao.shared.dto.StringFieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.extjs.gxt.ui.client.widget.form.TextField;

public class StringWidgetDesc extends CampoDescWidget<StringFieldDTO>{

	private TextField<String> textField = new TextField<String>();
	
	public StringWidgetDesc(StringFieldDTO fieldTO, FieldChangeListener listener) {
		super(fieldTO, listener);
		super.add(textField);
		super.setCellWidth(textField, FIELD_WIDTH);
	    textField.setWidth(FIELD_WIDTH);
	    textField.setReadOnly(true);
	    textField.setTitle(CampoType.STRING.desc());
		buildCheckIsRequired();
	}
}
