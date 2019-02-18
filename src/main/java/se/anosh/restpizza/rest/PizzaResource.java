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
import se.anosh.restpizza.dataaccess.PizzaNotFoundException;
import se.anosh.restpizza.domain.Pizza;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
@Stateless
@Path("/pizza")
public class PizzaResource {
    
    // HTTP status codes
    private static final int NO_CONTENT = 204;
    private static final int BAD_REQUEST = 400;
    private static final int NOT_FOUND = 404;
    private static final int GATEWAY_TIMEOUT = 504;
    
    @Inject
            PizzaManagerServiceLocal service;
    
    @POST
    @Consumes({"application/JSON"})
    public Response createPizza(Pizza pizza) {
        
        if (pizza == null)
            return Response.status(BAD_REQUEST).build();
        
        try {
            service.addPizza(pizza);
        } catch (Exception e) {
            return Response.status(GATEWAY_TIMEOUT).build();
        }
        return Response.status(NO_CONTENT).build();
    }
    
    @GET
    @Produces({"application/JSON"})
    @Path("{pizzaNo}")
    public Response findPizzaById(@PathParam("pizzaNo") int id) {
        
        try {
            Pizza found = service.findPizza(id);
            return Response.ok(found).build();
        } catch (PizzaNotFoundException ex) {
            return Response.status(NOT_FOUND).build(); // not found
        }
        
    }
    
    @GET
    @Produces({"application/JSON"})
    public Response getAllPizzas() {
        
        return Response.ok(service.listAllPizzas()).build();
    }
    
    
    @DELETE
    @Path("{pizzaNo}")
    public Response deletePizza(@PathParam("pizzaNo")int id) {
        
        /**
         *
         * The dao-implementation code for remove() calls the findById-method
         * (in the same class). That is why PizzaNotFoundException might be thrown.
         *
         * Please refer to PizzaDataAccessProductionVersion.java
         *
         */
        try {
            service.deletePizza(id);
            return Response.status(NO_CONTENT).build();
        } catch (PizzaNotFoundException ex) {
            return Response.status(NOT_FOUND).build();
        }
        
    }
    
    /**
     *
     * This method returns an updated version of the Pizza object
     * @param pizza
     * @return
     */
    @PUT
    @Produces({"application/JSON"})
    @Consumes({"application/JSON"})
    public Response updatePizza(Pizza pizza) {
        
        if (pizza == null)
            return Response.status(BAD_REQUEST).build();
        
        try {
            service.updatePizza(pizza); // throws PizzaNotFoundException
            return Response.ok(service.findPizza(pizza.getId())).build();
            
        } catch (PizzaNotFoundException ex) {
            return Response.status(NOT_FOUND).build();
        }
        
    }
    
    
    
}
