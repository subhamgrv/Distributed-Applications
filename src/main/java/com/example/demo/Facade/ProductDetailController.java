package com.example.demo.Facade;

import com.example.demo.DTO.ProductDetailDTO;
import com.example.demo.cart.ShoppingService;
import com.example.demo.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProductDetailController {
        private  ProductDetailFacade productDetailFacade;
        private ShoppingService shoppingService;

    ProductDetailController(ProductDetailFacade productDetailFacade,ShoppingService  shoppingService){
        this.shoppingService=  shoppingService;
        this.productDetailFacade=productDetailFacade;
    }

    @GetMapping("/productfacade/{id}")
    public String  getProductFacade(@PathVariable int id , Model model){
        model.addAttribute("ProductDetailDTO",productDetailFacade.buildFacade(id));
        model.addAttribute("Currentcurrency",shoppingService.getactiveCurreny());
        return "/mvc/productDTO";
    }


}
