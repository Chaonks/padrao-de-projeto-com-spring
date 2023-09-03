
package com.music.albums.domain.repository;

import com.music.albums.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}
