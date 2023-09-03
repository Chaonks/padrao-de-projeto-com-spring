
# Create user user

INSERT INTO `user` (`name`) VALUES ('Abgonlido Alves')

INSERT INTO `user` (`name`) VALUES ('Juvenal Juvêncio')

INSERT INTO `user` (`name`) VALUES ('Beto Santos')

# Create music

INSERT INTO music (`name`) VALUES ('Gustavo Lima - Bloqueado')

INSERT INTO music (`name`) VALUES ('Edson Gomes - Camelô')

INSERT INTO music (`name`) VALUES ('Bee Gees - How depp your love')

INSERT INTO music (`name`) VALUES ('Cutting Crew - (I Just) Died In Your Arms')

INSERT INTO music (`name`) VALUES ('Green Day - American Idiot')

INSERT INTO music (`name`) VALUES ('Simone e Simaria - São amores')

# Add playlist

INSERT INTO playlist (`name`) VALUES ('Internacional de novelas')

INSERT INTO playlist (`name`) VALUES ('Reggae misto vol.7')

INSERT INTO playlist (`name`) VALUES ('O Melhor da MPB')

INSERT INTO playlist (`name`) VALUES ('Pop Rock internacional')

INSERT INTO playlist (`name`) VALUES ('Paredão  dezembro 2023')

# Add playlist on user

INSERT INTO user_playlists (users_id, playlists_id) VALUES (1, 1)
INSERT INTO user_playlists (users_id, playlists_id) VALUES (2, 2)
INSERT INTO user_playlists (users_id, playlists_id) VALUES (2, 3)

# Inser music o playlist

INSERT INTO playlist_musics (playlists_id, musics_id) VALUES (1, 1)
INSERT INTO playlist_musics (playlists_id, musics_id) VALUES (2, 2)
INSERT INTO playlist_musics (playlists_id, musics_id) VALUES (2, 3)


