/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ServiciosOnline.Ejb;

import co.edu.udea.ServiciosOnline.Bean.Aeropuerto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class AeropuertoFacade extends AbstractFacade<Aeropuerto> {
    @PersistenceContext(unitName = "ServiciosOnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AeropuertoFacade() {
        super(Aeropuerto.class);
    }
    
}
