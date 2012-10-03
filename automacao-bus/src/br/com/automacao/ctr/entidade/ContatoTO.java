package br.com.automacao.ctr.entidade;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.dotcompany.to.TransferObject;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Value Object usado para armazenar um contato. O contato pode
 * estar relacionado a um fornecedor, um cliente, a empresa e a um colaborador</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 *       The author may be contacted at:
 *           t2ti.com@gmail.com</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
@Entity
@Table(name = "contato")
@NamedQueries({
    @NamedQuery(name = "ContatoVO.findAll", query = "SELECT c FROM ContatoVO c"),
    @NamedQuery(name = "ContatoVO.findById", query = "SELECT c FROM ContatoVO c WHERE c.id = :id"),
    @NamedQuery(name = "ContatoVO.findByEmpresaId", query = "SELECT c FROM ContatoVO c WHERE c.empresaId = :empresaId"),
    @NamedQuery(name = "ContatoVO.findByColaboradorId", query = "SELECT c FROM ContatoVO c WHERE c.colaboradorId = :colaboradorId"),
    @NamedQuery(name = "ContatoVO.findByClienteId", query = "SELECT c FROM ContatoVO c WHERE c.clienteId = :clienteId"),
    @NamedQuery(name = "ContatoVO.findByFornecedorId", query = "SELECT c FROM ContatoVO c WHERE c.fornecedorId = :fornecedorId"),
    @NamedQuery(name = "ContatoVO.findByNome", query = "SELECT c FROM ContatoVO c WHERE c.nome = :nome"),
    @NamedQuery(name = "ContatoVO.findByDono", query = "SELECT c FROM ContatoVO c WHERE c.dono = :dono")})
public class ContatoTO extends TransferObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "EMPRESA_ID")
    private Integer empresaId;
    @Column(name = "COLABORADOR_ID")
    private Integer colaboradorId;
    @Column(name = "CLIENTE_ID")
    private Integer clienteId;
    @Column(name = "FORNECEDOR_ID")
    private Integer fornecedorId;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "DONO")
    private Character dono;

    public ContatoTO() {
    }

    public ContatoTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Integer getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Integer colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Integer fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getDono() {
        return dono;
    }

    public void setDono(Character dono) {
        this.dono = dono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContatoTO)) {
            return false;
        }
        ContatoTO other = (ContatoTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

	@Override
	public Serializable getKey() {
		// TODO Auto-generated method stub
		return getId();
	}

}
