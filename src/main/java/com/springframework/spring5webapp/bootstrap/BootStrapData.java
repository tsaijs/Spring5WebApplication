package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.domain.Author;
import com.springframework.spring5webapp.domain.Book;
import com.springframework.spring5webapp.domain.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");

        Publisher weebPub = new Publisher("Weeb Publishing", "13337 Elite Ave.", "Los Angeles", "CA", "90703");
        publisherRepository.save(weebPub);

        Author Jon = new Author("Jon", "Test");
        Book greatNovel = new Book("Test Run Novel", "1337");

        Jon.getBooks().add((greatNovel));
        greatNovel.getAuthors().add(Jon);
        greatNovel.setPublisher(weebPub);
        weebPub.getBooks().add(greatNovel);

        authorRepository.save(Jon);
        bookRepository.save(greatNovel);
        publisherRepository.save(weebPub);

        Author Pip = new Author("Pipster", "Pippa");
        Book hhhNovel = new Book("Generic Isekai", "983231");

        Pip.getBooks().add(hhhNovel);
        hhhNovel.getAuthors().add(Pip);
        hhhNovel.setPublisher(weebPub);
        weebPub.getBooks().add(hhhNovel);

        authorRepository.save(Pip);
        bookRepository.save(hhhNovel);
        publisherRepository.save(weebPub);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Pip's number of Books: " + Pip.getBooks().size());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("weebPub number of Books: " + weebPub.getBooks().size());
    }
}
