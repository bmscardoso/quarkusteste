package pt.softinsa.com.testequarkus.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import pt.softinsa.com.testequarkus.model.Worker;
import pt.softinsa.com.testequarkus.service.WorkerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/worker")
public class WorkerResource {

    @Inject
    WorkerService workerService;

    @POST
    @Operation(hidden=true)
    @Path("/raisesalary")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response raiseSalary(Worker worker, @QueryParam("howmuch") int howMuch){


        worker = workerService.raiseSalary(worker, howMuch);

        return Response.ok(worker).build();
    }

}
