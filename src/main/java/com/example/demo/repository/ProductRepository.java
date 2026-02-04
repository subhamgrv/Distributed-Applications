package com.example.demo.repository;

import com.example.demo.products.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.BeanProperty;
import java.util.logging.Logger;

public interface ProductRepository extends JpaRepository<Product, Integer> {



}