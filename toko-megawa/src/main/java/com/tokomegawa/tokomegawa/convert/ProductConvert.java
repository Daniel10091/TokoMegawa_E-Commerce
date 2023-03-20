package com.tokomegawa.tokomegawa.convert;

import java.util.List;
import java.util.stream.Collectors;

import com.tokomegawa.tokomegawa.dto.ProductDto;
import com.tokomegawa.tokomegawa.model.Product;

public class ProductConvert {
  
  public static ProductDto convertProductDto(Product product) {
    ProductDto dto = new ProductDto();
    dto.setCode(product.getId());
    dto.setImage(product.getImage());
    dto.setName(product.getName());
    dto.setDescription(product.getDescription());
    dto.getCategory().setCode(product.getCategory().getId());
    dto.getCategory().setName(product.getCategory().getName());
    dto.setCurrency(product.getCurrency());
    dto.setPrice(product.getPrice());
    dto.setRating(product.getRating());
    dto.setCreatedDate(product.getCreatedDate());
    dto.setUpdatedDate(product.getUpdatedDate());
    return dto;
  }

  public static List<ProductDto> convertProductDtoList(List<Product> product) {
    return product.stream().map(ProductConvert::convertProductDto).collect(Collectors.toList());
  }
  
  public static Product convertProductEntity(ProductDto dto) {
    Product product = new Product();
    product.setId(dto.getCode());
    product.setImage(dto.getImage());
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.getCategory().setId(dto.getCategory().getCode());
    product.getCategory().setName(dto.getCategory().getName());
    product.setCurrency(dto.getCurrency());
    product.setPrice(dto.getPrice());
    product.setRating(dto.getRating());
    product.setCreatedDate(dto.getCreatedDate());
    product.setUpdatedDate(dto.getUpdatedDate());
    return product;
  }

  public static List<Product> convertProductEntityList(List<ProductDto> dto) {
    return dto.stream().map(ProductConvert::convertProductEntity).collect(Collectors.toList());
  }

}
