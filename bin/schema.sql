-- create user and set up db
CREATE user IF NOT EXISTS 'cinema_user'@'localhost' IDENTIFIED BY 'cinema_pwd';
CREATE DATABASE IF NOT EXISTS cinema_db;
GRANT ALL ON cinema_db.* TO 'cinema_user'@'localhost';

use cinema_db;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS movie;

CREATE TABLE role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80) UNIQUE NOT NULL
);

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    username VARCHAR(80) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE movie (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    rating FLOAT NOT NULL,
    genre VARCHAR(80) NOT NULL,
    story_line TEXT NOT NULL,
    time TIMESTAMP NOT NULL,
    cover_pic VARCHAR(255),
    price FLOAT NOT NULL
);
