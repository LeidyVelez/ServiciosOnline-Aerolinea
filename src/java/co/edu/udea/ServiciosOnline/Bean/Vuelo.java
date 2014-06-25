/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByIdVuelo", query = "SELECT v FROM Vuelo v WHERE v.idVuelo = :idVuelo"),
    @NamedQuery(name = "Vuelo.findByEstado", query = "SELECT v FROM Vuelo v WHERE v.estado = :estado"),
    @NamedQuery(name = "Vuelo.findByFechaSalida", query = "SELECT v FROM Vuelo v WHERE v.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Vuelo.findByFechaLlegada", query = "SELECT v FROM Vuelo v WHERE v.fechaLlegada = :fechaLlegada")})
public class Vuelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idVuelo")
    private String idVuelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaLlegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @ManyToMany(mappedBy = "vueloList")
    private List<Itinerario> itinerarioList;
    @JoinColumn(name = "ciudadOrigen", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad ciudadOrigen;
    @JoinColumn(name = "cuidadDestino", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad cuidadDestino;
    @JoinColumn(name = "avion", referencedColumnName = "idAvion")
    @ManyToOne(optional = false)
    private Avion avion;

    public Vuelo() {
    }

    public Vuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Vuelo(String idVuelo, String estado, Date fechaSalida, Date fechaLlegada) {
        this.idVuelo = idVuelo;
        this.estado = estado;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    @XmlTransient
    public List<Itinerario> getItinerarioList() {
        return itinerarioList;
    }

    public void setItinerarioList(List<Itinerario> itinerarioList) {
        this.itinerarioList = itinerarioList;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCuidadDestino() {
        return cuidadDestino;
    }

    public void setCuidadDestino(Ciudad cuidadDestino) {
        this.cuidadDestino = cuidadDestino;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVuelo != null ? idVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idVuelo == null && other.idVuelo != null) || (this.idVuelo != null && !this.idVuelo.equals(other.idVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Vuelo[ idVuelo=" + idVuelo + " ]";
    }
    
}
