package com.adiye.happyhome.coreapi.exception;

/**
 * Created by nyeluri on 1/17/17.
 */
public class ErrorInfo {
    String url;
    String exception;
    String message;

    public ErrorInfo(String url, String exception, String message){
        this.url = url;
        this.exception = exception;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
