package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotWindow;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.mirror.EmpresaMirror;
import br.com.automacao.shared.mirror.MarcaMirror;
import br.com.automacao.shared.mirror.ModelosMirror;

public class FabricaFormulario {

public static DotFormulario getFormulario(DotWindow window, String nameClasse){
		
		if(nameClasse.equals(EmpresaMirror.class.getName())){
			return new CadEmpresa(window);
		}else if(nameClasse.equals(ColaboradorMirror.class.getName())){
			return new CadColaborador(window);		
		}else if(nameClasse.equals(MarcaMirror.class.getName())){
			return new CadMarca(window);
		}
		else if(nameClasse.equals(ModelosMirror.class.getName())){
			return new CadModelos(window);
		}
		return new FormDinamicoSimples(window, nameClasse);
		}
		
}
