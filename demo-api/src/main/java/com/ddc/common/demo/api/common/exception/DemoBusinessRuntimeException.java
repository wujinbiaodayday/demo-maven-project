package com.ddc.common.demo.api.common.exception;

import com.ddc.common.api.exception.BusinessRuntimeException;

/**
 * 自定义业务异常
 */
public class DemoBusinessRuntimeException extends BusinessRuntimeException {
    public DemoBusinessRuntimeException() {
        super();
    }

    public DemoBusinessRuntimeException(String message) {
        super(message);
    }

    public DemoBusinessRuntimeException(String errorCode, String message) {
        this(errorCode, message, false);
    }

    public DemoBusinessRuntimeException(String errorCode, String message, boolean propertiesKey) {
        super(message);
        setErrorCode(errorCode);
        setPropertiesKey(propertiesKey);
    }

    public DemoBusinessRuntimeException(Throwable cause) {
        super(cause);
    }

    public DemoBusinessRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoBusinessRuntimeException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public DemoBusinessRuntimeException(String errorCode, String message,
                                        Throwable cause, boolean propertiesKey) {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

}
