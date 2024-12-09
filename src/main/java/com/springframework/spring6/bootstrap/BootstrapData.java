package com.springframework.spring6.bootstrap;

import com.springframework.spring6.domain.Author;
import com.springframework.spring6.domain.Book;
import com.springframework.spring6.domain.Publisher;
import com.springframework.spring6.repositories.AuthorRepository;
import com.springframework.spring6.repositories.BookRepository;
import com.springframework.spring6.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        since1961Saved.getAuthors().add(mishalSaved);
        lopSaved.getAuthors().add(navneetSaved);

        Publisher sunbooks = new Publisher();
        sunbooks.setPublisherName("Sun Books");
        sunbooks.setAddress("Garun Nagar");
        sunbooks.setCity("Padrauna");
        sunbooks.setState("Uttar Pradesh");
        sunbooks.setZip(274304);

        Publisher sunbooksSaved = publisherRepository.save(sunbooks);

        since1961Saved.setPublisher(sunbooksSaved);
        lopSaved.setPublisher(sunbooksSaved);

        authorRepository.save(mishalSaved);
        authorRepository.save(navneetSaved);
        bookRepository.save(since1961Saved);
        bookRepository.save(lopSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
