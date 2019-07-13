package mvc.controllers;

import core.services.AuthorService;
import core.services.BookService;
import dto.AuthorDTO;
import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/search")
public class SearchController {

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public SearchController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String get() {
        return "search";
    }

    @PostMapping
    public String post(Model model, @RequestParam String search) {

        String[] values = search.split(" ");
        Set<BookDTO> searchResult = new HashSet<>();
        Set<AuthorDTO> foundAuthors = new HashSet<>();
        for (String value : values) {
            searchResult.addAll(bookService.searchByTitle(value));
            foundAuthors.addAll(authorService.searchByFirstNameAndLastName(value));
        }
        searchResult.addAll(bookService.searchByAuthors(foundAuthors));
        model.addAttribute("searchResult", searchResult);

        return "search";
    }
}
