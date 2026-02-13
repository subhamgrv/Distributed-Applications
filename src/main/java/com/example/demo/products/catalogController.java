package com.example.demo.products;

import com.example.demo.DTO.PriceChangeDTO;
import com.example.demo.DTO.PriceChangeFacade;
import com.example.demo.cart.ShoppingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import   org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class catalogController {
private final ProductService productService;
    private final PriceChangeFacade priceChangeFacade;
    private final ShoppingService shoppingService;



catalogController(ProductService productService, PriceChangeFacade priceChangeFacade,ShoppingService shoppingService){
    this.productService=productService;
    this.priceChangeFacade=priceChangeFacade;
    this.shoppingService=shoppingService;
}

@GetMapping("/catalog")
    public String catalogPage(Model model, @RequestParam(required = false,defaultValue = "false") boolean edit, @RequestParam(required = false,name = "color") List<String> color){
    model.addAttribute("edit",edit);
    model.addAttribute("color",color);
    model.addAttribute("uniqueColor",productService.getallUniqueColorStrings());
    List<Product> products = (color==null || color.isEmpty())? productService.getallProducts() :productService.getProductBySelectedColor(color);

    List<PriceChangeDTO> view = priceChangeFacade.buildForProducts(products);
    model.addAttribute("products",view);
    model.addAttribute("CurrentCurreny",shoppingService.getactiveCurreny());

    return "/mvc/catalog";
}



@GetMapping("/catalog-paginated")
public String pageableCatalog(@PageableDefault(size = 3)Pageable pageable,Model model, @RequestParam(required = false,defaultValue = "false") boolean edit, @RequestParam(required = false,name = "color") List<String> color){
    Page<Product> page = productService.getAllProductPageable(pageable);
    model.addAttribute("edit",edit);
    model.addAttribute("color",color);
    model.addAttribute("page",page);
    model.addAttribute("uniqueColor",productService.getallUniqueColorStrings());
    List<Product> products = (color==null || color.isEmpty())? productService.getallProducts() :productService.getProductBySelectedColor(color);

    List<PriceChangeDTO> view = priceChangeFacade.buildForProducts(products);
    model.addAttribute("products",view);

    model.addAttribute("CurrentCurreny",shoppingService.getactiveCurreny());
    model.addAttribute("hasNext",page.hasNext());
    model.addAttribute("hasPrevious",page.hasPrevious());
    model.addAttribute("currentPage",page.getNumber()+1);
    model.addAttribute("totalPage",page.getTotalPages());
    return "/mvc/catalog";

}



@GetMapping("/productdetail/{id}")
    public String productPage(@PathVariable int id, Model model){
    Product p = productService.getById(id) ;
    model.addAttribute("product",priceChangeFacade.buildForproduct(p));
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
