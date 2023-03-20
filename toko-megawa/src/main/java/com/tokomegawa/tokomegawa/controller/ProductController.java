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

import com.tokomegawa.tokomegawa.convert.ProductConvert;
import com.tokomegawa.tokomegawa.dto.ProductDto;
import com.tokomegawa.tokomegawa.mapper.ProductMapper;
import com.tokomegawa.tokomegawa.model.Product;
import com.tokomegawa.tokomegawa.service.ProductService;

@RestController
@RequestMapping("/tokomegawa/api/product")
public class ProductController {

  ProductService productService;
  ProductMapper productMapper;

  public ProductController(ProductService productService, ProductMapper productMapper) {
    this.productService = productService;
    this.productMapper = productMapper;
  }
  
  @GetMapping("/getProducts")
  public ResponseEntity<List<ProductDto>> listAllProducts() {
    List<Product> product = productService.listAllProducts();
    return ResponseEntity.ok(ProductConvert.convertProductDtoList(product));
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<?> findProductById(@PathVariable("id") Long id) {
    try {
      Product product = productService.findProductById(id);
      return ResponseEntity.ok(productMapper.toDto(product));
    } catch (Exception e) {
      return new ResponseEntity<String>("O produto não foi encontrado.", HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<?> saveProduct(@RequestBody ProductDto dto) {
    try {
      var newProduct = productService.saveProduct(dto);
      return ResponseEntity.ok(productMapper.toDto(newProduct));
    } catch (Exception e) {
      System.out.println(" -> Erro: " + e.getMessage());
      return new ResponseEntity<String>("Erro ao tentar salvar o produto.", HttpStatus.BAD_REQUEST);
    }
  }

}
