package com.springframework.spring6.repositories;

import com.springframework.spring6.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
