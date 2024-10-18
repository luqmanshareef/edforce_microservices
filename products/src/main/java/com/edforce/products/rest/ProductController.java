package com.edforce.products.rest;

import com.edforce.products.entity.Product;
import com.edforce.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Value("${organization.name}")
    private String orgName;

    @Value("${organization.location}")
    private String location;

    @Autowired
    private ProductService productService;


//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts(){
////        System.out.println("Org Name : " + orgName + " At : " + location);
//
//        List<Product> productsPage = productService.getAllProducts();
//        return ResponseEntity.ok(productsPage);
//    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProductsByPage(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "pageSize", defaultValue = "999999999") Integer pageSize,
                                                              @RequestParam(value = "sortBy", defaultValue = "price") String sortBy, @RequestParam(value = "order", defaultValue = "ASC") String order){
//        System.out.println("Org Name : " + orgName + " At : " + location);
        Sort.Direction direction =  Sort.Direction.ASC;

        if (  order.equals("ASC") ){
            direction = Sort.Direction.ASC;

        }else if(  order.equals("DESC") ){
            direction = Sort.Direction.DESC;

        }
        Page<Product> productsPage = productService.getAllProducts(PageRequest.of(page,pageSize, Sort.by(direction,sortBy)));
        return ResponseEntity.ok(productsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){

        System.out.println("Location is : "  + location) ;
        Product p = productService.getProduct(id);
        return new ResponseEntity<>(p, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchByName(@RequestParam(value = "name") String name, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "pageSize", defaultValue = "999999999") Integer pageSize, @RequestParam(value = "sortBy", defaultValue = "price") String sortBy,
                                                      @RequestParam(value = "orderBy", defaultValue = "ASC") String orderBy){
        Sort.Direction direction =  Sort.Direction.ASC;

        if (  orderBy.equals("ASC") ){
            direction = Sort.Direction.ASC;

        }else if(  orderBy.equals("DESC") ){
            direction = Sort.Direction.DESC;

        }


        Page<Product> found = productService.searchProductByName(name, PageRequest.of(page,pageSize,Sort.by(direction,sortBy)));
        return ResponseEntity.ok(found);
    }

    @GetMapping("/searchByPRiceRange")
    public ResponseEntity<List<Product>> searchByPriceRange(@RequestParam(value = "min") Double min, @RequestParam(value = "max") Double max){
        List<Product> found = productService.searchProductByPriceRange(min, max);
        return ResponseEntity.ok(found);
    }

    @Operation(summary = "Add a new product", description = "Allows admin to add a new product to their inventory.")
    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody(required = false) @Valid Product product){
        Product p = productService.addProduct(product);
        return ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@Valid  @RequestBody Product product){
        return productService.updateProduct(id, product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

}
