package com.example.thicketmanaging.repositories;

import com.example.thicketmanaging.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByProjectId(Long projectId);

}
