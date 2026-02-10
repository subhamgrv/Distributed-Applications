package com.example.demo.products;


import com.example.demo.LoadProductDatabase;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.Entity;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
   private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    public List<Product> getallProducts(){
        return productRepository.findAll();

    }


    public Page<Product> getAllProductPageable(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product getById(int id)  {

        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not Found "+id));
    }

    public List<Product> getProductByColor(String color){
        List<Product> ls = productRepository.findAll();
        List<Product> sameColor = new ArrayList<>();
        for (Product p : ls){
            if(p.getColor().equalsIgnoreCase(color)){
                sameColor.add(p);
            }
        }
    return sameColor;}


    public List<Product> getProductBySelectedColor(List<String> color){
        List<Product> allSelectedColor = new ArrayList<>();

        for(String e: color){
            allSelectedColor.addAll(getProductByColor(e));
        }

    return allSelectedColor;}


    public  List <String> getallUniqueColorStrings(){
        List<String> allUniqueColor = new ArrayList<>();
        for (Product p : getallProducts()){
            if(!allUniqueColor.contains(p.getColor())){
                allUniqueColor.add(p.getColor());
            }
        }
    return allUniqueColor;}



    public List<Product> findByColorUsingNamedQuery(String color){
        if(color== null){
            return null;
        }
        else{
            color=color.trim();
            return productRepository.findByColorUsingNamedQuery(color);
        }

    }







    public Product addedNewProduct(String name, Double price, String color) {
        Product p = new Product(name, price,color);
    productRepository.save(p);
    return p; }





    public Product addedNewProductwithrequestbody(Product p){


        return productRepository.save(new Product(p.getName(),p.getPrice(),p.getColor()));
    }


    public void deletedProductwithrequestbody (int id){
        productRepository.deleteById(id);
    }

    public void updateProductwithrequestbody(Product p)  {



        Product existing = getById(p.getId());

        existing.setColor(p.getColor());
        existing.setPrice(p.getPrice());
        existing.setName(p.getName());


    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }


}
