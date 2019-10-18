/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanielaMarcela
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByIdadministrador", query = "SELECT a FROM Administrador a WHERE a.idadministrador = :idadministrador")
    , @NamedQuery(name = "Administrador.findByNombreadministrador", query = "SELECT a FROM Administrador a WHERE a.nombreadministrador = :nombreadministrador")
    , @NamedQuery(name = "Administrador.findByApellidoadministrador", query = "SELECT a FROM Administrador a WHERE a.apellidoadministrador = :apellidoadministrador")
    , @NamedQuery(name = "Administrador.findByPasswordadministrador", query = "SELECT a FROM Administrador a WHERE a.passwordadministrador = :passwordadministrador")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idadministrador")
    private Integer idadministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreadministrador")
    private String nombreadministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellidoadministrador")
    private String apellidoadministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "passwordadministrador")
    private String passwordadministrador;

    public Administrador() {
    }

    public Administrador(Integer idadministrador) {
        this.idadministrador = idadministrador;
    }

    public Administrador(Integer idadministrador, String nombreadministrador, String apellidoadministrador, String passwordadministrador) {
        this.idadministrador = idadministrador;
        this.nombreadministrador = nombreadministrador;
        this.apellidoadministrador = apellidoadministrador;
        this.passwordadministrador = passwordadministrador;
    }

    public Integer getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(Integer idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getNombreadministrador() {
        return nombreadministrador;
    }

    public void setNombreadministrador(String nombreadministrador) {
        this.nombreadministrador = nombreadministrador;
    }

    public String getApellidoadministrador() {
        return apellidoadministrador;
    }

    public void setApellidoadministrador(String apellidoadministrador) {
        this.apellidoadministrador = apellidoadministrador;
    }

    public String getPasswordadministrador() {
        return passwordadministrador;
    }

    public void setPasswordadministrador(String passwordadministrador) {
        this.passwordadministrador = passwordadministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadministrador != null ? idadministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idadministrador == null && other.idadministrador != null) || (this.idadministrador != null && !this.idadministrador.equals(other.idadministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Administrador[ idadministrador=" + idadministrador + " ]";
    }
    
}
