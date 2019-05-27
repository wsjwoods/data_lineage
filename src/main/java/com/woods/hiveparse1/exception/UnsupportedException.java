package com.woods.hiveparse1.exception;

/**
 * 不支持解析异常
 *
 * @author yangyang
 */
public class UnsupportedException extends RuntimeException {
    //~ Static fields/initializers ---------------------------------------------

    private static final long serialVersionUID = -5588025121452725145L;

    //~ Constructors -----------------------------------------------------------

    public UnsupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedException(String message) {
        super(message);
    }

    public UnsupportedException(Throwable cause) {
        super(cause);
    }
}

// End UnsupportedException.java
