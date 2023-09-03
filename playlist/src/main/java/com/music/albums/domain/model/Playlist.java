package com.music.albums.domain.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column( nullable = false, length = 30)
    private String name;

    @ManyToMany(mappedBy = "playlists")
    private List<User> users;

    @ManyToMany
    List<Music> musics;
    
}
