package br.com.automacao.shared.dto;

import br.com.automacao.shared.util.Mirror;

@SuppressWarnings("serial")
public class CepDTO extends Mirror {
	
	private String cep;
	
	private String bairro;
	
	private String cidade;
	
	private String  uf;
	
	private String  logradouro;
	
	private String  logradouroFull;
	
	private String  logradouroType;
	
	public CepDTO() {}
	
	public CepDTO(String cep, String bairro, String cidade, String uf,
			String logradouro, String logradouroFull, String logradouroType) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.logradouro = logradouro;
		this.logradouroFull = logradouroFull;
		this.logradouroType = logradouroType;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLogradouroFull() {
		return logradouroFull;
	}

	public void setLogradouroFull(String logradouroFull) {
		this.logradouroFull = logradouroFull;
	}

	public String getLogradouroType() {
		return logradouroType;
	}

	public void setLogradouroType(String logradouroType) {
		this.logradouroType = logradouroType;
	}
}