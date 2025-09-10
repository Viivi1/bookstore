package hh.backend.bookstore.web;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    public String showIndex(){
        return "index"; //index.html
    }
    // KIRJAN LISÄYS
    @GetMapping("/add")
    public String showAddBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook"; //addbook.html
    }
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    // KIRJAN POISTO 
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model){
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }

    // KIRJAN MUOKKAUS
    @GetMapping("/edit/{id}")
    public String showEditBook(@PathVariable("id") Long id, Model model){
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "editbook"; //editbook.html
    }
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    // KIRJAT LISTATTUNA
    @GetMapping("/booklist")
    public String showBookList(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist"; //booklist.html
    }
}
