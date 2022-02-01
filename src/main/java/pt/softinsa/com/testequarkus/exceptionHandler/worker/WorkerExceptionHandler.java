package pt.softinsa.com.testequarkus.exceptionHandler.worker;

import pt.softinsa.com.testequarkus.exceptionHandler.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WorkerExceptionHandler implements ExceptionMapper<WorkerException> {

    private static final String ERROR_CHANGE_SALARY = "Raise salary unsuccessfully";

    @Override
    public Response toResponse(WorkerException e) {

        if (e.getMessage().equalsIgnoreCase(WorkerErrorMessages.NOT_AN_EMPLOYEE)) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(ERROR_CHANGE_SALARY, e.getMessage())).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorResponse("Unknown error", e.getMessage())).build();
    }
}
