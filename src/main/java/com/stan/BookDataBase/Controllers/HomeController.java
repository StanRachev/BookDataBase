package com.stan.BookDataBase.Controllers;

import com.stan.BookDataBase.Services.BookService;
import com.stan.BookDataBase.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books", bookService.getAll());
        return modelAndView;
    }

    @GetMapping(path = {"/","/search"})
    public String getBooks(Model model, @Param("keyword") String keyword) {
        List<Book> books = bookService.getByKeyword(keyword);
//        model.addAttribute("books", books);
        model.addAttribute("books", books);
        return "keyword";
    }
}
