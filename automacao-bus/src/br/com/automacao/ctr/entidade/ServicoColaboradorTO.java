package br.com.automacao.ctr.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dotcompany.to.TransferObject;

/**
 * <b>Projeto:</b> automacao-bus <br>
 * <b>Pacote:</b> br.com.automacao.ctr.server.to <br>
 * <b>Título:</b> AgCidadeAtuacaoTO.java <br>
 * <b>Descrição:</b> <br>
 *
 * <b>Autor:</b> DotCompany TI
 * <b>Criação:</b> 25/08/2011, 09:52:25
 */
@SuppressWarnings("serial")
@Entity
@Table(name="servico_colaborador")
public class ServicoColaboradorTO extends TransferObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long 							id;
	
	@ManyToOne
	@JoinColumn(name = "id_colaborador", nullable = false)
	private ColaboradorTO						colaborador;

	public ServicoColaboradorTO(Long id) {
		this.id = id;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ColaboradorTO getColaborador() {
		return colaborador;
	}
	public void setColaborador(ColaboradorTO colaborador) {
		this.colaborador = colaborador;
	}
	@Override
	public Serializable getKey() {
		return getId();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}