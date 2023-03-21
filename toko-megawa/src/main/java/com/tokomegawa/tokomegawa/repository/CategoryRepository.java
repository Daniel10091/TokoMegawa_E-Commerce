package com.tokomegawa.tokomegawa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tokomegawa.tokomegawa.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("Select c from Category c where c.id = :id")
  Category findCategoryById(@Param("id") Long id);
  
}
