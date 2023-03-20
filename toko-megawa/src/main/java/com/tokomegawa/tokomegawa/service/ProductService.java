package com.tokomegawa.tokomegawa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tokomegawa.tokomegawa.dto.ProductDto;
import com.tokomegawa.tokomegawa.model.Product;
import com.tokomegawa.tokomegawa.repository.ProductRepository;

@Service
public class ProductService {

  ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  public List<Product> listAllProducts() {
    return productRepository.findAll();
  }

  public Product findProductById(Long id) {
    return productRepository.findProductById(id);
  }

  public List<Product> listProductsByCategory(String category) {
    return productRepository.findByCategory(category);
  }

  public Product saveProduct(ProductDto dto) {
    Product saveReturn = null;
    Product product = null;
    
    if (dto.getCode() != null) {
      product = productRepository.findById(dto.getCode()).get();
      if (product != null) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.getCategory().setName(dto.getCategory().getName());
        product.getCategory().setCreatedDate(dto.getCategory().getCreatedDate());
        product.setCurrency(dto.getCurrency());
        product.setPrice(dto.getPrice());
        product.setCreatedDate(dto.getCreatedDate());
        product.setUpdatedDate(LocalDateTime.now());
      } else {
        return null;
      }
    } else {
      saveReturn = productRepository.save(product);
      return saveReturn != null ? saveReturn : null;
    }
    return null;
  }

}
