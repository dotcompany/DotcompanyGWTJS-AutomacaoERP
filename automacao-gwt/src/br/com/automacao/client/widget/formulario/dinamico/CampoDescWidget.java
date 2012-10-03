package br.com.automacao.client.widget.formulario.dinamico;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.dto.FieldDTO;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public abstract class CampoDescWidget<T extends FieldDTO> extends
		HorizontalPanel {

	public static final String FIRST_COLUMN = "20px";
	public static final String FIELD_WIDTH = "170px";
	public static final String LABEL_WIDTH = "110px";
	public static final String FLAGS_WIDTH = "73px";
	public static final int HORIZONTAL_SPACING = 5;

	private Button remButton = new Button();
	private Button orderUpButton = new Button();
	private Button orderDownButton = new Button();
	private Button editButton = new Button();

	private LabelField label = new LabelField();

	protected final T fieldDTO;

	private CheckBox chkIsRequired;
	
	protected final FieldChangeListener listener;

	public CampoDescWidget(T fieldDTO, FieldChangeListener listener) {
		this.fieldDTO = fieldDTO;
		this.listener = listener;
		initOrderUpButton();
		initOrderDownButton();
		initRemButton();
		initEditButton();
		initLabel();
		super.setSpacing(CampoDescWidget.HORIZONTAL_SPACING);
	}

	protected void buildCheckIsRequired() {
		chkIsRequired = createCheckBox(fieldDTO.getRequerido());
		chkIsRequired.setEnabled(true);
		super.add(chkIsRequired);
		super.setCellWidth(chkIsRequired, FLAGS_WIDTH);
		super.setCellVerticalAlignment(chkIsRequired,
				HasVerticalAlignment.ALIGN_MIDDLE);
		super.setCellHorizontalAlignment(chkIsRequired,
				HasHorizontalAlignment.ALIGN_CENTER);
		chkIsRequired.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onIsRequiredCheck(chkIsRequired.getValue());
			}
		});
	}

	protected void onIsRequiredCheck(boolean checked) {
		if (listener != null)
			listener.onChange(fieldDTO);
	}

	private void initOrderDownButton() {
		orderDownButton.setIcon(DesktopApp.IMG.img_arrow_down());
		super.add(orderDownButton);
		super.setCellWidth(orderDownButton, FIRST_COLUMN);
		super.setCellHorizontalAlignment(orderDownButton,
				HasHorizontalAlignment.ALIGN_CENTER);
		super.setCellVerticalAlignment(orderDownButton,
				HasVerticalAlignment.ALIGN_MIDDLE);
		orderDownButton
				.addSelectionListener(new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						onDownField(fieldDTO);
					}
				});
	}

	private void initOrderUpButton() {
		orderUpButton.setIcon(DesktopApp.IMG.img_arrow_up());
		super.add(orderUpButton);
		super.setCellWidth(orderUpButton, FIRST_COLUMN);
		super.setCellHorizontalAlignment(orderUpButton,
				HasHorizontalAlignment.ALIGN_CENTER);
		super.setCellVerticalAlignment(orderUpButton,
				HasVerticalAlignment.ALIGN_MIDDLE);
		orderUpButton
				.addSelectionListener(new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						onUpField(fieldDTO);
					}
				});
	}

	private void initRemButton() {
		remButton.setIcon(DesktopApp.IMG.img_remove());
		super.add(remButton);
		super.setCellWidth(remButton, FIRST_COLUMN);
		super.setCellHorizontalAlignment(remButton,
				HasHorizontalAlignment.ALIGN_CENTER);
		super.setCellVerticalAlignment(remButton,
				HasVerticalAlignment.ALIGN_MIDDLE);
		remButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onRemoveField(fieldDTO);
			}
		});
	}

	private void initEditButton() {
		editButton.setIcon(DesktopApp.IMG.img_edit());
		super.add(editButton);
		super.setCellWidth(editButton, FIRST_COLUMN);
		super.setCellHorizontalAlignment(editButton,
				HasHorizontalAlignment.ALIGN_CENTER);
		super.setCellVerticalAlignment(editButton,
				HasVerticalAlignment.ALIGN_MIDDLE);
		editButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				onEditField(fieldDTO);
			}
		});
	}

	private void initLabel() {
		label.setText(fieldDTO.getNome());
		super.add(label);
		super.setCellWidth(label, LABEL_WIDTH);
	}

	public final void setText(String text) {
		label.setText(text);
	}

	private CheckBox createCheckBox(boolean isChecked) {
		CheckBox chk = new CheckBox();
		chk.setValue(isChecked);
		return chk;
	}

	protected final CheckBox getChkIsRequired() {
		return this.chkIsRequired;
	}

	protected final void onRemoveField(FieldDTO fieldDTO) {
		if (listener != null)
			listener.onRemove(this);
	}

	private void onEditField(FieldDTO fieldDTO) {
		if (listener != null)
			listener.onEdit(this);
	}

	protected final void onUpField(FieldDTO fieldDTO) {
		if (listener != null)
			listener.onUpField(this);
	}

	protected final void onDownField(FieldDTO fieldDTO) {
		if (listener != null)
			listener.onDownField(this);
	}

	public void incrementOrder() {
		fieldDTO.setOrdem(fieldDTO.getOrdem() + 1);
	}

	public void decrementOrder() {
		if (fieldDTO.getOrdem() > 0)
			fieldDTO.setOrdem(fieldDTO.getOrdem() - 1);
	}

	public T getFieldDTO() {
		return fieldDTO;
	}
}