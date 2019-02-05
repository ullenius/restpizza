package se.anosh.restpizza;

import java.util.List;
import java.util.Optional;
import javax.ejb.Remote;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Remote
public interface PizzaManagerService {
    
    public void addPizza(Pizza newPizza);
    public void updatePizza(Pizza pizza);
    public void deletePizza(int id);
    public Optional<Pizza> findPizza(int id);
    public List<Pizza> listAllPizzas();
    
}
