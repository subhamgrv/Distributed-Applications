package com.example.demo.Service;

import com.example.demo.cart.ShoppingService;
import com.example.demo.products.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {
        private Map<Integer,Integer >  stockcount;
        private final ShoppingService shoppingService;
    public InventoryService(ShoppingService shoppingService){
        this.shoppingService=shoppingService;
        stockcount=new HashMap<>();

        // Hardcoded initial stock for product ids 1..12
        stockcount.put(1, 10);   // T-Shirt Blue
        stockcount.put(2, 6);    // T-Shirt Black
        stockcount.put(3, 3);    // Hoodie Gray
        stockcount.put(4, 2);    // Hoodie Blue
        stockcount.put(5, 5);    // Jeans Blue
        stockcount.put(6, 4);    // Jeans Black
        stockcount.put(7, 1);    // Sneakers White
        stockcount.put(8, 0);    // Sneakers Black (sold out example)
        stockcount.put(9, 8);    // Cap Red
        stockcount.put(10, 7);   // Cap Blue
        stockcount.put(11, 12);  // Socks (3-pack)
        stockcount.put(12, 2);   // Jacket Green
    }

    public  int stockProProduct(int id){
        return stockcount.getOrDefault(id,0);
    }


    public void reduceStock(Product product){
       int available= stockcount.getOrDefault(product.getId(),0)-1;
       stockcount.put(product.getId(),available);
 }


    public void increaseStock(Product product){
        int newStock= stockcount.getOrDefault(product.getId(),0)+1;
        stockcount.put(product.getId(),newStock);
              }




}
