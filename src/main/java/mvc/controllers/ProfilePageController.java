//package mvc.controllers;
//
//import core.services.UserService;
//import data.model.Book;
//import data.model.User;
//import dto.BookDTO;
//import dto.LoggedUserDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping("/profile")
//public class ProfilePageController {
//
//    private UserService userService;
//
//    @Autowired
//    public ProfilePageController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String get() {
//        return "profile";
//    }
//
//    @GetMapping("/delete-book/{id:0|[0-9]*}")
//    public String delete(HttpServletRequest request, @PathVariable("id") Long id) {
//
//        LoggedUserDTO userDTO = (LoggedUserDTO) request.getSession().getAttribute("user");
////        for (Book borrowedBook : userDTO.get()) {
////            if (borrowedBook.getId() == id) {
////                userDTO.getBorrowedBooks().remove(borrowedBook);
////                break;
////            }
////        }   KOD NA USUWANIE KSIĄŻKI
//        userService.save(userDTO.getUser());
//
//        return "profile";
//    }
//}
