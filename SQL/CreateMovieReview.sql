DROP TABLE moviereviews;
DROP SEQUENCE movie_id_seq;
DROP TRIGGER trigger_movie_id;

CREATE TABLE moviereviews (
    movie_id INTEGER FOREIGN KEY REFERENCES movies(movie_id) ON DELETE CASCADE,
    review VARCHAR(65535)
);

INSERT INTO moviereviews (movie_id, review) VALUES(1, 'I loved it - it''s almost as good as Chinatown!');
INSERT INTO moviereviews (movie_id, review) VALUES(1, 'Super clever story with an amazing cast as well.');
INSERT INTO moviereviews (movie_id, review) VALUES(2, 'Truly one of the movies of all time.');
INSERT INTO moviereviews (movie_id, review) VALUES(3, 'What an emotional rollercoaster!');
