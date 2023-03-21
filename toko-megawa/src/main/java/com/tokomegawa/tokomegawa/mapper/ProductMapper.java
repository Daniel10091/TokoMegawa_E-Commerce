package com.tokomegawa.tokomegawa.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tokomegawa.tokomegawa.dto.ProductDto;
import com.tokomegawa.tokomegawa.model.Product;

@Mapper
public interface ProductMapper {
  
  @Mapping(source = "product.id", target = "code")
  @Mapping(source = "product.category.id", target = "categoryCode")
  ProductDto toDto(Product product);

  @InheritInverseConfiguration
  Product toEntiry(ProductDto productDto);

}
