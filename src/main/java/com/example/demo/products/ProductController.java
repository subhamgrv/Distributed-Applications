package com.example.demo.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    ProductController(ProductService productService) {
        this.productService= productService;
    }



//    @GetMapping("/Product")
//    public Product getProducts(){
//        return new Product(1,"Subham",2.0,"Blue");
//
//    }

    @GetMapping("/Products")
    public List<Product> getProducts(){
        return productService.getallProducts();

    }
    @GetMapping("/Products/{id}")
    public Product getProductById(@PathVariable int id){
       return productService.getById(id);}


    @GetMapping("/Products/color/{color}")
    public List<Product> getProductByColor(@PathVariable String color){
        return productService.getProductByColor(color);}


}
