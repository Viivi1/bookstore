package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> findBookId(@PathVariable("id") Long bookId){
        return bookRepository.findById(bookId);
    }
}
