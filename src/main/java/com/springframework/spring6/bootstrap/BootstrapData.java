package com.springframework.spring6.bootstrap;

import com.springframework.spring6.domain.Author;
import com.springframework.spring6.domain.Book;
import com.springframework.spring6.repositories.AuthorRepository;
import com.springframework.spring6.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author mishal = new Author();
        mishal.setFirstName("Mishal");
        mishal.setLastName("Al Shahari");

        Book since1961 = new Book();
        since1961.setTitle("Since 1961");
        since1961.setIsbn("123456789");

        Author mishalSaved = authorRepository.save(mishal);
        Book since1961Saved = bookRepository.save(since1961);

        Author navneet = new Author();
        navneet.setFirstName("Navneet");
        navneet.setLastName("Gupta");

        Book lop = new Book();
        lop.setTitle("Life of Pie");
        lop.setIsbn("987654321");

        Author navneetSaved = authorRepository.save(navneet);
        Book lopSaved = bookRepository.save(lop);

        mishalSaved.getBooks().add(since1961);
        navneetSaved.getBooks().add(lopSaved);

        authorRepository.save(mishalSaved);
        authorRepository.save(navneetSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
