/**
 * 
 * Web-service implementation code.
 * 
 * This design allows us to add other webservices later such as SOAP
 * 
 */

package se.anosh.restpizza;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import se.anosh.restpizza.dataaccess.PizzaNotFoundException;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@WebService(name="RestPizzaWebservice")
public class PizzaWebservice {
    
    // Det är en EJB så vi kan injecta den här
    // men eftersom att PizzaManagerService är @Remote så blir det ineffektivt
    // Java kommer att skapa en nätverksanslutning.
    // Så jag har skapat ett likadant interface med annontationen @Local istället
    
    @Inject
    private PizzaManagerServiceLocal service;
    
    public Pizza getPizzaById(int id) throws PizzaNotFoundException {
        return service.findPizza(id);
    }
    
    public List<Pizza> getAllPizzas() {
        return service.listAllPizzas();
    }
    
    public void registerNewPizza(Pizza pizza) {
        service.addPizza(pizza);
    }
    
    public void deletePizza(int id) throws PizzaNotFoundException {
        service.deletePizza(id);
    }
    
}
