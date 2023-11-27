package com.stan.moviesdb.Repositories;

import com.stan.moviesdb.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT * FROM Book book WHERE CONCAT" +
            "(book.author, ' ', book.name) LIKE %?1%")
    public List<Book> search(@Param("keyword") String keyword);
}
