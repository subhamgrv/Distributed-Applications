package com.example.demo.cart;

import com.example.demo.products.Product;

import java.util.HashMap;
import java.util.Map;

public class shoppingCart {

    private Map<Product,Integer> items;

    public shoppingCart(Map items){
    this.items =items;}


    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}
