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
@Table(name = "tiquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t"),
    @NamedQuery(name = "Tiquete.findByIdTiquete", query = "SELECT t FROM Tiquete t WHERE t.idTiquete = :idTiquete"),
    @NamedQuery(name = "Tiquete.findByUsuarioID", query = "SELECT t FROM Tiquete t WHERE t.usuarioID = :usuarioID"),
    @NamedQuery(name = "Tiquete.findByTipoIDUsuario", query = "SELECT t FROM Tiquete t WHERE t.tipoIDUsuario = :tipoIDUsuario"),
    @NamedQuery(name = "Tiquete.findByItinerario", query = "SELECT t FROM Tiquete t WHERE t.itinerario = :itinerario")})
public class Tiquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idTiquete")
    private String idTiquete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usuarioID")
    private String usuarioID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoIDUsuario")
    private String tipoIDUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "itinerario")
    private String itinerario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiquete")
    private List<Reserva> reservaList;

    public Tiquete() {
    }

    public Tiquete(String idTiquete) {
        this.idTiquete = idTiquete;
    }

    public Tiquete(String idTiquete, String usuarioID, String tipoIDUsuario, String itinerario) {
        this.idTiquete = idTiquete;
        this.usuarioID = usuarioID;
        this.tipoIDUsuario = tipoIDUsuario;
        this.itinerario = itinerario;
    }

    public String getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(String idTiquete) {
        this.idTiquete = idTiquete;
    }

    public String getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getTipoIDUsuario() {
        return tipoIDUsuario;
    }

    public void setTipoIDUsuario(String tipoIDUsuario) {
        this.tipoIDUsuario = tipoIDUsuario;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiquete != null ? idTiquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.idTiquete == null && other.idTiquete != null) || (this.idTiquete != null && !this.idTiquete.equals(other.idTiquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Tiquete[ idTiquete=" + idTiquete + " ]";
    }
    
}
