package com.dc.latam.web.controller;

import com.dc.latam.domain.dto.ErrorDTO;
import com.dc.latam.web.exceptions.RequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex) {
        ErrorDTO error = new ErrorDTO(ex.getStatus().toString(), ex.getMessage());
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
