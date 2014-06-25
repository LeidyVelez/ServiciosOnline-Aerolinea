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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "miembro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembro.findAll", query = "SELECT m FROM Miembro m"),
    @NamedQuery(name = "Miembro.findByIdMiembro", query = "SELECT m FROM Miembro m WHERE m.miembroPK.idMiembro = :idMiembro"),
    @NamedQuery(name = "Miembro.findByTipoIDMiembro", query = "SELECT m FROM Miembro m WHERE m.miembroPK.tipoIDMiembro = :tipoIDMiembro"),
    @NamedQuery(name = "Miembro.findByTipoMiembro", query = "SELECT m FROM Miembro m WHERE m.tipoMiembro = :tipoMiembro"),
    @NamedQuery(name = "Miembro.findByUsuario", query = "SELECT m FROM Miembro m WHERE m.usuario = :usuario"),
    @NamedQuery(name = "Miembro.findByContrasena", query = "SELECT m FROM Miembro m WHERE m.contrasena = :contrasena"),
    @NamedQuery(name = "Miembro.findByMillas", query = "SELECT m FROM Miembro m WHERE m.millas = :millas")})
public class Miembro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MiembroPK miembroPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipoMiembro")
    private String tipoMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "millas")
    private Integer millas;
    @JoinColumns({
        @JoinColumn(name = "idMiembro", referencedColumnName = "idUsuario", insertable = false, updatable = false),
        @JoinColumn(name = "tipoIDMiembro", referencedColumnName = "tipoId", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "miembro")
    private List<Reserva> reservaList;

    public Miembro() {
    }

    public Miembro(MiembroPK miembroPK) {
        this.miembroPK = miembroPK;
    }

    public Miembro(MiembroPK miembroPK, String tipoMiembro, String usuario, String contrasena) {
        this.miembroPK = miembroPK;
        this.tipoMiembro = tipoMiembro;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Miembro(String idMiembro, String tipoIDMiembro) {
        this.miembroPK = new MiembroPK(idMiembro, tipoIDMiembro);
    }

    public MiembroPK getMiembroPK() {
        return miembroPK;
    }

    public void setMiembroPK(MiembroPK miembroPK) {
        this.miembroPK = miembroPK;
    }

    public String getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(String tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getMillas() {
        return millas;
    }

    public void setMillas(Integer millas) {
        this.millas = millas;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
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
        hash += (miembroPK != null ? miembroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembro)) {
            return false;
        }
        Miembro other = (Miembro) object;
        if ((this.miembroPK == null && other.miembroPK != null) || (this.miembroPK != null && !this.miembroPK.equals(other.miembroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Miembro[ miembroPK=" + miembroPK + " ]";
    }
    
}
