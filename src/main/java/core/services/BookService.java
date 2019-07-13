package core.services;

import data.model.Book;
import data.repositories.BookRepository;
import dto.AuthorDTO;
import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getOne(Long id) {
        return bookRepository.getOne(id);
    }

    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    public Set<BookDTO> getRandomBooks(int amount) {

        Long amountBooksInDB = bookRepository.count();
        Set<BookDTO> randomBooks = new HashSet<>();
        Long randomId;
        while (randomBooks.isEmpty() || randomBooks.size() < amount) {
            randomId = 1 + (long) (Math.random() * (amountBooksInDB - 1));
            randomBooks.add(new BookDTO(getOne(randomId)));
        }

        return randomBooks;
    }

    public Set<BookDTO> searchByTitle(String value) {
        Set<Book> bookSet = bookRepository.getBookByTitleContains(value);
        Set<BookDTO> foundBooks = new HashSet<>();
        for (Book book : bookSet) {
            foundBooks.add(new BookDTO(book));
        }

        return foundBooks;
    }

    public Set<BookDTO> searchByAuthors(Set<AuthorDTO> authorsDTOS) {
        ArrayList<Long[]> foundBooksId = new ArrayList<>();
        for (AuthorDTO authorDTO : authorsDTOS) {
            foundBooksId.add(bookRepository.getBooksIdByAuthorId(authorDTO.getId()));
        }
        Set<BookDTO> resultSet = new HashSet<>();
        for (Long[] arr : foundBooksId) {
            for (Long l : arr) {
                resultSet.add(new BookDTO(bookRepository.getBookById(l)));
            }
        }

        return resultSet;
    }

    public Long getAmountOfAvailableBooks(Long bookId) {

        Set<BookDTO> sameBooksInDB = getSameBooksFromDB(new BookDTO(bookRepository.getBookById(bookId)));
        long avabialeBooks = (long) sameBooksInDB.size();
        Long[] borrowedBooksId = bookRepository.getBorrowedBooksIds();
        for (Long l : borrowedBooksId) {
            for (BookDTO book : sameBooksInDB) {
                if (book.getId() == l) {
                    avabialeBooks--;
                }
            }
        }

        return avabialeBooks;
    }

    public void borrowBook(Long userId, Long bookId) {

        bookRepository.insertBorrowedBook(userId, bookId);
    }

    private Set<BookDTO> getSameBooksFromDB(BookDTO bookDTO) {
        Set<BookDTO> bookDTOS = new HashSet<>();
        for (Book book : bookRepository.getBookByTitle(bookDTO.getTitle())) {
            bookDTOS.add(new BookDTO(book));
        }

        return bookDTOS;
    }
}
