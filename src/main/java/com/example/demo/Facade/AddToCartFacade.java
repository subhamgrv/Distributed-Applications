package com.example.demo.Facade;

import com.example.demo.DTO.ProductDetailDTO;
import com.example.demo.Service.InventoryService;
import com.example.demo.cart.ShoppingService;
import com.example.demo.products.Product;
import com.example.demo.products.ProductService;
import org.springframework.stereotype.Service;

/**
 *  Service for Cart
 *  It Merges shoppingservice and inventory
 */


@Service
public class AddToCartFacade {

    /**
     * this is a private field
     */
    private final ShoppingService shoppingService;
    private final InventoryService inventoryService;
    private final ProductService productService;

    public  AddToCartFacade(ShoppingService shoppingService, InventoryService inventoryService,ProductService productService) {

        this.shoppingService = shoppingService;
        this.inventoryService = inventoryService;
        this.productService=productService;

    }


    /**
     *
     *
     * @param id it will allow me to get the id of the stock and let me check if insert allowed
     * @return a boolean whether the insert is allowed in or not
     */

    public boolean insertAllowed(int id){
       return inventoryService.stockProProduct(id)>0? true:false;
    }

    /**
     *
     * @param id   if insert it allowed then add the item in the stock and then reduct from the inventory
     */
    public void manageStockadd(int id){
        if(insertAllowed(id)){
            shoppingService.addProduct(id);
            inventoryService.reduceStock(productService.getById(id));
        }else{
            return ;
        }
    }

    public boolean removeAllowed(int id){
        return shoppingService.getCart().getOrDefault(id,0) > 0 ? true :false;
    }
    public void manageStockremove(int id){
        if(removeAllowed(id)){
            shoppingService.removeProduct(id);
            inventoryService.increaseStock(productService.getById(id));
        }
    }


}
