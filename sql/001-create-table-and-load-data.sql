DROP TABLE IF EXISTS makeup;
CREATE TABLE makeup (
    id int unsigned AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);
INSERT INTO makeup (name) VALUES ('lipstick');
INSERT INTO makeup (name) VALUES ('Foundation');
INSERT INTO makeup (name) VALUES ('eye shadow');
INSERT INTO makeup (name) VALUES ('eyebrows');
INSERT INTO makeup (name) VALUES ('cheek');
