package com.springframework.spring6.repositories;

import com.springframework.spring6.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
