package com.example.demo.DTO;

import com.example.demo.cart.ShoppingCart;
import com.example.demo.cart.ShoppingService;
import com.example.demo.products.Currency;
import com.example.demo.products.Product;
import com.example.demo.products.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceChangeFacade {

    private ShoppingService shoppingService;
    private ProductService productService;
    public PriceChangeFacade(ShoppingService shoppingService,ProductService productService){

        this.shoppingService=shoppingService;
        this.productService=productService;
    }

    private  static final Currency Base_Currency= Currency.EUR;

    public  List<PriceChangeDTO> buildForProducts(List<Product> products){
        Currency active= shoppingService.getactiveCurreny();
        return products.stream().map(p-> new PriceChangeDTO(p,shoppingService.currencyConversion(p.getPrice(),Base_Currency,active),active)).toList();
    }

    public PriceChangeDTO buildForproduct(Product product){
        Currency active= shoppingService.getCart().getCurrency();
        return new PriceChangeDTO(product,shoppingService.currencyConversion(product.getPrice(),Base_Currency,active),active);
    }




}
