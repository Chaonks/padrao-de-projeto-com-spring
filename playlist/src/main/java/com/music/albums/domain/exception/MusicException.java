
package com.music.albums.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MusicException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	
	public MusicException(String messageString) {
            super(messageString);
	}
	
	

}
