package com.example.demo.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.math.BigDecimal;

/**
 * JPA entity representing a product in the catalog.
 *
 * <p>Mapped to a database table by JPA/Hibernate. Contains basic attributes such as
 * name, price, and color.</p>
 */
@NamedQuery(
        name = "Product.findByColorUsingNamedQuery",
        query = "Select p from Product p where p.color= (?1)"
)
/**
 * Named query to retrieve products by their color.
 *
 * <p>Usage: {@code Product.findByColorUsingNamedQuery} with parameter 1 = color.</p>
 */
@Entity



public class Product {

    /**
     * Primary key identifier for the product.
     * Generated automatically by the persistence provider.
     */
    @Id
    @GeneratedValue
    private int id;

    /** The display name of the product. */
    private String name;

    /** The unit price of the product. */
    private BigDecimal price;

    /** The color of the product (e.g., "red", "blue"). */
    private String color;

    /**
     * Full constructor including id.
     *
     * <p>Note: In most JPA use-cases, the id is generated automatically, so this constructor
     * is typically used for testing or manual mapping.</p>
     *
     * @param id product identifier
     * @param name product name
     * @param price product price
     * @param color product color
     */
    public Product(int id, String name, BigDecimal price, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
    }

    /**
     * Constructor without id (recommended for JPA when id is generated).
     *
     * @param name product name
     * @param price product price
     * @param color product color
     */
    public Product(String name, BigDecimal price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    /**
     * No-args constructor required by JPA.
     */
    public Product() {
    }

    /**
     * Returns the product id.
     *
     * @return product id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the product name.
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns the product color.
     *
     * @return product color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the product id.
     *
     * <p>Typically not needed when the id is generated automatically.</p>
     *
     * @param id product id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the product color.
     *
     * @param color product color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the product name.
     *
     * @param name product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the product price.
     *
     * @param price product price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
