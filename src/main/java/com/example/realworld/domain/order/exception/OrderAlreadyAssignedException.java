package com.example.realworld.domain.order.exception;

import com.example.realworld.common.exception.CustomException;
import org.springframework.http.HttpStatus;

public class OrderAlreadyAssignedException extends CustomException {

    public OrderAlreadyAssignedException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
