package com.music.albums.api.controller;

import com.music.albums.domain.dto.AddMusicToPlayListDto;
import com.music.albums.domain.dto.PlaylistDto;
import com.music.albums.domain.dto.ReturnMusicToPlaylistDto;
import com.music.albums.domain.model.Playlist;
import com.music.albums.domain.service.PlaylistService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<PlaylistDto> list() {
        return playlistService.list();
    }

    @GetMapping("/{id}")
    public PlaylistDto findById(@PathVariable Integer id) {
        return playlistService.findById(id);
    }

    @GetMapping("/byuser/{id}")
    public List<PlaylistDto> listByUser(@PathVariable Integer id) {
        return playlistService.listPlaylistByUser(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaylistDto create(@RequestBody @Valid Playlist playlist) {
        return playlistService.create(playlist);

    }

    @PostMapping("/addmusic")
    public ReturnMusicToPlaylistDto addMusicToPlaylist(@RequestBody AddMusicToPlayListDto addMusicToPlayListDto) {

        return playlistService.addMusicOnPlaylist(addMusicToPlayListDto);
    }

    @PutMapping("/{id}")
    public PlaylistDto update(@PathVariable Integer id, @RequestBody Playlist playlist) {
        return playlistService.update(id, playlist);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        playlistService.delete(id);
    }

}
