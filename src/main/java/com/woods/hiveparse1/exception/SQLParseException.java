package com.woods.hiveparse1.exception;

/**
 * @author yangyang
 */
public class SQLParseException extends RuntimeException {
    //~ Static fields/initializers ---------------------------------------------

    private static final long serialVersionUID = -5588025121452725145L;

    //~ Constructors -----------------------------------------------------------

    public SQLParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLParseException(String message) {
        super(message);
    }

    public SQLParseException(Throwable cause) {
        super(cause);
    }

}

// End SQLParseException.java
