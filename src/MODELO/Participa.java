/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fortunato José
 */
@Entity
@Table(name = "participa")
@NamedQueries({
    @NamedQuery(name = "Participa.findAll", query = "SELECT p FROM Participa p")
    , @NamedQuery(name = "Participa.findByIdParticipa", query = "SELECT p FROM Participa p WHERE p.idParticipa = :idParticipa")
    , @NamedQuery(name = "Participa.findByDataParticipa", query = "SELECT p FROM Participa p WHERE p.dataParticipa = :dataParticipa")})
public class Participa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idParticipa")
    private Integer idParticipa;
    @Column(name = "DataParticipa")
    @Temporal(TemporalType.DATE)
    private Date dataParticipa;
    @JoinColumn(name = "idParticipa", referencedColumnName = "idEvento", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Evento evento;
    @JoinColumn(name = "idParticipa", referencedColumnName = "IdParticipante", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Partcipante partcipante;

    public Participa() {
    }

    public Participa(Integer idParticipa) {
        this.idParticipa = idParticipa;
    }

    public Integer getIdParticipa() {
        return idParticipa;
    }

    public void setIdParticipa(Integer idParticipa) {
        this.idParticipa = idParticipa;
    }

    public Date getDataParticipa() {
        return dataParticipa;
    }

    public void setDataParticipa(Date dataParticipa) {
        this.dataParticipa = dataParticipa;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Partcipante getPartcipante() {
        return partcipante;
    }

    public void setPartcipante(Partcipante partcipante) {
        this.partcipante = partcipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipa != null ? idParticipa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participa)) {
            return false;
        }
        Participa other = (Participa) object;
        if ((this.idParticipa == null && other.idParticipa != null) || (this.idParticipa != null && !this.idParticipa.equals(other.idParticipa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Participa[ idParticipa=" + idParticipa + " ]";
    }
    
}
