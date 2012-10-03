package br.com.automacao.client.widget.formularios;

import br.com.automacao.client.widget.DotFormulario;
import br.com.automacao.client.widget.DotTextField;
import br.com.automacao.client.widget.IForm;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.type.ComissaoType;
import br.com.automacao.shared.type.LancaComissaoType;
import br.com.automacao.shared.type.PagComissaoType;
import br.com.automacao.shared.type.SalarioType;
import br.com.automacao.shared.util.Combo;
import br.com.automacao.shared.util.ComboBoxUtils;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class CadColaboradorFinanceiro extends IForm<ColaboradorMirror> {
	
	private TabItem tabItemFinanceiro = new TabItem("Informa\u00E7\u00E3o Financeira");
	private FormPanel formFinanceiro = new FormPanel();
	private DotTextField<String> tfSalario = new DotTextField<String>();
	private ComboBoxUtils<Combo> cbSalarioType = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbComissaoType = new ComboBoxUtils<Combo>();
	private DotTextField<String> tfComissao = new DotTextField<String>();
	private ComboBoxUtils<Combo> cbLancaComissao = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbPagComissao = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbConta = new ComboBoxUtils<Combo>();
	private ComboBoxUtils<Combo> cbPlanoConta = new ComboBoxUtils<Combo>();
	
	public CadColaboradorFinanceiro(){
		super(null);
	}
	
	public CadColaboradorFinanceiro(DotFormulario formulario) {
		super(formulario);
		tabItemFinanceiro.add(formFinanceiro);
		tabItemFinanceiro.setLayout(new FitLayout());
		
		formFinanceiro.setHeaderVisible(false);
		formFinanceiro.setFrame(true);
		formFinanceiro.setCollapsible(true);
		formFinanceiro.setLayout(new AbsoluteLayout());

		tfSalario.onlyNumber();
		tfSalario.buildInput(formFinanceiro, "Sal\u00E1rio fixo", 6, 22, "116", "22", 1);
		tfSalario.focus();
		cbSalarioType.buildInput(formFinanceiro, "Tipo de Sal\u00E1rio fixo", 128, 22, "150", "22", SalarioType.class, 2);

		cbComissaoType.buildInput(formFinanceiro, "Tipo de Comiss\u00E3o", 284, 22, "150", "22", ComissaoType.class, 3);
		tfComissao.buildInput(formFinanceiro, "Comiss\u00E3o", 440, 22, "57", "22", 4);
		tfComissao.onlyNumber();
		
		cbPagComissao.buildInput(formFinanceiro, "Pagamento de comiss\u00E3o ser\u00E1 apartir de...", 6, 71, "276", "22", PagComissaoType.class, 5);
		cbLancaComissao.buildInput(formFinanceiro, "Onde ser\u00E1 lan\u00E7ado a comiss\u00E3o?", 295, 71, "276", "22", LancaComissaoType.class, 6);
		cbConta.createComboBoxEmpty(formFinanceiro, "Tipo de Conta", 6, 128, "276", "22", 7);
		cbPlanoConta.createComboBoxEmpty(formFinanceiro, "Plano de Contas (associado)", 6, 192, "276", "22", 8	);
	}

	@Override
	public void clear() {
		super.doClear(formFinanceiro.getFields());
	}

	@Override
	public void fillDTO(ColaboradorMirror m) {
		if (fieldOk(tfSalario)) {
			m.setSalario(Double.valueOf(tfSalario.getValue().toString()));
		}
		if (fieldOk(cbSalarioType)){
			m.setTipoSalario((SalarioType) cbSalarioType.getValue().getItem());
		}
		if (fieldOk(cbComissaoType)) {
			m.setTipoComissao((ComissaoType) cbComissaoType.getValue().getItem());
		}
		if (fieldOk(tfComissao)) {
			m.setComissao(Double.valueOf(tfComissao.getValue().toString()));
		}
		if (fieldOk(cbPagComissao)) {
			m.setTipoPgComissao((PagComissaoType) cbPagComissao.getValue().getItem());
		}
		if (fieldOk(cbLancaComissao)) {
			m.setTipoLcComissao((LancaComissaoType) cbLancaComissao.getValue().getItem());
		}
		if (fieldOk(cbConta)) {
			//TODO 25/10 Ainda n�o foi definido se ser� criada uma novo objeto no colaborador ou se criar sera somenente somente um flag setada na conta que pertence a lista.
		}
		if (fieldOk(cbPlanoConta)) {
			//TODO 25/10 Ainda n�o foi definido se ser� Implementado.
		}
	}

	@Override
	public TabItem getItem() {
		return tabItemFinanceiro;
	}

	@Override
	public void loadFields(ColaboradorMirror m) {
		if (m.getSalario() != null) {
			tfSalario.setValue(m.getSalario().toString());
		}
		if (m.getTipoSalario() != null){
			cbSalarioType.setValue(new Combo(m.getTipoSalario().getNome(), m.getTipoSalario()));
		}
		if (m.getTipoComissao() != null) {
			cbComissaoType.setValue(new Combo(m.getTipoComissao().getNome(), m.getTipoComissao()));
		}
		if (m.getComissao() != null) {
			tfComissao.setValue(m.getComissao().toString());
		}
		if (m.getTipoPgComissao() != null) {
			cbPagComissao.setValue(new Combo(m.getTipoPgComissao().getNome(), m.getTipoPgComissao()));
		}
		if (m.getTipoLcComissao() != null) {
			cbLancaComissao.setValue(new Combo(m.getTipoLcComissao().getNome(), m.getTipoLcComissao()));
		}
		if (cbConta.getValue() != null) {
			//TODO 25/10 Ainda n�o foi definido se ser� criada uma novo objeto no colaborador ou se criar sera somenente somente um flag setada na conta que pertence a lista.
			
		}
		if (cbPlanoConta.getValue() != null) {
			//TODO 25/10 Ainda n�o foi definido se ser� Implementado.
		}
	}
}