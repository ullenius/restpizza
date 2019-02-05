package se.anosh.restpizza.dataaccess;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class PizzaNotFoundException extends Exception {
    
    public PizzaNotFoundException() {
    }
    
    public PizzaNotFoundException(String message) {
        super(message);
    }
    
}
