package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // pöllitty carcrud projektista

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	  	log.info("save a couple of books");
		repository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "123456789", 19.99));
		repository.save(new Book("1984", "George Orwell", 1949, "987654321", 14.99));
		repository.save(new Book("Kafka on the Shore", "Haruki Murakami", 2002, "112345111", 21.99));
	};
	}
}
