package com.music.albums.domain.service;

import com.music.albums.api.exceptions.EntityBadRequestException;
import com.music.albums.domain.dto.AddPlaylistToUserDto;
import com.music.albums.domain.dto.PlaylistDto;
import com.music.albums.domain.dto.ReturnPlaylistToUserDto;
import com.music.albums.domain.dto.UserDto;
import com.music.albums.domain.model.Playlist;
import com.music.albums.domain.model.User;
import com.music.albums.domain.repository.PlaylistRepository;
import com.music.albums.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<UserDto> list() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            UserDto dto = new UserDto(user);
            userDtos.add(dto);
        }
        return userDtos;
    }

    public UserDto findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não existe um usuário com o código " + id));

        UserDto userDto = new UserDto(user);

        return userDto;
    }

    public UserDto create(User user) {

        userRepository.save(user);
        UserDto userDto = new UserDto(user);
        return userDto;

    }

    public ReturnPlaylistToUserDto addPlaylistToUser(AddPlaylistToUserDto addPlaylistDto) {

        Playlist playlist = playlistRepository.findById(addPlaylistDto.getPlaylistId()).orElseThrow(
                () -> new EntityBadRequestException(
                        " Não existe uma playlist com o código " + addPlaylistDto.getPlaylistId()));
        User user = userRepository.findById(addPlaylistDto.getUserId()).orElseThrow(
                () -> new EntityBadRequestException(
                        " Não existe um usuário com o código " + addPlaylistDto.getUserId()));

        if (user.getPlaylists().contains(playlist)) {
            throw new DataIntegrityViolationException(
                    " Já existe uma playlist cadastrada com o código " + addPlaylistDto.getPlaylistId());
        }

        user.getPlaylists().add(playlist);

        userRepository.save(user);

        PlaylistDto playlistDto = new PlaylistDto(playlist);
        UserDto userDto = new UserDto(user);

        ReturnPlaylistToUserDto playlistToUserDto = new ReturnPlaylistToUserDto(userDto, playlistDto);

        return playlistToUserDto;

    }

    public UserDto update(Integer id, User user) {
        
       User userSave = userRepository.findById(id).
               orElseThrow( ()-> new EntityNotFoundException(
              "Não existe um usuário com o código " + id));

        userSave.setId(id);
        userSave.setName(user.getName());
        userRepository.save(userSave);
        
        UserDto userDto = new UserDto(userSave);

        return userDto;
    }

    public void delete(Integer id) {

        User user = userRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(
                ("Não existe um usuário com o código " + id)));
        userRepository.delete(user);
    }
}
 