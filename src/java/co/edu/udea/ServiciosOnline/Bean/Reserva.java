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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaMaximaPago", query = "SELECT r FROM Reserva r WHERE r.fechaMaximaPago = :fechaMaximaPago"),
    @NamedQuery(name = "Reserva.findByFechaReserva", query = "SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reserva.findByEstado", query = "SELECT r FROM Reserva r WHERE r.estado = :estado")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idReserva")
    private String idReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaMaximaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMaximaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaReserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Estado")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "idMiembro", referencedColumnName = "idMiembro"),
        @JoinColumn(name = "tipoIDMiembro", referencedColumnName = "tipoIDMiembro")})
    @ManyToOne(optional = false)
    private Miembro miembro;
    @JoinColumn(name = "tiquete", referencedColumnName = "idTiquete")
    @ManyToOne(optional = false)
    private Tiquete tiquete;

    public Reserva() {
    }

    public Reserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(String idReserva, Date fechaMaximaPago, Date fechaReserva, String estado) {
        this.idReserva = idReserva;
        this.fechaMaximaPago = fechaMaximaPago;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaMaximaPago() {
        return fechaMaximaPago;
    }

    public void setFechaMaximaPago(Date fechaMaximaPago) {
        this.fechaMaximaPago = fechaMaximaPago;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
