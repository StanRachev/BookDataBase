package com.stan.moviesdb.Controllers;

import org.springframework.ui.Model;
import com.stan.moviesdb.Services.BookService;
import com.stan.moviesdb.models.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookFormController {

    @Autowired
    private BookService bookService;

    @GetMapping("/add-book")
    public String showCreateForm(Book book) {
        return "NewBook";
    }

    @PostMapping("/book")
    public String createBook(@Valid Book newBook, BindingResult result, Model model) {
        Book book = new Book();
        book.setSummary(newBook.getSummary());
        bookService.save(newBook);
        return "redirect:/";
    }

    @GetMapping(path = {"/","/search"})
    public String getBooks(Model model, @Param("keyword") String keyword) {
        List<Book> books = bookService.getByKeyword(keyword);
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);
        return "keyword";
    }
}
