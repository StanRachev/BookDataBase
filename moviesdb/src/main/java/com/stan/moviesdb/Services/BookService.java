package com.stan.moviesdb.Services;

import com.stan.moviesdb.Repositories.BookRepository;
import com.stan.moviesdb.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getByKeyword(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }

        return bookRepository.findAll();
    }

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
