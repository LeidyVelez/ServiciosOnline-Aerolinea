/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "puertaabordaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puertaabordaje.findAll", query = "SELECT p FROM Puertaabordaje p"),
    @NamedQuery(name = "Puertaabordaje.findByIdPuertaAbordaje", query = "SELECT p FROM Puertaabordaje p WHERE p.idPuertaAbordaje = :idPuertaAbordaje"),
    @NamedQuery(name = "Puertaabordaje.findByNumeroPuerta", query = "SELECT p FROM Puertaabordaje p WHERE p.numeroPuerta = :numeroPuerta")})
public class Puertaabordaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idPuertaAbordaje")
    private String idPuertaAbordaje;
    @Column(name = "numeroPuerta")
    private Integer numeroPuerta;
    @JoinColumn(name = "aeropuerto", referencedColumnName = "idAeropuerto")
    @ManyToOne
    private Aeropuerto aeropuerto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertaAbordaje")
    private List<Paseabordaje> paseabordajeList;

    public Puertaabordaje() {
    }

    public Puertaabordaje(String idPuertaAbordaje) {
        this.idPuertaAbordaje = idPuertaAbordaje;
    }

    public String getIdPuertaAbordaje() {
        return idPuertaAbordaje;
    }

    public void setIdPuertaAbordaje(String idPuertaAbordaje) {
        this.idPuertaAbordaje = idPuertaAbordaje;
    }

    public Integer getNumeroPuerta() {
        return numeroPuerta;
    }

    public void setNumeroPuerta(Integer numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    @XmlTransient
    public List<Paseabordaje> getPaseabordajeList() {
        return paseabordajeList;
    }

    public void setPaseabordajeList(List<Paseabordaje> paseabordajeList) {
        this.paseabordajeList = paseabordajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuertaAbordaje != null ? idPuertaAbordaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puertaabordaje)) {
            return false;
        }
        Puertaabordaje other = (Puertaabordaje) object;
        if ((this.idPuertaAbordaje == null && other.idPuertaAbordaje != null) || (this.idPuertaAbordaje != null && !this.idPuertaAbordaje.equals(other.idPuertaAbordaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Puertaabordaje[ idPuertaAbordaje=" + idPuertaAbordaje + " ]";
    }
    
}
