package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.domain.Author;
import com.springframework.spring5webapp.domain.Book;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author Jon = new Author("Jon", "Test");
        Book greatNovel = new Book("Test Run Novel", "1337");
        Jon.getBooks().add((greatNovel));
        greatNovel.getAuthors().add(Jon);

        authorRepository.save(Jon);
        bookRepository.save(greatNovel);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
