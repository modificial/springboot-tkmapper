package com.modificial.api.exception;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description
 */
public class ServiceException extends  Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
