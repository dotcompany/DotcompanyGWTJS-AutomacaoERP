package br.com.automacao.shared.fo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Column implements IsSerializable{
	
	private String nome;

	private String label;

	private Boolean ativo;
	
	private String tipoColuna;
	
	private int size;
	
	private int posicao;

	public Column() {
	}
	
	public Column(String nome, String tipoColuna, String label) {
		this(nome, tipoColuna, label, true);
	}
	
	public Column(String nome, String tipoColuna, String label, Boolean ativo) {
		this.nome = nome;
		this.tipoColuna = tipoColuna;
		this.label = label;
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public String getTipoColuna() {
		return tipoColuna;
	}

	public String getLabel() {
		return label;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getPosicao() {
		return posicao;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}