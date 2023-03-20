package com.tokomegawa.tokomegawa.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
  
  private Long code;
  private String name;
  private ProductDto product;
  private LocalDateTime createdDate;

}
