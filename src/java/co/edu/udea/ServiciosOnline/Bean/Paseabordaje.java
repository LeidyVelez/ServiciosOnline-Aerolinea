/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "paseabordaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paseabordaje.findAll", query = "SELECT p FROM Paseabordaje p"),
    @NamedQuery(name = "Paseabordaje.findByIdPaseAbordaje", query = "SELECT p FROM Paseabordaje p WHERE p.idPaseAbordaje = :idPaseAbordaje"),
    @NamedQuery(name = "Paseabordaje.findByFechaEntrega", query = "SELECT p FROM Paseabordaje p WHERE p.fechaEntrega = :fechaEntrega")})
public class Paseabordaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idPaseAbordaje")
    private String idPaseAbordaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @JoinColumn(name = "puertaAbordaje", referencedColumnName = "idPuertaAbordaje")
    @ManyToOne(optional = false)
    private Puertaabordaje puertaAbordaje;
    @JoinColumns({
        @JoinColumn(name = "idViajero", referencedColumnName = "idUsuario"),
        @JoinColumn(name = "tipoIDViajero", referencedColumnName = "tipoId")})
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Paseabordaje() {
    }

    public Paseabordaje(String idPaseAbordaje) {
        this.idPaseAbordaje = idPaseAbordaje;
    }

    public Paseabordaje(String idPaseAbordaje, Date fechaEntrega) {
        this.idPaseAbordaje = idPaseAbordaje;
        this.fechaEntrega = fechaEntrega;
    }

    public String getIdPaseAbordaje() {
        return idPaseAbordaje;
    }

    public void setIdPaseAbordaje(String idPaseAbordaje) {
        this.idPaseAbordaje = idPaseAbordaje;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Puertaabordaje getPuertaAbordaje() {
        return puertaAbordaje;
    }

    public void setPuertaAbordaje(Puertaabordaje puertaAbordaje) {
        this.puertaAbordaje = puertaAbordaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaseAbordaje != null ? idPaseAbordaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paseabordaje)) {
            return false;
        }
        Paseabordaje other = (Paseabordaje) object;
        if ((this.idPaseAbordaje == null && other.idPaseAbordaje != null) || (this.idPaseAbordaje != null && !this.idPaseAbordaje.equals(other.idPaseAbordaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Paseabordaje[ idPaseAbordaje=" + idPaseAbordaje + " ]";
    }
    
}
