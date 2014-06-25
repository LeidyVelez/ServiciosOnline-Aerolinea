/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "asiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asiento.findAll", query = "SELECT a FROM Asiento a"),
    @NamedQuery(name = "Asiento.findByLetra", query = "SELECT a FROM Asiento a WHERE a.asientoPK.letra = :letra"),
    @NamedQuery(name = "Asiento.findByNumero", query = "SELECT a FROM Asiento a WHERE a.asientoPK.numero = :numero"),
    @NamedQuery(name = "Asiento.findByIdAvion", query = "SELECT a FROM Asiento a WHERE a.asientoPK.idAvion = :idAvion"),
    @NamedQuery(name = "Asiento.findByEstado", query = "SELECT a FROM Asiento a WHERE a.estado = :estado"),
    @NamedQuery(name = "Asiento.findByTipo", query = "SELECT a FROM Asiento a WHERE a.tipo = :tipo")})
public class Asiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsientoPK asientoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;

    public Asiento() {
    }

    public Asiento(AsientoPK asientoPK) {
        this.asientoPK = asientoPK;
    }

    public Asiento(AsientoPK asientoPK, String estado, String tipo) {
        this.asientoPK = asientoPK;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Asiento(String letra, int numero, String idAvion) {
        this.asientoPK = new AsientoPK(letra, numero, idAvion);
    }

    public AsientoPK getAsientoPK() {
        return asientoPK;
    }

    public void setAsientoPK(AsientoPK asientoPK) {
        this.asientoPK = asientoPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asientoPK != null ? asientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asiento)) {
            return false;
        }
        Asiento other = (Asiento) object;
        if ((this.asientoPK == null && other.asientoPK != null) || (this.asientoPK != null && !this.asientoPK.equals(other.asientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.Asiento[ asientoPK=" + asientoPK + " ]";
    }
    
}
