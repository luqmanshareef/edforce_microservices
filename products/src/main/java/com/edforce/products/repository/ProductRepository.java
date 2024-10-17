package com.edforce.products.repository;

import com.edforce.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameLike(String name);

    List<Product> findByNameContainsIgnoreCase(String name);

    Page<Product> findByNameContainsIgnoreCase(String name, Pageable pageable);

   List<Product> findByPriceBetween(Double min, Double max);

    Optional<Product> findByName(String name, Sort sort);

}
