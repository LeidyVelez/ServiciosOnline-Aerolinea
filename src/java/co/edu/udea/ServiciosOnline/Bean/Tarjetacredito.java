/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

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
 * @author Usuario
 */
@Entity
@Table(name = "tarjetacredito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetacredito.findAll", query = "SELECT t FROM Tarjetacredito t"),
    @NamedQuery(name = "Tarjetacredito.findByNumber", query = "SELECT t FROM Tarjetacredito t WHERE t.number = :number"),
    @NamedQuery(name = "Tarjetacredito.findByFranquisia", query = "SELECT t FROM Tarjetacredito t WHERE t.franquisia = :franquisia"),
    @NamedQuery(name = "Tarjetacredito.findByCodigoSeguridad", query = "SELECT t FROM Tarjetacredito t WHERE t.codigoSeguridad = :codigoSeguridad"),
    @NamedQuery(name = "Tarjetacredito.findByNombreTitular", query = "SELECT t FROM Tarjetacredito t WHERE t.nombreTitular = :nombreTitular"),
    @NamedQuery(name = "Tarjetacredito.findByUsuarioID", query = "SELECT t FROM Tarjetacredito t WHERE t.usuarioID = :usuarioID"),
    @NamedQuery(name = "Tarjetacredito.findByTipoIDUsuario", query = "SELECT t FROM Tarjetacredito t WHERE t.tipoIDUsuario = :tipoIDUsuario")})
public class Tarjetacredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "franquisia")
    private String franquisia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigoSeguridad")
    private String codigoSeguridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreTitular")
    private String nombreTitular;
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

    public Tarjetacredito() {
    }

    public Tarjetacredito(String number) {
        this.number = number;
    }

    public Tarjetacredito(String number, String franquisia, String codigoSeguridad, String nombreTitular, String usuarioID, String tipoIDUsuario) {
        this.number = number;
        this.franquisia = franquisia;
        this.codigoSeguridad = codigoSeguridad;
        this.nombreTitular = nombreTitular;
        this.usuarioID = usuarioID;
        this.tipoIDUsuario = tipoIDUsuario;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFranquisia() {
        return franquisia;
    }

    public void setFranquisia(String franquisia) {
        this.franquisia = franquisia;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjetacredito)) {
            return false;
        }
        Tarjetacredito other = (Tarjetacredito) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Tarjetacredito[ number=" + number + " ]";
    }
    
}
