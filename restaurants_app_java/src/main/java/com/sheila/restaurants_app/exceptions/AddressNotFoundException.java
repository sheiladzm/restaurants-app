package com.sheila.restaurants_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1106120769522679372L;

    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}