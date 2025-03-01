SET search_path TO films_schema;

CREATE TABLE IF NOT EXISTS movie
(
    id             BIGSERIAL PRIMARY KEY,
    budget         BIGINT,
    original_title VARCHAR(255)  NOT NULL,
    title          VARCHAR(255)  NOT NULL,
    movie_db_id    BIGINT UNIQUE NOT NULL,
    release_date   DATE,
    vote_average   FLOAT,
    vote_count     BIGINT
);

CREATE TABLE IF NOT EXISTS genre
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS movie_genre
(
    movie_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genre (id) ON DELETE CASCADE
);
