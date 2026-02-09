package com.example.demo.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import   org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class catalogController {
private final ProductService productService;


catalogController(ProductService productService){
    this.productService=productService;
}

@GetMapping("/catalog")
    public String catalogPage(Model model, @RequestParam(required = false,defaultValue = "false") boolean edit, @RequestParam(required = false,name = "color") List<String> color){
    model.addAttribute("edit",edit);
    model.addAttribute("color",color);
    model.addAttribute("uniqueColor",productService.getallUniqueColorStrings());
    if(color==null || color.isEmpty()){
        model.addAttribute("products",productService.getallProducts());
    }
    else{
        model.addAttribute("products",productService.getProductBySelectedColor(color));
    }

return "/mvc/catalog";
}



@GetMapping("/productdetail/{id}")
    public String productPage(@PathVariable int id, Model model){
    model.addAttribute("product",productService.getById(id));
    return "/mvc/productdetail";
}

@GetMapping("/ProductCatalog/delete/{id}")
    public String productDelete(@PathVariable int id,@RequestParam(defaultValue = "true") boolean edit){
    Product p  = productService.getById(id);
    if(p!=null){
        productService.deleteProductById(id);
        return "redirect:/catalog?edit=" + edit;
    }
    else{
        return "redirect:/catalog?edit=" + edit + "&error=notfound";
    }
}





}
