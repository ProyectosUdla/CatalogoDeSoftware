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
@Table(name = "AreaFuncional")
@NamedQueries({
    @NamedQuery(name = "AreaFuncional.findAll", query = "SELECT a FROM AreaFuncional a"),
    @NamedQuery(name = "AreaFuncional.findByIdAreaFuncional", query = "SELECT a FROM AreaFuncional a WHERE a.idAreaFuncional = :idAreaFuncional"),
    @NamedQuery(name = "AreaFuncional.findByNombre", query = "SELECT a FROM AreaFuncional a WHERE a.nombre = :nombre")})
public class AreaFuncional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_AreaFuncional")
    private Integer idAreaFuncional;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaFuncional")
    private List<Software> softwareList;

    public AreaFuncional() {
    }

    public AreaFuncional(Integer idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public Integer getIdAreaFuncional() {
        return idAreaFuncional;
    }

    public void setIdAreaFuncional(Integer idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idAreaFuncional != null ? idAreaFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaFuncional)) {
            return false;
        }
        AreaFuncional other = (AreaFuncional) object;
        if ((this.idAreaFuncional == null && other.idAreaFuncional != null) || (this.idAreaFuncional != null && !this.idAreaFuncional.equals(other.idAreaFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.AreaFuncional[ idAreaFuncional=" + idAreaFuncional + " ]";
    }
    
}
