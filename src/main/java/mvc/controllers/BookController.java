package mvc.controllers;

import core.services.BookService;
import data.model.Book;
import dto.BookDTO;
import dto.LoggedUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id:0|[0-9]*}")
    public String get(@PathVariable("id") Long id, Model model) {

        BookDTO bookDTO = new BookDTO(bookService.getBookById(id));
        model.addAttribute("book", bookDTO);
        model.addAttribute("availableAmount", bookService.getAmountOfAvailableBooks(bookDTO.getId()));

        return "book";
    }

    @GetMapping("/{id:0|[0-9]*}/borrow")
    public void borrowBook(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        LoggedUserDTO userDTO = (LoggedUserDTO) request.getSession().getAttribute("user");
//        BookDTO bookToBorrow = new BookDTO(bookService.getBookById(id));
//        for (Book borrowedBook : userDTO.getBooks()) {
//            if (borrowedBook.getTitle().equals(bookToBorrow.getTitle())) {
//                response.sendRedirect("/book/error");
//            }
//        }
        bookService.borrowBook(userDTO.getId(), id);

        response.sendRedirect("/profile");
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("book", new BookDTO());

        return "book";
    }
}
