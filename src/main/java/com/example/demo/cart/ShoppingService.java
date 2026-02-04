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

        Map<Integer,Integer> shoppingCart ;

        public ShoppingService(ProductService productService){
        this.productService=productService;
        shoppingCart = new HashMap<>();
        }


        public Map<Integer,Integer> getCart(){
            System.out.println(shoppingCart.entrySet().toString());
            return  shoppingCart;
        }


        public Map<Integer,Integer> addProduct(int id){
            Product p = productService.getById(id);
            shoppingCart.put(p.getId(),shoppingCart.getOrDefault(p.getId(),0)+1);
        return  shoppingCart;}


            public Map<Integer,Integer> removeProduct(int id){
                Product p = productService.getById(id);
                shoppingCart.put(p.getId(),shoppingCart.get(p.getId())-1);
                if(shoppingCart.get(p.getId())==0){
                    shoppingCart.remove(p.getId());
                }


            return  shoppingCart;}


        public  Map<Product,Integer> presentCart(){
            Map<Product,Integer> presentCart = new HashMap<>();
            for (Integer id : shoppingCart.keySet()){
                presentCart.put(productService.getById(id),shoppingCart.get(id));
            }


        return presentCart;}


}
