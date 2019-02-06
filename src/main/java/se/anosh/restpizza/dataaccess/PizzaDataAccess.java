package se.anosh.restpizza.dataaccess;

import java.util.List;
import javax.ejb.Local;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * Interace for the data access object.
 * 
 * This interface is used by the server and is not visible to the client.
 * Thus @Remote annontation is *NOT* needed. But it is still an EJB
 * 
 * 
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Local
public interface PizzaDataAccess {
    
    public void add(Pizza newPizza);
    public void update(int id, String name, double price) throws PizzaNotFoundException;
    public void remove(int id) throws PizzaNotFoundException;
    public List<Pizza> findAll();
    public Pizza findById(int id) throws PizzaNotFoundException;
    
}
