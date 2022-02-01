package pt.softinsa.com.testequarkus.exceptionHandler.customer;

import pt.softinsa.com.testequarkus.exceptionHandler.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomerExceptionHandler implements ExceptionMapper<CustomerException> {

    private static final String ERROR_CHANGE_GENDER = "Change gender unsuccessfully";
    private static final String ERROR_CHANGE_EYES = "Change eyes color unsuccessfully";

    @Override
    public Response toResponse(CustomerException e) {

        if (e.getMessage().equalsIgnoreCase(CustomerErrorMessages.CUSTOMER_NOT_FOUND)) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(ERROR_CHANGE_GENDER, e.getMessage())).build();

        } else if (e.getMessage().equalsIgnoreCase(CustomerErrorMessages.IT_IS_AN_ALIEN)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new ErrorResponse(ERROR_CHANGE_GENDER, e.getMessage())).build();

        }else if (e.getMessage().equalsIgnoreCase(CustomerErrorMessages.HAS_NO_EYES)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new ErrorResponse(ERROR_CHANGE_EYES, e.getMessage())).build();

        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorResponse("Unknown error", e.getMessage())).build();
    }
}
