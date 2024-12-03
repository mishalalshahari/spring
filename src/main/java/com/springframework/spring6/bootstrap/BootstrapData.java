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

        Publisher the1961company = new Publisher();
        the1961company.setPublisherName("The 1961 Company");
        the1961company.setAddress("Garun Nagar");
        the1961company.setCity("Padrauna");
        the1961company.setState("Uttar Pradesh");
        the1961company.setZip(274304);

        Author mishalSaved = authorRepository.save(mishal);
        Book since1961Saved = bookRepository.save(since1961);
        Publisher the1961companySaved = publisherRepository.save(the1961company);

        Author navneet = new Author();
        navneet.setFirstName("Navneet");
        navneet.setLastName("Gupta");

        Book lop = new Book();
        lop.setTitle("Life of Pie");
        lop.setIsbn("987654321");

        Publisher navneetpublication = new Publisher();
        navneetpublication.setPublisherName("Navneet Publication");
        navneetpublication.setAddress("Shahganj");
        navneetpublication.setCity("Jaunpur");
        navneetpublication.setState("Uttar Pradesh");
        navneetpublication.setZip(223103);

        Author navneetSaved = authorRepository.save(navneet);
        Book lopSaved = bookRepository.save(lop);
        Publisher navneetpublicationSaved = publisherRepository.save(navneetpublication);

        mishalSaved.getBooks().add(since1961);
        navneetSaved.getBooks().add(lopSaved);

        authorRepository.save(mishalSaved);
        authorRepository.save(navneetSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
