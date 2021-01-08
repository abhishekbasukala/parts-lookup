package com.altimetrik.spring.boot.parts.lookup.exception;

import com.altimetrik.spring.boot.parts.lookup.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class PartsControllerAdvice {

    @ExceptionHandler(PartsException.class)
    public ResponseEntity<BaseResponse> handlePartsException(PartsException ex){
        log.error("Parts Exception Thrown: {}", ex);
        BaseResponse baseResponse = new BaseResponse( String.valueOf(ex.getHttpStatus().value()), ex.getMessage());
        return new ResponseEntity(baseResponse, ex.getHttpStatus());
    }
}
