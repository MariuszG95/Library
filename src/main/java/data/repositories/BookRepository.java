package data.repositories;

import data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookById(Long id);

    Set<Book> getBookByTitleContains(String value);

    @Query(value = "SELECT book_id from authors_books WHERE author_id = ?", nativeQuery = true)
    Long[] getBooksIdByAuthorId(Long id);
}
