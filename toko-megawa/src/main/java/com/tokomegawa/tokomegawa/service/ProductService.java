package com.tokomegawa.tokomegawa.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tokomegawa.tokomegawa.dto.ProductDto;
import com.tokomegawa.tokomegawa.mapper.ProductMapper;
import com.tokomegawa.tokomegawa.model.Product;
import com.tokomegawa.tokomegawa.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

  ProductRepository productRepository;
  CategoryService categoryService;
  ProductMapper productMapper;

  public ProductService(
    ProductRepository productRepository, 
    CategoryService categoryService, 
    ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.categoryService = categoryService;
    this.productMapper = productMapper;
  }
  
  /**
   * @return
   */
  public List<Product> listAllProducts() {
    return productRepository.findAll();
  }

  /**
   * @param id
   * @return
   */
  public Product findProductById(Long id) {
    return productRepository.findProductById(id);
  }

  /**
   * @param category
   * @return
   */
  public List<Product> listProductsByCategory(String category) {
    return productRepository.findByCategory(category);
  }

  /**
   * @param dto
   * @return
   */
  public Product saveProduct(ProductDto dto) {
    Product saveReturn = null;
    Product product = null;
    
    if (dto.getCode() != null) {
      product = productRepository.findById(dto.getCode()).get();
      if (product != null) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());

        // product.setCategoryId(dto.getCategoryCode());

        product.setCategory(categoryService.findCategoryById(dto.getCategoryCode()));

        product.setCurrency(dto.getCurrency());
        product.setPrice(dto.getPrice());
        product.setUpdatedDate(LocalDateTime.now());
      } else {
        return null;
      }
    } else {
      product = productMapper.toEntiry(dto);
      // product = ProductConvert.convertProductEntity(dto);
    }
    saveReturn = productRepository.save(product);
    return saveReturn != null ? saveReturn : null;
  }

}
