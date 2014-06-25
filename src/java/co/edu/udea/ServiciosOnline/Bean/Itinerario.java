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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "itinerario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerario.findAll", query = "SELECT i FROM Itinerario i"),
    @NamedQuery(name = "Itinerario.findByIdItinerario", query = "SELECT i FROM Itinerario i WHERE i.idItinerario = :idItinerario"),
    @NamedQuery(name = "Itinerario.findByCanjeMillas", query = "SELECT i FROM Itinerario i WHERE i.canjeMillas = :canjeMillas")})
public class Itinerario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idItinerario")
    private String idItinerario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "canjeMillas")
    private int canjeMillas;
    @JoinTable(name = "vuelodeitinerario", joinColumns = {
        @JoinColumn(name = "idItinerario", referencedColumnName = "idItinerario")}, inverseJoinColumns = {
        @JoinColumn(name = "idVuelo", referencedColumnName = "idVuelo")})
    @ManyToMany
    private List<Vuelo> vueloList;

    public Itinerario() {
    }

    public Itinerario(String idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Itinerario(String idItinerario, int canjeMillas) {
        this.idItinerario = idItinerario;
        this.canjeMillas = canjeMillas;
    }

    public String getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(String idItinerario) {
        this.idItinerario = idItinerario;
    }

    public int getCanjeMillas() {
        return canjeMillas;
    }

    public void setCanjeMillas(int canjeMillas) {
        this.canjeMillas = canjeMillas;
    }

    @XmlTransient
    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItinerario != null ? idItinerario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerario)) {
            return false;
        }
        Itinerario other = (Itinerario) object;
        if ((this.idItinerario == null && other.idItinerario != null) || (this.idItinerario != null && !this.idItinerario.equals(other.idItinerario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Itinerario[ idItinerario=" + idItinerario + " ]";
    }
    
}
