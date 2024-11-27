package com.danilel.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Product(String name, String description, Double price, Integer quantity, Cart cart) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.cart = cart;
    }
}
