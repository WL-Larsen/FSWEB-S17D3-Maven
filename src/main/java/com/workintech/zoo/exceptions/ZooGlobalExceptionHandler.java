package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ZooGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handlerException(ZooException zooException){
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(zooException.getHttpStatus().value(), zooException.getLocalizedMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(zooErrorResponse, zooException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handlerException(Exception exception){
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(HttpStatus.INSUFFICIENT_STORAGE.value(), exception.getLocalizedMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(zooErrorResponse, HttpStatus.INSUFFICIENT_STORAGE);
    }

}
