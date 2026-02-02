package com.example.demo.cart;

import com.example.demo.products.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class ShoppingController {

    private ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService){
        this.shoppingService=shoppingService;
    }



    @GetMapping("/cart")
    public String getCart(Model model){
        model.addAttribute("shoppingcart",shoppingService.getCart());
    return "/mvc/cart";}

    @PostMapping("/cart-add/{id}")
    public String cartAdd(@PathVariable int id, Model model){
        shoppingService.addProduct(id);
        return "redirect:/cart";
    }
    @PostMapping("/cart-remove/{id}")
    public String cartRemove(@PathVariable int id, Model model){
        shoppingService.removeProduct(id);
        return "redirect:/cart";
    }






}
