/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fortunato José
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.nome = :nome")
    , @NamedQuery(name = "Usuario.findBySobrenome", query = "SELECT u FROM Usuario u WHERE u.sobrenome = :sobrenome")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByDataNascimento", query = "SELECT u FROM Usuario u WHERE u.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Usuario.findByNivel", query = "SELECT u FROM Usuario u WHERE u.nivel = :nivel")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Column(name = "Sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Senha")
    private String senha;
    @Column(name = "DataNascimento")
    @Temporal(TemporalType.DATE)
    private String dataNascimento;
    @Basic(optional = false)
    @Column(name = "Nivel")
    private String nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Evento> eventoCollection;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(UsuarioPK usuarioPK, String email, String senha, String nivel) {
        this.usuarioPK = usuarioPK;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
    }

    public Usuario(int idUsuario, String nome) {
        this.usuarioPK = new UsuarioPK(idUsuario, nome);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MODELO.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
