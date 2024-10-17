package com.edforce.products.service;

import com.edforce.products.entity.Product;
import com.edforce.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);

    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Page<Product> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }
    public Page<Product> searchProductByName(String keyword, Pageable pageable){

//        productRepository.findByName(keyword, Sort.by(Sort.Direction.ASC));

        return productRepository.findByNameContainsIgnoreCase(keyword, pageable);
    }

    public List<Product> searchProductByPriceRange(Double min, Double max){
        return productRepository.findByPriceBetween(min, max);
    }


    public Product addProduct(Product p){
        return productRepository.save(p);
    }
    public Product updateProduct(Long id, Product p){
        Product product = getProduct(id);
        if (product!= null){
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            product.setDescription(p.getDescription());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
