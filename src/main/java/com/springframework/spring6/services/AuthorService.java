package com.springframework.spring6.services;

import com.springframework.spring6.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
