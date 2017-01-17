package com.adiye.happyhome.coreapi.exception;

/**
 * Created by nyeluri on 1/16/17.
 */
public class CoreAPIInternalException extends RuntimeException {

    String message;
    long timestamp;

    public CoreAPIInternalException(String message, long timestamp){
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
