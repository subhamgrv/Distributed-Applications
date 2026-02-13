package com.example.demo.cart;

import com.example.demo.Facade.AddToCartFacade;
import com.example.demo.products.Currency;
import com.example.demo.products.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
@SessionAttributes("Currentcurrency")
public class ShoppingController {

    @ModelAttribute("Currentcurrency")
    public Currency initCurrency() {
        return Currency.EUR;
    }

    private final ShoppingService shoppingService;
    private final AddToCartFacade addToCardFacade;
    public ShoppingController(ShoppingService shoppingService, AddToCartFacade addToCardFacade){
        this.shoppingService=shoppingService;
        this.addToCardFacade=addToCardFacade;
    }


    @GetMapping("/cart")
    public String getCart(
            Model model,
            @RequestParam(name="voucher", required=false, defaultValue="false") boolean voucher,
            @RequestParam(name="currentCurrency", required=false) Currency newCurrency,
            @ModelAttribute("Currentcurrency") Currency currentCurrency
    ) {
        if (newCurrency != null) {
            currentCurrency = newCurrency;
            shoppingService.getCart().setCurrency(currentCurrency);
            model.addAttribute("Currentcurrency", currentCurrency); // updates session
        }

        Currency active = shoppingService.getCart().getCurrency();
        model.addAttribute("shoppingcart",shoppingService.presentCart());
        model.addAttribute("DiscountVoucher",shoppingService.getVoucherDiscount());
        model.addAttribute("voucher",voucher);
        model.addAttribute("Currentcurrency", currentCurrency); // updates session

        model.addAttribute("totalValue",shoppingService.totalValue());
        model.addAttribute("discountedPrice",shoppingService.discountedPrice(voucher,shoppingService.totalValue()));
        model.addAttribute("Saving",shoppingService.totalValue().subtract(shoppingService.discountedPrice(true,shoppingService.totalValue())));

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
