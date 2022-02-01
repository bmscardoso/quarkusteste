package pt.softinsa.com.testequarkus.exceptionHandler.credit;

import java.io.Serializable;

public class CreditException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public CreditException() {
    }

    public CreditException(String message) {
        super(message);
    }

    public CreditException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditException(Throwable cause) {
        super(cause);
    }

    public CreditException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
