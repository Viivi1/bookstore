package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.AppUser;
import hh.backend.bookstore.domain.AppUserRepository;
import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // pöllitty carcrud projektista

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository,
	 AppUserRepository appUserRepository) {
	return (args) -> {
		log.info("save some categories");
		Category fantasy = categoryRepository.save(new Category(null, "Fantasy"));
		Category scifi = categoryRepository.save(new Category(null, "Scifi"));
		Category history = categoryRepository.save(new Category(null, "History"));	

	  	log.info("save a couple of books");
		repository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "123456789", 19.99, fantasy));
		repository.save(new Book("1984", "George Orwell", 1949, "987654321", 14.99, scifi));
		repository.save(new Book("Kafka on the Shore", "Haruki Murakami", 2002, "112345111", 21.99, fantasy));
		
		// USERS
		AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		appUserRepository.save(user1);
		appUserRepository.save(user2);
	};
}
}
