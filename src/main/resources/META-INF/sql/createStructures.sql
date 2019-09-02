SET SQL_SAFE_UPDATES = 0;

use library;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_borrows;
DROP TABLE IF EXISTS users_orders;
DROP TABLE IF EXISTS borrows;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS borrows_books;
DROP TABLE IF EXISTS orders_books;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS books_authors;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS users_roles;

CREATE TABLE `users` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `login` varchar(20) NOT NULL,
    `email` varchar(50) NOT NULL,
    `password` varchar(255) NOT NULL,
    `active` boolean NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `users_borrows` (
    `user_id` bigint NOT NULL,
    `borrow_id` bigint NOT NULL
);

CREATE TABLE `users_orders` (
    `user_id` bigint NOT NULL,
    `order_id` bigint NOT NULL
);

CREATE TABLE `borrows` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `rental_date` date NOT NULL,
    `return_date` date NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `orders` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `order_date` date NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `borrows_books` (
    `borrow_id` bigint NOT NULL,
    `book_id` bigint NOT NULL
);

CREATE TABLE `orders_books` (
    `order_id` bigint NOT NULL,
    `book_id` bigint NOT NULL
);

CREATE TABLE `books` (
    `id` bigint AUTO_INCREMENT,
    `title` varchar(50) NOT NULL,
    `category` varchar(50) NOT NULL,
    `publishing_house` varchar(50) NOT NULL,
    `publication_date` date NOT NULL,
    `edition` varchar(50) NOT NULL,
    `language` varchar(50) NOT NULL,
    `identifier` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `books_authors` (
    `book_id` bigint NOT NULL,
    `author_id` bigint NOT NULL
);

CREATE TABLE `authors` (
    `id` bigint AUTO_INCREMENT,
    `first_name` varchar(50),
    `last_name` varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `users_roles` (
    `login` varchar(20),
    `role` varchar(20)
);
