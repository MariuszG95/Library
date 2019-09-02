package mvc.controllers;

import core.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private BookService bookService;

    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String get(Model model) {

        //Set<BookDTO> randomBookSet = bookService.getRandomBooks(5);
        //model.addAttribute("randomBookSet", randomBookSet);


        return "home";
    }
}
