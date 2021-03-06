package se.anosh.restpizza;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import se.anosh.restpizza.dataaccess.PizzaDataAccess;
import se.anosh.restpizza.dataaccess.PizzaNotFoundException;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
public class PizzaManagerImplementation implements PizzaManagerService, PizzaManagerServiceLocal {

    @Inject
    private PizzaDataAccess dao;
    
    @Override
    public void addPizza(Pizza newPizza) {
        dao.add(newPizza);
    }

    @Override
    public void updatePizza(Pizza pizza) throws PizzaNotFoundException {
        
        dao.update(pizza.getId(), pizza.getName(), pizza.getPrice());
    }
        
    @Override
    public void deletePizza(int id) throws PizzaNotFoundException {
        dao.remove(id);
    }

    @Override
    public Pizza findPizza(int id) throws PizzaNotFoundException {
        return dao.findById(id);
    }

    @Override
    public List<Pizza> listAllPizzas() {
        return dao.findAll();
    }
    
}
