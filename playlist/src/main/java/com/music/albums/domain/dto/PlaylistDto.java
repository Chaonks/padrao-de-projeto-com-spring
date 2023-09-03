package com.music.albums.domain.dto;

import com.music.albums.domain.model.Playlist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistDto {

    private Integer id;
    
    private String name;

    public PlaylistDto() {
    }

    public PlaylistDto(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
    }

}
