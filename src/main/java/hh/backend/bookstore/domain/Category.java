package hh.backend.bookstore.domain;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long categoryId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private List<Book> books;
    
    public Category(Long categoryId, String name){ //List<Book> books
        this.categoryId = categoryId;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public Category() {
        this.categoryId = null;
        this.name = null;
        this.books = null;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }
}
