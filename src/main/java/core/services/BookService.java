package core.services;

import data.model.Book;
import data.repositories.BookRepository;
import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
