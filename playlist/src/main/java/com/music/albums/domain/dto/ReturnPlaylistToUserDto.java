package com.music.albums.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnPlaylistToUserDto {

    private Integer userId;
    private String userName;
    private Integer playlistId;
    private String playlistName;

    public ReturnPlaylistToUserDto(UserDto userDto, PlaylistDto playlistDto) {
        this.userId = userDto.getId();
        this.userName = userDto.getName();
        this.playlistId = playlistDto.getId();
        this.playlistName = playlistDto.getName();
    }

    
    
}
