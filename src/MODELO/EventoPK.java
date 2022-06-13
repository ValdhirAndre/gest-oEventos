/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Fortunato José
 */
@Embeddable
public class EventoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idEvento")
    private int idEvento;
    @Basic(optional = false)
    @Column(name = "NomeEvento")
    private String nomeEvento;

    public EventoPK() {
    }

    public EventoPK(int idEvento, String nomeEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvento;
        hash += (nomeEvento != null ? nomeEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoPK)) {
            return false;
        }
        EventoPK other = (EventoPK) object;
        if (this.idEvento != other.idEvento) {
            return false;
        }
        if ((this.nomeEvento == null && other.nomeEvento != null) || (this.nomeEvento != null && !this.nomeEvento.equals(other.nomeEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.EventoPK[ idEvento=" + idEvento + ", nomeEvento=" + nomeEvento + " ]";
    }
    
}
