package org.skypro.skyshop.controller;


import org.skypro.skyshop.model.error.ShopError;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> divisionByZeroHandler(NoSuchProductException e) {
        return new ResponseEntity<>(new ShopError("001", "Нет такого продукта."),
                HttpStatus.NOT_FOUND);
    }

}
