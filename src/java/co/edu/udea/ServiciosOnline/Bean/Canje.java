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
@Table(name = "canje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canje.findAll", query = "SELECT c FROM Canje c"),
    @NamedQuery(name = "Canje.findByIdCanje", query = "SELECT c FROM Canje c WHERE c.idCanje = :idCanje"),
    @NamedQuery(name = "Canje.findByIdMiembro", query = "SELECT c FROM Canje c WHERE c.idMiembro = :idMiembro"),
    @NamedQuery(name = "Canje.findByTipoIDMiembro", query = "SELECT c FROM Canje c WHERE c.tipoIDMiembro = :tipoIDMiembro"),
    @NamedQuery(name = "Canje.findByTiquete", query = "SELECT c FROM Canje c WHERE c.tiquete = :tiquete"),
    @NamedQuery(name = "Canje.findByMillasDeCanje", query = "SELECT c FROM Canje c WHERE c.millasDeCanje = :millasDeCanje")})
public class Canje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idCanje")
    private String idCanje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idMiembro")
    private String idMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoIDMiembro")
    private String tipoIDMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tiquete")
    private String tiquete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "millasDeCanje")
    private int millasDeCanje;

    public Canje() {
    }

    public Canje(String idCanje) {
        this.idCanje = idCanje;
    }

    public Canje(String idCanje, String idMiembro, String tipoIDMiembro, String tiquete, int millasDeCanje) {
        this.idCanje = idCanje;
        this.idMiembro = idMiembro;
        this.tipoIDMiembro = tipoIDMiembro;
        this.tiquete = tiquete;
        this.millasDeCanje = millasDeCanje;
    }

    public String getIdCanje() {
        return idCanje;
    }

    public void setIdCanje(String idCanje) {
        this.idCanje = idCanje;
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getTipoIDMiembro() {
        return tipoIDMiembro;
    }

    public void setTipoIDMiembro(String tipoIDMiembro) {
        this.tipoIDMiembro = tipoIDMiembro;
    }

    public String getTiquete() {
        return tiquete;
    }

    public void setTiquete(String tiquete) {
        this.tiquete = tiquete;
    }

    public int getMillasDeCanje() {
        return millasDeCanje;
    }

    public void setMillasDeCanje(int millasDeCanje) {
        this.millasDeCanje = millasDeCanje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCanje != null ? idCanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canje)) {
            return false;
        }
        Canje other = (Canje) object;
        if ((this.idCanje == null && other.idCanje != null) || (this.idCanje != null && !this.idCanje.equals(other.idCanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Canje[ idCanje=" + idCanje + " ]";
    }
    
}
