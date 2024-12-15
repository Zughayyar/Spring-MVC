package com.axsosacademy.springmvc.Controllers;

import com.axsosacademy.springmvc.models.Book;
import com.axsosacademy.springmvc.services.BookServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksApi {
    private final BookServices bookServices;
    public BooksApi(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookServices.allBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(
            @RequestParam(value = "title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages
    ) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookServices.createBook(book);
    }

    @RequestMapping("api/books/{id}")
    public Book show(@PathVariable("id") long id) {
        Book book = bookServices.findBookById(id);
        return book;
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages
    ) {
        Book book = bookServices.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookServices.deleteBook(id);
    }

}
