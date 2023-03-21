package com.tokomegawa.tokomegawa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tokomegawa.tokomegawa.dto.CategoryDto;
import com.tokomegawa.tokomegawa.mapper.CategoryMapper;
import com.tokomegawa.tokomegawa.model.Category;
import com.tokomegawa.tokomegawa.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
  
  CategoryRepository categoryRepository;
  CategoryMapper categoryMapper;

  public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
    this.categoryRepository = categoryRepository;
    this.categoryMapper = categoryMapper;
  }

  /**
   * @return
   */
  public List<Category> listAllCategories() {
    return categoryRepository.findAll();
  }
  
  /**
   * @param id
   * @return
   */
  public Category findCategoryById(Long id) {
    return categoryRepository.findCategoryById(id);
  }

  /**
   * @param categoryDto
   * @return
   */
  public Category saveCategory(CategoryDto categoryDto) {
    Category saveReturn = null;
    Category category = null;

    if (categoryDto.getCode() != null) {
      category = categoryRepository.findById(categoryDto.getCode()).get();
      if (category != null) {
        category.setName(categoryDto.getName());
      } else {
        return null;
      }
    } else {
      category = categoryMapper.toEntity(categoryDto);
    }
    saveReturn = categoryRepository.save(category);
    return saveReturn != null ? saveReturn : null;
  }

}
