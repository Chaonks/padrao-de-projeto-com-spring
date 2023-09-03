package com.music.albums.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPlaylistToUserDto {

    private Integer playlistId;

    private Integer userId;
    
}
