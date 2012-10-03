package br.com.automacao.shared.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.automacao.shared.util.Mirror;

import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("serial")
public class FieldCollectionDTO extends Mirror implements IsSerializable {
	
	private List<FieldDTO> fields;
	private boolean modified;

	protected FieldCollectionDTO() {}

	private final void setModified(boolean modified) {
		this.modified = modified;
	}

	public FieldCollectionDTO(String name) {
		this.fields = new ArrayList<FieldDTO>();
		this.modified = false;
	}

	public final Iterator<FieldDTO> getFields() {
		return this.fields.iterator();
	}

	public final List<FieldDTO> getFieldList() {
		return this.fields;
	}

	public final void addField(FieldDTO FieldDTO) {
		if (FieldDTO != null) {
			this.fields.add(FieldDTO);
			setModified(true);
		}
	}

	public final int size() {
		return this.fields.size();
	}

	public final boolean isModified() {
		return this.modified;
	}

	public final void remove(FieldDTO FieldDTO) {
		if (FieldDTO != null) {
			this.fields.remove(FieldDTO);
			int order = 0;
			for (FieldDTO f : this.fields)
				f.setOrdem(order++);
			setModified(true);
		}
	}

	public final void save() {
		setModified(false);
	}

	public final void unsave() {
		setModified(true);
	}

	public final boolean hasAlreadyDefined(String name) {
		for (FieldDTO field : this.fields)
			if (field.getNome().equalsIgnoreCase(name))
				return true;
		return false;
	}
}