package com.example.demo.products;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private final ProductService  productService;

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

    @GetMapping("/Products/delete/{id}")
    public void deleteProductById(@PathVariable int id){
         productService.deleteProductById(id);
    }


    @GetMapping("/Products/color/{color}")
    public List<Product> getProductByColor(@PathVariable String color){
        return productService.getProductByColor(color);}

    @PostMapping("/addedproduct")
    public Product addedNewProduct(@RequestParam String name,@RequestParam Double price, @RequestParam String color){
        return productService.addedNewProduct(name,price,color);
    }

    @PostMapping("/addedproductasjson")
    public Product formdata(@RequestBody Product p){
        return productService.addedNewProductwithrequestbody(p);
    }

    @DeleteMapping("/Deletedproductasjson")
    public void deleteProduct(@RequestBody Map<String,Integer> mp){
        productService.deletedProductwithrequestbody(mp.get("id"));

    }

    @PutMapping("/updateproductasjson")
    public void updateProduct(@RequestBody Product p){
        productService.updateProductwithrequestbody(p);
    }




}
