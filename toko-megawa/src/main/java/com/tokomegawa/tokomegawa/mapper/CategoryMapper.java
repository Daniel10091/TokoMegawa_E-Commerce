package com.tokomegawa.tokomegawa.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tokomegawa.tokomegawa.dto.CategoryDto;
import com.tokomegawa.tokomegawa.model.Category;

@Mapper
public interface CategoryMapper {
  
  @Mapping(source = "category.id", target = "code")
  CategoryDto toDto(Category category);

  @InheritInverseConfiguration
  Category toEntity(CategoryDto categoryDto);

}
