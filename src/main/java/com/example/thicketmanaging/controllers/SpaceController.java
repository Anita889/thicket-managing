package com.example.thicketmanaging.controllers;


import com.example.thicketmanaging.dataservices.CategoryDataService;
import com.example.thicketmanaging.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {

    private final CategoryDataService categoryService;

    public SpaceController(CategoryDataService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllSpaces() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getSpaceById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createSpace(@RequestBody Category space) {
        return categoryService.createCategory(space);
    }

    @PutMapping("/{id}")
    public Optional<Category> updateSpace(@PathVariable Long id, @RequestBody Category space) {
        return categoryService.updateCategory(id, space);
    }

    @DeleteMapping("/{id}")
    public void deleteSpace(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
