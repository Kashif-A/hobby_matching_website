USE msc;

DROP TABLE IF EXISTS msc.user_hobby; 
DROP TABLE IF EXISTS msc.hobby;
DROP TABLE IF EXISTS msc.user_detail; 
DROP TABLE IF EXISTS msc.user_authentication; 

CREATE TABLE IF NOT EXISTS user_authentication (
    id INT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_detail (
    id INT AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    location VARCHAR(255) NOT NULL,
    username INT NOT NULL,
				profile_img VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES user_authentication(id)
);

CREATE TABLE IF NOT EXISTS hobby (
    id INT AUTO_INCREMENT,
    hobby VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_hobby (
    id INT AUTO_INCREMENT,
    hobby_fk INT NOT NULL,
    user_fk INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (hobby_fk) REFERENCES hobby(id),
    FOREIGN KEY (user_fk) REFERENCES user_detail(id)
);

/* user_authentication */

/* user_detail */

/* hobby */
INSERT INTO hobby (hobby) VALUES ('reading');
INSERT INTO hobby (hobby) VALUES ('swimming');
INSERT INTO hobby (hobby) VALUES ('walking');
INSERT INTO hobby (hobby) VALUES ('internet');
INSERT INTO hobby (hobby) VALUES ('comedy');
INSERT INTO hobby (hobby) VALUES ('knitting');
INSERT INTO hobby (hobby) VALUES ('chatting');
INSERT INTO hobby (hobby) VALUES ('dogs');
INSERT INTO hobby (hobby) VALUES ('cats');
INSERT INTO hobby (hobby) VALUES ('painting');
INSERT INTO hobby (hobby) VALUES ('food');
INSERT INTO hobby (hobby) VALUES ('travel');
INSERT INTO hobby (hobby) VALUES ('relaxing');
INSERT INTO hobby (hobby) VALUES ('life');
INSERT INTO hobby (hobby) VALUES ('history');
INSERT INTO hobby (hobby) VALUES ('talking');
INSERT INTO hobby (hobby) VALUES ('friends');
INSERT INTO hobby (hobby) VALUES ('family');
INSERT INTO hobby (hobby) VALUES ('cooking');
INSERT INTO hobby (hobby) VALUES ('biking');
INSERT INTO hobby (hobby) VALUES ('running');
INSERT INTO hobby (hobby) VALUES ('swimming');
INSERT INTO hobby (hobby) VALUES ('music');

/* user_hobby */
SELECT * FROM msc.user_hobby;
SELECT * FROM msc.user_authentication;
SELECT * FROM msc.user_detail;
SELECT * FROM msc.hobby;