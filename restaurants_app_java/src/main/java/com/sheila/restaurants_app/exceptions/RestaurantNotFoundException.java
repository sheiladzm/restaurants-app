package com.sheila.restaurants_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1106120769522679372L;

    public RestaurantNotFoundException() {
    }

    public RestaurantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
