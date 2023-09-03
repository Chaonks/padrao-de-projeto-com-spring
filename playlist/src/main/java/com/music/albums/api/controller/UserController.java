package com.music.albums.api.controller;

import com.music.albums.domain.dto.AddPlaylistToUserDto;
import com.music.albums.domain.dto.ReturnPlaylistToUserDto;
import com.music.albums.domain.dto.UserDto;
import com.music.albums.domain.model.User;
import com.music.albums.domain.service.UserService;
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
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> list() {
          return userService.list();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid User user) {
        return userService.create(user);

    }
    
    @PostMapping("/addplaylist")
    public ReturnPlaylistToUserDto addPlaylist(@RequestBody AddPlaylistToUserDto addPlaylistDto ){
      return userService.addPlaylistToUser(addPlaylistDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

}
