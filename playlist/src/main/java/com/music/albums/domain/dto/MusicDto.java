package com.music.albums.domain.dto;

import com.music.albums.domain.model.Music;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MusicDto {
    
    private Integer id;
    private String name;

	public MusicDto() {
	}

	public MusicDto(Music music) {
		this.id = music.getId();
		this.name = music.getName();
	}
    

    

}
