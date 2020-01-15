/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "Lenguaje")
@NamedQueries({
    @NamedQuery(name = "Lenguaje.findAll", query = "SELECT l FROM Lenguaje l"),
    @NamedQuery(name = "Lenguaje.findByIdLenguaje", query = "SELECT l FROM Lenguaje l WHERE l.idLenguaje = :idLenguaje"),
    @NamedQuery(name = "Lenguaje.findByNombreLenguaje", query = "SELECT l FROM Lenguaje l WHERE l.nombreLenguaje = :nombreLenguaje"),
    @NamedQuery(name = "Lenguaje.findByFramework", query = "SELECT l FROM Lenguaje l WHERE l.framework = :framework"),
    @NamedQuery(name = "Lenguaje.findByFrontEnd", query = "SELECT l FROM Lenguaje l WHERE l.frontEnd = :frontEnd")})
public class Lenguaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Lenguaje")
    private Integer idLenguaje;
    @Size(max = 45)
    @Column(name = "nombreLenguaje")
    private String nombreLenguaje;
    @Size(max = 45)
    @Column(name = "framework")
    private String framework;
    @Size(max = 45)
    @Column(name = "frontEnd")
    private String frontEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLenguaje")
    private List<Software> softwareList;

    public Lenguaje() {
    }

    public Lenguaje(Integer idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public Integer getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(Integer idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public String getNombreLenguaje() {
        return nombreLenguaje;
    }

    public void setNombreLenguaje(String nombreLenguaje) {
        this.nombreLenguaje = nombreLenguaje;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getFrontEnd() {
        return frontEnd;
    }

    public void setFrontEnd(String frontEnd) {
        this.frontEnd = frontEnd;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLenguaje != null ? idLenguaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lenguaje)) {
            return false;
        }
        Lenguaje other = (Lenguaje) object;
        if ((this.idLenguaje == null && other.idLenguaje != null) || (this.idLenguaje != null && !this.idLenguaje.equals(other.idLenguaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Lenguaje[ idLenguaje=" + idLenguaje + " ]";
    }
    
}
