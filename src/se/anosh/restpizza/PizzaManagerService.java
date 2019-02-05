package se.anosh.restpizza;

import java.util.List;
import javax.ejb.Remote;
import se.anosh.restpizza.domain.Pizza;
import se.anosh.restpizza.dataaccess.PizzaNotFoundException;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Remote
public interface PizzaManagerService {
    
    public void addPizza(Pizza newPizza);
    public void updatePizza(Pizza pizza) throws PizzaNotFoundException;
    public void deletePizza(int id) throws PizzaNotFoundException;
    public Pizza findPizza(int id) throws PizzaNotFoundException;
    public List<Pizza> listAllPizzas();
    
}
