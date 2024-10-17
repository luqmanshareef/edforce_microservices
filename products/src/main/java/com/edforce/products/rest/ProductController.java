package com.edforce.products.rest;

import com.edforce.products.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static List<Product> products = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity(products,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        for (Product p :products){
            if (id.equals(p.getId())){
                return new ResponseEntity<>(p, HttpStatusCode.valueOf(200));
            }
        }
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam(value = "name" ,required = false, defaultValue = "a") String name){
        List<Product> found = new ArrayList<>();
        for (Product p :products) {
            if (p.getName().contains(name)) {
                found.add(p);
            }
        }
        return ResponseEntity.ok(found);
    }

    @Operation(summary = "Add a new product", description = "Allows admin to add a new product to their inventory.")
    @PostMapping()
    public Product createProduct(@RequestBody(required = false) Product product){
        System.out.println("in createProduct : " + product.getName());
        product.setId(""+new Random().nextInt());
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product){

        for (Product p :products){
            if (id.equals(p.getId())){
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                p.setPrice(product.getPrice());
                return p;
            }
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id){

        Product toDelete = null;
        for (Product p :products){
            if (id.equals(p.getId())){
                toDelete = p;
            }
        }
        products.remove(toDelete);
    }

}
