package com.indra.retail.orders.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.indra.retail.orders.service.OrderNotFoundException;

@RestControllerAdvice 
public class ExceptionController {

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>("Entrada invalida: " + ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFound(OrderNotFoundException ex) {
        return new ResponseEntity<>("Orden no Encontrada: ", HttpStatus.NOT_FOUND);
    }
}
