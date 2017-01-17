package com.adiye.happyhome.coreapi.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by nyeluri on 1/17/17.
 */
@ControllerAdvice
public class CoreAPIExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody ErrorInfo handleEntityNotFoundException(HttpServletRequest request,EntityNotFoundException e){
        ErrorInfo errorInfo = new ErrorInfo(request.getRequestURL().toString(),e.toString(),e.getEntity().concat(" Not Found"));
        return errorInfo;
    }

    @ExceptionHandler(CoreAPIInternalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody ErrorInfo handleCoreAPIInternalException(HttpServletRequest request,CoreAPIInternalException e){
        ErrorInfo errorInfo = new ErrorInfo(request.getRequestURL().toString(),e.toString(),e.getMessage());
        return errorInfo;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody ErrorInfo handleException(HttpServletRequest request,Exception e){
        ErrorInfo errorInfo = new ErrorInfo(request.getRequestURL().toString(),e.toString(),e.getMessage());
        return errorInfo;
    }
}
