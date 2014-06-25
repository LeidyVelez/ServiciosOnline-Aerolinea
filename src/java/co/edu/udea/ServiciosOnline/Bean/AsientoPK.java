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
public class AsientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "letra")
    private String letra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idAvion")
    private String idAvion;

    public AsientoPK() {
    }

    public AsientoPK(String letra, int numero, String idAvion) {
        this.letra = letra;
        this.numero = numero;
        this.idAvion = idAvion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (letra != null ? letra.hashCode() : 0);
        hash += (int) numero;
        hash += (idAvion != null ? idAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsientoPK)) {
            return false;
        }
        AsientoPK other = (AsientoPK) object;
        if ((this.letra == null && other.letra != null) || (this.letra != null && !this.letra.equals(other.letra))) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if ((this.idAvion == null && other.idAvion != null) || (this.idAvion != null && !this.idAvion.equals(other.idAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ServiciosOnline.Bean.AsientoPK[ letra=" + letra + ", numero=" + numero + ", idAvion=" + idAvion + " ]";
    }
    
}
