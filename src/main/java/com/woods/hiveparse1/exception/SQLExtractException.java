package com.woods.hiveparse1.exception;

public class SQLExtractException extends RuntimeException {
    //~ Static fields/initializers ---------------------------------------------

    private static final long serialVersionUID = -5588025121452725145L;

    //~ Constructors -----------------------------------------------------------

    public SQLExtractException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLExtractException(String message) {
        super(message);
    }

    public SQLExtractException(Throwable cause) {
        super(cause);
    }
}

// End SQLExtractException.java
