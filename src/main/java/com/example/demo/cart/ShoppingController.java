package com.example.demo.cart;

import com.example.demo.Facade.AddToCartFacade;
import com.example.demo.products.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class ShoppingController {

    private final ShoppingService shoppingService;
    private final AddToCartFacade addToCardFacade;
    public ShoppingController(ShoppingService shoppingService, AddToCartFacade addToCardFacade){
        this.shoppingService=shoppingService;
        this.addToCardFacade=addToCardFacade;
    }



    @GetMapping("/cart")
    public String getCart(Model model){
        model.addAttribute("shoppingcart",shoppingService.presentCart());
        model.addAttribute("totalValue",shoppingService.totalValue());
    return "/mvc/cart";}

    @PostMapping("/cart-add/{id}")
    public String cartAdd(@PathVariable int id, Model model){
        addToCardFacade.manageStockadd(id);
        return "redirect:/cart";
    }
    @PostMapping("/cart-remove/{id}")
    public String cartRemove(@PathVariable int id, Model model){
        addToCardFacade.manageStockremove(id);
        return "redirect:/cart";
    }






}
