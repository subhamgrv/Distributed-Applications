package com.example.demo.DTO;

import com.example.demo.Service.InventoryService;
import com.example.demo.products.Product;
import com.example.demo.products.ProductService;

public class ProductDetailDTO {
    private Product product;
    private Integer stock;
    private boolean isSoldOut;


    public ProductDetailDTO(Product product,Integer stock,boolean isSoldOut){
        this.product=product;
        this.stock=stock;
        this.isSoldOut=isSoldOut;
    }

    public ProductDetailDTO(){

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }




}


