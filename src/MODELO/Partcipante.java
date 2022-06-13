/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fortunato José
 */
@Entity
@Table(name = "partcipante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partcipante.findAll", query = "SELECT p FROM Partcipante p")
    , @NamedQuery(name = "Partcipante.findByIdParticipante", query = "SELECT p FROM Partcipante p WHERE p.idParticipante = :idParticipante")
    , @NamedQuery(name = "Partcipante.findByNome", query = "SELECT p FROM Partcipante p WHERE p.nome = :nome")
    , @NamedQuery(name = "Partcipante.findBySobrenome", query = "SELECT p FROM Partcipante p WHERE p.sobrenome = :sobrenome")
    , @NamedQuery(name = "Partcipante.findByCategoria", query = "SELECT p FROM Partcipante p WHERE p.categoria = :categoria")})
public class Partcipante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdParticipante")
    private Integer idParticipante;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @Column(name = "Categoria")
    private String categoria;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "partcipante")
    private Participa participa;

    public Partcipante() {
    }

    public Partcipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Partcipante(Integer idParticipante, String nome, String sobrenome, String categoria) {
        this.idParticipante = idParticipante;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.categoria = categoria;
    }

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Participa getParticipa() {
        return participa;
    }

    public void setParticipa(Participa participa) {
        this.participa = participa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipante != null ? idParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partcipante)) {
            return false;
        }
        Partcipante other = (Partcipante) object;
        if ((this.idParticipante == null && other.idParticipante != null) || (this.idParticipante != null && !this.idParticipante.equals(other.idParticipante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Partcipante[ idParticipante=" + idParticipante + " ]";
    }
    
}
