SET SQL_SAFE_UPDATES = 0;

use library;

DELETE FROM users;
ALTER TABLE users AUTO_INCREMENT = 1;
DELETE FROM users_borrowed_books;
DELETE FROM books;
ALTER TABLE books AUTO_INCREMENT = 1;
DELETE FROM authors_books;
DELETE FROM authors;
ALTER TABLE authors AUTO_INCREMENT = 1;
DELETE FROM users_roles;

INSERT INTO books (title) VALUES ('Book 1');
INSERT INTO books (title) VALUES ('Book 1');
INSERT INTO books (title) VALUES ('Book 1');
INSERT INTO books (title) VALUES ('Book 2');
INSERT INTO books (title) VALUES ('Book 2');
INSERT INTO books (title) VALUES ('Book 3');
INSERT INTO books (title) VALUES ('Book 4');
INSERT INTO books (title) VALUES ('Book 4');
INSERT INTO books (title) VALUES ('Book 4');
INSERT INTO books (title) VALUES ('Book 4');
INSERT INTO books (title) VALUES ('Book 5');
INSERT INTO books (title) VALUES ('Book 5');
INSERT INTO books (title) VALUES ('Book 5');
INSERT INTO books (title) VALUES ('Book 5');
INSERT INTO books (title) VALUES ('Book 5');
INSERT INTO books (title) VALUES ('Book 6');
INSERT INTO books (title) VALUES ('Book 7');
INSERT INTO books (title) VALUES ('Book 7');
INSERT INTO books (title) VALUES ('Book 7');

INSERT INTO authors (first_name, last_name) VALUES ('Author', '1');
INSERT INTO authors_books (author_id, book_id) VALUES (1, 1);
INSERT INTO authors_books (author_id, book_id) VALUES (1, 2);
INSERT INTO authors_books (author_id, book_id) VALUES (1, 3);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '2');
INSERT INTO authors_books (author_id, book_id) VALUES (2, 4);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 5);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 6);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 7);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 8);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 9);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 10);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '3');
INSERT INTO authors_books (author_id, book_id) VALUES (3, 4);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 5);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 6);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 7);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 8);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 9);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 10);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '4');
INSERT INTO authors_books (author_id, book_id) VALUES (4, 11);
INSERT INTO authors_books (author_id, book_id) VALUES (4, 12);
INSERT INTO authors_books (author_id, book_id) VALUES (4, 13);
INSERT INTO authors_books (author_id, book_id) VALUES (4, 14);
INSERT INTO authors_books (author_id, book_id) VALUES (4, 15);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '5');
INSERT INTO authors_books (author_id, book_id) VALUES (5, 11);
INSERT INTO authors_books (author_id, book_id) VALUES (5, 12);
INSERT INTO authors_books (author_id, book_id) VALUES (5, 13);
INSERT INTO authors_books (author_id, book_id) VALUES (5, 14);
INSERT INTO authors_books (author_id, book_id) VALUES (5, 15);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '6');
INSERT INTO authors_books (author_id, book_id) VALUES (6, 11);
INSERT INTO authors_books (author_id, book_id) VALUES (6, 12);
INSERT INTO authors_books (author_id, book_id) VALUES (6, 13);
INSERT INTO authors_books (author_id, book_id) VALUES (6, 14);
INSERT INTO authors_books (author_id, book_id) VALUES (6, 15);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '7');
INSERT INTO authors_books (author_id, book_id) VALUES (7, 16);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '8');
INSERT INTO authors_books (author_id, book_id) VALUES (8, 17);
INSERT INTO authors_books (author_id, book_id) VALUES (8, 18);
INSERT INTO authors_books (author_id, book_id) VALUES (8, 19);
INSERT INTO authors (first_name, last_name) VALUES ('Author', '9');
INSERT INTO authors_books (author_id, book_id) VALUES (9, 17);
INSERT INTO authors_books (author_id, book_id) VALUES (9, 18);
INSERT INTO authors_books (author_id, book_id) VALUES (9, 19);

INSERT INTO users (login, password, active, first_name, last_name) VALUES ('TestUser1', '{bcrypt}$2a$10$fuj660/plEaD0lzIYyiQx.Q7f1aXMzrZwnHUKOVy3.hJ7g/skLTse', true, 'Test', 'User');
INSERT INTO users_roles (login, role) VALUES ('TestUser1', 'ROLE_USER');
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 5);
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 6);
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 7);

INSERT INTO users (login, password, active, first_name, last_name) VALUES ('TestUser2', '{bcrypt}$2a$10$fuj660/plEaD0lzIYyiQx.Q7f1aXMzrZwnHUKOVy3.hJ7g/skLTse', true, 'Test', 'User');
INSERT INTO users_roles (login, role) VALUES ('TestUser2', 'ROLE_USER');
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 11);
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 12);
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 13);
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 14);
INSERT INTO users_borrowed_books (user_id, book_id) VALUES (1, 15);

INSERT INTO users (login, password, active, first_name, last_name) VALUES ('Admin', '{bcrypt}$2a$10$fuj660/plEaD0lzIYyiQx.Q7f1aXMzrZwnHUKOVy3.hJ7g/skLTse', true, 'Admin', 'Admin');
INSERT INTO users_roles (login, role) VALUES ('Admin', 'ROLE_ADMIN');