DROP TABLE IF EXISTS Makeup;
CREATE TABLE Makeup (
    id int unsigned AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);
INSERT INTO Makeup (name) VALUES ('lipstick');
INSERT INTO Makeup (name) VALUES ('Foundation');
INSERT INTO Makeup (name) VALUES ('eye shadow');
INSERT INTO Makeup (name) VALUES ('eyebrows');
INSERT INTO Makeup (name) VALUES ('cheek');
