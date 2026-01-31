package com.example.demo.products;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> productList = new ArrayList<Product>();


    public ProductService(){
        productList.add(new Product(1,  "T-Shirt",        14.99,  "Blue"));
        productList.add(new Product(2,  "T-Shirt",        14.99,  "Black"));
        productList.add(new Product(3,  "Hoodie",         39.99,  "Gray"));
        productList.add(new Product(4,  "Hoodie",         44.99,  "Blue"));
        productList.add(new Product(5,  "Jeans",          59.99,  "Blue"));
        productList.add(new Product(6,  "Jeans",          49.99,  "Black"));
        productList.add(new Product(7,  "Sneakers",       79.99,  "White"));
        productList.add(new Product(8,  "Sneakers",       89.99,  "Black"));
        productList.add(new Product(9,  "Cap",             9.99,  "Red"));
        productList.add(new Product(10, "Cap",            11.99,  "Blue"));
        productList.add(new Product(11, "Socks (3-pack)",  6.49,  "White"));
        productList.add(new Product(12, "Jacket",        119.99,  "Green"));
    }


    public List<Product> getallProducts(){
        return productList;

    }

    public Product getById(int id){
        for (Product p : productList){
            if(p.getId()== id) {
                return p;
            }
        }

        return null;
    }

    public List<Product> getProductByColor(String color){
        List <Product> result= new ArrayList<>();
        for (Product p : productList){
            if(p.getColor().equalsIgnoreCase(color)) {
                result.add(p);
            }
        }


        return result;
    }




    public Product addedNewProduct(String name, int id , Double price, String color){
        Product p = new Product(id,name,price,color);
        for(Product m : productList) {
            if (m.getId() == p.getId()) {
                return getById(id);

            }
        }

                productList.add(p);
                return p;
            }





    public Product addedNewProductwithrequestbody(Product p){
        for(Product m : productList) {
            if (m.getId() == p.getId()) {
                return getById(p.getId());

            }
        }

        productList.add(p);
        return p;
    }


    public Product deletedProductwithrequestbody (int id){
        Product p  = getById(id);
        if(p!=null){
            productList.remove(p);
            return p;
        }
        else{
            return null;
        }
    }

    public Product updateProductwithrequestbody(Product p){
        Product m = getById(p.getId());
        if(m!=null){
            m.setColor(p.getColor());
            m.setPrice(p.getPrice());
            m.setName(p.getName());

            return m;
    }else{
            return p;

    }
    }

    public Product deleteProductById(int id){
        Product p  = getById(id);
        if(p!=null){
            productList.remove(p);
            return p;
        }
        else{
            return null;
        }
    }


}
