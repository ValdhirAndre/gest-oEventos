/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fortunato José
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByIdEvento", query = "SELECT e FROM Evento e WHERE e.eventoPK.idEvento = :idEvento")
    , @NamedQuery(name = "Evento.findByNomeEvento", query = "SELECT e FROM Evento e WHERE e.eventoPK.nomeEvento = :nomeEvento")
    , @NamedQuery(name = "Evento.findByDataEvento", query = "SELECT e FROM Evento e WHERE e.dataEvento = :dataEvento")
    , @NamedQuery(name = "Evento.findByDuracao", query = "SELECT e FROM Evento e WHERE e.duracao = :duracao")
    , @NamedQuery(name = "Evento.findByAvaliacao", query = "SELECT e FROM Evento e WHERE e.avaliacao = :avaliacao")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventoPK eventoPK;
    @Basic(optional = false)
    @Column(name = "DataEvento")
    @Temporal(TemporalType.TIME)
    private Date dataEvento;
    @Lob
    @Column(name = "Descricaco")
    private String descricaco;
    @Basic(optional = false)
    @Column(name = "Duracao")
    @Temporal(TemporalType.TIME)
    private Date duracao;
    @Basic(optional = false)
    @Column(name = "Avaliacao")
    private String avaliacao;
    @JoinColumn(name = "idEvento", referencedColumnName = "IdAmbiente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AmbienteFisico ambienteFisico;
    @JoinColumn(name = "idEvento", referencedColumnName = "IdUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "evento")
    private Participa participa;

    public Evento() {
    }

    public Evento(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public Evento(EventoPK eventoPK, Date dataEvento, Date duracao, String avaliacao) {
        this.eventoPK = eventoPK;
        this.dataEvento = dataEvento;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
    }

    public Evento(int idEvento, String nomeEvento) {
        this.eventoPK = new EventoPK(idEvento, nomeEvento);
    }

    public EventoPK getEventoPK() {
        return eventoPK;
    }

    public void setEventoPK(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescricaco() {
        return descricaco;
    }

    public void setDescricaco(String descricaco) {
        this.descricaco = descricaco;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public AmbienteFisico getAmbienteFisico() {
        return ambienteFisico;
    }

    public void setAmbienteFisico(AmbienteFisico ambienteFisico) {
        this.ambienteFisico = ambienteFisico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (eventoPK != null ? eventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.eventoPK == null && other.eventoPK != null) || (this.eventoPK != null && !this.eventoPK.equals(other.eventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Evento[ eventoPK=" + eventoPK + " ]";
    }
    
}
