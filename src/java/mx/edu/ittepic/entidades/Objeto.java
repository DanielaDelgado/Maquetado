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
@Table(name = "objeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objeto.findAll", query = "SELECT o FROM Objeto o")
    , @NamedQuery(name = "Objeto.findByIdobjeto", query = "SELECT o FROM Objeto o WHERE o.idobjeto = :idobjeto")
    , @NamedQuery(name = "Objeto.findByNombreobjeto", query = "SELECT o FROM Objeto o WHERE o.nombreobjeto = :nombreobjeto")
    , @NamedQuery(name = "Objeto.findByImagenobjeto", query = "SELECT o FROM Objeto o WHERE o.imagenobjeto = :imagenobjeto")
    , @NamedQuery(name = "Objeto.findByDescripcionobjeto", query = "SELECT o FROM Objeto o WHERE o.descripcionobjeto = :descripcionobjeto")
    , @NamedQuery(name = "Objeto.findByIdusuario", query = "SELECT o FROM Objeto o WHERE o.idusuario = :idusuario")})
public class Objeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idobjeto")
    private Integer idobjeto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombreobjeto")
    private String nombreobjeto;
    @Size(max = 300)
    @Column(name = "imagenobjeto")
    private String imagenobjeto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descripcionobjeto")
    private String descripcionobjeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public Objeto() {
    }

    public Objeto(Integer idobjeto) {
        this.idobjeto = idobjeto;
    }

    public Objeto(Integer idobjeto, String nombreobjeto, String descripcionobjeto, int idusuario) {
        this.idobjeto = idobjeto;
        this.nombreobjeto = nombreobjeto;
        this.descripcionobjeto = descripcionobjeto;
        this.idusuario = idusuario;
    }

    public Integer getIdobjeto() {
        return idobjeto;
    }

    public void setIdobjeto(Integer idobjeto) {
        this.idobjeto = idobjeto;
    }

    public String getNombreobjeto() {
        return nombreobjeto;
    }

    public void setNombreobjeto(String nombreobjeto) {
        this.nombreobjeto = nombreobjeto;
    }

    public String getImagenobjeto() {
        return imagenobjeto;
    }

    public void setImagenobjeto(String imagenobjeto) {
        this.imagenobjeto = imagenobjeto;
    }

    public String getDescripcionobjeto() {
        return descripcionobjeto;
    }

    public void setDescripcionobjeto(String descripcionobjeto) {
        this.descripcionobjeto = descripcionobjeto;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobjeto != null ? idobjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objeto)) {
            return false;
        }
        Objeto other = (Objeto) object;
        if ((this.idobjeto == null && other.idobjeto != null) || (this.idobjeto != null && !this.idobjeto.equals(other.idobjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Objeto[ idobjeto=" + idobjeto + " ]";
    }
    
}
