package se.anosh.restpizza.dataaccess;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public void update(int id, String newName, double newPrice) throws PizzaNotFoundException {
        
        /**
         * 
         * JPA's dirty checking does the work of merging after we update
         * the fields. Auto-magic! :)
         */
        Pizza updated = findById(id);
        updated.setName(newName);
        updated.setPrice(newPrice);
    }

    @Override
    public void remove(int id) throws PizzaNotFoundException {
        Pizza deletePizza = findById(id);
        em.remove(deletePizza);
    }

    @Override
    public List<Pizza> findAll() {
        Query myQuery = em.createNamedQuery("SELECT p FROM Pizza p");
        return myQuery.getResultList();
        
    }

    @Override
    public Pizza findById(int id) throws PizzaNotFoundException {
        Pizza found = em.find(Pizza.class,id);
        if (found == null)
            throw new PizzaNotFoundException("Pizza with " + id + " was not found");
        
        return found;
    }
    
}
