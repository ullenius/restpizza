package se.anosh.restpizza.dataaccess;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Default
public class PizzaDataAccessProductionVersion implements PizzaDataAccess {


    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void add(Pizza newPizza) {
        
        em.persist(newPizza);
    }

    @Override
    public void update(Pizza p) {
        em.merge(p);
    }

    @Override
    public void remove(int id) throws PizzaNotFoundException {
        Pizza deletePizza = findById(id);
        em.remove(deletePizza);
    }

    @Override
    public List<Pizza> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pizza findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
