package br.com.automacao.service.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.client.service.FuncaoService;
import br.com.automacao.ctr.entidade.FuncaoTO;
import br.com.automacao.ctr.negocio.Funcao;
import br.com.automacao.shared.mirror.FuncaoMirror;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ListUtil;

@SuppressWarnings("serial")
@Service("funcaoManager")
public class FuncaoServiceImpl extends BaseService implements FuncaoService {

	@Override
	@Transactional(readOnly = true)
	public ListUtil listComboFuncao() {
		List<FuncaoTO> list = crud(Funcao.class).listAllFuncao();
		List<FuncaoMirror> listaNew = new ArrayList<FuncaoMirror>();
		copyList(list, listaNew);
		List<Combo> itens = new ArrayList<Combo>();
		for (FuncaoMirror mirror : listaNew) {
			itens.add(new Combo(mirror.getDescricaoMenu(), mirror));
		}
		return new ListUtil(itens, itens.size());
	}
}