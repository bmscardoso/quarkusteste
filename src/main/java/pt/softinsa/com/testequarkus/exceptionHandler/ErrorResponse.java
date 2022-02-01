package pt.softinsa.com.testequarkus.exceptionHandler;

public class ErrorResponse {

    private String error;
    private String cause;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String error, String cause) {
        super();
        this.error = error;
        this.cause = cause;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
