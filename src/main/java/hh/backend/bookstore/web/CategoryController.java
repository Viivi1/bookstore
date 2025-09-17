package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; //categorylist.html
    }

    @GetMapping("/addcategory")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; //addcategory.html
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}
