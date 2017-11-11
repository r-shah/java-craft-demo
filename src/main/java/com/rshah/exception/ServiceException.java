package com.rshah.exception;

public class ServiceException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -1234202855500626489L;

    public ServiceException(String message){
       super(message);
    }
}
