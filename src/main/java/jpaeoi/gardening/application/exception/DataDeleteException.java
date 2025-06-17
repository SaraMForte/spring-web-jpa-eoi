package jpaeoi.gandening.application.exception;

public class DataDeleteException extends RuntimeException {
    public DataDeleteException(String message) {
        super(message);
    }

    public DataDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
