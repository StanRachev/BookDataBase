package com.stan.BookDataBase.Controllers;

import com.stan.BookDataBase.Services.BookService;
import com.stan.BookDataBase.models.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
