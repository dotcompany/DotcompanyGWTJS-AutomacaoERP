package br.com.automacao.service.servlet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.FornecedorService;
import br.com.automacao.ctr.entidade.FornecedorTO;
import br.com.automacao.shared.mirror.FornecedorMirror;
import br.com.dotcompany.hibernate.Generics;

@SuppressWarnings("serial")
@Service("fornecedorManager")
public class FornecedorServiceImpl extends BaseService implements FornecedorService {


	@Override
	@Transactional(readOnly = false)
	public void excluir(FornecedorMirror mm) {
		FornecedorTO fornecedor = crud(Generics.class).pegar(new FornecedorTO(mm.getId()));
		crud(Generics.class).excluir(fornecedor);
	}
	
	@Override
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void saveUpdate(FornecedorMirror mm) {
		FornecedorTO to = converterTo(mm);
		if (mm.getId() == null) {
			crud(Generics.class).incluir(to);
		} else {
			crud(Generics.class).alterar(to);
		}
	} 

	/* Método usado para sincronizar o mirror com o objeto do Banco de Dados */
	@Override
	@Transactional(readOnly = true)
	public FornecedorMirror buscar(FornecedorMirror mm) {
		FornecedorTO fornecedor = crud(Generics.class).buscar(new FornecedorTO(mm.getId()));
		return converterMirror(fornecedor);
	}

	/* Método usado para sincronizar o mirror com o que esta na sessão do Hibernate */
	@Override
	@Transactional(readOnly = true)
	public FornecedorMirror pegar(FornecedorMirror mm) {
		FornecedorTO fornecedor = crud(Generics.class).pegar(new FornecedorTO(mm.getId()));
		return converterMirror(fornecedor);
	}
}
