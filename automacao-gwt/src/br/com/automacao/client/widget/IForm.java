package br.com.automacao.client.widget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.automacao.client.dialog.MsgDialog;
import br.com.automacao.shared.mirror.PessoaMirror;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.user.client.ui.Hidden;
import com.gwtent.reflection.client.annotations.Reflect_SubClasses;

@Reflect_SubClasses
@SuppressWarnings("unchecked")
public abstract class IForm<T extends Mirror> {
	
	public Map<String, Object> mapCollectionTmp = new HashMap<String, Object>();
	
	public final static String ITM_CNAE = "itmCnae"; 
	public final static String ITM_DPTO = "itmDpto"; 
	public final static String ITM_FUNCAO = "itmFuncao";
	public final static String ITM_GRUPO = "itmGrupo";
	public final static String ITM_SUBGRUPO = "itmSubGrupo";
	public final static String ITM_CATEGORIA = "itmCategoria";
	public final static String ITM_MARCA = "itmMarca";
	public final static String ITM_LOC_INTERNA = "itmLocInterna";
	public final static String ITM_UNIDADE = "itmUnidade";
	public final static String ITM_TRIBUTACAO = "itmTributacao";
	public final static String ITM_NCM = "itmNCM";
	
	private final DotFormulario formulario;

	public IForm(DotFormulario formulario) {
		this.formulario = formulario;
	}
	
	public static boolean ok(Object str){
		return str != null ;
	}
	
	public boolean fieldOk(Hidden field) {
		return field != null && field.getValue() != null && !field.getValue().isEmpty();
	}
	
	public boolean fieldOk(Field field) {
		return field != null && field.getValue() != null && !field.getValue().equals("");
	}
	
	public void validate(Field... fields){
		boolean erro = false;
		for(Field field : fields){
			System.out.println(field == null);
			System.out.println(field.getValue());
			if(fieldOk(field)){continue;}
			field.markInvalid("Campo em branco!");
			erro = true;
		}
		if(erro)
			MsgDialog.alert("Erro", "Existem campos a serem preenchidos!");
	}
	
	protected void doClear(List<Field<?>> fields){
		for(Field<?> field : fields){
			field.clear();
		}
	}

	public abstract TabItem getItem();

	public abstract void fillDTO(T dto);

	public abstract void clear();

	public abstract void loadFields(T dto);
	
	public DotFormulario getFormulario() {
		return formulario;
	}

	
}