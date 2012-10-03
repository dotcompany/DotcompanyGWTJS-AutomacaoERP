package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.ColaboradorMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class ColaboradorModel extends DotModel{

	public final static String COLABORADOR 		= "colaborador";
	public final static String ID 				= "id";
	public final static String CPF 				= "cpf";
	public final static String NOME				= "nome";
	
	public ColaboradorModel() {}
	
	public ColaboradorModel(FileColumn fc) {
		createColumns(fc);
	}
	
//	public ColaboradorModel(ColaboradorMirror colaborador) {
//		add(colaborador);
//	}
	
	@Override
	public void add(Mirror mirror) {
		dotModel = new ColaboradorModel();
		ColaboradorMirror colaborador = ((ColaboradorMirror)mirror); 
		dotModel.set(COLABORADOR, colaborador);
		dotModel.set(CPF, colaborador.getCpf());
		dotModel.set(NOME, colaborador.getNome());
		dotModel.set(ID, colaborador.getId());
		listModel.add(dotModel);
	}
	
	@Override
	public ColaboradorMirror getTO() {
		return get(COLABORADOR);
	}

	public String getCpf(){
		return get(CPF);
	}
	
	public String getNome(){
		return get(NOME);
	}

	@Override
	public String getSecond() {
		return getNome();
	}

	@Override
	protected void createColumns(FileColumn fc) {
		fc.addColumn(ID, "String", "Código", true);
		fc.addColumn(CPF, "String", "Cpf", true);
		fc.addColumn(NOME, "String", "Nome", true);
	}

	@Override
	public String getValueFind() {
		return NOME;
	}
}