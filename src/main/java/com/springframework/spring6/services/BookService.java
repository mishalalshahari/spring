package com.springframework.spring6.services;

import com.springframework.spring6.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
