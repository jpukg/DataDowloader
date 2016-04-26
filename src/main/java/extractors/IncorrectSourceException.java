package extractors;

public class IncorrectSourceException extends RuntimeException {

    public IncorrectSourceException(String message){
        super(message);
    }

    public IncorrectSourceException(String message, Throwable cause){
        super(message,cause);
    }
}
