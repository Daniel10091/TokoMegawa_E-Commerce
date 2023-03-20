package com.tokomegawa.tokomegawa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
  
  @Id
  @Column(name = "id")
  private Long id;
  
  @Column(name = "image")
  private byte[] image;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  @Column(name = "description", nullable = false)
  private String description;
  
  @OneToOne
  @JoinColumn(name = "category")
  private Category category;
  
  @Column(name = "currency", nullable = false)
  private String currency;
  
  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "rating", nullable = false)
  private Integer rating;

  @Column(name = "created_date")
  @CreationTimestamp
  private LocalDateTime createdDate;

  @Column(name = "updated_date")
  @CreationTimestamp
  private LocalDateTime updatedDate;

}
