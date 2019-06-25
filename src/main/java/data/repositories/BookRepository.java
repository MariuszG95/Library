package data.repositories;

import data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookById(Long id);

    Set<Book> getBookByTitleContains(String value);

    @Query(value = "SELECT book_id from authors_books WHERE author_id = ?", nativeQuery = true)
    Long[] getBooksIdByAuthorId(Long id);

    Set<Book> getBookByTitle(String title);

    @Query(value = "SELECT book_id FROM users_borrowed_books", nativeQuery = true)
    Long[] getBorrowedBooksIds();

    @Modifying
    @Query(value = "INSERT INTO users_borrowed_books (user_id, book_id) VALUES (?1, ?2)", nativeQuery = true)
    void insertBorrowedBook(Long userId, Long bookId);
}
