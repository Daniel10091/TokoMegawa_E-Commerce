package com.tokomegawa.tokomegawa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokomegawa.tokomegawa.convert.CategoryConvert;
import com.tokomegawa.tokomegawa.dto.CategoryDto;
import com.tokomegawa.tokomegawa.model.Category;
import com.tokomegawa.tokomegawa.service.CategoryService;

@RestController
@RequestMapping("/tokomegawa/api/category")
public class CategoryController {
  
  CategoryService categoryService;
  
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/getCategories")
  public ResponseEntity<List<CategoryDto>> listAllCategories() {
    List<Category> categories = categoryService.listAllCategories();
    return ResponseEntity.ok(CategoryConvert.convertCategoryDtoList(categories));
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<?> findCategoryByCode(@PathVariable("id") Long id) {
    try {
      Category category = categoryService.findCategoryById(id);
      return ResponseEntity.ok(CategoryConvert.convertCategoryDto(category));
    } catch (Exception e) {
      System.out.println(" -> Erro: " + e.getMessage());
      return new ResponseEntity<String>("A categoria não foi encontrada.", HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {
    try {
      var newCategory = categoryService.saveCategory(categoryDto);
      return ResponseEntity.ok(CategoryConvert.convertCategoryDto(newCategory));
    } catch (Exception e) {
      System.out.println(" -> Erro: " + e.getMessage());
      return new ResponseEntity<String>("Erro ao tentar salvar a categoria.", HttpStatus.BAD_REQUEST);
    }
  }

}
