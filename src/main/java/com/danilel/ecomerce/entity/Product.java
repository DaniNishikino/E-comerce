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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
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
