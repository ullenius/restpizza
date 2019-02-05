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
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import se.anosh.restpizza.PizzaManagerServiceLocal;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Path("/pizza")
public class PizzaResource {
    
    @Inject
    PizzaManagerServiceLocal service;
    
    @POST
    @Consumes({"application/JSON", "application/XML"})
    public Response createPizza(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @GET
    @Produces({"application/JSON", "application/XML"})
    @Path("{pizzaNo}")
    public Response findPizzaById(@PathParam("pizzaNo") int id) {
        
         throw new UnsupportedOperationException("Not supported yet.");
    }
    
   @GET
    @Produces({"application/JSON", "application/XML"})
    public Response getAllPizzas() {
        
     throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @DELETE
    @Path("{pizzaNo}")
    public Response deletePizza() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * 
     * This method returns an updated version of the object
     * @param pizza
     * @return 
     */
    @PUT
    @Produces({"application/JSON", "application/XML"})
    @Consumes({"application/JSON", "application/XML"})
    public Response updatePizza(Pizza pizza) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
        
        
}
