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
    gender VARCHAR(2) NOT NULL,
    location VARCHAR(255) NOT NULL,
    _status VARCHAR(20) NOT NULL,
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
INSERT INTO user_authentication (username, password) 
VALUES ('username', 'password');
INSERT INTO user_authentication (username, password) 
VALUES ('john', 'wick');

/* user_detail */
INSERT INTO user_detail (first_name, last_name, gender, location, _status, username, profile_img) 
VALUES ('username', 'password', 'm', 'Bolton', 'online', 1, 'https://www.aspentrading.com/wp-content/uploads/dave-floyd-head-shot-12.19.2016-300x300.png');
INSERT INTO user_detail (first_name, last_name, gender, location, _status, username, profile_img) 
VALUES ('john', 'wick', 'm', 'Bolton', 'online', 1, 'https://www.aspentrading.com/wp-content/uploads/dave-floyd-head-shot-12.19.2016-300x300.png');

/* hobby */
INSERT INTO hobby (hobby) 
VALUES ('reading');
INSERT INTO hobby (hobby) 
VALUES ('swimming');
INSERT INTO hobby (hobby) 
VALUES ('music');

/* user_hobby */
INSERT INTO user_hobby (hobby_fk, user_fk) 
VALUES (1, 1);
INSERT INTO user_hobby (hobby_fk, user_fk) 
VALUES (2, 1);
INSERT INTO user_hobby (hobby_fk, user_fk) 
VALUES (3, 1);
INSERT INTO user_hobby (hobby_fk, user_fk) 
VALUES (3, 2);

/* select statements */
SELECT * FROM msc.hobby;
SELECT * FROM msc.user_authentication;
SELECT * FROM msc.user_detail;
SELECT * FROM msc.user_hobby;

SELECT msc.hobby.hobby
	FROM user_detail
		INNER JOIN msc.user_hobby ON msc.user_detail.id = msc.user_hobby.user_fk
		INNER JOIN msc.hobby ON msc.hobby.id = msc.user_hobby.hobby_fk
		WHERE msc.user_detail.id = (
			 SELECT msc.user_authentication.id FROM msc.user_authentication
				WHERE msc.user_authentication.id = 1
		);
        
SELECT msc.user_authentication.id FROM msc.user_authentication WHERE msc.user_authentication.id = 1;