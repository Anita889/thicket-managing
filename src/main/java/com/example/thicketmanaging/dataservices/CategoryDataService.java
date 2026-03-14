package com.example.thicketmanaging.dataservices;

import com.example.thicketmanaging.entities.Category;
import com.example.thicketmanaging.repositories.CategoryRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDataService {

    private final CategoryRepository categoryRepository;

    public CategoryDataService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoriesByProject(Long projectId) {
        return categoryRepository.findByProjectId(projectId);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> updateCategory(Long id, Category space) {
        Category category = categoryRepository.findById(id).get();
        category.setName(space.getName());
        categoryRepository.save(category);
        return Optional.of(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
