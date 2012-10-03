package br.com.automacao.shared.util;

import java.util.ArrayList;
import java.util.List;

import br.com.automacao.shared.type.AguaType;
import br.com.automacao.shared.type.ArquivoType;
import br.com.automacao.shared.type.CampoType;
import br.com.automacao.shared.type.ChegouType;
import br.com.automacao.shared.type.ClientesType;
import br.com.automacao.shared.type.ComissaoType;
import br.com.automacao.shared.type.ConstrucaoType;
import br.com.automacao.shared.type.ContatoType;
import br.com.automacao.shared.type.ContratacaoType;
import br.com.automacao.shared.type.CriterioType;
import br.com.automacao.shared.type.DirecaoType;
import br.com.automacao.shared.type.EmitirNfType;
import br.com.automacao.shared.type.EmpresaType;
import br.com.automacao.shared.type.EnderecoType;
import br.com.automacao.shared.type.EstadoCivilType;
import br.com.automacao.shared.type.EstadosBrType;
import br.com.automacao.shared.type.FinalidadeType;
import br.com.automacao.shared.type.LancaComissaoType;
import br.com.automacao.shared.type.LetraType;
import br.com.automacao.shared.type.MateriaPrimaType;
import br.com.automacao.shared.type.ModeType;
import br.com.automacao.shared.type.MoradiaType;
import br.com.automacao.shared.type.PagComissaoType;
import br.com.automacao.shared.type.PessoaType;
import br.com.automacao.shared.type.RamoType;
import br.com.automacao.shared.type.ReceitaType;
import br.com.automacao.shared.type.RegimeType;
import br.com.automacao.shared.type.ResideType;
import br.com.automacao.shared.type.SalarioType;
import br.com.automacao.shared.type.SangueType;
import br.com.automacao.shared.type.ServicoType;
import br.com.automacao.shared.type.SexoType;
import br.com.automacao.shared.type.TipoTributacaoECFType;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

class ComboUtils<C extends Combo> extends ComboBox<C> {
	
	protected ListStore<C> states = new ListStore<C>();
	
	@SuppressWarnings("unchecked")
	protected static <T extends Enum> List<Combo> getItensEnum(Class<T> t) {
		List<Combo> itens = new ArrayList<Combo>();
		if (t == AguaType.class) {
			for (AguaType e : AguaType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == SangueType.class) {
			for (SangueType e : SangueType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
			
		}else if (t == PessoaType.class) {
			for (PessoaType e : PessoaType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == EstadoCivilType.class) {
			for (EstadoCivilType e : EstadoCivilType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ArquivoType.class) {
			for (ArquivoType e : ArquivoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == CampoType.class) {
			for (CampoType e : CampoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ChegouType.class) {
			for (ChegouType e : ChegouType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ComissaoType.class) {
			for (ComissaoType e : ComissaoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ConstrucaoType.class) {
			for (ConstrucaoType e : ConstrucaoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ContatoType.class) {
			for (ContatoType e : ContatoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ContratacaoType.class) {
			for (ContratacaoType e : ContratacaoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == CriterioType.class) {
			for (CriterioType e : CriterioType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == DirecaoType.class) {
			for (DirecaoType e : DirecaoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == EmitirNfType.class) {
			for (EmitirNfType e : EmitirNfType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == EmpresaType.class) {
			for (EmpresaType e : EmpresaType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == EnderecoType.class) {
			for (EnderecoType e : EnderecoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == EstadosBrType.class) {
			for (EstadosBrType e : EstadosBrType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		}else if (t == FinalidadeType.class) {
			for (FinalidadeType e : FinalidadeType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		}  else if (t == LancaComissaoType.class) {
			for (LancaComissaoType e : LancaComissaoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == LetraType.class) {
			for (LetraType e : LetraType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == MateriaPrimaType.class) {
			for (MateriaPrimaType e : MateriaPrimaType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ModeType.class) {
			for (ModeType e : ModeType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == MoradiaType.class) {
			for (MoradiaType e : MoradiaType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == PagComissaoType.class) {
			for (PagComissaoType e : PagComissaoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}		
		} else if (t == RamoType.class) {
			for (RamoType e : RamoType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ReceitaType.class) {
			for (ReceitaType e : ReceitaType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == RegimeType.class) {
			for (RegimeType e : RegimeType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == ResideType.class) {
			for (ResideType e : ResideType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		} else if (t == SalarioType.class) {
			for (SalarioType e : SalarioType.values()) {
				itens.add(new Combo(e.getNome(),e));
			}
		} else if (t == ServicoType.class) {
			for (ServicoType e : ServicoType.values()) {
				itens.add(new Combo(e.getNome(),e));
			}
		} else if (t == SexoType.class) {
			for (SexoType e : SexoType.values()) {
				itens.add(new Combo(e.getNome(),e));
			}
		} else if (t == ClientesType.class) {
			for (ClientesType e : ClientesType.values()) {
				itens.add(new Combo(e.getNome(),e));
			}
		} else if (t == TipoTributacaoECFType.class) {
			for (TipoTributacaoECFType e : TipoTributacaoECFType.values()) {
				itens.add(new Combo(e.getNome(), e));
			}
		}  else { throw new RuntimeException("Tipo de Objeto ["+t.getClass()+"] n�o foi definido."); }
		return itens;
	}
}
