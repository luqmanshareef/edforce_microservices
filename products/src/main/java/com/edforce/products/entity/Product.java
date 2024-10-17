package com.edforce.products.entity;

import com.edforce.products.validation.ValidProductName;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
//    @ValidProductName
    private String name;

    @Positive(message = "How can you have negative price???")
    private Double price;

    @Size(min = 5, max = 25)
    private String description;

}
