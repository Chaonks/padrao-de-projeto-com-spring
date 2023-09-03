
package com.music.albums.domain.repository;

import com.music.albums.domain.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer>{

}
