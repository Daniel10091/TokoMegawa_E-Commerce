package com.tokomegawa.tokomegawa.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
  
  private Long code;
  private byte[] image;
  private String name;
  private String description;
  private CategoryDto category;
  private String currency;
  private Double price;
  private Integer rating;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

}
