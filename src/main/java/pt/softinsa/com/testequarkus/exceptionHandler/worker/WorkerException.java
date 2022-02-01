package pt.softinsa.com.testequarkus.exceptionHandler.worker;

import java.io.Serializable;

public class WorkerException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public WorkerException() {
    }

    public WorkerException(String message) {
        super(message);
    }

    public WorkerException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkerException(Throwable cause) {
        super(cause);
    }

    public WorkerException(String message, Throwable cause,
                           boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
