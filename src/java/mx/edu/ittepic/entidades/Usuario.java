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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByNombreusuario", query = "SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Usuario.findByApellidousuario", query = "SELECT u FROM Usuario u WHERE u.apellidousuario = :apellidousuario")
    , @NamedQuery(name = "Usuario.findByPasswordusuario", query = "SELECT u FROM Usuario u WHERE u.passwordusuario = :passwordusuario")
    , @NamedQuery(name = "Usuario.findByRegionusuario", query = "SELECT u FROM Usuario u WHERE u.regionusuario = :regionusuario")
    , @NamedQuery(name = "Usuario.findByContactousuario", query = "SELECT u FROM Usuario u WHERE u.contactousuario = :contactousuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellidousuario")
    private String apellidousuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "passwordusuario")
    private String passwordusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "regionusuario")
    private String regionusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "contactousuario")
    private String contactousuario;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nombreusuario, String apellidousuario, String passwordusuario, String regionusuario, String contactousuario) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.apellidousuario = apellidousuario;
        this.passwordusuario = passwordusuario;
        this.regionusuario = regionusuario;
        this.contactousuario = contactousuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getApellidousuario() {
        return apellidousuario;
    }

    public void setApellidousuario(String apellidousuario) {
        this.apellidousuario = apellidousuario;
    }

    public String getPasswordusuario() {
        return passwordusuario;
    }

    public void setPasswordusuario(String passwordusuario) {
        this.passwordusuario = passwordusuario;
    }

    public String getRegionusuario() {
        return regionusuario;
    }

    public void setRegionusuario(String regionusuario) {
        this.regionusuario = regionusuario;
    }

    public String getContactousuario() {
        return contactousuario;
    }

    public void setContactousuario(String contactousuario) {
        this.contactousuario = contactousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
