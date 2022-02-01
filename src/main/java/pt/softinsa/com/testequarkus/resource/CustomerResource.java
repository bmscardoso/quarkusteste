package pt.softinsa.com.testequarkus.resource;


import org.jboss.resteasy.annotations.jaxrs.PathParam;
import pt.softinsa.com.testequarkus.model.Customer;
import pt.softinsa.com.testequarkus.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerService customerService;


    @POST
    @Path("/changegender")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeGender(Customer customer){

        customer = customerService.changeSex(customer);

        return Response.ok(customer).build();
    }

    @POST
    @Path("/changeeyes/{newColor}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeEyes(Customer customer, @PathParam String newColor){

        customer = customerService.changeEyes(customer, newColor);

        return Response.ok(customer).build();
    }
}