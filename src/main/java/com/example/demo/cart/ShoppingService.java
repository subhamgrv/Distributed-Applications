package com.example.demo.cart;

import com.example.demo.products.Product;
import com.example.demo.products.ProductService;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingService {

    private final ProductService productService;

        Map<Product,Integer> shoppingCart ;

        public ShoppingService(ProductService productService){
        this.productService=productService;
        shoppingCart = new HashMap<>();
        }


        public Map<Product,Integer> getCart(){
            return  shoppingCart;
        }


        public Map<Product,Integer> addProduct(int id){
            Product p = productService.getById(id);
            shoppingCart.put(p,shoppingCart.getOrDefault(p,0)+1);
        return  shoppingCart;}


            public Map<Product,Integer> removeProduct(int id){
                Product p = productService.getById(id);
                shoppingCart.put(p,shoppingCart.get(p)-1);
                if(shoppingCart.get(p)==0){
                    shoppingCart.remove(p);
                }


            return  shoppingCart;}



}
