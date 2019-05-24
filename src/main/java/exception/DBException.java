package exception;

public class DBException extends RuntimeException {
    //~ Static fields/initializers ---------------------------------------------

    private static final long serialVersionUID = -5588025121452725145L;

    //~ Constructors -----------------------------------------------------------

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(Throwable cause) {
        super(cause);
    }
}

// End DBException.java
