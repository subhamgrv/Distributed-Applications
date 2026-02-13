package com.example.demo.DTO;

import com.example.demo.products.Currency;
import com.example.demo.products.Product;

import java.math.BigDecimal;

public class PriceChangeDTO {
    private Product product;
    private BigDecimal displayprice;
    private Currency currency;


    public PriceChangeDTO(Product p, BigDecimal bigDecimal, Currency active){
        this.product=p;
        this.displayprice=bigDecimal;
        this.currency=active;
    };

    public void setDisplayprice(BigDecimal displayprice) {
        this.displayprice = displayprice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getDisplayprice() {
        return displayprice;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
