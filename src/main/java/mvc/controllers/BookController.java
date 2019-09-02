//package mvc.controllers;
//
//import core.services.BookService;
//import dto.BookDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/book")
//public class BookController {
//
//    private BookService bookService;
//
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @GetMapping("/{id:0|[0-9]*}")
//    public String get(@PathVariable("id") Long id, Model model) {
//
//        BookDTO bookDTO = new BookDTO().convertToDTO(bookService.getBookById(id));
//        model.addAttribute("book", bookDTO);
//
//        return "book";
//    }
//
//    @GetMapping("/error")
//    public String error(Model model) {
//        model.addAttribute("book", new BookDTO());
//
//        return "book";
//    }
//}
