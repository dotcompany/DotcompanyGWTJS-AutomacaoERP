package br.com.automacao.service.servlet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.automacao.client.service.MarcaService;
import br.com.automacao.ctr.entidade.MarcaTO;
import br.com.automacao.ctr.negocio.Marca;
import br.com.automacao.shared.mirror.MarcaMirror;
import br.com.dotcompany.hibernate.Generics;

@SuppressWarnings("serial")
@Service("marcaManager")
public class MarcaServiceImpl extends BaseService implements MarcaService {


	@Override
	@Transactional(readOnly = false)
	public void excluir(MarcaMirror mm) {
		MarcaTO marca = crud(Generics.class).pegar(new MarcaTO(mm.getId()));
		crud(Marca.class).excluir(marca);
	}
	
	@Override
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void saveUpdate(MarcaMirror mm) {
		MarcaTO to = converterTo(mm);
		if (mm.getId() == null) {
			crud(Marca.class).incluir(to);
		} else {
			crud(Marca.class).alterar(to);
		}
	} 

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public MarcaMirror buscar(MarcaMirror mm) {
		MarcaTO marca = crud(Generics.class).buscar(new MarcaTO(mm.getId()));
		return converterMirror(marca);
	}

	/* Método usado para sincronizar o mirror com o que esta na sessão do Hibernate */
	@Override
	@Transactional(readOnly = true)
	public MarcaMirror pegar(MarcaMirror mm) {
		MarcaTO marca = crud(Generics.class).pegar(new MarcaTO(mm.getId()));
		return converterMirror(marca);
	}
}
