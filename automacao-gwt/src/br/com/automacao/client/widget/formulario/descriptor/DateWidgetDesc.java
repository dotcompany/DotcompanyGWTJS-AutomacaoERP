package br.com.automacao.client.widget.formulario.descriptor;

import br.com.automacao.client.widget.formulario.dinamico.CampoDescWidget;
import br.com.automacao.client.widget.formulario.dinamico.FieldChangeListener;
import br.com.automacao.shared.dto.DateFieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.extjs.gxt.ui.client.widget.form.DateField;

public class DateWidgetDesc extends CampoDescWidget<DateFieldDTO> {

	private DateField dateField = new DateField();
	
	public DateWidgetDesc(DateFieldDTO fieldTO, FieldChangeListener listener) {
		super(fieldTO, listener);
		super.add(dateField);
		super.setCellWidth(dateField, FIELD_WIDTH);
		dateField.setWidth(FIELD_WIDTH);
		dateField.setTitle(CampoType.DATE.desc());
		dateField.setReadOnly(true);
		buildCheckIsRequired();
	}
}
