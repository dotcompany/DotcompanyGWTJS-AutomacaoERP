package br.com.automacao.service.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.CnaeService;
import br.com.automacao.ctr.entidade.CnaeTO;
import br.com.automacao.ctr.negocio.Cnae;
import br.com.automacao.shared.mirror.CnaeMirror;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ListUtil;

@SuppressWarnings("serial")
@Service("cnaeManager")
public class CnaeServiceImpl extends BaseService implements CnaeService {

	@Override
	@Transactional(readOnly = true)
	public ListUtil listComboCnae() {
		List<CnaeTO> list = crud(Cnae.class).listAllCnae();
		List<CnaeMirror> listaNew = new ArrayList<CnaeMirror>();
		copyList(list, listaNew);
		List<Combo> itens = new ArrayList<Combo>();
		for (CnaeMirror cm : listaNew) {
			itens.add(new Combo(cm.getNome(), cm));
		}
		return new ListUtil(itens, itens.size());
	}
}