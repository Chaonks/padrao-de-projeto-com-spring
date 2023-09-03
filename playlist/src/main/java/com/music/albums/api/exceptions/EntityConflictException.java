
package com.music.albums.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityConflictException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
   
    public EntityConflictException(String message){
        super(message);
    }
    public EntityConflictException(){
        super("A entidade não poder ser excluída, pois está em uso");
    }
}
