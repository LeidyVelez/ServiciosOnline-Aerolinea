/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "aeropuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a"),
    @NamedQuery(name = "Aeropuerto.findByIdAeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.idAeropuerto = :idAeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByNombre", query = "SELECT a FROM Aeropuerto a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aeropuerto.findByTipo", query = "SELECT a FROM Aeropuerto a WHERE a.tipo = :tipo")})
public class Aeropuerto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idAeropuerto")
    private String idAeropuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "ciudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @OneToMany(mappedBy = "aeropuerto")
    private List<Puertaabordaje> puertaabordajeList;

    public Aeropuerto() {
    }

    public Aeropuerto(String idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public Aeropuerto(String idAeropuerto, String nombre, String tipo) {
        this.idAeropuerto = idAeropuerto;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getIdAeropuerto() {
        return idAeropuerto;
    }

    public void setIdAeropuerto(String idAeropuerto) {
        this.idAeropuerto = idAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Puertaabordaje> getPuertaabordajeList() {
        return puertaabordajeList;
    }

    public void setPuertaabordajeList(List<Puertaabordaje> puertaabordajeList) {
        this.puertaabordajeList = puertaabordajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAeropuerto != null ? idAeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.idAeropuerto == null && other.idAeropuerto != null) || (this.idAeropuerto != null && !this.idAeropuerto.equals(other.idAeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Aeropuerto[ idAeropuerto=" + idAeropuerto + " ]";
    }
    
}
