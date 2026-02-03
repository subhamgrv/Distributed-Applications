package com.example.demo.Facade;

import com.example.demo.DTO.ProductDetailDTO;
import com.example.demo.Service.InventoryService;
import com.example.demo.products.Product;
import com.example.demo.products.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailFacade {

    private final ProductService productService;
    private final InventoryService inventoryService;


    public  ProductDetailFacade(ProductService productService, InventoryService inventoryService){

        this.productService= productService;
        this.inventoryService=inventoryService;

    }

    public ProductDetailDTO buildFacade (int id){
        Product p = productService.getById(id);
        int available =inventoryService.stockProProduct(id);

    return new ProductDetailDTO(p,available,available >0 ? false :true); }



}



