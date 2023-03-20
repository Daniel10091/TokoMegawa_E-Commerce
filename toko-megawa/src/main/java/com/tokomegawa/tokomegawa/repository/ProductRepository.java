package com.tokomegawa.tokomegawa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tokomegawa.tokomegawa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("Select p from Product p where p.id = :id")
  Product findProductById(@Param("id") Long id);

  @Query("Select p from Product p where p.category.name = :category")
  List<Product> findByCategory(@Param("category") String category);
  
}
