package br.com.automacao.service.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.NcmService;
import br.com.automacao.ctr.entidade.NCMTO;
import br.com.automacao.ctr.negocio.Ncm;
import br.com.automacao.shared.mirror.NCMMirror;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ListUtil;

@SuppressWarnings("serial")
@Service("ncmManager")
public class NcmServiceImpl extends BaseService implements NcmService {
	@Transactional(readOnly = true)
	@Override
	public ListUtil listComboAll() {
		List<NCMTO> list = crud(Ncm.class).listComboAll();
		List<NCMMirror> listaNew = new ArrayList<NCMMirror>();
		copyList(list, listaNew);
		List<Combo> itens = new ArrayList<Combo>();
		for (NCMMirror cm : listaNew) {
			itens.add(new Combo(cm.getNome(), cm));
		}
		return new ListUtil(itens, itens.size());
	}

	@Override
	public void alterar(NCMMirror nm) {
		
	}

	@Override
	public NCMMirror buscar(NCMMirror nm) {
		return null;
	}

	@Override
	public void excluir(NCMMirror nm) {
		
	}

	@Override
	public void incluir(NCMMirror nm) {
		
	}

	@Override
	public NCMMirror pegar(NCMMirror nm) {
		return null;
	}

	@Override
	public void saveUpdate(NCMMirror nm) {
		
	}
}