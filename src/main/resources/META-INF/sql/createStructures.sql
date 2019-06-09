DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_borrowed_books;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors_books;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS users_roles;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` boolean NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `users_borrowed_books` (
  `user_id` bigint NOT NULL,
  `book_id` bigint NOT NULL
)

CREATE TABLE `books` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `authors_books` (
  `author_id` bigint NOT NULL,
  `book_id` bigint NOT NULL
)

CREATE TABLE `authors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `users_roles` (
  `login` varchar(20) NOT NULL,
  `role` varchar(5) NOT NULL
)