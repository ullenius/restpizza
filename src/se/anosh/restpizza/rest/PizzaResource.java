/**
 * 
 * REST webservice implementation code
 * 
 * CRUD-functionality
 * 
 * 
 */

package se.anosh.restpizza.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import se.anosh.restpizza.PizzaManagerServiceLocal;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Path("/pizza")
public class PizzaResource {
    
    
            @Inject
            PizzaManagerServiceLocal service;
        
        
        
        
        
}
