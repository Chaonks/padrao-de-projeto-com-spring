package com.music.albums.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnMusicToPlaylistDto {

    private Integer playlistId;
    private String playlistName;

    private Integer musicId;
    private String musicName;

    public ReturnMusicToPlaylistDto(PlaylistDto playlistDto, MusicDto musicDto) {
        this.playlistId = playlistDto.getId();
        this.playlistName = playlistDto.getName();
        this.musicId = musicDto.getId();
        this.musicName = musicDto.getName();
    }

}
