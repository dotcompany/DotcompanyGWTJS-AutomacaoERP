package br.com.automacao.client.widget.formulario.descriptor;

import br.com.automacao.client.widget.formulario.dinamico.CampoDescWidget;
import br.com.automacao.client.widget.formulario.dinamico.FieldChangeListener;
import br.com.automacao.shared.dto.FloatFieldDTO;
import br.com.automacao.shared.type.CampoType;

import com.extjs.gxt.ui.client.widget.form.TextField;

public class FloatWidgetDesc extends CampoDescWidget<FloatFieldDTO> {

	private TextField<Float> field = new TextField<Float>();

	public FloatWidgetDesc(FloatFieldDTO fieldTO, FieldChangeListener listener) {
		super(fieldTO, listener);
		super.add(field);
		super.setCellWidth(field, FIELD_WIDTH);
		field.setWidth(FIELD_WIDTH);
		field.setReadOnly(true);
		field.setTitle(CampoType.FLOAT.desc());
		buildCheckIsRequired();
	}
}