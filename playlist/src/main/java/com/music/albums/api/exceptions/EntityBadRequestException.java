package com.music.albums.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EntityBadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    
    public EntityBadRequestException(String message, HttpStatus httpStatus) {
        super(message);
    }

    public EntityBadRequestException(String message) {

        super(message);
    }


}
