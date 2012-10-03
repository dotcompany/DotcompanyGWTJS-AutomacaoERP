package br.com.automacao.service.servlet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.ModelosService;
import br.com.automacao.ctr.entidade.ModelosTO;
import br.com.automacao.ctr.negocio.Modelos;
import br.com.automacao.shared.mirror.ModelosMirror;
import br.com.dotcompany.hibernate.Generics;

@SuppressWarnings("serial")
@Service("modelosManager")
public class ModelosServiceImpl extends BaseService implements ModelosService {

	@Override
	@Transactional(readOnly = false)
	public void excluir(ModelosMirror cm) {
		ModelosTO modelos = crud(Generics.class).pegar(new ModelosTO(cm.getId()));
		crud(Modelos.class).excluir(modelos);
	}
	
	@Override
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void saveUpdate(ModelosMirror cm) {
		ModelosTO to = converterTo(cm);
		if (cm.getId() == null) {
			crud(Modelos.class).incluir(to);
		} else {
			crud(Modelos.class).alterar(to);
		}
	}

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public ModelosMirror buscar(ModelosMirror cm) {
		ModelosTO modelos = crud(Generics.class).buscar(new ModelosTO(cm.getId()));
		return converterMirror(modelos);
	}

	/* Método usado para sincronizar o mirror com o que esta na sessão do Hibernate */
	@Override
	@Transactional(readOnly = true)
	public ModelosMirror pegar(ModelosMirror cm) {
		ModelosTO modelos = crud(Generics.class).pegar(new ModelosTO(cm.getId()));
		return converterMirror(modelos);
	}
}