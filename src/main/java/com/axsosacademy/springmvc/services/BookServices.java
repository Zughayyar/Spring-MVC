package com.axsosacademy.springmvc.services;

import com.axsosacademy.springmvc.models.Book;
import com.axsosacademy.springmvc.models.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {
    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public Book findBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Book thisBook = this.findBookById(id);
        thisBook.setTitle(title);
        thisBook.setDescription(desc);
        thisBook.setLanguage(lang);
        thisBook.setNumberOfPages(numOfPages);
        return bookRepository.save(thisBook);
    }
}
