package br.com.automacao.service.servlet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.ColaboradorService;
import br.com.automacao.ctr.entidade.ColaboradorTO;
import br.com.automacao.ctr.negocio.Colaborador;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.dotcompany.hibernate.Generics;

@SuppressWarnings("serial")
@Service("colaboradorManager")
public class ColaboradorServiceImpl extends BaseService implements ColaboradorService {

	@Override
	@Transactional(readOnly = false)
	public void excluir(ColaboradorMirror cm) {
		ColaboradorTO colaborador = crud(Generics.class).pegar(new ColaboradorTO(cm.getId()));
		crud(Colaborador.class).excluir(colaborador);
	}
	
	@Override
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void saveUpdate(ColaboradorMirror cm) {
		ColaboradorTO to = converterTo(cm);
		if (cm.getId() == null) {
			crud(Colaborador.class).incluir(to);
		} else {
			crud(Colaborador.class).alterar(to);
		}
	}

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public ColaboradorMirror buscar(ColaboradorMirror cm) {
		ColaboradorTO colaborador = crud(Generics.class).buscar(new ColaboradorTO(cm.getId()));
		return converterMirror(colaborador);
	}

	/* Método usado para sincronizar o mirror com o que esta na sessão do Hibernate */
	@Override
	@Transactional(readOnly = true)
	public ColaboradorMirror pegar(ColaboradorMirror cm) {
		ColaboradorTO colaborador = crud(Generics.class).pegar(new ColaboradorTO(cm.getId()));
		return converterMirror(colaborador);
	}
}