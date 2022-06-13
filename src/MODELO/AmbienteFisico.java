/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fortunato José
 */
@Entity
@Table(name = "ambiente_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbienteFisico.findAll", query = "SELECT a FROM AmbienteFisico a")
    , @NamedQuery(name = "AmbienteFisico.findByIdAmbiente", query = "SELECT a FROM AmbienteFisico a WHERE a.idAmbiente = :idAmbiente")
    , @NamedQuery(name = "AmbienteFisico.findByAmbiente", query = "SELECT a FROM AmbienteFisico a WHERE a.ambiente = :ambiente")})
public class AmbienteFisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdAmbiente")
    private Integer idAmbiente;
    @Basic(optional = false)
    @Column(name = "Ambiente")
    private String ambiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambienteFisico")
    private Collection<Evento> eventoCollection;

    public AmbienteFisico() {
    }

    public AmbienteFisico(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public AmbienteFisico(Integer idAmbiente, String ambiente) {
        this.idAmbiente = idAmbiente;
        this.ambiente = ambiente;
    }

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbiente != null ? idAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbienteFisico)) {
            return false;
        }
        AmbienteFisico other = (AmbienteFisico) object;
        if ((this.idAmbiente == null && other.idAmbiente != null) || (this.idAmbiente != null && !this.idAmbiente.equals(other.idAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.AmbienteFisico[ idAmbiente=" + idAmbiente + " ]";
    }
    
}
