package com.example.demo.cart;

import java.util.Map;
import com.example.demo.products.Currency;

public class ShoppingCart {

    private Map<Integer,Integer> items;
    private Boolean voucherUsed ;
    private Currency currency;



    public void setCurrency(Currency currency){
        this.currency=currency;
    }
    public Currency getCurrency(){
        return currency;
    }


    public void setVoucherUsed(Boolean voucherUsed) {
        this.voucherUsed = voucherUsed;
    }

    public Boolean getVoucherUsed() {
        return voucherUsed;
    }

    public ShoppingCart(){

    }
    public ShoppingCart(Map<Integer, Integer> items, boolean voucherUsed,Currency currency){
        this.voucherUsed=voucherUsed;
    this.items =items;
    this.currency=currency;}


    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }


}
