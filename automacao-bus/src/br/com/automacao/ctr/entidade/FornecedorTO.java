package br.com.automacao.ctr.entidade;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.dotcompany.to.TransferObject;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Value Object usado para armazenar um fornecedor.</p>
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
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "FornecedorTO.findAll", query = "SELECT f FROM FornecedorTO f"),
    @NamedQuery(name = "FornecedorTO.findById", query = "SELECT f FROM FornecedorTO f WHERE f.id = :id"),
    @NamedQuery(name = "FornecedorTO.findByNome", query = "SELECT f FROM FornecedorTO f WHERE f.nome = :nome"),
    @NamedQuery(name = "FornecedorTO.findByCpfCnpj", query = "SELECT f FROM FornecedorTO f WHERE f.cpfCnpj = :cpfCnpj"),
    @NamedQuery(name = "FornecedorTO.findByRg", query = "SELECT f FROM FornecedorTO f WHERE f.rg = :rg"),
    @NamedQuery(name = "FornecedorTO.findByOrgaoRg", query = "SELECT f FROM FornecedorTO f WHERE f.orgaoRg = :orgaoRg"),
    @NamedQuery(name = "FornecedorTO.findByInscricaoEstadal", query = "SELECT f FROM FornecedorTO f WHERE f.inscricaoEstadal = :inscricaoEstadal"),
    @NamedQuery(name = "FornecedorTO.findByInscricaoMunicipal", query = "SELECT f FROM FornecedorTO f WHERE f.inscricaoMunicipal = :inscricaoMunicipal"),
    @NamedQuery(name = "FornecedorTO.findByDesde", query = "SELECT f FROM FornecedorTO f WHERE f.desde = :desde"),
    @NamedQuery(name = "FornecedorTO.findByTipoPessoa", query = "SELECT f FROM FornecedorTO f WHERE f.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "FornecedorTO.findByExcluido", query = "SELECT f FROM FornecedorTO f WHERE f.excluido = :excluido"),
    @NamedQuery(name = "FornecedorTO.findByDataCadastro", query = "SELECT f FROM FornecedorTO f WHERE f.dataCadastro = :dataCadastro")})
public class FornecedorTO extends TransferObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    /*
    @Basic(optional = false)
    @Column(name = "SITUACAO_FOR_CLI_ID", nullable = false)
    private int situacaoForCliId;
    @Basic(optional = false)
    @Column(name = "TIPO_FORNECEDOR_ID", nullable = false)
    private int tipoFornecedorId;
    @Basic(optional = false)
    @Column(name = "ID_EMPRESA", nullable = false)
    private int idEmpresa;
     *
     */
    @Column(name = "NOME", length = 150)
    private String nome;
    @Column(name = "CPF_CNPJ", length = 14)
    private String cpfCnpj;
    @Column(name = "RG", length = 20)
    private String rg;
    @Column(name = "ORGAO_RG", length = 10)
    private String orgaoRg;
    @Column(name = "INSCRICAO_ESTADAL", length = 30)
    private String inscricaoEstadal;
    @Column(name = "INSCRICAO_MUNICIPAL", length = 30)
    private String inscricaoMunicipal;
    @Column(name = "DESDE")
    private Date desde;
    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;
    @Column(name = "EXCLUIDO")
    private String excluido;
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    /*
     * Mapeamento Empresa-Fornecedor
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_EMPRESA",
    insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private EmpresaTO empresa;
    
    public FornecedorTO() {
    }

    public FornecedorTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoRg() {
        return orgaoRg;
    }

    public void setOrgaoRg(String orgaoRg) {
        this.orgaoRg = orgaoRg;
    }

    public String getInscricaoEstadal() {
        return inscricaoEstadal;
    }

    public void setInscricaoEstadal(String inscricaoEstadal) {
        this.inscricaoEstadal = inscricaoEstadal;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getExcluido() {
        return excluido;
    }

    public void setExcluido(String excluido) {
        this.excluido = excluido;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    /**
     * @return the empresa
     */
    public EmpresaTO getEmpresa() {
        return empresa;
    }
    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(EmpresaTO empresa) {
        this.empresa = empresa;
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
        if (!(object instanceof FornecedorTO)) {
            return false;
        }
        FornecedorTO other = (FornecedorTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return this.getNome();
	}

	@Override
	public Serializable getKey() {
		// TODO Auto-generated method stub
		return getId();
	}

}
