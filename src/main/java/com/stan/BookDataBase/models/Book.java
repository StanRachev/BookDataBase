package com.stan.moviesdb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String author;
     private String name;
     private String summary;
     private int pages;
     private String genre;
     private String language;

    @Override
    public String toString() {
        return String.format("%s - %s", author, name);
    }
}
