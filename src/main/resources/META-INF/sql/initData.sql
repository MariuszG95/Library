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

INSERT INTO books (title) VALUES ('Pan Tadeusz');
INSERT INTO books (title) VALUES ('Pan Tadeusz');
INSERT INTO books (title) VALUES ('Pan Tadeusz');
INSERT INTO books (title) VALUES ('Krzyżacy');
INSERT INTO books (title) VALUES ('Krzyżacy');
INSERT INTO books (title) VALUES ('Potop');
INSERT INTO books (title) VALUES ('Quo vadis?');
INSERT INTO books (title) VALUES ('Quo vadis?');
INSERT INTO books (title) VALUES ('Quo vadis?');
INSERT INTO books ( title) VALUES ('Quo vadis?');
INSERT INTO books (title) VALUES ('Lalka');
INSERT INTO books (title) VALUES ('Lalka');
INSERT INTO books (title) VALUES ('Lalka');
INSERT INTO books (title) VALUES ('Lalka');
INSERT INTO books (title) VALUES ('Lalka');
INSERT INTO books (title) VALUES ('Wesele');
INSERT INTO books (title) VALUES ('Ferdydurke');
INSERT INTO books (title) VALUES ('Ferdydurke');
INSERT INTO books (title) VALUES ('Ferdydurke');

INSERT INTO authors (first_name, last_name) VALUES ('Adam', 'Mickiewicz');
INSERT INTO authors_books (author_id, book_id) VALUES (1, 1);
INSERT INTO authors_books (author_id, book_id) VALUES (1, 2);
INSERT INTO authors_books (author_id, book_id) VALUES (1, 3);
INSERT INTO authors (first_name, last_name) VALUES ('Henryk', 'Sienkiewicz');
INSERT INTO authors_books (author_id, book_id) VALUES (2, 4);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 5);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 6);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 7);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 8);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 9);
INSERT INTO authors_books (author_id, book_id) VALUES (2, 10);
INSERT INTO authors (first_name, last_name) VALUES ('Bolesław', 'Prus');
INSERT INTO authors_books (author_id, book_id) VALUES (3, 11);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 12);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 13);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 14);
INSERT INTO authors_books (author_id, book_id) VALUES (3, 15);
INSERT INTO authors (first_name, last_name) VALUES ('Stanisław', 'Wyspiański');
INSERT INTO authors_books (author_id, book_id) VALUES (4, 16);
INSERT INTO authors (first_name, last_name) VALUES ('Witold', 'Gombrowicz');
INSERT INTO authors_books (author_id, book_id) VALUES (5, 17);
INSERT INTO authors_books (author_id, book_id) VALUES (5, 18);
INSERT INTO authors_books (author_id, book_id) VALUES (5, 19);

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