package br.com.automacao.shared.model;

import br.com.automacao.shared.fo.FileColumn;
import br.com.automacao.shared.mirror.ModelosMirror;
import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class ModelosModel extends DotModel{

	public final static String MODELOS 				= "modelos";
	public final static String ID 					= "id";
	public final static String NOME					= "nome";
	public final static String QTDDIASDEGARANTIA 	= "qtddiasdegarantia";
	public final static String TERMOSDAGARANTIA 	= "termosdagarantia";
	
	public ModelosModel() {}
	
	public ModelosModel(FileColumn fc) {
		createColumns(fc);
	}
	
//	public ColaboradorModel(ColaboradorMirror colaborador) {
//		add(colaborador);
//	}
	
	@Override
	public void add(Mirror mirror) {
		dotModel = new ModelosModel();
		ModelosMirror modelos = ((ModelosMirror)mirror); 
		dotModel.set(MODELOS, modelos);
		dotModel.set(ID, modelos.getId());
		dotModel.set(NOME, modelos.getNome());
		dotModel.set(QTDDIASDEGARANTIA, modelos.getQtddiasdegarantia());
		dotModel.set(TERMOSDAGARANTIA, modelos.getTermosdagarantia());
		listModel.add(dotModel);
	}
	
	@Override
	public ModelosMirror getTO() {
		return get(MODELOS);
	}

	public String getQtddiasdegarantia(){
		return get(QTDDIASDEGARANTIA);
	}
	
	public String getTermosdagarantia(){
		return get(TERMOSDAGARANTIA);
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
		fc.addColumn(NOME, "String", "Nome", true);
		fc.addColumn(QTDDIASDEGARANTIA, "String", "Qtd. dias de garantia", true);
		fc.addColumn(TERMOSDAGARANTIA, "String", "Termos da Garantia", true);
	}

	@Override
	public String getValueFind() {
		return NOME;
	}
}