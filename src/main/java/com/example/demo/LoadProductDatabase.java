package com.example.demo;

import com.example.demo.products.Product;
import com.example.demo.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.List;


@Configuration
public class LoadProductDatabase {



    private static final Logger log= LoggerFactory.getLogger(LoadProductDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(ProductRepository productRepository){
        return args -> {

            if(productRepository.count()>0){
                log.info("AlREADY sEEDED ");
                return;
            }

            Product p1  = new Product("T-Shirt", new BigDecimal("14.989999999"), "Blue");
            productRepository.save(p1);
            log.info("Saved Product {}", p1);

            Product p12 = new Product("T-Shirt", new BigDecimal("14.989999999"), "Black");
            productRepository.save(p12);
            log.info("Saved Product {}", p12);

            Product p2  = new Product("Hoodie", new BigDecimal("39.989999999"), "Gray");
            productRepository.save(p2);
            log.info("Saved Product {}", p2);

            Product p3  = new Product("Hoodie", new BigDecimal("44.989999999"), "Blue");
            productRepository.save(p3);
            log.info("Saved Product {}", p3);

            Product p4  = new Product("Jeans", new BigDecimal("59.989999999"), "Blue");
            productRepository.save(p4);
            log.info("Saved Product {}", p4);

            Product p5  = new Product("Jeans", new BigDecimal("49.989999999"), "Black");
            productRepository.save(p5);
            log.info("Saved Product {}", p5);

            Product p6  = new Product("Sneakers", new BigDecimal("79.989999999"), "White");
            productRepository.save(p6);
            System.out.println(p6.getPrice().toPlainString());
            log.info("Saved Product {}", p6);

            Product p7  = new Product("Sneakers", new BigDecimal("89.989999999"), "Black");
            productRepository.save(p7);
            log.info("Saved Product {}", p7);

            Product p8  = new Product("Cap", new BigDecimal("9.989999999"), "Red");
            productRepository.save(p8);
            log.info("Saved Product {}", p8);

            Product p9  = new Product("Cap", new BigDecimal("11.989999999"), "Blue");
            productRepository.save(p9);
            log.info("Saved Product {}", p9);

            Product p10 = new Product("Socks (3-pack)", new BigDecimal("6.489999999"), "White");
            productRepository.save(p10);
            log.info("Saved Product {}", p10);

            Product p11 = new Product("Jacket", new BigDecimal("119.989999999"), "Green");
            productRepository.save(p11);
            log.info("Saved Product {}", p11);

        }; }



}
