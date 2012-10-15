package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.EmpresaMirror;

public class FabricaFormulario {

public static DotFormulario getFormulario(DotWindow window, String nameClasse){
		
		if(nameClasse.equals(EmpresaMirror.class.getName())){
			return new CadEmpresa(window);
		}
		return new FormDinamicoSimples(window, nameClasse);
		}
}
