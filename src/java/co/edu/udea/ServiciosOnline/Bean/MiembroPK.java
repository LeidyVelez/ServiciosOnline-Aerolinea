/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Embeddable
public class MiembroPK implements Serializable {
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

    public MiembroPK() {
    }

    public MiembroPK(String idMiembro, String tipoIDMiembro) {
        this.idMiembro = idMiembro;
        this.tipoIDMiembro = tipoIDMiembro;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembro != null ? idMiembro.hashCode() : 0);
        hash += (tipoIDMiembro != null ? tipoIDMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiembroPK)) {
            return false;
        }
        MiembroPK other = (MiembroPK) object;
        if ((this.idMiembro == null && other.idMiembro != null) || (this.idMiembro != null && !this.idMiembro.equals(other.idMiembro))) {
            return false;
        }
        if ((this.tipoIDMiembro == null && other.tipoIDMiembro != null) || (this.tipoIDMiembro != null && !this.tipoIDMiembro.equals(other.tipoIDMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.MiembroPK[ idMiembro=" + idMiembro + ", tipoIDMiembro=" + tipoIDMiembro + " ]";
    }
    
}
