package com.ddc.common.demo.api.common.exception;


import com.ddc.common.api.exception.BusinessException;

/**
 * 自定义业务异常
 */
public class DemoBusinessException extends BusinessException {
    public DemoBusinessException() {
        super();
    }

    public DemoBusinessException(String message) {
        super(message);
    }

    public DemoBusinessException(String errorCode, String message) {
        this(errorCode, message, false);
    }

    public DemoBusinessException(String errorCode, String message, boolean propertiesKey) {
        super(message);
        setErrorCode(errorCode);
        setPropertiesKey(propertiesKey);
    }

    public DemoBusinessException(Throwable cause) {
        super(cause);
    }

    public DemoBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoBusinessException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public DemoBusinessException(String errorCode, String message,
                                 Throwable cause, boolean propertiesKey) {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }
}