package com.tokomegawa.tokomegawa.convert;

import java.util.List;
import java.util.stream.Collectors;

import com.tokomegawa.tokomegawa.dto.CategoryDto;
import com.tokomegawa.tokomegawa.model.Category;

public class CategoryConvert {
  
  public static CategoryDto convertCategoryDto(Category category) {
    CategoryDto dto = new CategoryDto();
    dto.setCode(category.getId());
    dto.setName(category.getName());
    dto.setCreatedDate(category.getCreatedDate());
    return dto;
  }
  
  public static List<CategoryDto> convertCategoryDtoList(List<Category> category) {
    return category.stream().map(CategoryConvert::convertCategoryDto).collect(Collectors.toList());
  }

  public static Category convertCategoryEntity(CategoryDto dto) {
    Category category = new Category();
    category.setId(dto.getCode());
    category.setName(dto.getName());
    category.setCreatedDate(dto.getCreatedDate());
    return category;
  }

  public static List<Category> convertCategoryEntityList(List<CategoryDto> dto) {
    return dto.stream().map(CategoryConvert::convertCategoryEntity).collect(Collectors.toList());
  }

}
