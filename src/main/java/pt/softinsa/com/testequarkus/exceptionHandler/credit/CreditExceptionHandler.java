package pt.softinsa.com.testequarkus.exceptionHandler.credit;

import pt.softinsa.com.testequarkus.exceptionHandler.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CreditExceptionHandler implements ExceptionMapper<CreditException> {

    private static final String CREDIT_VALIDATION_INTERRUPTED = "Insufficient resources for credit validation";


    @Override
    public Response toResponse(CreditException e) {

        if (e.getMessage().equalsIgnoreCase(CreditErrorMessages.CREDIT_ABOBE_96_MONTHS)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new ErrorResponse(CREDIT_VALIDATION_INTERRUPTED, e.getMessage())).build();

        } else if (e.getMessage().equalsIgnoreCase(CreditErrorMessages.CLIENT_DOS_NOT_EXIST)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new ErrorResponse(CREDIT_VALIDATION_INTERRUPTED, e.getMessage())).build();

        } else if (e.getMessage().equalsIgnoreCase(CreditErrorMessages.CLIENT_HAS_NOT_TWO_YEARS_IN_ACTUAL_COMPANY)) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new ErrorResponse(CREDIT_VALIDATION_INTERRUPTED, e.getMessage())).build();

        }




        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorResponse("Unknown error", e.getMessage())).build();

    }


}
