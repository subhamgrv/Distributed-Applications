package com.example.demo.Facade;

import com.example.demo.DTO.ProductDetailDTO;
import com.example.demo.Service.InventoryService;
import com.example.demo.cart.ShoppingService;
import com.example.demo.products.Product;
import com.example.demo.products.ProductService;
import org.springframework.stereotype.Service;

@Service
public class AddToCartFacade {

    private final ShoppingService shoppingService;
    private final InventoryService inventoryService;
    private final ProductService productService;

    public  AddToCartFacade(ShoppingService shoppingService, InventoryService inventoryService,ProductService productService) {

        this.shoppingService = shoppingService;
        this.inventoryService = inventoryService;
        this.productService=productService;

    }

    public boolean insertAllowed(int id){
       return inventoryService.stockProProduct(id)>0? true:false;
    }

    public void manageStockadd(int id){
        if(insertAllowed(id)){
            shoppingService.addProduct(id);
            inventoryService.reduceStock(productService.getById(id));
        }else{
            return ;
        }
    }

    public boolean removeAllowed(int id){
        return shoppingService.getCart().getOrDefault(productService.getById(id),0) > 0 ? true :false;
    }
    public void manageStockremove(int id){
        if(removeAllowed(id)){
            shoppingService.removeProduct(id);
            inventoryService.increaseStock(productService.getById(id));
        }
    }


}
